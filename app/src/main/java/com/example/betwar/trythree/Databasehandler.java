package com.example.betwar.trythree;
import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



/**
 * Created by betwar on 6/9/2015.
 */
public class Databasehandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="contactManager";
    private static final String TABLE_CONTACT="contacts";

    //COLUMN NAMES
    private static final String KEY_ID="id";
    private static final String KEY_NAME="name";
    private static final String KEY_MAIL="email";
    private static final String KEY_PHONE="phone";


    public  Databasehandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_CONTACTS_TABLE="CREATE TABLE " + TABLE_CONTACT + "(" +KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NAME + " TEXT," + KEY_MAIL + " TEXT," + KEY_PHONE + " INTEGER );";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_CONTACT);
        onCreate(db);
    }



}

