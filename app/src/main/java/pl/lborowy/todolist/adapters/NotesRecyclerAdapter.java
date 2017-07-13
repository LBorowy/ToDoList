package pl.lborowy.todolist.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import pl.lborowy.todolist.R;
import pl.lborowy.todolist.model.Note;
import pl.lborowy.todolist.viewHolders.NoteViewHolder;

/**
 * Created by RENT on 2017-07-13.
 */

public class NotesRecyclerAdapter extends RecyclerView.Adapter<NoteViewHolder> {

    private List<Note> noteList;
    private LayoutInflater inflater;
    private OnNoteClicked onNoteClicked;

    public NotesRecyclerAdapter(List<Note> noteList, Context context, OnNoteClicked onNoteClicked) { // przepisywanie naszej listy
        this.noteList = noteList;
        this.onNoteClicked = onNoteClicked;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); // ważne
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        NoteViewHolder viewHolder = new NoteViewHolder(view);
        return viewHolder;
        // parent -> recyclerview
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, final int position) {
        Note note = noteList.get(position);
        holder.nameTextView.setText(note.getName());
        holder.noteDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onNoteClicked != null) {
                    onNoteClicked.onDeleteClicked(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return noteList.size(); // gdyby była tablica to .length()
    }

    public interface OnNoteClicked {
        void onDeleteClicked(int position);

        void onUpClicked(int position);

        void onDownClicke(int position);
    }
}
