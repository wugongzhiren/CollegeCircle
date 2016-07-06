package com.example.administrator.qqsliding;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/7/6.
 */
public class Index_fg extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.index_fg,container,false);
        //TextView txt_content = (TextView) view.findViewById(R.id.txt_content);
        //txt_content.setText(content);
        return view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
