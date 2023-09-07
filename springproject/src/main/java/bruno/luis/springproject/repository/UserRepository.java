package bruno.luis.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bruno.luis.springproject.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer >{

}
