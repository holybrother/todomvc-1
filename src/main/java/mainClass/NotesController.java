package mainClass;

import model.Note;
import model.NoteRepository;
import model.User;
import model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;


@RestController // http://localhost:8080/root/notes
@RequestMapping("{username}/notes")
public class NotesController {
    @Autowired
    NoteRepository noteRepository;
    @Autowired
    UserRepository userRepository;

    @RequestMapping
    Collection<Note> readNotes(@PathVariable String username) {
        return noteRepository.findByUserUsername(username);
    }

    @RequestMapping(method= RequestMethod.POST)
    public void addNote(@PathVariable String username, @Valid @RequestBody Note note){
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));
        note.setUser(user);
        noteRepository.save(note);
    }



}

@ResponseStatus(HttpStatus.NOT_FOUND)
class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String username) {
        super("could not find user '" + username + "'.");
    }
}