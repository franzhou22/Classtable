package com.example.franzhou.animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
            ImageView imageView;
            Animation animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView= (ImageView) findViewById(R.id.imageView);
    }

    public  void alpha(View v){
            //透明=动态改变视图的透明度
        animation =new AlphaAnimation(1.0f,0f);
        animation.setDuration(3000);//持续时间
        animation.setFillAfter(true);//保存动画状态
        animation.setRepeatCount(Animation.INFINITE);//循环次数（无限）
        animation.setRepeatMode(Animation.REVERSE);//重复模式，反转

        // XML
        animation = AnimationUtils.loadAnimation(this,R.anim.alpha);
//
        imageView.startAnimation(animation);//开始动画
    }

    public  void  scale(View v) {
        //缩放
        float x =imageView.getWidth()/2f;
        float y=imageView.getHeight()/2f;
        animation =new ScaleAnimation(1.0f,0f,0f,1.0f,x,y);
        animation.setDuration(3000);



        imageView.startAnimation(animation);

    }
    public  void  trans (View v){
        //移动

        animation =new TranslateAnimation(0, 100, 0,0);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        animation.setRepeatMode(Animation.INFINITE);
        animation.setRepeatCount(Animation.REVERSE);
        imageView.startAnimation(animation);
    }
     public  void  rota (View v){
         //旋转
         float x =imageView.getWidth()/2f;
         float y =imageView.getHeight()/2f;
         animation =new RotateAnimation(0,125f,x,y);
         animation.setDuration(3000);
         animation.setRepeatMode(Animation.INFINITE);
         animation.setRepeatCount(Animation.REVERSE);
         animation= AnimationUtils.loadAnimation(this,R.anim.alls);
         imageView.startAnimation(animation);
     }
    public  void  jump(View v){
        Intent it =new Intent(this,Main2Activity.class);
        startActivity(it);
        overridePendingTransition(R.anim.scale,R.anim.alpha);

    }


}
