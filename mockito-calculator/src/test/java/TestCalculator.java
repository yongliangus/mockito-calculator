import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.example.Calculator;
import org.example.CalculatorService;
import org.junit.Before;
import org.junit.Test;

// Using standard Junit test framework
public class TestCalculator {

  Calculator c = null;

  CalculatorService service = new CalculatorService() {
    @Override
    public int add(int i, int j) {
      return i+j;
    }
  };

  @Before
  public  void setUp()
  {
    c = new Calculator(service);
  }

  @Test
  public void testPerformAddition()
  {
    assertEquals(5, c.performAddition(2,3));
  }
}
