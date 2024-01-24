package com.example.latihanuas6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(@Nullable Context context) {
        super(context, "UserData.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE user_data (" +
                "name TEXT," +
                "nim INTEGER PRIMARY KEY," +
                "email TEXT," +
                "hp INTEGER);";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String upgrade = "DROP TABLE IF EXISTS user_data";
        sqLiteDatabase.execSQL(upgrade);
        onCreate(sqLiteDatabase);
    }

    public long insertData(String name, int nim, String email, int hp){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("nim", nim);
        cv.put("email", email);
        cv.put("hp", hp);
        Log.d("TAG", "insertData: " + name + nim + email + hp);
        return db.insert("user_data", null, cv);

    }

    public ArrayList<Student> getAllStudents(){
        ArrayList<Student> listStudent = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM user_data", null);

        while(cursor.moveToNext()){
            String name = cursor.getString(0);
            int nim = Integer.parseInt(cursor.getString(1));
            String email = cursor.getString(2);
            int hp = Integer.parseInt(cursor.getString(3));

            listStudent.add(new Student(name, email, nim, hp));

        }

        cursor.close();
        return listStudent;
    }
}
