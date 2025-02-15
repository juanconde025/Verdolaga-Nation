package com.verdolaganation.Verdolaga_Nation.Notification;

import com.verdolaganation.Verdolaga_Nation.User.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private boolean checked;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "id_user_interactor", nullable = false)
    private User interactor;

    @ManyToOne
    @JoinColumn(name = "id_user_notified", nullable = false)
    private User notified;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public Notification() {
    }

    public Notification(int id, boolean checked, String type, String content, User interactor, User notified, LocalDateTime createdAt) {
        this.id = id;
        this.checked = checked;
        this.type = type;
        this.content = content;
        this.interactor = interactor;
        this.notified = notified;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getInteractor() {
        return interactor;
    }

    public void setInteractor(User interactor) {
        this.interactor = interactor;
    }

    public User getNotified() {
        return notified;
    }

    public void setNotified(User notified) {
        this.notified = notified;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
