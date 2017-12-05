package mve.spring.demo.controllers;

import mve.spring.demo.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PropertyInjectedController {

  @Autowired
  public GreetingService greetingServiceImpl;

  public String sayHello() {
    return greetingServiceImpl.sayGreeting();
  }
}
