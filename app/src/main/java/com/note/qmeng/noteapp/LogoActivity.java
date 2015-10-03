package com.note.qmeng.noteapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.note.qmeng.tagcloud.SampleTagCloud;

/**
 * Created by MQ on 2015/10/3.
 */
public class LogoActivity  extends Activity{
    private ProgressBar progressBar;
    private Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo);
        progressBar = (ProgressBar)findViewById(R.id.pgBar);
        backButton = (Button)findViewById(R.id.backButton);

        Intent intent = new Intent(this,SampleTagCloud.class);
        startActivity(intent);
//        finish();
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
