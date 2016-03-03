package fr.benjichaz.tp5;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {

    private int contactid;
    private ImageView avatar;
    private EditText firstname;
    private EditText lastname;
    private EditText phone;
    private EditText email;
    private Button submit;

    private Uri avatarURI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);


        avatar = (ImageView) findViewById(R.id.avatar);
        firstname = (EditText) findViewById(R.id.firstname);
        lastname = (EditText) findViewById(R.id.lastname);
        phone = (EditText) findViewById(R.id.phone);
        email = (EditText) findViewById(R.id.email);

        submit = (Button) findViewById(R.id.submit);

        contactid = getIntent().getIntExtra("contactid", -1);
        firstname.setText(getIntent().getStringExtra("firstname"));
        lastname.setText(getIntent().getStringExtra("lastname"));
        phone.setText(getIntent().getStringExtra("phone"));
        email.setText(getIntent().getStringExtra("email"));

        avatarURI = (Uri) getIntent().getParcelableExtra("avatarURI");
        if(avatarURI == null)
            avatar.setImageResource(R.drawable.default_avatar);
        else
            avatar.setImageURI(avatarURI);



        avatar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 2);

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void finish() {
        // Prepare data intent
        Intent data = new Intent();
        data.putExtra("contactid", contactid);
        data.putExtra("firstname", firstname.getText().toString());
        data.putExtra("lastname", lastname.getText().toString());
        data.putExtra("phone", phone.getText().toString());
        data.putExtra("email", email.getText().toString());
        data.putExtra("avatarURI", avatarURI);

        setResult(RESULT_OK, data);
        super.finish();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if (requestCode == 2 && resultCode == Activity.RESULT_OK) {
            if (data == null) {
                //Display an error
                return;
            }
            avatarURI = data.getData();
            avatar.setImageURI(avatarURI);


        }
    }
}
