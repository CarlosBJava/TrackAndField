package com.example.trackandfield;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConfigurationInjectionTest {

    private final String otherPartyUrl = "www.testurl.nl";

    private ConfigurationInjection configurationInjection;

    @BeforeEach
    void setUp() {
        configurationInjection = new ConfigurationInjection(otherPartyUrl);

    }

    @Test
     void printUrl() {



    }
}