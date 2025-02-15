package com.verdolaganation.Verdolaga_Nation.Publication;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/publications")
public class PublicationController {
    private final PublicationService publicationService;

    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @GetMapping
    public ResponseEntity<List<Publication>> getAllPublications() {
        return ResponseEntity.ok(publicationService.getAllPublications());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publication> getPublicationById(@PathVariable int id) {
        Optional<Publication> publication = publicationService.getPublicationById(id);
        return publication.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Publication>> getPublicationsByUserId(@PathVariable int userId) {
        return ResponseEntity.ok(publicationService.getPublicationsByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<Publication> createPublication(@RequestParam int userId,
                                                         @RequestParam String description,
                                                         @RequestParam(required = false) String imageUrl) {
        Publication publication = publicationService.createPublication(userId, description, imageUrl);
        return ResponseEntity.ok(publication);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publication> updatePublication(@PathVariable int id,
                                                         @RequestParam String description,
                                                         @RequestParam(required = false) String imageUrl) {
        Publication updatedPublication = publicationService.updatePublication(id, description, imageUrl);
        return ResponseEntity.ok(updatedPublication);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublication(@PathVariable int id) {
        publicationService.deletePublication(id);
        return ResponseEntity.noContent().build();
    }
}
