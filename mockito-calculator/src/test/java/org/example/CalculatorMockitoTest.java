package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class CalculatorMockitoTest {

  @InjectMocks
  Calculator c;

  @Mock
  CalculatorService service;

  // Without using Mockito Extension
  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("Addition using calculator service")
  void performAddition() {
    // Mocking the service.add(2,3)
    Mockito.when(service.add(2,3)).thenReturn(5);
    assertEquals(5, c.performAddition(2,3));
  }
}