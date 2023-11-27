package com.yvidoes;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbhelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "video_database";
    private static final int DATABASE_VERSION = 12;

    public static final String TABLE_VIDEOS = "videos";
    public static final String VIDEOS_ID = "id";
    public static final String VIDEOS_URI = "videouri";
    public static final String VIDEOS_NAME = "videouri";

    // Database creation SQL statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_VIDEOS + "("
            + VIDEOS_ID + " integer primary key autoincrement, "
            + VIDEOS_URI + " text not null, "
            + VIDEOS_NAME + " text);";

    public dbhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Not needed for this example
    }
    public long insertVideo(String videoUri) {
        SQLiteDatabase database = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(VIDEOS_URI, videoUri);

        long newRowId = database.insert(TABLE_VIDEOS, null, values);
        database.close();

        return newRowId;
    }

    public Cursor getAllVideos() {
        SQLiteDatabase database = getReadableDatabase();

        String[] projection = {VIDEOS_ID, VIDEOS_URI};

        Cursor cursor = database.query(TABLE_VIDEOS, projection,
                null, null, null, null, null);


        return cursor;
    }
}

