package com.ramesh.libraryworld.entity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String Description;
    private int copies;
    private int copiesAvailable;
    private String category;
    private String img;
}
