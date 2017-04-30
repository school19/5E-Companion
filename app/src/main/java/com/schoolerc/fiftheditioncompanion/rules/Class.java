package com.schoolerc.fiftheditioncompanion.rules;

import android.os.Parcel;
import android.os.Parcelable;

import com.schoolerc.fiftheditioncompanion.rules.visitors.ComponentVisitor;
/**
 * Created by Chaz Schooler on 2/5/2017.
 */

public class Class extends Component implements Parcelable{

    private int levels;
    private int hitDieSides;

    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitClassComponent(this);
    }

    public Class()
    {
    }

    protected Class(Parcel source)
    {
        super(source);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
    }

    public static final Creator<Class> CREATOR = new Creator<Class>() {
        @Override
        public Class createFromParcel(Parcel source) {
            return new Class(source);
        }

        @Override
        public Class[] newArray(int size) {
            return new Class[size];
        }
    };
}
