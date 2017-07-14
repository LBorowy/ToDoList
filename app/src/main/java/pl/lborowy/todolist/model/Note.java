package pl.lborowy.todolist.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by RENT on 2017-07-13.
 */

public class Note implements Parcelable { // do bardziej skomplikowanych elementów w Bundle

    private String name;

    public Note() {
    }

    public Note(String note) {
        this.name = note;
    }

    protected Note(Parcel in) {
        name = in.readString();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }
}
