package com.verdolaganation.Verdolaga_Nation.Notification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    List<Notification> findByNotifiedIdOrderByCreatedAtDesc(int userId);

    List<Notification> findByCheckedFalseAndNotifiedId(int userId);
}
