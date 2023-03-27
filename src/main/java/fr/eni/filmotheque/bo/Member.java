package fr.eni.filmotheque.bo;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Member {
    long id;
    String firstName;
    String lastName;
    String login;
    String password;
    Boolean isAdmin;

    public Member(String firstName, String lastName, String login, String password, Boolean isAdmin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
    }
}
