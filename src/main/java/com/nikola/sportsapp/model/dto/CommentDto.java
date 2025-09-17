package com.nikola.sportsapp.model.dto;

import java.time.LocalDateTime;

public class CommentDto {

    private Long id;
    private String content;
    private LocalDateTime dateTime;
    private String username;

    public CommentDto() {
    }

    public CommentDto(Long id, String content, LocalDateTime dateTime, String username) {
        this.id = id;
        this.content = content;
        this.dateTime = dateTime;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
