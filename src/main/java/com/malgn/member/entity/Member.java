package com.malgn.member.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=50, nullable=false, unique=true)
    private String name;

    @Column(length=100, nullable=false)
    private String password;

    @Column(name="created_date", nullable=false)
    private LocalDateTime createdDate;

    @Column(name="last_modified_date")
    private LocalDateTime lastModifiedDate;

    @Column(name="last_modified_by", length=50)
    private String lastModifiedBy;

    @Column(length=20, nullable=false)
    private String role;

    @PrePersist
    public void prePersist() {
        this.createdDate = LocalDateTime.now();
        if (this.role == null) this.role = "ROLE_USER";
    }
}

