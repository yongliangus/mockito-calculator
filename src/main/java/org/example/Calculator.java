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
}
