package com.example.test123;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class DBHandler extends SQLiteOpenHelper {
    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "smig";

    // below int is our database version
    private static final int DB_VERSION = 1;

    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


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

    private static String USER_ID = "2";

    public void setUSER_ID(String USER_ID) {
        DBHandler.USER_ID = USER_ID;
    }


    public boolean Login(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM users WHERE username = ? AND password = ?", new String[]{username, password});
        while (cursor.moveToNext()) {
            setUSER_ID(cursor.getString(0));
            return true;
        }
        return false;
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

    public void sendReport(String topic, String message){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("topic", topic);
        values.put("message", message);
        db.insert("report", null, values);
    }

    public void buyTicket(String rodzaj, float cena, int ilosc, int linia, int time){
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("rodzaj", rodzaj);
        values.put("cena", cena);
        values.put("data_zakupu", formatter.format(date));
        values.put("linia", linia);
        values.put("id_klienta", USER_ID);
        values.put("data_wygasniecia", formatter.format(date.getTime() + time * 1000L));
        values.put("ilosc", ilosc);
        db.insert("user_ticket", null, values);
    }

    public ArrayList<Ticket> getTickets(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Ticket> tickets = new ArrayList<>();
        Cursor cursorCourses = db.rawQuery("SELECT * FROM user_ticket WHERE id_klienta=" + USER_ID + "  ORDER BY data_wygasniecia DESC LIMIT 30", null);
        if (cursorCourses.moveToFirst()) {
            do {
                tickets.add(new Ticket(cursorCourses.getString(1), cursorCourses.getFloat(2), cursorCourses.getString(3), cursorCourses.getInt(4), cursorCourses.getString(6), cursorCourses.getInt(7)));
            }
            while (cursorCourses.moveToNext());
            cursorCourses.close();
        }
        return tickets;
    }

    public ArrayList<TicketInOffer> TicketsOffer(int from, int to){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<TicketInOffer> tickets = new ArrayList<>();
        Cursor cursorCourses = db.rawQuery("SELECT * FROM ticket WHERE time >= " + Integer.toString(from) + " AND time <= " + Integer.toString(to), null);
        if (cursorCourses.moveToFirst()) {
            do {
                tickets.add(new TicketInOffer(cursorCourses.getString(2), cursorCourses.getFloat(1), cursorCourses.getInt(3)));
            }
            while (cursorCourses.moveToNext());
            cursorCourses.close();
        }
        return tickets;
    }

    public ArrayList<Mandate> getPaidMandates(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Mandate> mandates = new ArrayList<>();
        Cursor cursorCourses = db.rawQuery("SELECT * FROM mandate WHERE user_id=" + USER_ID + " AND status=1 ORDER BY datetime DESC LIMIT 30", null);
        if (cursorCourses.moveToFirst()) {
            do {
                mandates.add(new Mandate(cursorCourses.getInt(0), cursorCourses.getString(1), cursorCourses.getFloat(2), cursorCourses.getInt(4), cursorCourses.getString(5)));
            }
            while (cursorCourses.moveToNext());
            cursorCourses.close();
        }
        return mandates;
    }

    public ArrayList<Mandate> getUnpaidMandates(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Mandate> mandates = new ArrayList<>();
        Cursor cursorCourses = db.rawQuery("SELECT * FROM mandate WHERE user_id=" + USER_ID + " AND status=0 ORDER BY datetime DESC LIMIT 30", null);
        if (cursorCourses.moveToFirst()) {
            do {
                mandates.add(new Mandate(cursorCourses.getInt(0) ,cursorCourses.getString(1), cursorCourses.getFloat(2), cursorCourses.getInt(4), cursorCourses.getString(5)));
            }
            while (cursorCourses.moveToNext());
            cursorCourses.close();
        }
        return mandates;
    }

    public void payMandate(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("status", 1);
        db.update("mandate", values, "id="+id, null);
        db.close();
    }
}


