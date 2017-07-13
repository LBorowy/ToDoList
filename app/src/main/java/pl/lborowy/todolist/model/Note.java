package pl.lborowy.todolist.model;

/**
 * Created by RENT on 2017-07-13.
 */

public class Note {

    private String name;

    public Note() {
    }

    public Note(String note) {
        this.name = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
