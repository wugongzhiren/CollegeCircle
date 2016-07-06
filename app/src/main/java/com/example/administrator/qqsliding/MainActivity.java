package com.example.administrator.qqsliding;

import android.app.Activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sliding.view.SlidingMenu;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private SlidingMenu slidingMenu;
    private TextView tapdongtai;
    private TextView tabfaxian;
    private TextView tabfriend;
    private TextView tabfankui;
    private FragmentManager manager;
    private Index_fg fg1,fg2,fg3,fg4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        slidingMenu = (SlidingMenu) findViewById(R.id.slidemenu);
        manager = getFragmentManager();
        bindviews();
        tapdongtai.performClick();//模仿一次点击，聚焦在index
        //Toast.makeText(this,"滑动",Toast.LENGTH_SHORT).show();
    }

    //基于回调的click方法，布局中onclick属性关联的方法
    public void openmenu(View view) {
        slidingMenu.openMenu();
    }

    private void bindviews() {
        //初始化底部导航菜单
        tapdongtai = (TextView) findViewById(R.id.txt_dongtai);
        tabfriend = (TextView) findViewById(R.id.txt_friend);
        tabfaxian = (TextView) findViewById(R.id.txt_faxian);
        tabfankui = (TextView) findViewById(R.id.txt_fankui);
        //设置监听器
        tapdongtai.setOnClickListener(this);
        tabfriend.setOnClickListener(this);
        tabfaxian.setOnClickListener(this);
        tabfankui.setOnClickListener(this);


    }

    //重置所有文本的选中状态
    private void setSelected(){
        tabfankui.setSelected(false);
        tabfaxian.setSelected(false);
        tabfriend.setSelected(false);
        tapdongtai.setSelected(false);
    }
    //隐藏所有的fragment
    private void hideAllFragment(FragmentTransaction fragmentTransaction){
        if(fg1 != null)fragmentTransaction.hide(fg1);
        if(fg2 != null)fragmentTransaction.hide(fg2);
        if(fg3 != null)fragmentTransaction.hide(fg3);
        if(fg4 != null)fragmentTransaction.hide(fg4);
    }

    @Override
    public void onClick(View v) {
        android.app.FragmentTransaction fTransaction = manager.beginTransaction();
        hideAllFragment(fTransaction);
        switch (v.getId()){
            case R.id.txt_dongtai:
                setSelected();
                tapdongtai.setSelected(true);
                if(fg1==null){
                    fg1=new Index_fg();
                    fTransaction.add(R.id.ly_content,fg1);//第一个参数是Fragmentayout布局文件
                    //fg1实例化时便会调用Indexfg的oncreateview方法绘制第一个fg的用户界面
                }
                else{
                    fTransaction.show(fg1);
                }
                break;

        }
        fTransaction.commit();
    }
}
