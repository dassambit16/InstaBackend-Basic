package com.assignment.Insta.Backend.Basic.Repo;

import com.assignment.Insta.Backend.Basic.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;

public interface IPostRepo extends JpaRepository<Post, Integer> {
}
