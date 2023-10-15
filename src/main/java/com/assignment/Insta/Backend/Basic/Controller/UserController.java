package com.assignment.Insta.Backend.Basic.Controller;

import com.assignment.Insta.Backend.Basic.Model.AuthenticationToken;
import com.assignment.Insta.Backend.Basic.Model.User;
import com.assignment.Insta.Backend.Basic.Model.dto.AuthenticatedInputDto;
import com.assignment.Insta.Backend.Basic.Model.dto.SignInInputDto;
import com.assignment.Insta.Backend.Basic.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("user/signUp")
    public String userSignUp(@RequestBody User user) {
        return userService.userSignUp(user);
    }
    @PostMapping("user/signIn")
    public String userSignIn(@RequestBody SignInInputDto signInInputDto) {
        return userService.userSignIn(signInInputDto);
    }

    @DeleteMapping ("user/signOut")
    public String userSignOut(@RequestBody AuthenticatedInputDto authInfo) {
        return userService.userSignOut(authInfo);
    }
}
