package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

// Reference - https://www.concretepage.com/spring-5/spybean-example-spring-test

@ExtendWith(SpringExtension.class)
@DisplayName("Person Spring Extension Test")
class PersonTest {

  @SpyBean
  private Person person;

  @Test
  public void test1() {
    String name = person.getName();
    assertEquals("Shiva", name);
  }
}