package mve.spring.demo.demo.bootstrap;

import mve.spring.demo.demo.model.Author;
import mve.spring.demo.demo.model.Book;
import mve.spring.demo.demo.model.repositories.AuthorRepository;
import mve.spring.demo.demo.model.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

  @Autowired
  private AuthorRepository authorRepository;

  @Autowired
  private BookRepository bookRepository;

  private void initData() {
    Author mathias = new Author("Mathias", "Ver Elst");
    Book ddd = new Book("Domain Drive Design", "1234", "Harpin Collins");
    mathias.getBooks().add(ddd);
    ddd.getAuthors().add(mathias);

    authorRepository.save(mathias);
    bookRepository.save(ddd);

    Author rod = new Author("Rod", "Johnson");
    Book noEJB = new Book("J2EE Development without EJB", "23444", "Worx");
    rod.getBooks().add(noEJB);

    authorRepository.save(rod);
    bookRepository.save(noEJB);
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    initData();
  }
}
