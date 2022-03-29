package com.ineo.learn.springframework.controllers;

import com.ineo.learn.springframework.repositories.PublisherRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublisherController {

    private final PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @RequestMapping("/publishers")
    public String getBooks(Model model) {
        model.addAttribute("publishers" , publisherRepository.findAll());
        return "publishers/list";
    }
}
