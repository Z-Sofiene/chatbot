package tn.i_sante.bpo.chatbot.service.impl;
import opennlp.tools.tokenize.SimpleTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tn.i_sante.bpo.chatbot.service.ChatbotService;
import tn.i_sante.bpo.chatbot.service.WebServiceMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChatbotServiceImpl implements ChatbotService {

    @Autowired
    private WebServiceMapping webServiceMapping;

    @Value("${openai.api.key}")
    private String openAiApiKey;

    private final String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";

    public String processUserInput(String input) {
        // Tokenize the user input
        SimpleTokenizer tokenizer = SimpleTokenizer.INSTANCE;
        String[] tokens = tokenizer.tokenize(input.toLowerCase());

        // Example: Analyze tokens to determine intent
        if (contains(tokens, "status")) {
            String endpoint = findMatchingEndpoint("dossiers");
            return fetchDataFromEndpoint(endpoint);
        } else if (contains(tokens, "complaint")) {
            String endpoint = findMatchingEndpoint("reclamation");
            return fetchDataFromEndpoint(endpoint);
        }

        // If no specific endpoint is matched, use GPT-3 to generate a response
        return getGPT3Response(input);
    }

    private boolean contains(String[] tokens, String keyword) {
        for (String token : tokens) {
            if (token.equals(keyword)) {
                return true;
            }
        }
        return false;
    }

    private String findMatchingEndpoint(String keyword) {
        List<String> endpoints = webServiceMapping.WebServices();
        for (String endpoint : endpoints) {
            if (endpoint.contains(keyword)) {
                return endpoint;
            }
        }
        return null;
    }


    private String fetchDataFromEndpoint(String endpoint) {
        // Implement logic to call the appropriate REST endpoint
        if (endpoint != null) {
            // Here you would make an HTTP GET request to the endpoint
            return "Mock data fetched from endpoint: " + endpoint;
        }
        return "No matching endpoint found.";
    }

    private String getGPT3Response(String input) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + openAiApiKey);
        headers.set("Content-Type", "application/json");

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "gpt-3.5-turbo");
        requestBody.put("prompt", input);
        requestBody.put("max_tokens", 150);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.exchange(OPENAI_API_URL, HttpMethod.POST, entity, Map.class);

        Map<String, Object> responseBody = response.getBody();
        if (responseBody != null) {
            List<Map<String, Object>> choices = (List<Map<String, Object>>) responseBody.get("choices");
            if (choices != null && !choices.isEmpty()) {
                return (String) choices.get(0).get("text");
            }
        }
        return "Sorry, I couldn't generate a response.";
    }
}
