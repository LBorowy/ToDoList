package pl.lborowy.todolist.dialogs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.lborowy.todolist.R;
import pl.lborowy.todolist.model.Note;

/**
 * Created by RENT on 2017-07-14.
 */

public class EditNoteDialog extends DialogFragment {

    private static final String NOTE_KEY = "note";
    private static final String NOTE_INDEX_KEY = "note_index";

    @BindView(R.id.editNote_nameText)
    EditText nameText;

    @BindView(R.id.editNote_saveButton)
    Button saveButton;

    private Note note;
    private int noteIndex;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_edit_note, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    // tworzenie danych
    public EditNoteDialog newInstance(Note note, int position) {
        EditNoteDialog editNoteDialog = new EditNoteDialog();
        Bundle bundle = new Bundle();
        bundle.putParcelable(NOTE_KEY, note); // * implements parcelable w modelu Note
        bundle.putInt(NOTE_INDEX_KEY, position);
        editNoteDialog.setArguments(bundle);
        return editNoteDialog;
    }

    // odzyskiwanie danych

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            note = arguments.getParcelable(NOTE_KEY);
            noteIndex = arguments.getInt(NOTE_INDEX_KEY);
        }
    }
}
