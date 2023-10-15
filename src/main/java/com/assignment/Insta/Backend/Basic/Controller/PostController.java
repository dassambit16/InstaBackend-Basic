package com.assignment.Insta.Backend.Basic.Controller;

import com.assignment.Insta.Backend.Basic.Model.Post;
import com.assignment.Insta.Backend.Basic.Service.AuthenticationTokenService;
import com.assignment.Insta.Backend.Basic.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping("create/post")
    public String createPost(@RequestParam String email, @RequestParam String tokenValue, @RequestBody Post newPost) {
        return postService.createPost(email,tokenValue, newPost);
    }

    @GetMapping("post/{id}")
    public List<Post> getAllPost() {
        return postService.getAllPost();
    }
}
