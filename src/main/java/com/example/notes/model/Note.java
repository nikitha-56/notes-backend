package com.example.notes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Table(name="notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    private String shareId;

    @PrePersist
    public void generateShareId() {
        if (shareId == null) {
            shareId = UUID.randomUUID().toString();
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getShareId() { return shareId; }
    public void setShareId(String shareId) { this.shareId = shareId; }
}
