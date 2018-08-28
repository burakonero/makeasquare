package com.example.burak.myapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import io.socket.emitter.Emitter;
import io.socket.client.IO;
import io.socket.emitter.Emitter;

import android.app.Activity;
import android.app.Application;
import android.graphics.Color;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import io.socket.client.IO;
import java.net.URISyntaxException;

import static android.content.ContentValues.TAG;
import static com.example.burak.myapplication.R.id.textView;
import static java.lang.Integer.parseInt;

public class Client {
    public static io.socket.client.Socket socket;
    private OutputStream socketOutput;
    private BufferedReader socketInput;
    private String ip;
    private int port;

    static String ax = "";
    static int room = 0;
    public static void connect(){

                try {
                    socket = IO.socket("http://192.168.0.23:3000");
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
                socket.emit("doit","doitbaba");
                socket.emit("getbrowser1","j");
                socket.connect();




    }

    private Emitter.Listener getbrowser1f = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {

            //perform anything

            socket.emit("doit2","doitbaba");


        }
    };


    public void disconnect() {

        socket.close();


    }
}