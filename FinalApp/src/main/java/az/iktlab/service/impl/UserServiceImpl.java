package az.iktlab.service.impl;

import az.iktlab.dao.UserRepository;
import az.iktlab.dao.impl.UserDaoImpl;
import az.iktlab.model.User;
import az.iktlab.service.UserService;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository = new UserDaoImpl();
    @Override
    public int insertUser(User user) {
        return userRepository.insertUser(user);
    }

    @Override
    public User getByNameAndSurname(String name, String surname) {
        return userRepository.getByNameAndSurname(name,surname);
    }
}
