package com.example.betwar.trythree;

import android.graphics.drawable.Drawable;
import android.net.Uri;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import SqlLiteClasses.Contact;
import SqlLiteClasses.ContactRepo;
import android.widget.EditText;
public class MainActivity extends FragmentActivity implements PictureFragment.OnFragmentInteractionListener{

    //must implement this interface
    public void onFragmentInteraction(Uri uri){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ContactRepo cRepo=new ContactRepo(this);
//        Log.d("Insert","Insert:...");
//        Contact contact=new Contact();
//        contact.name="Abbas";
//        contact.email="email@email.com";
//        contact.phone=12345678;
//        cRepo.addContact(contact);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);


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

    public void submitButton(View view){

//        Databasehandler db= new Databasehandler(this);
//
//

        /* get data rom input and pass it to fragment with bundle */
        EditText name=(EditText)findViewById(R.id.nameInput);
        EditText phone=(EditText)findViewById(R.id.phoneInput);
//        EditText email=(EditText)findViewById(R.id.emailInput);
//        //strings
       String phoneString=phone.getText().toString();
//        int phoneInt=Integer.parseInt(phoneString);
//         String emailString=email.getText().toString();
        String nameString= name.getText().toString();
//

        //Fragment change from submite button
        Bundle bundle=new Bundle();
        bundle.putString("Key_name_passes",nameString);
        bundle.putString("Ket_phone_passes",phoneString);

        PictureFragment pf=new PictureFragment();
        pf.setArguments(bundle);
        //fragment
        if(findViewById(R.id.frame1) !=null) {


            //fragment created and replace the last one
            android.support.v4.app.FragmentManager fm=getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction  ft=fm.beginTransaction();
            ft.replace(R.id.frame1, pf);

            ft.commit();

        }


       // Intent intent=new Intent(MainActivity.this,DetailActivityView.class);


       // String[] data=new String[]{phoneString,emailString};
      //  intent.putExtra("strings",data);

     //  startActivity(intent);
    }
    public void frahmentButton(View view){



    }
}
