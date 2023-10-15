package com.assignment.Insta.Backend.Basic.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AuthenticationToken {
    @Id
    private Long tokenId;
    private String token;
    private LocalDate tokenCreationDate;

    @OneToOne
    private User user;

    public AuthenticationToken(User existingUser) {
        this.user = existingUser;
        this.tokenCreationDate = LocalDate.now();
        this.token = UUID.randomUUID().toString();
    }
}
