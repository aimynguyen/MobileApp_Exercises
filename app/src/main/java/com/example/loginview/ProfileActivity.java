package com.example.loginview;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class ProfileActivity extends AppCompatActivity {
    TextView name;
    TextInputEditText name1, email, address, url, description;
    Button save, logout;

    @Override protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.profile);

        name=findViewById(R.id.textView10);
        name1=findViewById(R.id.profile_name);
        email=findViewById(R.id.profile_email);
        address=findViewById(R.id.profile_address);
        url=findViewById(R.id.profile_avtURL);
        description=findViewById(R.id.profile_description);
        save=findViewById(R.id.button);
        logout=findViewById(R.id.button2);

        name.setText(getIntent().toString());
        SharedPreferences share=getSharedPreferences("hoso", MODE_PRIVATE);
        String saveDescription = share.getString("mota","");

        description.setText(saveDescription);

        save.setOnClickListener(v->{
            SharedPreferences.Editor editor = share.edit();

            editor.putString("mota",description.getText().toString());
            editor.apply();


            Toast.makeText(this, "đã lưu description", Toast.LENGTH_SHORT).show();
        });

        logout.setOnClickListener(v->{
            Intent intent=new Intent(ProfileActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });


    }
}
