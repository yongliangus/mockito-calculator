package org.example;

public class Calculator {

  CalculatorService service;
  public Calculator(CalculatorService service)
  {
    this.service = service;
  }
  public int performAddition(int i, int j)
  {
    return service.add(i, j);
  }
  private int performMinus(int i, int j) { return i - j; }
  public String getName() { return "Calculator"; }
}
