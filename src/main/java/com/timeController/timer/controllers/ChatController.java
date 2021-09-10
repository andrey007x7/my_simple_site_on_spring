package com.timeController.timer.controllers;

import com.timeController.timer.models.Chat;
import com.timeController.timer.repo.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ChatController {
    private final ChatRepository chatRepository;

    @Autowired
    public ChatController(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @GetMapping("/chat")
    public String showChat(Model model) {
        Iterable<Chat> chats = chatRepository.findAll();
        model.addAttribute("chat", chats);
        return "/chat";
    }

    @PostMapping("/chat")
    public String sendMessage(@RequestParam String message, @RequestParam String name) {
        Chat chat = new Chat(message, name);
        chatRepository.save(chat);
        return "redirect:/chat";
    }
}
