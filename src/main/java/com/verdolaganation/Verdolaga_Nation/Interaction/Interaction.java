package com.verdolaganation.Verdolaga_Nation.Interaction;

import com.verdolaganation.Verdolaga_Nation.Publication.Publication;
import com.verdolaganation.Verdolaga_Nation.TypeInteraction.TypeInteraction;
import com.verdolaganation.Verdolaga_Nation.User.User;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "interactions")
public class Interaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "id_user_interactor", nullable = false)
    private User interactor;

    @ManyToOne
    @JoinColumn(name = "id_user_interacted", nullable = false)
    private User interacted;

    @ManyToOne
    @JoinColumn(name = "id_publications", nullable = false)
    private Publication publication;

    @ManyToOne
    @JoinColumn(name = "id_type_interaction", nullable = false)
    private TypeInteraction typeInteraction;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public Interaction() {
    }

    public Interaction(int id, String comment, User interactor, User interacted, Publication publication, TypeInteraction typeInteraction, LocalDateTime createdAt) {
        this.id = id;
        this.comment = comment;
        this.interactor = interactor;
        this.interacted = interacted;
        this.publication = publication;
        this.typeInteraction = typeInteraction;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getInteractor() {
        return interactor;
    }

    public void setInteractor(User interactor) {
        this.interactor = interactor;
    }

    public User getInteracted() {
        return interacted;
    }

    public void setInteracted(User interacted) {
        this.interacted = interacted;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public TypeInteraction getTypeInteraction() {
        return typeInteraction;
    }

    public void setTypeInteraction(TypeInteraction typeInteraction) {
        this.typeInteraction = typeInteraction;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
