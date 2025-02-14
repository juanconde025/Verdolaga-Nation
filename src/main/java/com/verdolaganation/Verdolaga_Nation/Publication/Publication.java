package com.verdolaganation.Verdolaga_Nation.Publication;

import com.verdolaganation.Verdolaga_Nation.User.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "publications")
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_users", nullable = false)
    private User user;

    private String description;
    private String imageUrl;

    @Column(nullable = false)
    private LocalDateTime creationDate = LocalDateTime.now();

    public Publication() {
    }

    public Publication(int id, User user, String description, String imageUrl, LocalDateTime creationDate) {
        this.id = id;
        this.user = user;
        this.description = description;
        this.imageUrl = imageUrl;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
