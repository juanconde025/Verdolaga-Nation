package com.verdolaganation.Verdolaga_Nation.Follow;

import com.verdolaganation.Verdolaga_Nation.User.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "follows")
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_user_follower", nullable = false)
    private User follower;

    @ManyToOne
    @JoinColumn(name = "id_user_followed", nullable = false)
    private User followed;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // 🔹 Constructor vacío requerido por JPA
    public Follow() {
        this.createdAt = LocalDateTime.now();
    }

    // 🔹 Constructor con parámetros
    public Follow(User follower, User followed) {
        this.follower = follower;
        this.followed = followed;
        this.createdAt = LocalDateTime.now();
    }

    // 🔹 Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public User getFollowed() {
        return followed;
    }

    public void setFollowed(User followed) {
        this.followed = followed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
