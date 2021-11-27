package com.example.cuonghmph16667fpteduvn_ass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText txtUsername2,txtPassword2;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUsername2 = findViewById(R.id.txtUserName2);
        txtPassword2 = findViewById(R.id.txtPassword2);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginDatabase db = new LoginDatabase(Login.this);
                String username = txtUsername2.getText().toString();
                String password = txtPassword2.getText().toString();

                boolean kt = db.kiemTra(username,password);
                if(kt == true){
                    Toast.makeText(Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this,ChuongTrinh.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(Login.this, "Sai tên đăng nhập hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}