package com.example.trackandfield;

// Dependency Injection
//    - Constructor: ondersteunt final = beste oplossing
//    - Setter = (setter method)
//    - Field injection = @Autowire

import org.springframework.stereotype.Service;

@Service
public class DependencyInjection {

    private final Whatever whatever;

    public DependencyInjection(Whatever whatever) {
        this.whatever = whatever;
    }

    public Integer doSomething() {
        return whatever.doSomething() * 3;
    }
}

@Service
class Whatever {

    public Integer doSomething() {
        return 15;
    }
}