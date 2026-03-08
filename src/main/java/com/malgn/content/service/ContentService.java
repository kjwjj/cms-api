package com.malgn.content.service;

import com.malgn.content.entity.Content;
import com.malgn.content.repository.ContentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class ContentService {

    private final ContentRepository contentRepository;

    public Content create(Content content) {

        return contentRepository.save(content);
    }

    public Page<Content> list(Pageable pageable) {

        return contentRepository.findAll(pageable);
    }

    public Optional<Content> get(Long id) {
        return contentRepository.findById(id);
    }

    public Optional<Content> getWithViewCount(Long id) {
        contentRepository.increaseViewCount(id);
        return contentRepository.findById(id);
    }

    public Content update(Content content) {

        return contentRepository.save(content);
    }

    public void delete(Long id) {

        contentRepository.deleteById(id);
    }
}
