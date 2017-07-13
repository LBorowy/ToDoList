package pl.lborowy.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.lborowy.todolist.adapters.NotesRecyclerAdapter;
import pl.lborowy.todolist.model.Note;

public class MainActivity extends AppCompatActivity implements NotesRecyclerAdapter.OnNoteClicked {

    @BindView(R.id.main_noteEditText)
    EditText noteEditText;

    @BindView(R.id.main_addButton)
    AppCompatButton addButton;

    @BindView(R.id.main_recyclerView)
    RecyclerView recyclerView;

    List<Note> noteList;

    LinearLayoutManager linearLayoutManager;


    private NotesRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        prepareNotesData();
        prepareRecyclerAdapter();
    }

    private void prepareNotesData() {
        // tworzenie noteList
        noteList = new ArrayList<>();
        noteList.add(new Note("testowa notka"));
    }

    private void prepareRecyclerAdapter() {
        adapter = new NotesRecyclerAdapter(noteList, getApplicationContext(), this);
        recyclerView.setAdapter(adapter);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @OnClick(R.id.main_addButton)
    public void addNote() {
        Note note = new Note();
        note.setName(noteEditText.getText().toString().trim());
        noteList.add(0, note);
        adapter.notifyItemInserted(0); // na zerowej pozycji cos zostalo wprowadzeone / przesuwanie innych na dol
        linearLayoutManager.scrollToPosition(0);
        noteEditText.setText("");
    }

    @Override
    public void onDeleteClicked(int position) {

    }

    @Override
    public void onUpClicked(int position) {

    }

    @Override
    public void onDownClicke(int position) {

    }
}
