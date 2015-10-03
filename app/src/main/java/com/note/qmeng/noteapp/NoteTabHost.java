package com.note.qmeng.noteapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;

/**
 * Created by MQ on 2015/10/3.
 */
public class NoteTabHost extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabhost);

        //获取TabHost对象
        TabHost tabHost = (TabHost) findViewById(R.id.tabhost);
        tabHost.setup();

        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("时间线",getResources().getDrawable(R.drawable.ic_launcher)).setContent(R.id.view1));
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("活动",getResources().getDrawable(R.drawable.ic_launcher)).setContent(R.id.view2));
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("+",getResources().getDrawable(R.drawable.ic_launcher)).setContent(R.id.view3));
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("好友",getResources().getDrawable(R.drawable.ic_launcher)).setContent(R.id.view4));
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("设置",getResources().getDrawable(R.drawable.ic_launcher)).setContent(R.id.view5));

    }
}
