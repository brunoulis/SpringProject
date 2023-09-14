package bruno.luis.springproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import bruno.luis.springproject.model.UserModel;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.http.HttpSession;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    HttpSession session;

    private Logger log = LoggerFactory.getLogger(UserDetailServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Usuario que llega al login: {}", username);
        Optional<UserModel> optUser = userService.findByEmail(username);
        if (optUser.isPresent()) {
            log.info("Usuario que llega al login: {}", optUser.get().getId());
            session.setAttribute("user", optUser.get());
            UserModel user = optUser.get();
            return User.builder().username(user.getName()).password(encoder.encode(user.getPassword()))
                    .roles(user.getType()).build();

        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");

        }

    }

}