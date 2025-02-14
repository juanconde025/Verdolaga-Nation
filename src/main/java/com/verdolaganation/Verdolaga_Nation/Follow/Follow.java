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
    private User Follower;

    @ManyToOne
    @JoinColumn(name = "id_user_followed", nullable = false)
    private User Followed;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public Follow() {
    }

    public Follow(int id, User follower, User followed, LocalDateTime createdAt) {
        this.id = id;
        Follower = follower;
        Followed = followed;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getFollower() {
        return Follower;
    }

    public void setFollower(User follower) {
        Follower = follower;
    }

    public User getFollowed() {
        return Followed;
    }

    public void setFollowed(User followed) {
        Followed = followed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
