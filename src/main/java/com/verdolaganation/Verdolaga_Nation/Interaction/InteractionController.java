package com.verdolaganation.Verdolaga_Nation.Interaction;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interactions")
public class InteractionController {

    private final InteractionService interactionService;

    public InteractionController(InteractionService interactionService) {
        this.interactionService = interactionService;
    }

    @PostMapping
    public ResponseEntity<Interaction> createInteraction(
            @RequestParam int interactorId,
            @RequestParam int interactedId,
            @RequestParam int publicationId,
            @RequestParam int typeInteractionId,
            @RequestParam(required = false) String comment) {

        Interaction interaction = interactionService.createInteraction(interactorId, interactedId, publicationId, comment, typeInteractionId);
        return ResponseEntity.ok(interaction);
    }

    @GetMapping
    public ResponseEntity<List<Interaction>> getAllInteractions() {
        return ResponseEntity.ok(interactionService.getAllInteractions());
    }

    @GetMapping("/by-interactor/{interactorId}")
    public ResponseEntity<List<Interaction>> getInteractionsByInteractor(@PathVariable int interactorId) {
        return ResponseEntity.ok(interactionService.getInteractionsByInteractor(interactorId));
    }

    @GetMapping("/by-interacted/{interactedId}")
    public ResponseEntity<List<Interaction>> getInteractionsByInteracted(@PathVariable int interactedId) {
        return ResponseEntity.ok(interactionService.getInteractionsByInteracted(interactedId));
    }

    @GetMapping("/by-publication/{publicationId}")
    public ResponseEntity<List<Interaction>> getInteractionsByPublication(@PathVariable int publicationId) {
        return ResponseEntity.ok(interactionService.getInteractionsByPublication(publicationId));
    }

    @GetMapping("/by-type/{typeInteractionId}")
    public ResponseEntity<List<Interaction>> getInteractionsByType(@PathVariable int typeInteractionId) {
        return ResponseEntity.ok(interactionService.getInteractionsByType(typeInteractionId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInteraction(@PathVariable int id) {
        interactionService.deleteInteraction(id);
        return ResponseEntity.ok("Interaction deleted");
    }
}

