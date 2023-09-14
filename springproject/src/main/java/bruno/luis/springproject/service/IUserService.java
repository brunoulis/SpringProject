package bruno.luis.springproject.service;

import java.util.Optional;

import java.util.List;

import bruno.luis.springproject.model.UserModel;

public interface IUserService {
    List<UserModel> findAll();

    Optional<UserModel> findById(Integer id);

    UserModel save(UserModel user);

    Optional<UserModel> findByEmail(String email);

}
