package com.assignment.Insta.Backend.Basic.Service;

import com.assignment.Insta.Backend.Basic.Model.AuthenticationToken;
import com.assignment.Insta.Backend.Basic.Model.User;
import com.assignment.Insta.Backend.Basic.Model.dto.AuthenticatedInputDto;
import com.assignment.Insta.Backend.Basic.Model.dto.SignInInputDto;
import com.assignment.Insta.Backend.Basic.Repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;
    @Autowired
    AuthenticationTokenService tokenService;

    public String userSignUp(User user) {
        String email = user.getUserEmail();
        User existingEmail = userRepo.findFistByUserEmail(email);
        if(existingEmail != null) {
            return "Email already in use!";
        }
        String signUpPassword = user.getUserPassword();
        try {
            String encryptedPassword = PasswordEncryptor.encrypt(signUpPassword);
            user.setUserPassword(encryptedPassword);
            userRepo.save(user);
            return "User Registered!";
        } catch (NoSuchAlgorithmException e) {
            return "Internal Server issue while signing up, please try again later!";
        }
    }

    public String userSignIn(SignInInputDto signInInputDto) {
        String email = signInInputDto.getEmail();
        User existingUser = userRepo.findFistByUserEmail(email);
        if(existingUser == null) {
            return "User not registered, Sign up first";
        }
        String password = signInInputDto.getPassword();
        try {
            String encryptedPassword = PasswordEncryptor.encrypt(password);
            if(existingUser.getUserPassword().equals(encryptedPassword)) {
                AuthenticationToken authToken = new AuthenticationToken(existingUser);
                if(EmailService.sendEmail(email, "OTP", authToken.getToken())) {
                    tokenService.createToken(authToken);
                    return "Check email for OTP";
                }else {
                    return "Error while generating token";
                }
            }
            else {
                return "Invalid Credential";
            }
        } catch (NoSuchAlgorithmException e) {
            return "Un Authorised Credential";
        }

    }

    public String userSignOut(AuthenticatedInputDto authInfo) {
        if(tokenService.authenticate(authInfo)){
            String tokenValue = authInfo.getTokenValue();
            tokenService.deleteToken(tokenValue);
            return "Signed Out!";
        }else{
            return "UnAuthenticated Access!";
        }
    }
}
