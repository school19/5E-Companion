package com.schoolerc.ddcompanion.data;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by Chaz Schooler on 3/12/2017.
 */

public class ComponentService extends Service {
    private final IBinder binder = new ComponentServiceBinder();
    public IBinder onBind(Intent intent)
    {
        return null;
    }
}
