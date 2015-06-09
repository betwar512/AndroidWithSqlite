package com.example.betwar.trythree;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.List;


public class DetailActivityView extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_detail_activity_view);
      //  Intent inten=getIntent();
       // String[] strings=inten.getStringArrayExtra("strings");


       // Contact contact= db.getContact(1);
        ContactRepo cRepo=new ContactRepo(this);
        List<Contact> contacts=cRepo.getAllContacts();

      Contact contact= contacts.get(0);

       String phoneS= Integer.toString(contact.phone);
        TextView textField1=(TextView)findViewById(R.id.phoneInput);
        TextView textField2=(TextView)findViewById(R.id.emailInput);

        textField1.setText(phoneS);
        textField2.setText(contact.email);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detail_activity_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
