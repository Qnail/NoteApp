package com.note.qmeng.noteapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;


public class LoginActivity extends Activity implements OnClickListener{
    private EditText accountEditText = null;
    private EditText pwdEditText = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        //set up click listeners for all the buttons.

        View loginButton = this.findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.loginButton:
                if(checkPassWord())
                {
                    Intent i = new Intent(this,IndexActivity.class);
                    startActivity(i);
                }else {
                    //TODO the password is wrong do sth.
                }
                break;
        }
    }

    public boolean checkPassWord(){
        boolean result = false;
        accountEditText = (EditText)findViewById(R.id.accountEditText);
        pwdEditText = (EditText)findViewById(R.id.pwdEditText);
        if(accountEditText.getText().toString().equals("seu")&&pwdEditText.getText().toString().equals("123"))
        {
            result = true;
        }

        return result;
    }
}
