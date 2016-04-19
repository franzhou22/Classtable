package com.example.franzhou.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {
 ImageView iv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        iv2= (ImageView) findViewById(R.id.iv2);
    }




    public  void play (View v){
        //设置图片播放的动画资源
        iv2.setImageResource(R.drawable.ggg);
        //获取帧动画对象
        AnimationDrawable anima=(AnimationDrawable)iv2.getDrawable();
        //播放
        anima.start();
    }

    //属性动画
    public  void  obj(View v){
    //ObjectAnimator
        ObjectAnimator oanima= ObjectAnimator.ofFloat(iv2,"rotateX",0f,360f);
        oanima.setDuration(2000);
        oanima.start();
        oanima.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float f = (Float) animation.getAnimatedValue();
                iv2.setScaleX(f);
                iv2.setAlpha(f);
                iv2.setRotation(f);

//                ObjectAnimator oanima2=ObjectAnimator.ofFloat();
            }
        });
    }

    public  void  value(View v){
        Animator obj = AnimatorInflater.loadAnimator(this,R.animator.property);
        obj.setTarget(iv2);
        obj.start();
    }

    public  void  jump(View v){
        startActivity(new Intent(this,Main3Activity.class));
    }

}
