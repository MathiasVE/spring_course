package mve.spring.demo.controllers;

import mve.spring.demo.services.GreetingService;
import mve.spring.demo.services.GreetingServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PropertyInjectedControllerTest {
  private PropertyInjectedController propertyInjectedController;

  @Before
  public void setUp() throws Exception {
    this.propertyInjectedController = new PropertyInjectedController();
    this.propertyInjectedController.greetingService = new GreetingServiceImpl();
  }

  @Test
  public void testGreeting() throws Exception {
    Assert.assertEquals(GreetingServiceImpl.HELLO_WORLD, this.propertyInjectedController.sayHello());
  }
}
