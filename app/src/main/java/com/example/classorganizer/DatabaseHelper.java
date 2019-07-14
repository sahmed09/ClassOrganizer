package com.example.classorganizer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "UserDetails.db";
    private static final String TABLE_NAME = "User_details";
    private static final String ID = "Id";
    private static final String NAME = "Name";
    private static final String EMAIL = "Email";
    private static final String USERNAME = "Username";
    private static final String ACCOUNT_TYPE = "Account_Type";
    private static final String PASSWORD = "Password";
    private static final int VERSION_NUMBER = 2;

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255) NOT NULL, " + EMAIL + " TEXT NOT NULL, " + USERNAME + " TEXT NOT NULL, " + ACCOUNT_TYPE + " TEXT NOT NULL, " + PASSWORD + " TEXT NOT NULL );";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    private Context context;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(CREATE_TABLE);
            Toast.makeText(context,"onCreate is called", Toast.LENGTH_LONG).show();
        } catch(Exception e) {
            Toast.makeText(context,"Exception : " + e, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            db.execSQL(DROP_TABLE);
            onCreate(db);
            Toast.makeText(context,"onUpgrade is called", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(context,"Exception : " + e, Toast.LENGTH_LONG).show();
        }
    }

    public long insertData(UserDetails userDetails) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,userDetails.getName());
        contentValues.put(EMAIL,userDetails.getEmail());
        contentValues.put(USERNAME,userDetails.getUsername());
        contentValues.put(ACCOUNT_TYPE,userDetails.getAccountType());
        contentValues.put(PASSWORD,userDetails.getPassword());

        long rowId = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        return rowId;
    }

    public Boolean findPassword(String uname, String pass) {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        Boolean result = false;

        if(cursor.getCount()==0) {
            Toast.makeText(context,"No Data is found", Toast.LENGTH_LONG).show();
        }
        else {
            while (cursor.moveToNext()) {

                String username = cursor.getString(3);
                String password = cursor.getString(5);

                if(username.equals(uname) && password.equals(pass)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public String findAccount(String un) {

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        String account="";

        if(cursor.getCount()==0) {
            Toast.makeText(context,"No Data is found", Toast.LENGTH_LONG).show();
        }
        else {
            while (cursor.moveToNext()) {

                String username = cursor.getString(3);
                String accountType = cursor.getString(4);

                if(username.equals(un)) {
                    account = accountType;
                    break;
                }
            }
        }
        return account;
    }
}
