package com.factory.notification.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @PostMapping
    public String sendNotification(@RequestBody String message) {
        return "Notification sent: " + message;
    }
}