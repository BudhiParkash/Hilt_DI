package com.example.daggerhiltbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.net.SocketKeepalive;
import android.os.Bundle;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    // field injection
    @Inject
    SomeClass someClass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println(someClass.dothing());
        System.out.println(someClass.dootherrhing());

    }
}

class SomeClass{
    SomeOtherClass someOtherClass;

    @Inject
    public SomeClass(SomeOtherClass someOtherClass) {
        this.someOtherClass = someOtherClass;
    }

    public String dothing(){
        return "Heloo filed dependecy Injection";
    }

    public String dootherrhing(){
        return  someOtherClass.dootherthing();
    }


}

class SomeOtherClass{
    @Inject
    public SomeOtherClass() {
    }
    public String dootherthing(){
        return "Heloo Constructor Injection";
    }
}



