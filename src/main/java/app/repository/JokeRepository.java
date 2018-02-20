package app.repository;

import app.model.Joke;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JokeRepository extends CrudRepository<Joke, Long> {

}
