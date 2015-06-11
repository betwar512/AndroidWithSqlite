package SqlLiteClasses;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by betwar on 6/9/2015.
 */
public class ContactRepo {
    private static final String KEY_ID="id";
    private static final String KEY_NAME="name";
    private static final String KEY_MAIL="email";
    private static final String KEY_PHONE="phone";
    private static final String TABLE_CONTACT="contacts";
        private Databasehandler dbHd;

    public ContactRepo(Context context){
        dbHd=new Databasehandler(context);

    }

    //db contact CRUD
    public void addContact(Contact contact){
        SQLiteDatabase db=dbHd.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_NAME,contact.name);
        values.put(KEY_MAIL,contact.email);
        values.put(KEY_PHONE,contact.phone);
        db.insert(TABLE_CONTACT, null, values);
        db.close();

    }

    public Contact getContact(int id){

        SQLiteDatabase db=dbHd.getReadableDatabase();

        Cursor cursor=db.query(TABLE_CONTACT, new String[]{KEY_ID, KEY_NAME, KEY_MAIL, KEY_PHONE}, KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null);
        if(cursor!=null)
            cursor.moveToFirst();
        Contact contact=new Contact();
        //(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2),Integer.parseInt(cursor.getString(3)));

        contact.id=Integer.parseInt(cursor.getString(0));
        contact.name=cursor.getString(1);
        contact.email=cursor.getString(2);
        contact.phone=Integer.parseInt(cursor.getString(3));


        return contact;

    }
    public List<Contact> getAllContacts(){
        List<Contact> contacts=new ArrayList<Contact>();


        SQLiteDatabase db=dbHd.getReadableDatabase();
        String query="SELECT * FROM " + TABLE_CONTACT;
        Cursor cursor=db.rawQuery(query,null);

        if (cursor.moveToFirst()){
            do{
                Contact contact=new Contact();
                contact.id = Integer.parseInt(cursor.getString(0));
                contact.name=cursor.getString(1);
                contact.email= cursor.getString(2);
                contact.phone=Integer.parseInt(cursor.getString(3));
                contacts.add(contact);
            }while(cursor.moveToNext());
        }

        return contacts;
    }
    public int getContactsCount(){
        String query="SELECT * FROM "+TABLE_CONTACT;
        SQLiteDatabase db=dbHd.getReadableDatabase();
        Cursor cursor=db.rawQuery(query,null);
        cursor.close();




        return cursor.getCount();

    }
    // Updating single contact
    public int updateContact(Contact contact) {
        SQLiteDatabase db = dbHd.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.name);
        values.put(KEY_MAIL,contact.email);
        values.put(KEY_PHONE, contact.phone);


        // updating row
        return db.update(TABLE_CONTACT, values, KEY_ID + " = ?",
                new String[]{String.valueOf(contact.id)});

    }
    // Deleting single contact
    public void deleteContact(Contact contact) {
        SQLiteDatabase db = dbHd.getWritableDatabase();
        db.delete(TABLE_CONTACT, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.id) });
        db.close();
    }

}
