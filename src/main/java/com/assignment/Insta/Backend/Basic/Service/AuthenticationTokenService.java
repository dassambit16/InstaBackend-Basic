package com.assignment.Insta.Backend.Basic.Service;

import com.assignment.Insta.Backend.Basic.Model.AuthenticationToken;
import com.assignment.Insta.Backend.Basic.Model.dto.AuthenticatedInputDto;
import com.assignment.Insta.Backend.Basic.Repo.IAuthenticationTokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationTokenService {
    @Autowired
    IAuthenticationTokenRepo tokenRepo;


    public void createToken(AuthenticationToken authToken) {
        tokenRepo.save(authToken);
    }

    public boolean authenticate(AuthenticatedInputDto authInfo) {
        String email = authInfo.getEmail();
        String tokenValue = authInfo.getTokenValue();
        AuthenticationToken token = tokenRepo.findFirstByToken(tokenValue);
        if(token != null){
            return token.getUser().getUserEmail().equals(email);
        }
        return false;
    }

    public void deleteToken(String tokenValue) {
        AuthenticationToken token = tokenRepo.findFirstByToken(tokenValue);
        tokenRepo.delete(token);
    }

    public boolean authenticate(String email, String tokenValue) {
        AuthenticationToken token =  tokenRepo.findFirstByToken(tokenValue);
        if(token!=null)
        {
            return token.getUser().getUserEmail().equals(email);
        }
        else
        {
            return false;
        }
    }
}
