package pl.lborowy.todolist.viewHolders;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.lborowy.todolist.R;

/**
 * Created by RENT on 2017-07-13.
 */

public class NoteViewHolder extends RecyclerView.ViewHolder{ // extends z dokumentacji

    @BindView(R.id.noteItem_noteName)
    public AppCompatTextView nameTextView;

    @BindView(R.id.noteItem_noteDown)
    public ImageView noteDown;

    @BindView(R.id.noteItem_noteUp)
    public ImageView noteUp;

    @BindView(R.id.noteItem_noteDelete)
    public ImageView noteDelete;

    @BindView(R.id.noteItem_noteEdit)
    public ImageView noteEdit;

    public NoteViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
