package mve.spring.demo.demo.model.repositories;

import mve.spring.demo.demo.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
