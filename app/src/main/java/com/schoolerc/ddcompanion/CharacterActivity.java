package com.schoolerc.ddcompanion;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toolbar;

public class CharacterActivity extends Activity {

    private static final String TAG = "CharacterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);
    }
}
