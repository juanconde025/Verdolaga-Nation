package com.verdolaganation.Verdolaga_Nation.TypeInteraction;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class TypeInteractionService {

    private final TypeInteractionRepository typeInteractionRepository;

    @Autowired
    public TypeInteractionService(TypeInteractionRepository typeInteractionRepository) {
        this.typeInteractionRepository = typeInteractionRepository;
    }

    public List<TypeInteraction> getAllTypeInteractions() {
        return typeInteractionRepository.findAll();
    }

    public Optional<TypeInteraction> getTypeInteractionById(int id) {
        return typeInteractionRepository.findById(id);
    }

    public TypeInteraction createTypeInteraction(TypeInteraction typeInteraction) {
        return typeInteractionRepository.save(typeInteraction);
    }

    public TypeInteraction updateTypeInteraction(int id, TypeInteraction newTypeInteraction) {
        return typeInteractionRepository.findById(id)
                .map(typeInteraction -> {
                    typeInteraction.setType(newTypeInteraction.getType());
                    return typeInteractionRepository.save(typeInteraction);
                }).orElseThrow(() -> new RuntimeException("TypeInteraction not found"));
    }

    public void deleteTypeInteraction(int id) {
        typeInteractionRepository.deleteById(id);
    }
}

