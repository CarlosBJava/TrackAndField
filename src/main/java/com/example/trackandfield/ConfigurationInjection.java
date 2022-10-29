package com.example.trackandfield;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConfigurationInjection {

    private final String otherPartyUrl;

    public ConfigurationInjection(@Value("${otherParty.url}") String otherPartyUrl) {
        this.otherPartyUrl = otherPartyUrl;
    }

    public void printUrl() {
        System.out.println(otherPartyUrl);
    }

}
