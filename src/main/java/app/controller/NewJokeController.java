package app.controller;

import app.model.Joke;
import app.model.JokeForm;
import app.repository.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewJokeController {

    @Autowired
    private JokeRepository jokeRepository;

    @GetMapping("/new")
    public String newJokeForm(Model model) {
        model.addAttribute("jokeform", new JokeForm());
        return "new";
    }

    @PostMapping("/new")
    public String newJokeSubmit(@ModelAttribute JokeForm jokeForm) {
        jokeRepository.save(new Joke(jokeForm.getJoke()));
        return "submitted";
    }
}
