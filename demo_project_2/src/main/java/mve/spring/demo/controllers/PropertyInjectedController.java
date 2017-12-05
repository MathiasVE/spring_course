package mve.spring.demo.controllers;

import mve.spring.demo.services.GreetingServiceImpl;

public class PropertyInjectedController {
  public GreetingServiceImpl greetingService;

  public String sayHello() {
    return greetingService.sayGreeting();
  }
}
