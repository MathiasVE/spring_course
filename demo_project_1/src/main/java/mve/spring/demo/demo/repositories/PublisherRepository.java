package mve.spring.demo.demo.repositories;

import mve.spring.demo.demo.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
