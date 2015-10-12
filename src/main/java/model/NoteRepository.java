package model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

/**
 * Created by admin on 12.10.2015.
 */
public interface NoteRepository extends JpaRepository<Note, Long> {
    Collection<Note> findByUserUsername(String username);
}
