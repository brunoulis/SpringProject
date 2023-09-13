package bruno.luis.springproject.service;

import java.util.Optional;

import java.util.List;

import bruno.luis.springproject.model.User;

public interface IUserService {
    List<User> findAll();
    Optional<User> findById(Integer id);
    User save(User user);
    Optional<User> findByEmail(String email);

}
