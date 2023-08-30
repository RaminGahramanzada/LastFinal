package az.iktlab.controller;

import az.iktlab.model.User;
import az.iktlab.service.UserService;
import az.iktlab.service.impl.UserServiceImpl;

public class UserController {
    private final UserService userService = new UserServiceImpl();
    public int insertUser(User user) {
        return userService.insertUser(user);
    }

    public User getByNameAndSurname(String name, String surname) {
        return userService.getByNameAndSurname(name,surname);
    }
}
