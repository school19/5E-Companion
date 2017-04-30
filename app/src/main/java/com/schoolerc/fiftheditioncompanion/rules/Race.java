package com.schoolerc.fiftheditioncompanion.rules;


import android.os.Parcel;
import android.os.Parcelable;

import com.schoolerc.fiftheditioncompanion.rules.visitors.ComponentVisitor;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;


@Root
public class Race extends Component implements Parcelable {

    @Element
    String name;

    @Element
    private int speed;

    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitRaceComponent(this);
    }

    public Race()
    {
    }

    private Race(Parcel source)
    {
        super(source);
        name = source.readString();
        speed = source.readInt();
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeString(name);
        dest.writeInt(speed);
    }

    public static final Creator<Race> CREATOR = new Creator<Race>(){
        @Override
        public Race createFromParcel(Parcel source) {
            return new Race(source);
        }

        @Override
        public Race[] newArray(int size) {
            return new Race[size];
        }
    };
}
