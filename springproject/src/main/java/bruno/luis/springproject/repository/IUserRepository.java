package bruno.luis.springproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bruno.luis.springproject.model.UserModel;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Integer> {
    Optional<UserModel> findByEmail(String email);

}
