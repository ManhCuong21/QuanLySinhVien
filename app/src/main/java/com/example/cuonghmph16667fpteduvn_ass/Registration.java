package com.example.cuonghmph16667fpteduvn_ass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {
    EditText txtUsername,txtPassword,txtEnterthepassword;
    Button btnRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        txtUsername = findViewById(R.id.txtUserName);
        txtPassword = findViewById(R.id.txtPassword);
        txtEnterthepassword = findViewById(R.id.txtEnterthepassword);
        btnRegistration = findViewById(R.id.btnRegistration);

        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(kiemTraNhap() == false){
                    return;
                }
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();

                LoginDatabase db = new LoginDatabase(Registration.this);
                long result = db.insertData(username,password);
                if(result > 0){
                    Toast.makeText(Registration.this, "Tạo tài khoản thành công", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(Registration.this, "Tạo tài khoản thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private boolean kiemTraNhap(){
        if(txtUsername.getText().toString().length() == 0){
            Toast.makeText(this, "Chưa nhập Username", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(txtPassword.getText().toString().length() == 0){
            Toast.makeText(this, "Chưa nhập Password", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(txtEnterthepassword.getText().toString().length() == 0){
            Toast.makeText(this, "Chưa nhập Enter The Password", Toast.LENGTH_SHORT).show();
            return false;
        }
        String password1 = txtPassword.getText().toString();
        String enterPass = txtEnterthepassword.getText().toString();

        if(password1.compareTo(enterPass) != 0){
            Toast.makeText(this, "Password không đồng nhất", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}