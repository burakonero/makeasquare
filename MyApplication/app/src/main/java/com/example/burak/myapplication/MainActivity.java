package com.example.burak.myapplication;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

import javax.security.auth.callback.Callback;


public class MainActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_multiplayer);
        locateButtons();
        Client.connect();

    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void locateButtons(){


            Button[] b = new Button[95];
            String a = "";
            Display display = getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int width = size.x;
            int height = size.y;
            int unitwid = width/33;
            int unithei = height/33;
            int xPos=3*unitwid/2;
            int yPos=unitwid*10;


            LinearLayout.LayoutParams[] params = new LinearLayout.LayoutParams[95];

            for(int i = 1;i<=30;i=i+1){
                a = "button"+i;
                int resID = getResources().getIdentifier(a, "id", getPackageName());
                b[i] = (Button)findViewById(resID);

                params[i] = new LinearLayout.LayoutParams(width, height);
                params[i].height = 5*unitwid;
                params[i].width = unitwid;
                params[i].leftMargin = xPos;
                params[i].topMargin = yPos;

                b[i].setLayoutParams(params[i]);
                b[i].setBackgroundColor(Color.rgb(253, 255, 135));

                xPos=xPos+6*unitwid;

                if(i%6==0){
                    yPos=yPos+6*unitwid;
                    xPos=3*unitwid/2;
                }
                b[i].setVisibility(View.VISIBLE);

            }

                 xPos=3*unitwid/2;
                 yPos=unitwid*10;

        for(int i = 31;i<=61;i=i+1){
            a = "button"+i;
            int resID = getResources().getIdentifier(a, "id", getPackageName());
            b[i] = (Button)findViewById(resID);

            params[i] = new LinearLayout.LayoutParams(width, height);
            params[i].height = unitwid;
            params[i].width = 5*unitwid;
            params[i].leftMargin = xPos+unitwid;
            params[i].topMargin = yPos-params[i].height;

            b[i].setLayoutParams(params[i]);
            b[i].setBackgroundColor(Color.rgb(253, 255, 135));

            xPos=xPos+6*unitwid;

            if(i%5==0){
                yPos=yPos+6*unitwid;
                xPos=3*unitwid/2;
            }
            b[i].setVisibility(View.VISIBLE);

        }

        xPos=3*unitwid/2;
        yPos=unitwid*10;

            for(int i = 61;i<=85;i=i+1){
                a = "button"+i;
                int resID = getResources().getIdentifier(a, "id", getPackageName());
                b[i] = (Button)findViewById(resID);
                //b[i].setBackgroundColor(Color.YELLOW);
                params[i] = new LinearLayout.LayoutParams(width, height);
                params[i].height = unitwid*5;
                params[i].width = unitwid*5;
                params[i].leftMargin = xPos+unitwid;
                params[i].topMargin = yPos;

                b[i].setLayoutParams(params[i]);
                b[i].setBackgroundColor(Color.rgb(240,240,255));

                //b[i].setAlpha((float) 0.5);
                xPos=xPos+unitwid*6;

                if(i%5==0){
                    yPos=yPos+unitwid*6;
                    xPos=3*unitwid/2;
                }
                b[i].setVisibility(View.VISIBLE);
            }

    }

}

