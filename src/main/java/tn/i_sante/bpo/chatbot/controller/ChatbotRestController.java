package tn.i_sante.bpo.chatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.i_sante.bpo.chatbot.service.ChatbotService;

@RestController
@RequestMapping("/api/chatbot")
public class ChatbotRestController {

    @Autowired
    private ChatbotService chatbotService;

    @PostMapping
    public ChatbotResponse chat(@RequestBody ChatbotRequest request) {
        String userInput = request.getMessage();
        String response = chatbotService.processUserInput(userInput);
        return new ChatbotResponse(response);
    }

    @GetMapping
    public ChatbotResponse chatGet(@RequestParam String message) {
        String response = chatbotService.processUserInput(message);
        return new ChatbotResponse(response);
    }

    static class ChatbotRequest {
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    static class ChatbotResponse {
        private String response;

        public ChatbotResponse(String response) {
            this.response = response;
        }

        public String getResponse() {
            return response;
        }

        public void setResponse(String response) {
            this.response = response;
        }
    }
}
