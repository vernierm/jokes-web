package app.service;

import app.model.Joke;
import app.repository.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service("jokeService")
public class JokeServiceImpl implements JokeService {

    @Autowired
    private JokeRepository jokeRepository;

    @Override
    public List<Joke> findAllJokesSorted() {
        List<Joke> jokes = new ArrayList<>();
        jokeRepository.findAll().forEach(jokes::add);
        jokes.sort(Comparator.<Joke>comparingInt((joke) -> (joke.getLikes() - joke.getDislikes())).reversed());
        return jokes;
    }

    @Override
    public void likeJoke(Long id) {
        Joke j = jokeRepository.findOne(id);
        j.setLikes(j.getLikes() + 1);
        jokeRepository.save(j);
    }

    @Override
    public void dislikeJoke(Long id) {
        Joke j = jokeRepository.findOne(id);
        j.setDislikes(j.getDislikes() + 1);
        jokeRepository.save(j);
    }
}
