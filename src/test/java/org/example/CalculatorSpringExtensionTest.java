package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// Reference - https://www.concretepage.com/spring-5/spybean-example-spring-test

@ExtendWith(SpringExtension.class)
@DisplayName("Calculator Mockito Extension Test")
public class CalculatorSpringExtensionTest {

  @SpyBean
  Calculator c;

  @Test
  @DisplayName("Get name test")
  void getNameTest() {
    String name = c.getName();
    assertEquals("Calculator", name);
  }
}