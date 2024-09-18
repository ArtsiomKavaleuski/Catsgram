package ru.yandex.practicum.catsgram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.model.Post;
import ru.yandex.practicum.catsgram.service.PostService;

import java.util.Collection;
import java.util.Optional;

@RestController
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public Collection<Post> findAll(@RequestParam(defaultValue = "10") int size,
                                    @RequestParam(defaultValue = "asc") String sort,
                                    @RequestParam(defaultValue = "-1") int from) {
        return postService.findAll(size, sort, from);
    }

    @GetMapping("/posts/{id}")
    public Optional<Post> findById(@PathVariable("id") long id) {
        return postService.findById(id);
    }

    @PostMapping(value = "/post")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post) {
       return postService.create(post);
    }

    @PutMapping
    public Post update(@RequestBody Post newPost) {
        return postService.update(newPost);
    }
}