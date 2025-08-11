package models;

import lombok.Data;

@Data
public class UserModel {
    private Integer id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private Integer userStatus;
}


