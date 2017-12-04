package mve.spring.demo.demo.bootstrap;

import mve.spring.demo.demo.model.Author;
import mve.spring.demo.demo.model.Book;
import mve.spring.demo.demo.model.Publisher;
import mve.spring.demo.demo.model.repositories.AuthorRepository;
import mve.spring.demo.demo.model.repositories.BookRepository;
import mve.spring.demo.demo.model.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

  @Autowired
  private PublisherRepository publisherRepository;

  @Autowired
  private AuthorRepository authorRepository;

  @Autowired
  private BookRepository bookRepository;

  private void initData() {

    Publisher harpin = new Publisher("Harpin Collins", "221B Baker Street, London");
    Author mathias = new Author("Mathias", "Ver Elst");
    Book ddd = new Book("Domain Drive Design", "1234", harpin);
    mathias.getBooks().add(ddd);
    ddd.getAuthors().add(mathias);

    publisherRepository.save(harpin);
    authorRepository.save(mathias);
    bookRepository.save(ddd);

    Publisher worx = new Publisher("Worx", "221B Baker Street, London");
    Author rod = new Author("Rod", "Johnson");
    Book noEJB = new Book("J2EE Development without EJB", "23444", worx);
    rod.getBooks().add(noEJB);

    publisherRepository.save(worx);
    authorRepository.save(rod);
    bookRepository.save(noEJB);
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    initData();
  }
}
