package bruno.luis.springproject.service;

import java.util.Optional;

import bruno.luis.springproject.model.User;

public interface IUserService {
    Optional<User> findById(Integer id);
    User save(User user);

}
