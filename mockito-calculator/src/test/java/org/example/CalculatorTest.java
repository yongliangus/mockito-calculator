package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

  // Object to be tested
  Calculator c = null;

  // Object to be mocked without using Mockito framework
  CalculatorService service = null;

  @BeforeEach
  void setUp() {

    // Without using Mockito framework, have to create
    // the CalculatorService object and implement
    // its interface function "add"
    service = new CalculatorService() {
      @Override
      public int add(int i, int j) {
        return i+j;
      }
    };

    // Create a Calculator
    c = new Calculator(service);
  }

  @Test
  @DisplayName("Addition using calculator service")
  void performAddition() {
    assertEquals(5, c.performAddition(2,3));
  }
}