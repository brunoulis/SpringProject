package bruno.luis.springproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bruno.luis.springproject.model.User;
import bruno.luis.springproject.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Optional<User> findById(Integer id) {
        // TODO Auto-generated method stub
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        // TODO Auto-generated method stub
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        // TODO Auto-generated method stub
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        return userRepository.findAll();
    }

}
