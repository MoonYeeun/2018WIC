package com.example.sm_pc.a2018wic;



import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton home,location,qr,chat;
    FragmentManager fm;
    FragmentTransaction tran;
    MyEmotion frag1;
    MyEmotion frag2;
    QRreader frag3;
    ChatActivity frag4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        home = (ImageButton) findViewById(R.id.home);
        location = (ImageButton) findViewById(R.id.location);
        qr = (ImageButton)findViewById(R.id.qr);
        chat = (ImageButton)findViewById(R.id.chat);

        home.setOnClickListener(this);
        location.setOnClickListener(this);
        qr.setOnClickListener(this);
        chat.setOnClickListener(this);

        frag1 = new MyEmotion(); //프래그먼트 객채셍성
        frag2 = new MyEmotion(); //프래그먼트 객채셍성
        frag3 = new QRreader(); //프래그먼트 객채셍성
        frag4 = new ChatActivity();
        setFrag(1); //프래그먼트 교체
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.home:
                setFrag(1);
                break;
            case R.id.location:
                setFrag(0);
                break;
            case R.id.qr:
                setFrag(2);
                break;
            case R.id.chat:
                setFrag(3);
                break;
        }
    }
    public void setFrag(int n){    //프래그먼트를 교체하는 작업을 하는 메소드를 만들었습니다
        fm = getSupportFragmentManager();
        tran = fm.beginTransaction();
        switch (n){
            case 0:
                tran.replace(R.id.frame, frag1);  //replace의 매개변수는 (프래그먼트를 담을 영역 id, 프래그먼트 객체) 입니다.
                tran.commit();
                break;
            case 1:
                tran.replace(R.id.frame, frag2);  //replace의 매개변수는 (프래그먼트를 담을 영역 id, 프래그먼트 객체) 입니다.
                tran.commit();
                break;
            case 2:
                tran.replace(R.id.frame, frag3);  //replace의 매개변수는 (프래그먼트를 담을 영역 id, 프래그먼트 객체) 입니다.
                tran.commit();
                break;
            case 3:
                tran.replace(R.id.frame,frag4);
                tran.commit();
                break;
        }
    }

}
