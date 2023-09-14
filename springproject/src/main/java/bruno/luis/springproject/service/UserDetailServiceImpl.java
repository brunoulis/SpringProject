package bruno.luis.springproject.service;

/*
 * Esta clase implementa la interfaz `UserDetailsService`, que es utilizada por Spring Security para cargar
 * los detalles del usuario desde la base de datos.
 */

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
/*
 * Esta anotación marca esta clase como un bean de Spring.
 */
public class UserDetailServiceImpl implements UserDetailsService {

/*
 * Este campo está inyectado con el bean `IUserService`, que proporciona métodos para acceder a la base de datos de usuarios.
 */
    @Autowired
    private IUserService userService;

/*
 * Este campo se utiliza para encriptar contraseñas.
 */
    private BCryptPasswordEncoder encoder;

/*
 * Este campo está inyectado con el bean `HttpSession`, que proporciona acceso a la sesión HTTP actual.
 */
    @Autowired
    HttpSession session;

/*
 * Este campo es un registrador que se puede utilizar para escribir mensajes de registro.
 */
    private Logger log = LoggerFactory.getLogger(UserDetailServiceImpl.class);

/*
 * Este método es utilizado por Spring Security para cargar los detalles del usuario desde la base de datos.
 */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Usuario que llega al login: {}", username);
        /*
         * Este método obtiene al usuario de la base de datos por su nombre de usuario.
         */
        Optional<UserModel> optUser = userService.findByEmail(username);
        if (optUser.isPresent()) {
            log.info("Usuario que llega al login: {}", optUser.get().getId());
            /*
             * Este método establece al usuario en la sesión HTTP actual.
             */
            session.setAttribute("user", optUser.get());
            UserModel user = optUser.get();
            /*
             * Este método crea un objeto `User` a partir del modelo de usuario.
             */
            return User.builder().username(user.getName()).password(encoder.encode(user.getPassword()))
                    .roles(user.getType()).build();

        } else {
            throw new UsernameNotFoundException("Usuario no encontrado");

        }

    }

}
