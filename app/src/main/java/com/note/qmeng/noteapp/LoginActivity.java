package com.note.qmeng.noteapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends Activity{
    /**
     *  base information in login page.
     */
    private EditText userName,password;
    private String userNameStr,passwordStr;
    private CheckBox remPwd,autoLogin;
    private Button loginButton;
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        //get user instance
        sp = this.getSharedPreferences("userInfo", Context.MODE_WORLD_READABLE);
        userName = (EditText)findViewById(R.id.accountEditText);
        password = (EditText)findViewById(R.id.pwdEditText);
        remPwd = (CheckBox)findViewById(R.id.cbRemPwd);
        autoLogin = (CheckBox)findViewById(R.id.cbAutoLogin);
        loginButton = (Button)findViewById(R.id.loginButton);
        //check CheckBox
        if(sp.getBoolean("IS_CHECKED",false))
        {
            remPwd.setChecked(true);
            userName.setText(sp.getString("USER_NAME",""));
            password.setText(sp.getString("PASSWORD",""));

            //check autoLogin
            if(sp.getBoolean("AUTO_LOGIN",false))
            {
                autoLogin.setChecked(true);
                Intent intent = new Intent(this,LogoActivity.class);
                startActivity(intent);
                this.finish();
            }
        }

        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                userNameStr = userName.getText().toString();
                passwordStr = password.getText().toString();
                if(checkInfo(userNameStr,passwordStr))
                {
                    Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                    if(remPwd.isChecked())
                    {
                        SharedPreferences.Editor editor= sp.edit();
                        editor.putString("USER_NAME",userNameStr);
                        editor.putString("PASSWORD",passwordStr);
                        editor.commit();
                    }
                    Intent intent = new Intent(LoginActivity.this,LogoActivity.class);
                    startActivity(intent);
                    finish();
                }else
                {
                    Toast.makeText(LoginActivity.this,"用户名或密码错误，请重新登录！",Toast.LENGTH_LONG).show();
                }
            }
        });

        remPwd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(remPwd.isChecked())
                {
                    sp.edit().putBoolean("IS_CHECKED",true).commit();
                }else
                {
                    sp.edit().putBoolean("IS_CHECKED",false).commit();
                }
            }
        });

        autoLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(autoLogin.isChecked())
                {
                    sp.edit().putBoolean("AUTO_LOGIN",true).commit();
                }else
                {
                    sp.edit().putBoolean("AUTO_LOGIN",false).commit();
                }
            }
        });
    }

//    public void onClick(View v)
//    {
//        switch (v.getId())
//        {
//            case R.id.loginButton:
//                if(checkPassWord())
//                {
//                    Intent i = new Intent(this,LogoActivity.class);
//                    startActivity(i);
//                }else {
//                    //the password is wrong do sth.
//                }
//                break;
//        }
//    }

    public boolean checkInfo(String userName,String password){
        boolean result = false;
        if(userName.equals("seu")&&password.equals("123"))
        {
            result = true;
        }
        return result;
    }
}
