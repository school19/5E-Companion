package com.schoolerc.fiftheditioncompanion.rules;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Chaz on 4/29/2017.
 */

public class PropertyModifier implements Parcelable {
    Property target;
    Operation operation;

    public PropertyModifier(){}
    protected PropertyModifier(Parcel parcel)
    {
        target = (Property) parcel.readSerializable();
        operation = parcel.readParcelable(getClass().getClassLoader());
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags)
    {
        out.writeSerializable(target);
        out.writeParcelable(operation, flags);
    }

    public static final Parcelable.Creator<PropertyModifier> CREATOR = new Parcelable.Creator<PropertyModifier>()
    {
        @Override
        public PropertyModifier createFromParcel(Parcel source) {
            return new PropertyModifier(source);
        }

        @Override
        public PropertyModifier[] newArray(int size) {
            return new PropertyModifier[size];
        }
    };
}
