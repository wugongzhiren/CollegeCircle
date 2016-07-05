package com.example.administrator.qqsliding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.qqsliding.MainActivity;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private Button loginbutton;
    private TextView username;
    private TextView password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginbutton = (Button) findViewById(R.id.login);
        username= (TextView) findViewById(R.id.username);
        password= (TextView) findViewById(R.id.password);
        loginbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name=username.getText().toString();
        if(name==null||name.equals("")){
            Toast.makeText(this,"用户名不能为空",Toast.LENGTH_SHORT).show();
            return;

        }
        String psword=password.getText().toString();
        if(psword==null||psword.equals("")){
            Toast.makeText(this,"密码不能为空",Toast.LENGTH_SHORT).show();
            return;

        }
        else {
            Intent intent = new Intent(this, MainActivity.class);
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            //intent.setClass(Login.this,MainActivity.class);
            startActivity(intent);
        }
    }
}
