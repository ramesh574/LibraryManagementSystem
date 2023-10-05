package com.ramesh.libraryworld.dao;

import com.ramesh.libraryworld.entity.Review;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface ReviewRepository extends JpaRepository<Review,Long> {

    Page<Review> findByBookId(@RequestParam Long bookId, Pageable pageable);
    Review findByUserEmailAndBookId(String userEmail,Long bookId);
}
