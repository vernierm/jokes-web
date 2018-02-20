package app.service;

import app.model.Joke;

import java.util.List;

public interface JokeService {

    List<Joke> findAllJokesSorted();

    void likeJoke(Long id);

    void dislikeJoke(Long id);
}
