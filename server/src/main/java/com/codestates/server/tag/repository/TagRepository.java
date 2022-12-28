package com.codestates.server.tag.repository;

import com.codestates.server.tag.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Optional<Tag> findByCategory(String category);

    Page<Tag> findAllByCategoryContains(String category, Pageable pageable);
}
