package com.example.whatsappbot;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ChatController {

    @PostMapping("/chat")
    public String chat(@RequestBody String message) {
        message = message.toLowerCase().trim();

        // ✅ Get Firestore from FirebaseApp
        Firestore db = FirestoreClient.getFirestore();

        // 💾 Prepare data to save
        Map<String, Object> data = new HashMap<>();
        data.put("message", message);
        data.put("timestamp", System.currentTimeMillis());

        // 💾 Save to "chats" collection
        db.collection("chats").add(data);

        // 🧠 Reply logic
        switch (message) {
            case "hi":
            case "hello":
                return "Hey there! 👋";

            case "bye":
                return "Goodbye! 👋 Take care.";

            case "how are you":
                return "I'm just a bot, but I'm feeling ⚡charged up!";

            case "tell me something cool":
                return "Did you know? 🧠 The first computer bug was a real moth stuck in a Harvard computer in 1947! 💻🪲";

            default:
                return "Hmm... I didn't understand that 🤔. Try saying 'hi', 'bye', or 'tell me something cool'.";
        }
    }
}

