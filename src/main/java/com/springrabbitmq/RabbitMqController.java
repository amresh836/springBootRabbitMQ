package com.springrabbitmq;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mq")
@RequiredArgsConstructor
public class RabbitMqController {
    private final RabbitMqProducer rabbitMqProducer;
    private final RabbitMQJsonProducer rabbitMQJsonProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        rabbitMqProducer.sendMessage(message);
        return ResponseEntity.ok("message sent successfully");
    }
    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        rabbitMQJsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("json message sent to rabbitmq");
    }
}
