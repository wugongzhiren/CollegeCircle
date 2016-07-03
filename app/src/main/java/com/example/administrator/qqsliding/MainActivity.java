package com.example.administrator.qqsliding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.example.sliding.view.SlidingMenu;

public class MainActivity extends AppCompatActivity {
    private SlidingMenu slidingMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        slidingMenu= (SlidingMenu) findViewById(R.id.slidemenu);
        Toast.makeText(this,"滑动",Toast.LENGTH_SHORT).show();
    }
    public void openmenu(View view){
        slidingMenu.openMenu();
    }
}
