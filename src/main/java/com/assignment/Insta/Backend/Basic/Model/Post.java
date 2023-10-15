package com.assignment.Insta.Backend.Basic.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
    @Id
    private Integer postId;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private String postData;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;
}
