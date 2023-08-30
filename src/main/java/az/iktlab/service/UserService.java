package az.iktlab.service;

import az.iktlab.model.User;

public interface UserService {
    int insertUser(User user);
    User getByNameAndSurname(String name,String surname);
}
