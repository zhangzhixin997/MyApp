package com.example.zhangzhixin.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by zhangzhixin on 2016/10/19.
 */
public class Myadapter extends BaseAdapter {
    private Context c;
    private ArrayList<Music> musics=new ArrayList<>();

    public Myadapter(Context c, ArrayList<Music> musics) {
        this.c = c;
        this.musics = musics;
    }
    @Override
    public int getCount() {
        return musics.size();
    }

    @Override
    public Object getItem(int position) {
        return musics.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(null==convertView){
            convertView= LayoutInflater.from(c).inflate(R.layout.itemlayout, null);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.musicname);
        tv.setText(musics.get(position).getName().toString());
        return convertView;

    }

}
