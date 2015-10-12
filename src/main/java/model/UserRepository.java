package model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by admin on 12.10.2015.
 */
public interface UserRepository extends JpaRepository<Note, Long> {
    Optional<User> fingByUsername(String note);
}
