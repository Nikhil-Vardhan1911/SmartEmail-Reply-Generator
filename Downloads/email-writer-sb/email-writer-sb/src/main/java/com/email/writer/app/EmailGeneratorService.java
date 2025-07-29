package com.email.writer.app;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmailGeneratorService {
	
	private final  WebClient webClient;
	
	
	@Value("${gemini.api.url}")
	private String geminiApiUrl;
	
	@Value("${gemini.api.key}")
	private String geminiApiKey;
	
	public EmailGeneratorService(WebClient.Builder webClientBuilder) {
		this.webClient =webClientBuilder.build();
	}

	public String generateEmailReply(EmailRequest emailRequest) {
		// Build the prompt
		String prompt = buildPrompt(emailRequest);
		// craft a request
		
		Map<String,Object> requestBody = Map.of("contents", new Object[] {
				Map.of("parts", new Object[] {
						Map.of("text", prompt)
				})
		}
		);
		// Do request and get response
		
		String response = webClient.post()
			    .uri(uriBuilder -> uriBuilder
			        .scheme("https")
			        .host("generativelanguage.googleapis.com")
			        .path("/v1beta/models/gemini-2.0-flash:generateContent")
			        .queryParam("key", geminiApiKey)
			        .build())
			    .header("Content-Type", "application/json")
			    .bodyValue(requestBody)
			    .retrieve()
			    .bodyToMono(String.class)
			    .block();
		System.out.println("Raw Gemini API response: " + response);
		// extract Response and Return;
		return extractResponseContent(response);
	}

	private String extractResponseContent(String response) {
		
		try {
	        ObjectMapper mapper = new ObjectMapper();
	        JsonNode rootNode = mapper.readTree(response);
	        JsonNode candidates = rootNode.path("candidates");

	        if (!candidates.isArray() || candidates.isEmpty()) {
	            return "No response candidates returned by Gemini.";
	        }

	        // Get the escaped JSON string
	        String rawJson = candidates.get(0)
	                .path("content")
	                .path("parts")
	                .get(0)
	                .get("text")
	                .toString();  // This gives the string with quotes and escape chars

	        // Unescape it properly
	        String formattedText = mapper.readValue(rawJson, String.class);

	        return formattedText.trim();
	    } catch (Exception e) {
	        return "Error processing Gemini response: " + e.getMessage();
	    }
	}

	private String buildPrompt(EmailRequest emailRequest) {
		StringBuilder prompt = new StringBuilder();
		prompt.append("Generate a professional email reply for the following email content. please don't generate a subject line ");
		if(emailRequest.getTone() !=null && !emailRequest.getTone().isEmpty()) {
			prompt.append("Use a ").append(emailRequest.getTone()).append(" tone. ");
		}
		prompt.append("\n Original email: \n").append(emailRequest.getEmailContent());
		return prompt.toString();
	}
}
