package fr.benjichaz.tp5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnExo1 = (Button) findViewById(R.id.btnExo1);
        final Button btnExo2 = (Button) findViewById(R.id.btnExo2);
        final Button btnExo3 = (Button) findViewById(R.id.btnExo3);

        btnExo1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent myIntent = new Intent(MainActivity.this, Exo1Activity.class);
                startActivityForResult(myIntent, 1);

            }
        });
        btnExo2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent myIntent = new Intent(MainActivity.this, Exo2Activity.class);
                startActivityForResult(myIntent, 2);

            }
        });

        btnExo3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent myIntent = new Intent(MainActivity.this, Exo3Activity.class);
                startActivityForResult(myIntent, 3);

            }
        });




    }
}
