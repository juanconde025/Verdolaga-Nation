package com.verdolaganation.Verdolaga_Nation.Notification;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/notifications")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Notification>> getUserNotifications(@PathVariable int userId) {
        return ResponseEntity.ok(notificationService.getUserNotifications(userId));
    }

    @GetMapping("/unread/{userId}")
    public ResponseEntity<List<Notification>> getUnreadNotifications(@PathVariable int userId) {
        return ResponseEntity.ok(notificationService.getUnreadNotifications(userId));
    }

    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        return ResponseEntity.ok(notificationService.saveNotification(notification));
    }

    @PutMapping("/mark-as-read/{notificationId}")
    public ResponseEntity<Notification> markAsRead(@PathVariable int notificationId) {
        return ResponseEntity.ok(notificationService.markAsRead(notificationId));
    }

}
