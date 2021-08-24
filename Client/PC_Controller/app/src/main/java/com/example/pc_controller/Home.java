package com.example.pc_controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.io.PrintWriter;
import java.net.Socket;

public class Home extends AppCompatActivity {

    Connection connection;
    Context context;
    SeekBar seekBar;

//    boolean isConnected = false;
//    public Socket socket;
//    public PrintWriter out;

    ImageButton shutDown,lock_screen,connect,sleep,restart,previous,play_pause,next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        context = Home.this;
//        connection = new Connection(context);

        shutDown = findViewById(R.id.shutdown);
        lock_screen = findViewById(R.id.lock_screen);
        connect = findViewById(R.id.connect);
        sleep = findViewById(R.id.sleep);
        restart = findViewById(R.id.restart);
        previous = findViewById(R.id.previous);
        play_pause = findViewById(R.id.play_pause);
        next = findViewById(R.id.next);
        seekBar = findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//                Toast.makeText(context, String.valueOf(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar s) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                String intensity = String.valueOf(seekBar.getProgress());
                String brightness = "Brightness"+intensity;

                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(brightness);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }

            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.LEFT_ARROW_KEY);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });

        play_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.SPACE);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.RIGHT_ARROW_KEY);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.RESTART_PC);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });

        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.SLEEP_PC);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });

        lock_screen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.LOCK_SCREEN);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });

        shutDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.POWER_OFF);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });

        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                connection = new Connection(context);
                connection.execute(Constants.SERVER_IP); //try to connect to server in another thread
            }
        });


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:

                        return true;

                    case R.id.mouse:
                        startActivity(new Intent(Home.this, MouseActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.keyboard:
                        startActivity(new Intent(Home.this,KeyBoard.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.multipleKeys:
                        startActivity(new Intent(Home.this,MultipleKeys.class));
                        overridePendingTransition(0,0);
                        return true;
                }

                return false;
            }
        });



    }

//    @Override
//     public boolean onOptionsItemSelected(MenuItem item) {
//
//         int id = item.getItemId();
//
//         //noinspection SimplifiableIfStatement
//         if(id == R.id.action_connect) {
//             connection = new Connection(context);
//             connection.execute(Constants.SERVER_IP); //try to connect to server in another thread
//             return true;
//         }
//
//         return super.onOptionsItemSelected(item);
//     }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        return true;
//    }

}