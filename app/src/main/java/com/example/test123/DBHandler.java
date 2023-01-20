package com.example.test123;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;



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

    private static final String USER_ID = "2";

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
                + DISCOUNT_COL + " INTEGER DEFAULT 0)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public User getUser() {
        SQLiteDatabase db = this.getReadableDatabase();
        User user = null;
        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorCourses = db.rawQuery("SELECT * FROM users WHERE id=" + USER_ID, null);
        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                user = new User(cursorCourses.getString(1), cursorCourses.getString(2), cursorCourses.getString(3), cursorCourses.getString(4), cursorCourses.getInt(5));
            }
            while (cursorCourses.moveToNext());
            // at last closing our cursor
            cursorCourses.close();

        }
        return user;
    }

    public void updateUser(String username, String email, String phone, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USERNAME_COL, username);
        values.put(EMAIL_COL, email);
        values.put(PHONE_COL, phone);
        values.put(PASSWORD_COL, password);
        db.update(TABLE_NAME, values, "id="+USER_ID, null);
        db.close();
    }

    public void addDiscount(int discount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DISCOUNT_COL, discount);
        db.update(TABLE_NAME, values, "id=" + USER_ID, null);
        db.close();
    }
    public int getDiscount(){
        SQLiteDatabase db = this.getReadableDatabase();
        int discount = 0;
        Cursor cursorCourses = db.rawQuery("SELECT * FROM users WHERE id=" + USER_ID, null);
        if (cursorCourses.moveToFirst()) {
            do {
                discount = cursorCourses.getInt(5);
            }
            while (cursorCourses.moveToNext());
            cursorCourses.close();
        }
        return discount;
    }

    public void addTicket(String rodzaj, double cena){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("rodzaj", rodzaj);
        values.put("cena", cena);
        db.insert("ticket", null, values);
    }

    public void sendReport(String topic, String message){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("topic", topic);
        values.put("message", message);
        db.insert("report", null, values);
    }
    public void createTable(){
    }
//    get all bus numbers from database
    public ArrayList<String> getAllBusNumbers(){
        ArrayList<String> busNumbers = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM timetable", null);
        if (cursor.moveToFirst()) {
            do {
                busNumbers.add(cursor.getString(1));
            }
            while (cursor.moveToNext());
            cursor.close();
        }
        return busNumbers;
    }

    public ArrayList<String> getBusNumber(int id){
        ArrayList<String> busNumbers = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM timetable WHERE id="+id, null);
        if (cursor.moveToFirst()) {
            do {
                busNumbers.add(cursor.getString(1));
            }
            while (cursor.moveToNext());
            cursor.close();
        }
        return busNumbers;
    }


    public ArrayList<String> getAllRoutes(int id){
        ArrayList<String> routes = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM timetable WHERE id=" + id, null);
//        ArrayList<String> routesList = new ArrayList<String>(Arrays.asList(routes.split(",")));
        if (cursor.moveToFirst()) {
            do {
                String[] routesList = cursor.getString(2).split(",");
                for (String route : routesList) {
                    if (!routes.contains(route)) {
                        routes.add(route);
                    }
                }
            }
            while (cursor.moveToNext());
            cursor.close();
        }
        return routes;
    }

    //get all time from timetable table
    public ArrayList<String> getAllTime(int id){
        ArrayList<String> times = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM timetable WHERE id=" + id, null);
//        ArrayList<String> routesList = new ArrayList<String>(Arrays.asList(routes.split(",")));
        if (cursor.moveToFirst()) {
            do {
                String[] routesList = cursor.getString(3).split(",");
                for (String route : routesList) {
                    if (!times.contains(route)) {
                        times.add(route);
                    }
                }
            }
            while (cursor.moveToNext());
            cursor.close();
        }
        return times;
    }

    //get current id from timetable table
    public int getCurrentId(String busNumber){
        int id = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM timetable WHERE bus_number='" + busNumber + "'", null);
        if (cursor.moveToFirst()) {
            do {
                id = cursor.getInt(0);
            }
            while (cursor.moveToNext());
            cursor.close();
        }
        return id;
    }
}


