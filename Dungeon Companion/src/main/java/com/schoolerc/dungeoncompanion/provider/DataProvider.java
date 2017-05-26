package com.schoolerc.dungeoncompanion.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.schoolerc.dungeoncompanion.data.Race.RaceContract;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Chaz on 5/23/2017.
 */

public class DataProvider extends ContentProvider {

    private static final int ACTION_RACES = 1;
    private static final int ACTION_RACE = 2;

    private static UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        matcher.addURI("com.schoolerc.dungeoncompanion.provider", "race", ACTION_RACES);
        matcher.addURI("com.schoolerc.dungeoncompanion.provider", "race/#", ACTION_RACE);
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
        switch (matcher.match(uri)) {
            case ACTION_RACES:
                return openHelper.getReadableDatabase().query(RaceContract.TABLE_NAME, projection, selection, selectionArgs, null, sortOrder, null);
            case ACTION_RACE:
                return openHelper.getReadableDatabase().query(RaceContract.TABLE_NAME, null, RaceContract._ID + "=?", new String[]{"" + ContentUris.parseId(uri)}, null, null, null, null);
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (matcher.match(uri)) {
            case ACTION_RACE:
                return "vnd.android.cursor.item/vnd.schoolerc.race";
            case ACTION_RACES:
                return "vnd.android.cursor.dir/vnd.schoolerc.race";
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        switch (matcher.match(uri)) {
            case ACTION_RACES:
                return ContentUris.withAppendedId(uri, openHelper.getWritableDatabase().insert(RaceContract.TABLE_NAME, null, values));
            default:
                return null;
        }
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        int count;
        switch (matcher.match(uri)) {
            case ACTION_RACE:
                if(selection != null)
                {
                    selection = "("+selection+") AND " + RaceContract._ID + "=?";
                    ArrayList<String> tmp = new ArrayList<>();
                    tmp.addAll(Arrays.asList(selectionArgs));
                    tmp.add(""+ContentUris.parseId(uri));
                    selectionArgs = new String[tmp.size()];
                    tmp.toArray(selectionArgs);
                }
                else{
                    selection = RaceContract._ID+"=?";
                    selectionArgs = new String[]{""+ContentUris.parseId(uri)};
                }
                count = openHelper.getWritableDatabase().delete(RaceContract.TABLE_NAME, selection, selectionArgs);
                break;
            case ACTION_RACES:
                count = openHelper.getWritableDatabase().delete(RaceContract.TABLE_NAME, selection, selectionArgs);
                break;
            default:
                count = 0;
                break;
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        int count;
        switch (matcher.match(uri)) {
            case ACTION_RACES:
                count = openHelper.getWritableDatabase().update(RaceContract.TABLE_NAME, values, selection, selectionArgs);
                break;
            case ACTION_RACE:
                if(selection != null)
                {
                    selection = "("+selection+") AND " + RaceContract._ID + "=?";
                    ArrayList<String> tmp = new ArrayList<>();
                    tmp.addAll(Arrays.asList(selectionArgs));
                    tmp.add(""+ContentUris.parseId(uri));
                    selectionArgs = new String[tmp.size()];
                    tmp.toArray(selectionArgs);
                }
                else{
                    selection = RaceContract._ID+"=?";
                    selectionArgs = new String[]{""+ContentUris.parseId(uri)};
                }
                count = openHelper.getWritableDatabase().update(RaceContract.TABLE_NAME, values, selection, selectionArgs);
                break;
            default:
                count = 0;
                break;
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
    }
}
