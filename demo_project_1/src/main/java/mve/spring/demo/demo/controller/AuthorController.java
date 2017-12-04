package mve.spring.demo.demo.controller;

import mve.spring.demo.demo.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

  @Autowired
  private AuthorRepository authorRepository;

  @RequestMapping("/authors")
  private String getAuthors(Model model) {
    model.addAttribute("authors", authorRepository.findAll());
    return "authors";
  }
}
