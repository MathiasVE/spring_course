package mve.spring.demo.controllers;

import mve.spring.demo.services.GreetingService;
import mve.spring.demo.services.GreetingServiceImpl;

public class ConstructorInjectedController {
  private GreetingService greetingService;

  public ConstructorInjectedController(GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  public String sayHello() {
    return greetingService.sayGreeting();
  }
}
