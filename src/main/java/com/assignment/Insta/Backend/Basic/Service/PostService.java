package com.assignment.Insta.Backend.Basic.Service;

import com.assignment.Insta.Backend.Basic.Model.Post;
import com.assignment.Insta.Backend.Basic.Model.User;
import com.assignment.Insta.Backend.Basic.Repo.IPostRepo;
import com.assignment.Insta.Backend.Basic.Repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    IPostRepo postRepo;

    @Autowired
    IUserRepo userRepo;

    @Autowired
    AuthenticationTokenService authenticationTokenService;

    public String createPost(String email, String tokenValue, Post newPost) {
        if(authenticationTokenService.authenticate(email,tokenValue)) {
            User existingUser = userRepo.findFistByUserEmail(email);
            newPost.setUser(existingUser);

            postRepo.save(newPost);
            return "posted!";
        }else{
            return "Un Authenticated Access!";
        }
    }

    public List<Post> getAllPost() {
        return postRepo.findAll();
    }
}
