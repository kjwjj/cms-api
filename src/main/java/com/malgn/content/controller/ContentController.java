package com.malgn.content.controller;

import com.malgn.content.entity.Content;
import com.malgn.content.service.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.malgn.content.dto.ContentUpdateDto;

@RestController
@RequestMapping("/api/contents")
@RequiredArgsConstructor
public class ContentController {

    private final ContentService contentService;

    @PostMapping
    public ResponseEntity<Content> create(@RequestBody Content content, Authentication auth) {
        content.setCreatedBy(auth.getName());
        return ResponseEntity.ok(contentService.create(content));
    }

    @GetMapping
    public ResponseEntity<Page<Content>> list(Pageable pageable) {
        return ResponseEntity.ok(contentService.list(pageable));
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Content> get(@PathVariable Long id) {
//        return contentService.get(id)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Content> get(@PathVariable Long id) {
        return contentService.get(id).map(existing -> {
            existing.setViewCount(existing.getViewCount() + 1);
            contentService.update(existing);
            return ResponseEntity.ok(existing);
        }).orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Content> update(@PathVariable Long id,
                                          @RequestBody ContentUpdateDto dto,
                                          Authentication auth) {
        return contentService.get(id).map(existing -> {
            boolean isAdmin = auth.getAuthorities().stream()
                    .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
            if (!isAdmin && !existing.getCreatedBy().equals(auth.getName())) {
                return ResponseEntity.status(403).<Content>build();
            }
            existing.setTitle(dto.getTitle());
            existing.setDescription(dto.getDescription());
            existing.setLastModifiedBy(auth.getName());
            return ResponseEntity.ok(contentService.update(existing));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id,
                                       Authentication auth) {
        return contentService.get(id).map(existing -> {
            boolean isAdmin = auth.getAuthorities().stream()
                    .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));
            if (!isAdmin && !existing.getCreatedBy().equals(auth.getName())) {
                return ResponseEntity.status(403).<Void>build();
            }
            contentService.delete(id);
            return ResponseEntity.ok().<Void>build();
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
