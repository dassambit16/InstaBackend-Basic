package com.assignment.Insta.Backend.Basic.Repo;

import com.assignment.Insta.Backend.Basic.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepo extends JpaRepository<User, Integer> {
    User findFistByUserEmail(String email);
}
