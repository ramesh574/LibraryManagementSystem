package com.ramesh.libraryworld.entity;

import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userEmail;
    @CreationTimestamp
    private Date date;

    private double rating;
    private Long bookId;

    private String reviewDescription;
}
