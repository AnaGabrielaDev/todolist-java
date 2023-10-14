package br.com.anagabriela.todolist.user;

import lombok.Data;

@Data // lombok add getters and setter to Model
public class UserModel {
    private String name;
    private String username;
    private String password;
}
