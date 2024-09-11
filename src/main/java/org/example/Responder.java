package org.example;

import java.util.HashMap;
import java.util.List;

public class Responder {

    private HashMap<String, String> responseMap;

    public Responder() {
        responseMap = new HashMap<String, String>();
        responseMap.put("nice weather", "That's wonderful! Good weather always lifts the mood.");
        responseMap.put("good weather", "That's wonderful! Good weather always lifts the mood.");
        responseMap.put("bad weather", "Oh no, that doesn't sound good. Hopefully, the weather will improve soon!");
        responseMap.put("rain", "Oh no, that doesn't sound good. Hopefully, the weather will improve soon!");
        responseMap.put("cold weather", "Oh no, that doesn't sound good. Hopefully, the weather will improve soon!");
        responseMap.put("good day", "That sounds great! I'm glad to hear that your day was good.");
        responseMap.put("bad day", "I'm sorry to hear that. Tomorrow will surely be better!");
        responseMap.put("hello", "Hello! How are you today?");
        responseMap.put("hi", "Hi there! How can I assist you today?");
        responseMap.put("how are you", "I'm good as always! Thank you for asking!");
        responseMap.put("how are you doing", "I'm doing great, thanks for asking! How about you?");
        responseMap.put("how was your day", "I'm just a bot, so I don't have days, but I'm here to help you! How can I assist you today?");
        responseMap.put("how's it going", "Everything is going smoothly here. How can I help you today?");
        responseMap.put("slow", "I think this might be related to your hardware. Upgrading your processor should resolve any performance issues.");
        responseMap.put("bug", "Well, there's nothing I can do right now to fix this issue. We'll just have to wait for our developers to fix the bug.");
        responseMap.put("help", "Sure, let me know what the problem is so I can assist you!");
        responseMap.put("fablas", "I like him. He's a very good fortnite player and twitch streamer!");
        responseMap.put("minecraft", "Minecraft is my favorite game!");

    }

    public String generateResponse(List<String> words) {
        String inputPhrase = String.join(" ", words).trim().toLowerCase();
        String response = responseMap.get(inputPhrase);
        if (response != null) {
            return response;
        }

        for (String keyword : words) {
            response = responseMap.get(keyword);
            if (response != null) {
                return response;
            }
        }

        response = findBestMatch(words);
        if (response != null) {
            return response;
        }

        return this.pickDefaultResponse();
    }

    private String findBestMatch(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            for (int j = i + 1; j <= words.size(); j++) {
                String subPhrase = String.join(" ", words.subList(i, j)).trim().toLowerCase();
                String response = responseMap.get(subPhrase);
                if (response != null) {
                    return response;
                }
            }
        }
        return null;
    }

    private String pickDefaultResponse() {
        return "That sounds interesting. Tell me more...";
    }
}
