package mve.spring.demo.demo.model.repositories;

import mve.spring.demo.demo.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{

}
