package com.ramesh.libraryworld.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "messages")
@Data
public class Message {

    public Message(){}

    public Message(String title, String question) {
        this.title = title;
        this.question = question;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userEmail;
    private String title;
    private String question;
    private String adminEmail;
    private String response;
    private boolean closed;
}













