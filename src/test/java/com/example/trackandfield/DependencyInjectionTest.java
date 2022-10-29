package com.example.trackandfield;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DependencyInjectionTest {

    @Mock
    private Whatever whatever;

    private DependencyInjection dependencyInjection;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        dependencyInjection = new DependencyInjection(whatever);
    }

    @Test
    void doSomething() {
        when(whatever.doSomething()).thenReturn(10);

        var result = dependencyInjection.doSomething();

        assertThat(result).isEqualTo(30);
        verify(whatever, times(1)).doSomething();
    }
}