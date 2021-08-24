package com.example.pc_controller;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Connection extends AsyncTask<String,Void,Boolean>{

    public static Socket socket;
    public static PrintWriter out;
    public static boolean isConnected=false;
    public Context context;

    public Connection(Context context){
        this.context = context;
    }
    public Connection(){

    }


    @Override
    public Boolean doInBackground(String... params) {
        boolean result = true;
        try {
            InetAddress serverAddr = InetAddress.getByName(params[0]);
            socket = new Socket(serverAddr, Constants.SERVER_PORT);//Open socket on server IP and port
        } catch (IOException e) {
            Log.e("pc_controller", "Error while connecting", e);
            result = false;
        }
        return result;
    }

    @Override
    public void onPostExecute(Boolean result)
    {
        isConnected = result;
        Toast.makeText(context,isConnected?"Connected to server!":"Error while connecting",Toast.LENGTH_LONG).show();
        try {
            if(isConnected) {
                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket
                        .getOutputStream())), true); //create output stream to send data to server
            }
        }catch (IOException e){
            Log.e("remotedroid", "Error while creating OutWriter", e);
            Toast.makeText(context,"Error while connecting",Toast.LENGTH_LONG).show();
        }
    }

//    public void sendMessageToServer(String message) {
//        if(isConnected && out != null) {
//
//
//            Thread thread = new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//                    try  {
//                        //Code here
//                        out.println(message); //send mouse movement to server
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//
//            thread.start();
//
//        }
//    }

}
