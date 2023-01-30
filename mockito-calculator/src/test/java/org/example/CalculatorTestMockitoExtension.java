package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

// Reference - https://www.vogella.com/tutorials/Mockito/article.html#using-mockito-for-mocking-objects-in-unit-tests

// Automatically creates mock objects for any class attribute
// or method parameter annotated with @Mock.
@ExtendWith(MockitoExtension.class)
public class CalculatorTestMockitoExtension {

  @InjectMocks
  Calculator c;

  @Mock
  CalculatorService service;

//  @BeforeEach
//  void setUp() {
//  }

  @Test
  @DisplayName("Addition using calculator service")
  void performAddition() {
    // Mocking the service.add(2,3)
    Mockito.when(service.add(2,3)).thenReturn(5);
    assertEquals(5, c.performAddition(2,3));
  }
}