package mve.spring.demo.controllers;

import mve.spring.demo.services.GreetingServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GetterInjectedControllerTest {
  private GetterInjectedController getterInjectedController;

  @Before
  public void setUp() throws Exception {
    this.getterInjectedController = new GetterInjectedController();
    this.getterInjectedController.setGreetingService(new GreetingServiceImpl());
  }

  @Test
  public void testGreeting() throws Exception {
    Assert.assertEquals(GreetingServiceImpl.HELLO_WORLD, this.getterInjectedController.sayHello());
  }
}
