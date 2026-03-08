package com.malgn.content.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="contents")
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=50, nullable=false)
    private String title;

    @Column(columnDefinition="TEXT")
    private String description;

    @Column(name="view_count", nullable=false)
    private Long viewCount = 0L;

    @Column(name="created_date", nullable=false)
    private LocalDateTime createdDate;

    @Column(name="created_by", length=50, nullable=false)
    private String createdBy;

    @Column(name="last_modified_date")
    private LocalDateTime lastModifiedDate;

    @Column(name="last_modified_by", length=50)
    private String lastModifiedBy;

    @PrePersist
    public void prePersist() {
        createdDate = LocalDateTime.now();
        if (viewCount == null) viewCount = 0L;
    }

    @PreUpdate
    public void preUpdate(){
        lastModifiedDate = LocalDateTime.now();
    }
}
