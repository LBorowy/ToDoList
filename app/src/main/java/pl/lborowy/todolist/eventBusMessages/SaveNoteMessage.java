package pl.lborowy.todolist.eventBusMessages;

import pl.lborowy.todolist.model.Note;

/**
 * Created by RENT on 2017-07-14.
 */

public class SaveNoteMessage {
    private Note note;
    private int position;

    //eventBus tylko konstruktor i gettery


    public SaveNoteMessage(Note note, int position) {
        this.note = note;
        this.position = position;
    }

    public Note getNote() {
        return note;
    }

    public int getPosition() {
        return position;
    }
}
