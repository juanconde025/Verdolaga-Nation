package com.verdolaganation.Verdolaga_Nation.Interaction;

import com.verdolaganation.Verdolaga_Nation.Publication.Publication;
import com.verdolaganation.Verdolaga_Nation.TypeInteraction.TypeInteraction;
import com.verdolaganation.Verdolaga_Nation.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InteractionRepository extends JpaRepository<Interaction, Integer> {
    List<Interaction> findByInteractor(User interactor);

    List<Interaction> findByInteracted(User interacted);

    List<Interaction> findByPublication(Publication publication);

    List<Interaction> findByTypeInteraction(TypeInteraction typeInteraction);


}

