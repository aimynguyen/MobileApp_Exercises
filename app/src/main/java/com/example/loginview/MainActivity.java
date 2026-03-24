package com.example.loginview;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextInputEditText email, pw;
    TextView forGotPw, register;
    Button  signIn;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=findViewById(R.id.login_email);
        pw=findViewById(R.id.login_pw);

        forGotPw=findViewById(R.id.tbForgotPW);
        register=findViewById(R.id.tbRegister);

        signIn=findViewById(R.id.btnSignin);

        register.setOnClickListener(v->{
            Intent intentRegister = new Intent(MainActivity.this, RegisterActivity.class);
            intentRegister.putExtra("email", email.getText().toString());
            intentRegister.putExtra("pw",pw.getText().toString());
            startActivity(intentRegister);
        });

        signIn.setOnClickListener(v-> {
            String inputEmail=email.getText().toString();
            String inputPW=pw.getText().toString();

            if(inputEmail.isEmpty() || inputPW.isEmpty()){
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            // giả db
            SharedPreferences dbFake = getSharedPreferences("confirmLogin", MODE_PRIVATE);
            String savedEmail=dbFake.getString("reg_email", "");
            String savedPW=dbFake.getString("reg_pw", "");

            if(inputEmail.equals(savedEmail) && inputPW.equals(savedPW)){
                Intent intentLogin = new Intent( MainActivity.this, ProfileActivity.class);
                intentLogin.putExtra("email", inputEmail);
                intentLogin.putExtra("name", dbFake.getString("reg_name",""));
                startActivity(intentLogin);
                finish();
            }
            else {
                Toast.makeText(this, "Vui lòng nhập đúng email và mật khẩu", Toast.LENGTH_SHORT).show();
            }

        });
    }
}