package sem3;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FileDoesNotExist extends IOException {
    public FileDoesNotExist() {
        super("This file doesn't exist");
    }
}
