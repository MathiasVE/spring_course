package mve.spring.demo.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PrimaryGreeting implements GreetingService {
  @Override
  public String sayGreeting() {
    return "Hello from primary";
  }
}
