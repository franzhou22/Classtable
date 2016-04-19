package com.example.franzhou.animation;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.GridLayout;

public class Main3Activity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    CheckBox ck,ck2,ck3,ck4,ck5;
    GridLayout gridLayout;
    ViewGroup viewGroup;
    LayoutTransition layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        viewGroup =(ViewGroup)findViewById(R.id.containt);
        gridLayout=new GridLayout(this);
        gridLayout.setColumnCount(5);
        viewGroup.addView(gridLayout);

        ck = (CheckBox) findViewById(R.id.ck);
        ck2 = (CheckBox) findViewById(R.id.ck2);
        ck3 = (CheckBox) findViewById(R.id.ck3);
        ck4 = (CheckBox) findViewById(R.id.ck4);
        ck5 = (CheckBox) findViewById(R.id.ck5);
        //事件
        ck.setOnCheckedChangeListener(this);
        ck2.setOnCheckedChangeListener(this);
        ck3.setOnCheckedChangeListener(this);
        ck4.setOnCheckedChangeListener(this);
        ck5.setOnCheckedChangeListener(this);
    }

    int i=1;
    public  void add (View v){
            //往gridlayout中添加按钮
        Button button=new Button(this);
        button.setText("按钮"+i++);
        gridLayout.addView(button,i>0?1:0);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        layout=new LayoutTransition();
        layout.setAnimator(LayoutTransition.APPEARING,ck.isChecked()? layout.getAnimator(LayoutTransition.APPEARING):null);
        layout.setAnimator(LayoutTransition.CHANGE_APPEARING,ck2.isChecked()?layout.getAnimator(LayoutTransition.CHANGE_APPEARING):null);
        layout.setAnimator(LayoutTransition.CHANGING,ck3.isChecked()?layout.getAnimator(LayoutTransition.CHANGE_DISAPPEARING):null);
        layout.setAnimator(LayoutTransition.CHANGE_DISAPPEARING,ck4.isChecked()? layout.getAnimator(LayoutTransition.CHANGE_DISAPPEARING):null);
        layout.setAnimator(LayoutTransition.DISAPPEARING,ck5.isChecked()?layout.getAnimator(LayoutTransition.DISAPPEARING):null);

        gridLayout.setLayoutTransition(layout);

    }
}
