package mve.spring.demo.controllers;

import mve.spring.demo.services.GreetingService;
import mve.spring.demo.services.GreetingServiceImpl;

public class GetterInjectedController {
  private GreetingService greetingService;

  public String sayHello() {
    return greetingService.sayGreeting();
  }

  public void setGreetingService(GreetingService greetingService) {
    this.greetingService = greetingService;
  }
}
