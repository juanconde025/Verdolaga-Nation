package com.verdolaganation.Verdolaga_Nation.Interaction;

import com.verdolaganation.Verdolaga_Nation.Publication.Publication;
import com.verdolaganation.Verdolaga_Nation.Publication.PublicationRepository;
import com.verdolaganation.Verdolaga_Nation.TypeInteraction.TypeInteraction;
import com.verdolaganation.Verdolaga_Nation.User.User;
import com.verdolaganation.Verdolaga_Nation.User.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InteractionService {

    private final InteractionRepository interactionRepository;
    private final PublicationRepository publicationRepository;
    private final UserRepository userRepository;


    public InteractionService(InteractionRepository interactionRepository, PublicationRepository publicationRepository, UserRepository userRepository) {
        this.interactionRepository = interactionRepository;
        this.publicationRepository = publicationRepository;
        this.userRepository = userRepository;
    }

    public Interaction createInteraction(int interactorId, int interactedId, int publicationId, String comment, int typeInteractionId) {
        Optional<User> interactor = userRepository.findById(interactorId);
        Optional<User> interacted = userRepository.findById(interactedId);
        Optional<Publication> publication = publicationRepository.findById(publicationId);

        if (interactor.isEmpty() || interacted.isEmpty() || publication.isEmpty()) {
            throw new RuntimeException("No interactor or publication found");
        }

        Interaction interaction = new Interaction();
        interaction.setInteractor(interactor.get());
        interaction.setInteracted(interacted.get());
        interaction.setPublication(publication.get());
        interaction.setTypeInteraction(new TypeInteraction(typeInteractionId, "")); // Solo se usa el ID
        interaction.setComment(comment);

        return interactionRepository.save(interaction);
    }

    public List<Interaction> getAllInteractions() {
        return interactionRepository.findAll();
    }

    public List<Interaction> getInteractionsByInteractor(int interactorId) {
        Optional<User> user = userRepository.findById(interactorId);
        return user.map(interactionRepository::findByInteractor).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<Interaction> getInteractionsByInteracted(int interactedId) {
        Optional<User> user = userRepository.findById(interactedId);
        return user.map(interactionRepository::findByInteracted).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<Interaction> getInteractionsByPublication(int publicationId) {
        Optional<Publication> publication = publicationRepository.findById(publicationId);
        return publication.map(interactionRepository::findByPublication).orElseThrow(() -> new RuntimeException("Publication not found"));
    }

    public List<Interaction> getInteractionsByType(int typeInteractionId) {
        return interactionRepository.findByTypeInteraction(new TypeInteraction(typeInteractionId, ""));
    }

    public void deleteInteraction(int id) {
        if (!interactionRepository.existsById(id)) {
            throw new RuntimeException("Interaction not found");
        }
        interactionRepository.deleteById(id);
    }
}
