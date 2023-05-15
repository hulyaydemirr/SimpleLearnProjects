package com.example.sportyShoes.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Login {
    @Id
    private String emailId;
    private String password;
    private String typeOfUser;
}
