package com.geektech.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText emailText=findViewById(R.id.email);
        EditText passwordText=findViewById(R.id.password);
        LinearLayout linearLayout=findViewById(R.id.entering_layout);
        MaterialButton loginButton=findViewById(R.id.login_button);

        emailText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if(emailText.getText().toString().isEmpty())
                loginButton.setBackgroundColor(getResources().getColor(R.color.grey));
            else
                loginButton.setBackgroundColor(getResources().getColor(R.color.orange));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(emailText.getText().toString().equals("admin")&&passwordText.getText().toString().equals("admin")){
                    linearLayout.setVisibility(View.GONE);
                    findViewById(R.id.zabyli_parol).setVisibility(View.GONE);
                    findViewById(R.id.najmi_suda).setVisibility(View.GONE);
                    findViewById(R.id.vhod).setVisibility(View.GONE);
                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(MainActivity.this, "Вы ввели неправильный логин и/или пароль.", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}