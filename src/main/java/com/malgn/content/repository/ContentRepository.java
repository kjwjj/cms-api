package com.malgn.content.repository;

import com.malgn.content.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ContentRepository extends JpaRepository<Content, Long> {

    @Modifying
    @Query("update Content c set c.viewCount = c.viewCount + 1 where c.id = :id")
    void increaseViewCount(@Param("id") Long id);
}
