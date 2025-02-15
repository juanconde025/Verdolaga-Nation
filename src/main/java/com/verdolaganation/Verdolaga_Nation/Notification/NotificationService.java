package com.verdolaganation.Verdolaga_Nation.Notification;

import com.verdolaganation.Verdolaga_Nation.User.User;
import com.verdolaganation.Verdolaga_Nation.User.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;

    public NotificationService(NotificationRepository notificationRepository, UserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }

    public List<Notification> getUserNotifications(int userId) {
        return notificationRepository.findByNotifiedIdOrderByCreatedAtDesc(userId);
    }

    public List<Notification> getUnreadNotifications(int userId) {
        return notificationRepository.findByCheckedFalseAndNotifiedId(userId);
    }

    public Notification saveNotification(Notification notification) {
        User interactor = userRepository.findById(notification.getInteractor().getId())
                .orElseThrow(() -> new IllegalArgumentException("Interactor user not found"));
        User notified = userRepository.findById(notification.getNotified().getId())
                .orElseThrow(() -> new IllegalArgumentException("Notified user not found"));

        notification.setInteractor(interactor);
        notification.setNotified(notified);

        return notificationRepository.save(notification);
    }

    public Notification markAsRead(int notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        notification.setChecked(true);
        return notificationRepository.save(notification);
    }

}
