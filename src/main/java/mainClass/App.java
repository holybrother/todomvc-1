package mainClass;

import model.Note;
import model.NoteRepository;
import model.User;
import model.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
@EnableAutoConfiguration


public class App {
    @Bean
    CommandLineRunner init(UserRepository userRepository, NoteRepository noteRepository) {
        return (evt) -> {
            User user = new User();
            user.setUsername("root");
            user.setPassword("root");
            userRepository.save((Iterable<Note>) user);
            Note note = new Note();
            note.setUser(user);
            note.setText("test note");
            noteRepository.save(note);

            user = new User();
            user.setUsername("root1");
            user.setPassword("root1");
            userRepository.save((Iterable<Note>) user);
            note = new Note();
            note.setUser(user);
            note.setText("vvv note");
            noteRepository.save(note);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}