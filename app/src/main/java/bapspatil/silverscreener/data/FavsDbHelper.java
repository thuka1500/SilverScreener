package bapspatil.silverscreener.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FavsDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "favorites.db";
    private static final int DATABASE_VERSION = 1;

    public FavsDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_FAVORITES_TABLE = "CREATE TABLE " + FavsContract.FavoritesEntry.TABLE_NAME + " (" +
                FavsContract.FavoritesEntry._ID + " INTEGER PRIMARY KEY," +
                FavsContract.FavoritesEntry.COLUMN_TITLE + " TEXT NOT NULL," +
                FavsContract.FavoritesEntry.COLUMN_PLOT + " TEXT NOT NULL," +
                FavsContract.FavoritesEntry.COLUMN_RATING + " TEXT NOT NULL," +
                FavsContract.FavoritesEntry.COLUMN_DATE + " TEXT NOT NULL)";
        db.execSQL(SQL_CREATE_FAVORITES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + FavsContract.FavoritesEntry.TABLE_NAME);
        onCreate(db);
    }

}