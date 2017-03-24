package com.example.zhangzhixin.myapplication;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private Myadapter myAdapter;
    private ArrayList<Music> musics=new ArrayList<>();
    private String str;
    private String str1;
    private Music music;
    private File[] files;
    private MediaPlayer player;
    private String filestr="";
    private Uri uri=null;
    private View.OnClickListener mylistener;
    private android.util.Log Loe;
    private View play;
    private View stop;
    private View pause;
    private AlertDialog ad;
    private int position1=0;
    private int position2;
    private MediaPlayer play2;
    private boolean pausef=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);
        myAdapter = new Myadapter(this, musics);
        lv.setAdapter(myAdapter);
        File f = Environment.getExternalStorageDirectory();
        str = f.getPath();
        str1 = str + "/qqmusic/song/";
        getdata();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder abu = new AlertDialog.Builder(MainActivity.this);
                View view1 = getLayoutInflater().inflate(R.layout.alterloglayout, null);
                abu.setView(view1);
                abu.setTitle("我的本地音乐");
                ad = abu.create();
                ad.show();
                play = view1.findViewById(R.id.play);
                position2=position1;
                position1=position;
                play.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        File f= files[position];
                        File f1=files[position2];
                         play2=new MediaPlayer();
                        try {
                            play2.setDataSource(f1.getPath());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Toast.makeText(MainActivity.this, "你播放的是"+f.getName(), Toast.LENGTH_SHORT).show();
//                        player = MediaPlayer.create(MainActivity.this, uri);
                        if(player!=null&&position!=position2) {
                            Toast.makeText(MainActivity.this, "stop", Toast.LENGTH_SHORT).show();
                            player.stop();
                            player = new MediaPlayer();
                            try {
                                player.setDataSource(f.getPath());
                                player.prepare();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            player.start();
                        }
                        else if(player==play2){
                            Toast.makeText(MainActivity.this, "start", Toast.LENGTH_SHORT).show();
                            player.start();
                        }
                        else if(player==null){
                            player = new MediaPlayer();
                            Toast.makeText(MainActivity.this, "else if player==null", Toast.LENGTH_SHORT).show();
                            try {
                                player.setDataSource(f.getPath());
                                player.prepare();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            player.start();
                        }
                        else if(position==position2&&player!=null){
                            if(pausef){
                                player.start();
                                pausef=false;
                            }
                            else {
                                player = new MediaPlayer();
                                Toast.makeText(MainActivity.this, "else", Toast.LENGTH_SHORT).show();
                                try {
                                    player.setDataSource(f.getPath());
                                    player.prepare();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                player.start();
                            }
                        }
                        ad.dismiss();
                    }
                });
                stop = view1.findViewById(R.id.stop);
                stop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        File f= files[position];
                        Toast.makeText(MainActivity.this, "stop click", Toast.LENGTH_SHORT).show();
                        if (player!=null) {
                            player.stop();
                        }
                        ad.dismiss();
                    }
                });
                pause=(TextView)view1.findViewById(R.id.pause);
                pause.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pausef=true;
                        File f= files[position];
                        Toast.makeText(MainActivity.this, "pause click", Toast.LENGTH_SHORT).show();
                        if (player!=null) {
                            player.pause();
                        }
                        ad.dismiss();
                    }
                });
            }
        });

    }
    public void getdata() {
        File f = new File(str1);
        files = f.listFiles();
       for (int i = 0; i < files.length; i++) {
            music = new Music();
            music.setName(files[i].getName());
            musics.add(music);
            music = null;
        }
     }
    }

