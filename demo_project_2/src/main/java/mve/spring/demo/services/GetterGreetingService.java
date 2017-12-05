package mve.spring.demo.services;

import org.springframework.stereotype.Service;

@Service
public class GetterGreetingService implements GreetingService {

  @Override
  public String sayGreeting() {
    return "Hello from getter service";
  }
}