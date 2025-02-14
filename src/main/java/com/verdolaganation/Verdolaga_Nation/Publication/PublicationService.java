package com.verdolaganation.Verdolaga_Nation.Publication;

import com.verdolaganation.Verdolaga_Nation.User.User;
import com.verdolaganation.Verdolaga_Nation.User.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicationService {
    private final PublicationRepository publicationRepository;
    private final UserRepository userRepository;

    public PublicationService(PublicationRepository publicationRepository, UserRepository userRepository) {
        this.publicationRepository = publicationRepository;
        this.userRepository = userRepository;
    }

    public List<Publication> getAllPublications() {
        return publicationRepository.findAll();
    }

    public Optional<Publication> getPublicationById(int id) {
        return publicationRepository.findById(id);
    }

    public List<Publication> getPublicationsByUserId(int userId) {
        return publicationRepository.findByUserIdOrderByCreationDateDesc(userId);
    }

    public Publication createPublication(int userId, String description, String imageUrl) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new IllegalArgumentException("User with ID " + userId + " not exist");
        }
        Publication publication = new Publication();
        publication.setUser(user.get());
        publication.setDescription(description);
        publication.setImageUrl(imageUrl);
        return publicationRepository.save(publication);
    }

    public Publication updatePublication(int id, String description, String imageUrl) {
        Optional<Publication> optionalPublication = publicationRepository.findById(id);
        if (optionalPublication.isEmpty()) {
            throw new IllegalArgumentException("Publication not found");
        }
        Publication publication = optionalPublication.get();
        publication.setDescription(description);
        publication.setImageUrl(imageUrl);
        return publicationRepository.save(publication);
    }

    public void deletePublication(int id) {
        if (!publicationRepository.existsById(id)) {
            throw new IllegalArgumentException("Publication not found");
        }
        publicationRepository.deleteById(id);
    }
}
