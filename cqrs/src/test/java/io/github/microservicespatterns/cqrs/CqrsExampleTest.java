package io.github.microservicespatterns.cqrs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CqrsExampleTest {
  @Test
  void commandUpdatesReadModelForQuery() {
    CqrsExample example = new CqrsExample();

    example.createItem("item-1", "Blue notebook");

    assertEquals("Item: Blue notebook", example.findItem("item-1"));
  }
}
