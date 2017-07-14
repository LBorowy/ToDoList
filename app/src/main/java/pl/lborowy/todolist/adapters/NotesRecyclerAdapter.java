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
    public NotesRecyclerAdapter(List<Note> noteList, Context context, OnNoteClicked onNoteClicked) {
        this.noteList = noteList;
        this.onNoteClicked = onNoteClicked;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.note_item, parent, false);
        NoteViewHolder viewHolder = new NoteViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(final NoteViewHolder holder, final int position) {
        final Note note = noteList.get(position);
        holder.nameTextView.setText(note.getName());
        holder.noteDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onNoteClicked != null) {
                    onNoteClicked.onDeleteClicked(holder.getAdapterPosition());
//                    onNoteClicked.onDeleteClicked(position);
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return noteList.size();
    }
    public interface OnNoteClicked {
        void onDeleteClicked(int position);
        void onUpClicked(int position);
        void onDownClicked(int position);
    }
}
