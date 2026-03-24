package com.example.loginview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {
    TextInputEditText name, email, pw, confirm;
    Button create;

    @Override protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        name = findViewById(R.id.reg_name);
        email=findViewById(R.id.reg_email);
        pw=findViewById(R.id.reg_pw);
        confirm=findViewById(R.id.reg_confirm);
        create=findViewById(R.id.btnCreate);

        String emailTuLogin = getIntent().getStringExtra("email");
        String pwTuLogin = getIntent().getStringExtra("pw");

        if (emailTuLogin != null) email.setText(emailTuLogin);
        if (pwTuLogin != null) pw.setText(pwTuLogin);

        create.setOnClickListener(v-> {

            String matKhau = pw.getText().toString();
            String xacNhan = confirm.getText().toString();

            if (!matKhau.equals(xacNhan)) {
                Toast.makeText(RegisterActivity.this, "Mật khẩu xác nhận không khớp!", Toast.LENGTH_SHORT).show();
                confirm.setError("sai mat khau roi be yeu oi!");
                return;
            }
            Intent intent = new Intent(RegisterActivity.this, ProfileActivity.class);
            intent.putExtra("email", email.getText().toString());
            intent.putExtra("pw", pw.getText().toString());
            startActivity(intent);
            finish();
        });

    }
}
