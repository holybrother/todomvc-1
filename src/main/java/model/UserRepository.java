package model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Note, Long> {
    Optional<User> fingByUsername(String username);


}
