package com.schoolerc.dungeoncompanion.ui.display;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.schoolerc.dungeoncompanion.R;
import com.schoolerc.dungeoncompanion.util.FileUtil;
import com.schoolerc.dungeoncompanion.util.OnErrorListener;

import com.schoolerc.dungeoncompanion.ui.creator.CharacterCreatorActivity;

import java.io.File;
import java.io.IOException;


public class CharacterDisplayActivity extends Activity implements CharacterListFragment.OnEditCharacterListListener, OnErrorListener{

    private static final String TAG = "CharDisplayActivity";
    private static final String COMPONENTS_DIRECTORY = "components";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        try {
            Log.e(TAG, "Data directory: " + this.getFilesDir().list()[1]);
        }
        catch(Exception ex)
        {

        }
        this.getFilesDir().mkdirs();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        File componentsFile = new File(getFilesDir().getAbsolutePath() + File.separator + COMPONENTS_DIRECTORY);
        if(!componentsFile.exists())
        {
            try {
                FileUtil.unzip(getAssets().open("app.zip"), getFilesDir(), this);
            }
            catch(IOException ex)
            {
                onError(ex, "Failed to open asset file");
            }
        }
    }
	
    public void onAddCharacter()
    {
        Intent intent = new Intent(this, CharacterCreatorActivity.class);
        startActivity(intent);
    }

    public void onError(Exception exception, Object object)
    {
        Toast.makeText(this, (String)object, Toast.LENGTH_LONG).show();
    }
}
