# mockito-calculator
An example of mockito calculator inspired by https://www.youtube.com/watch?v=HsQ9OwKA79s&amp;t=1s

The goal of this project is to demonstrate how to use Mockito step by step for unit test

1. CalculatorTest.java showed how to write junit test
without mockito framework. In order to mock Calculator's dependency, you have
to create the CalculatorService object and implement its interface function "add".

2. CalculatorMockitoTest.java did the same with Mockito.
Creation of CalculatorService object and its implementation are no longer needed. Instead, all
mock CalculatorService directly with "when" ... and "return" ...

3. CalculatorMockitoExtensionTest went a step further by using Mockito Extension with
"@ExtendWith" class decorator to automatically creates mock objects for any class
attribute or method parameter annotated with @Mock. Moreover, you aren't required to
set up MockitoAnnotations.openMocks(this) in #2.

# Unit testing of private method

Java private method can not be mocked with mockito. However, you can use java reflection
to make the private method accessible and then unit test it.
```
// Calculator has a private method
public class Calculator {
  private int performMinus(int i, int j) { return i - j; }
}

@InjectMocks
Calculator c;

// Find the private method with java reflection
Method privateMethod = Calculator.class.getDeclaredMethod("performMinus", int.class, int.class);

// Change the method to be accessible
privateMethod.setAccessible(true);

// Invoke the private method
int result = (int) privateMethod.invoke(c, 5, 2);
```
