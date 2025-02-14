package com.verdolaganation.Verdolaga_Nation.TypeInteraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/type-interactions")
public class TypeInteractionController {
    private final TypeInteractionService typeInteractionService;

    @Autowired
    public TypeInteractionController(TypeInteractionService typeInteractionService) {
        this.typeInteractionService = typeInteractionService;
    }

    @GetMapping
    public List<TypeInteraction> getAllTypeInteractions() {
        return typeInteractionService.getAllTypeInteractions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeInteraction> getTypeInteractionById(@PathVariable int id) {
        Optional<TypeInteraction> typeInteraction = typeInteractionService.getTypeInteractionById(id);
        return typeInteraction.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public TypeInteraction createTypeInteraction(@RequestBody TypeInteraction typeInteraction) {
        return typeInteractionService.createTypeInteraction(typeInteraction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeInteraction> updateTypeInteraction(@PathVariable int id, @RequestBody TypeInteraction updatedTypeInteraction) {
        try {
            TypeInteraction updated = typeInteractionService.updateTypeInteraction(id, updatedTypeInteraction);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeInteraction(@PathVariable int id) {
        typeInteractionService.deleteTypeInteraction(id);
        return ResponseEntity.noContent().build();
    }
}

