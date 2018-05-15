package com.example.administrator.thunder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText number = (EditText)this.findViewById(R.id.number);
        final EditText password = (EditText)this.findViewById(R.id.password);
        Button login = (Button)this.findViewById(R.id.login);
        Button reset = (Button)this.findViewById(R.id.reset);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if(number.getText().toString().equals("123") && password.getText().toString().equals("123")){
                    Toast.makeText( LoginActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
                    Intent change = new Intent(LoginActivity.this,MyPlaneActivity.class);
                    LoginActivity.this.startActivity(change);
                //}
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number.setText(null);
                password.setText(null);
            }
        });
    }
}
