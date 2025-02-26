package com.verdolaganation.Verdolaga_Nation.Publication;

import org.springframework.http.HttpStatus;
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

    @GetMapping("/find")
    public ResponseEntity<List<Publication>> getAllPublications() {
        return ResponseEntity.ok(publicationService.getAllPublications());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publication> getPublicationById(@PathVariable int id) {
        Optional<Publication> publication = publicationService.getPublicationById(id);
        return publication.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/publications-user/{userId}")
    public ResponseEntity<List<Publication>> getPublicationsByUserId(@PathVariable int userId) {
        return ResponseEntity.ok(publicationService.getPublicationsByUserId(userId));
    }

    @PostMapping("/post")
    public ResponseEntity<Publication> createPublication(@RequestBody Publication publication) {
        Publication savedPublication = publicationService.createPublication(publication);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPublication);
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<Publication> updatePublication(@PathVariable int id,
                                                         @RequestParam String description,
                                                         @RequestParam(required = false) String imageUrl) {
        Publication updatedPublication = publicationService.updatePublication(id, description, imageUrl);
        return ResponseEntity.ok(updatedPublication);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePublication(@PathVariable int id) {
        publicationService.deletePublication(id);
        return ResponseEntity.noContent().build();
    }
}
