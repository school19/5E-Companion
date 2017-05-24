package com.schoolerc.dungeoncompanion.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by Chaz on 5/23/2017.
 */

public class EntityProvider extends ContentProvider {

    private static final int ACTION_RACE_TEMPLATE = 1;

    private static UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
    static{
        matcher.addURI("com.schoolerc.dungeoncompanion.provider", "race_template", ACTION_RACE_TEMPLATE);
    }

    SQLiteOpenHelper openHelper;
    @Override
    public boolean onCreate() {
        openHelper = new DatabaseOpenHelper(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }
}
