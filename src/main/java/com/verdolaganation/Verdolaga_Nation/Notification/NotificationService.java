package com.verdolaganation.Verdolaga_Nation.Notification;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> getUserNotifications(int userId) {
        return notificationRepository.findByNotifiedIdOrderByCreatedAtDesc(userId);
    }

    public List<Notification> getUnreadNotifications(int userId) {
        return notificationRepository.findByCheckedFalseAndNotifiedId(userId);
    }

    public Notification saveNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Notification markAsRead(int notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("Notificación no encontrada"));
        notification.setChecked("true");
        return notificationRepository.save(notification);
    }

}
