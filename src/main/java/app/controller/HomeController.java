package app.controller;

import app.model.Joke;
import app.repository.JokeRepository;
import app.service.JokeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Iterator;

@Controller
public class HomeController {

    @Autowired
    private JokeService jokeService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("jokes", jokeService.findAllJokesSorted());
        return "index" ;
    }

    @PostMapping("/like/{id}")
    public String like(@PathVariable("id") String id) {
        jokeService.likeJoke(Long.valueOf(id));
        return "redirect:/";
    }

    @PostMapping("/dislike/{id}")
    public String dislike(@PathVariable("id") String id) {
        jokeService.dislikeJoke(Long.valueOf(id));
        return "redirect:/";
    }
}
