package ylab.bies.ideaservice.exception;

import java.io.IOException;

public class IdeaNotFoundException extends IOException {
    public IdeaNotFoundException(Long id) {
        super("Idea with id=" + id + " not found");
    }
}
