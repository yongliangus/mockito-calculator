import static org.junit.Assert.assertEquals;

import org.example.Calculator;
import org.example.CalculatorService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

// Using Mockito to mock CalculatorService
public class TestCalculatorMockito {

  @InjectMocks
  Calculator c = null;  // This the class object under test

  @Mock
  CalculatorService service;// This is the Calculator's dependency to be mocked

  @Before
  public  void setUp()
  {
    MockitoAnnotations.openMocks(this);
    c = new Calculator(service);
  }

  @Test
  public void testPerformAddition()
  {
    // Mocking the service.add(2,3)
    Mockito.when(service.add(2,3)).thenReturn(5);
    assertEquals(5, c.performAddition(2,3));
  }
}
