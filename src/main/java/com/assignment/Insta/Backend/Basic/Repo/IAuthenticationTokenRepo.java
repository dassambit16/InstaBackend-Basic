package com.assignment.Insta.Backend.Basic.Repo;

import com.assignment.Insta.Backend.Basic.Model.AuthenticationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthenticationTokenRepo extends JpaRepository<AuthenticationToken, Long> {
    AuthenticationToken findFirstByToken(String tokenValue);
}
