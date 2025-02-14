package com.verdolaganation.Verdolaga_Nation.Publication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Integer> {
    List<Publication> findByUserIdOrderByCreationDateDesc(int userId);
}
