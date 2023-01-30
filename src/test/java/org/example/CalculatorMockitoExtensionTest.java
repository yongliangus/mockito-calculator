package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

// Reference - https://www.vogella.com/tutorials/Mockito/article.html#using-mockito-for-mocking-objects-in-unit-tests

// Automatically creates mock objects for any class attribute
// or method parameter annotated with @Mock.
@ExtendWith(MockitoExtension.class)
public class CalculatorMockitoExtensionTest {

  @InjectMocks
  Calculator c;

  @Mock
  CalculatorService service;

  // Simply put, the API is Mockito.spy() to spy on a real object.
  @Spy
  Calculator d = new Calculator(service);

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

  // Using java reflection to change the private method to be accessible
  // Reference, https://www.vogella.com/tutorials/Mockito/article.html#exercise-using-spy-and-reflection-to-change-private-fields
  @Test
  @DisplayName("Test private method minus")
  void performMinus() throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException {

    // Find the private method with java reflection
    Method privateMethod = Calculator.class.getDeclaredMethod("performMinus", int.class, int.class);

    // Change the method to be accessible
    privateMethod.setAccessible(true);

    // Invoke the private method
    int total = (int) privateMethod.invoke(c, 5, 2);

    assertEquals(3, total);
  }
}