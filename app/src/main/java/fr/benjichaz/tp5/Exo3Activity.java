package fr.benjichaz.tp5;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Exo3Activity extends AppCompatActivity {


    private ListView mListView;
    private Button add;
    private List<Contact> contacts;
    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"7. onResume()", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"14. onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"15. onStop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"16. onDestroy()", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo3);


        Toast.makeText(getApplicationContext(),"1. onCreate()", Toast.LENGTH_SHORT).show();


        add = (Button) findViewById(R.id.add);

        mListView = (ListView) findViewById(R.id.listView3);

        contacts = genererContacts();

        ContactAdapter adapter = new ContactAdapter(Exo3Activity.this, contacts);
        mListView.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent myIntent = new Intent(Exo3Activity.this, ContactActivity.class);
                myIntent.putExtra("contactid", -1);
                myIntent.putExtra("firstname", "");
                myIntent.putExtra("lastname", "");
                myIntent.putExtra("phone", "");
                myIntent.putExtra("email", "");
                myIntent.putExtra("avatarURI", (Uri) null);
                startActivityForResult(myIntent, 1);

            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            @SuppressWarnings("unchecked")
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                Contact contact = (Contact) mListView.getItemAtPosition(position);

                Intent myIntent = new Intent(Exo3Activity.this, ContactActivity.class);
                myIntent.putExtra("contactid", position);
                myIntent.putExtra("firstname", contact.getFirstname());
                myIntent.putExtra("lastname", contact.getLastname());
                myIntent.putExtra("phone", contact.getPhone());
                myIntent.putExtra("email", contact.getEmail());
                myIntent.putExtra("avatarURI", contact.getAvatar());
                startActivityForResult(myIntent, 1);
            }
        });

/*
        Intent myIntent = new Intent(Exo3Activity.this, ContactActivity.class);

        startActivityForResult(myIntent, 1);*/
    }

    private List<Contact> genererContacts(){
        List<Contact> contacts = new ArrayList<Contact>();
        contacts.add(new Contact("Benjamin", "Chazelle", "0651235139", "benjichaz@outlook.fr", null));
        contacts.add(new Contact("Ginger", "King", "0123210", "gk@wrong.kd", null));

        return contacts;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            if (data == null)
                return;

            int contactid = data.getIntExtra("contactid", -1);
            String firstname = data.getStringExtra("firstname");
            String lastname = data.getStringExtra("lastname");
            String phone = data.getStringExtra("phone");
            String email = data.getStringExtra("email");
            Uri avatarURI = data.getParcelableExtra("avatarURI");


            if(data.getIntExtra("contactid", -1) == -1) {
                Contact contact = new Contact(firstname, lastname, phone, email, avatarURI);
                contacts.add(contact);
            }
            else if(contactid >= 0 && contactid < contacts.size()){
                Contact contact = contacts.get(contactid);
                contact.setFirstname(firstname);
                contact.setLastname(lastname);
                contact.setPhone(phone);
                contact.setEmail(email);
                contact.setAvatar(avatarURI);
            }


        }
    }
/*
    public void finish() {

        System.out.println("iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");



    }*/


}
