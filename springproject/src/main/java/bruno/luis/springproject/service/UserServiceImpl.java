package bruno.luis.springproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bruno.luis.springproject.model.User;
import bruno.luis.springproject.repository.IUserRepository;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Override
    public Optional<User> findById(Integer id) {
        // TODO Auto-generated method stub
        return userRepository.findById(id);
    }

    

}
