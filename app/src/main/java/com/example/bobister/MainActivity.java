package com.example.bobister;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.buttonSubmit).setOnClickListener( v -> {
            String email = ((EditText)findViewById(R.id.editTextEmail)).getText().toString().trim();
            String pass = ((EditText)findViewById(R.id.editPass)).getText().toString().trim();
            String check = ((EditText)findViewById(R.id.editPassCheck)).getText().toString().trim();
            TextView text1 = ((TextView)findViewById(R.id.podpis));

            if(email.isEmpty()){
                text1.setText("Proszę wpisać email");
            }
            else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                text1.setText("Niepoprawny adres email");
            }
            else if(pass.isEmpty()) {
                text1.setText("Proszę wpisać hasło");
            }
            else if(!pass.equals(check)) {
                text1.setText("Hasła nie są takie same" );
            }
            else{
                text1.setText("Witaj, "+email);
            }
        });
    }
}