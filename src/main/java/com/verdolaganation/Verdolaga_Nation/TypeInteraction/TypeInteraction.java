package com.verdolaganation.Verdolaga_Nation.TypeInteraction;

import jakarta.persistence.*;

@Entity
@Table(name = "type_interactions")
public class TypeInteraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String type;

    public TypeInteraction() {
    }

    public TypeInteraction(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
