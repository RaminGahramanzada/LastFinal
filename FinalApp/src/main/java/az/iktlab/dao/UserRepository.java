package az.iktlab.dao;

import az.iktlab.model.User;

public interface UserRepository  {
    int insertUser(User user);
    User getByNameAndSurname(String name,String surname);
}
