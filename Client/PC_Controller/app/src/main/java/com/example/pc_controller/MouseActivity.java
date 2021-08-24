 package com.example.pc_controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

 public class MouseActivity extends AppCompatActivity implements View.OnClickListener {

    Context context;
    Button leftClick;
    Button rightClick;
//    Button previousButton;
    TextView mousePad;

     public boolean isConnected=false;
     public boolean mouseMoved=false;
     public Socket socket;
     public PrintWriter out;

     public float initX =0;
     public float initY =0;
     public float disX =0;
     public float disY =0;

     Connection connection;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this; //save the context to show Toast messages
        connection = new Connection(context);
//        connection.execute(Constants.SERVER_IP);
        socket = connection.socket;
        out = connection.out;
        isConnected = connection.isConnected;

        //Get references of all buttons
        leftClick = (Button)findViewById(R.id.leftClick);
        rightClick = (Button)findViewById(R.id.rightClick);


        //this activity extends View.OnClickListener, set this as onClickListener
        //for all buttons
//        playPauseButton.setOnClickListener(this);
//        nextButton.setOnClickListener(this);
//        previousButton.setOnClickListener(this);

         leftClick.setOnClickListener(MouseActivity.this);
         rightClick.setOnClickListener(this);

        //Get reference to the TextView acting as mousepad
        mousePad = (TextView)findViewById(R.id.mousePad);

        //capture finger taps and movement on the textview
        mousePad.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(isConnected && out!=null){
                    switch(event.getAction()){
                        case MotionEvent.ACTION_DOWN:
                            //save X and Y positions when user touches the TextView
                            initX =event.getX();
                            initY =event.getY();
                            mouseMoved=false;
                            break;
                        case MotionEvent.ACTION_MOVE:
                            disX = event.getX()- initX; //Mouse movement in x direction
                            disY = event.getY()- initY; //Mouse movement in y direction
                            /*set init to new position so that continuous mouse movement
                            is captured*/
                            initX = event.getX();
                            initY = event.getY();
                            if(disX !=0|| disY !=0){

                                Thread thread = new Thread(new Runnable() {

                                    @Override
                                    public void run() {
                                        try  {
                                            //Code here
                                            out.println(disX +","+ disY); //send mouse movement to server
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });

                                thread.start();


                            }
                            mouseMoved=true;
                            break;
                        case MotionEvent.ACTION_UP:
                            //consider a tap only if usr did not move mouse after ACTION_DOWN
                            if(!mouseMoved){

                                Thread thread = new Thread(new Runnable() {

                                    @Override
                                    public void run() {
                                        try  {
                                            //Code here
                                           out.println();
                                           out.println(Constants.MOUSE_LEFT_CLICK);

                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                });

                                thread.start();


                            }
                    }
                }
                else {
                    Log.d("debug", String.valueOf(new Connection().isConnected));
                }
                return true;
            }
        });


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setSelectedItemId(R.id.mouse);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(MouseActivity.this,Home.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.mouse: //mainActivity

                        return true;
                    case R.id.keyboard:
                        startActivity(new Intent(MouseActivity.this,KeyBoard.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.multipleKeys:
                        startActivity(new Intent(MouseActivity.this,MultipleKeys.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });
    }


//     @Override
//     public boolean onCreateOptionsMenu(Menu menu) {
//         // Inflate the menu; this adds items to the action bar if it is present.
//         getMenuInflater().inflate(R.menu.main_menu, menu);
//         return true;
//     }

//     @Override
//     public boolean onOptionsItemSelected(MenuItem item) {
//         // Handle action bar item clicks here. The action bar will
//         // automatically handle clicks on the Home/Up button, so long
//         // as you specify a parent activity in AndroidManifest.xml.
//         int id = item.getItemId();
//
//         //noinspection SimplifiableIfStatement
//         if(id == R.id.action_connect) {
//             connection = new Connection();
//             connection.execute(Constants.SERVER_IP); //try to connect to server in another thread
//             return true;
//         }
//
//         return super.onOptionsItemSelected(item);
//     }

//     OnClick method is called when any of the buttons are pressed
     @Override
     public void onClick(View v) {
         switch (v.getId()) {
             case R.id.leftClick:
                 if (isConnected && out!=null) {

                     Thread thread = new Thread(new Runnable() {

                         @Override
                         public void run() {
                             try  {
                                 //Code here

                                 out.println();
                                 out.println(Constants.MOUSE_LEFT_CLICK);


                             } catch (Exception e) {
                                 e.printStackTrace();
                             }
                         }
                     });

                     thread.start();


                 }
                 break;
             case R.id.rightClick:
                 if (isConnected && out!=null) {

                     Thread thread = new Thread(new Runnable() {

                         @Override
                         public void run() {
                             try  {
                                 //Code here

                                 out.println();
                                 out.println(Constants.MOUSE_RIGHT_CLICK);

                             } catch (Exception e) {
                                 e.printStackTrace();
                             }
                         }
                     });

                     thread.start();


                 }
                 break;

         }

     }

     @Override
     public void onDestroy()
     {
         super.onDestroy();
         if(isConnected && out!=null) {
             try {
                 out.println("exit"); //tell server to exit
                 socket.close(); //close socket
             } catch (IOException e) {
                 Log.e("pc controller", "Error in closing socket", e);
             }
         }
     }

//     public class ConnectPhoneTask extends AsyncTask<String,Void,Boolean> {
//
//         @Override
//         protected Boolean doInBackground(String... params) {
//             boolean result = true;
//             try {
//                 InetAddress serverAddr = InetAddress.getByName(params[0]);
//                 socket = new Socket(serverAddr, Constants.SERVER_PORT);//Open socket on server IP and port
//             } catch (IOException e) {
//                 Log.e("remotedroid", "Error while connecting", e);
//                 result = false;
//             }
//             return result;
//         }
//
//         @Override
//         protected void onPostExecute(Boolean result)
//         {
//             isConnected = result;
//             Toast.makeText(context,isConnected?"Connected to server!":"Error while connecting",Toast.LENGTH_LONG).show();
//             try {
//                 if(isConnected) {
//                     out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket
//                             .getOutputStream())), true); //create output stream to send data to server
//                 }
//             }catch (IOException e){
//                 Log.e("remotedroid", "Error while creating OutWriter", e);
//                 Toast.makeText(context,"Error while connecting",Toast.LENGTH_LONG).show();
//             }
//         }
//     }

 }