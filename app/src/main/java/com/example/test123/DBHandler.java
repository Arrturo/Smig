package com.example.test123;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBHandler extends SQLiteOpenHelper {
    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "smig";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "users";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our course name column
    private static final String USERNAME_COL = "username";

    // below variable id for our course duration column.
    private static final String EMAIL_COL = "email";

    // below variable for our course description column.
    private static final String PHONE_COL = "phone";

    // below variable is for our course tracks column.
    private static final String PASSWORD_COL = "password";

    private static final String DISCOUNT_COL = "discount";

    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public void addNewUser(String username, String email, String phone, String password) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(USERNAME_COL, username);
        values.put(EMAIL_COL, email);
        values.put(PHONE_COL, phone);
        values.put(PASSWORD_COL, password);
        values.put(DISCOUNT_COL, 0);

        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USERNAME_COL + " TEXT,"
                + EMAIL_COL + " TEXT,"
                + PHONE_COL + " TEXT,"
                + PASSWORD_COL + " TEXT,"
                + DISCOUNT_COL + " INTEGER)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public User getUser() {
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorCourses = db.rawQuery("SELECT * FROM users", null);
        User user = null;
        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                user = new User(cursorCourses.getString(1), cursorCourses.getString(2), cursorCourses.getString(3), cursorCourses.getString(4));
            }
            while (cursorCourses.moveToNext());
            // at last closing our cursor
            cursorCourses.close();
            
        }
        return user;
    }
}

