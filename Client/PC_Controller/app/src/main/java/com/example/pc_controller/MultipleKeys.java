package com.example.pc_controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MultipleKeys extends AppCompatActivity {

    ImageButton leftArrow, rightArrow, UpArrow, DownArrow;
    Button button_f1,button_f2, button_f3, button_f4, button_f5, button_f6, button_f7, button_f8,button_f9, button_f10,button_f11;
    Button button_f12,button_enter,button_win,button_tab,button_esc,button_caps,button_insert,button_delete,button_alt,button_plus,button_minus,button_space;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_keys);


        leftArrow = findViewById(R.id.arrowLeftKey);
        rightArrow = findViewById(R.id.arrowRightKey);
        UpArrow = findViewById(R.id.arrowUPKey);
        DownArrow = findViewById(R.id.arrowDownKey);
        button_f1 = findViewById(R.id.btn_f1);
        button_f2 = findViewById(R.id.btn_f2);
        button_f3 = findViewById(R.id.btn_f3);
        button_f4 = findViewById(R.id.btn_f4);
        button_f5 = findViewById(R.id.btn_f5);
        button_f6 = findViewById(R.id.btn_f6);
        button_f7 = findViewById(R.id.btn_f7);
        button_f8 = findViewById(R.id.btn_f8);
        button_f9 = findViewById(R.id.btn_f9);
        button_f10 = findViewById(R.id.btn_f10);
        button_f11 = findViewById(R.id.btn_f11);
        button_f12 = findViewById(R.id.btn_f12);
        button_enter = findViewById(R.id.btn_Enter);
        button_win =findViewById(R.id.btn_win);
        button_tab = findViewById(R.id.btn_tab);
        button_esc = findViewById(R.id.btn_esc);
        button_caps = findViewById(R.id.btn_caps);
        button_insert = findViewById(R.id.btn_insert);
        button_delete = findViewById(R.id.btn_delete);
        button_alt = findViewById(R.id.btn_alt);
        button_plus = findViewById(R.id.btn_plus);
        button_minus = findViewById(R.id.btn_minus);
        button_space = findViewById(R.id.btn_space);

        leftArrow.setOnClickListener(new View.OnClickListener() {
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

        rightArrow.setOnClickListener(new View.OnClickListener() {
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

        UpArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.UP_ARROW_KEY);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });

        DownArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.DOWN_ARROW_KEY);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });


        button_f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.F_1);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });

        button_f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.F_2);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });

        button_f3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.F_3);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });
        button_f4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.F_4);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });
        button_f5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.F_5);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });
        button_f6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.F_6);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });button_f7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.F_7);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });
        button_f8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.F_8);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });
        button_f9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.F_9);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });
        button_f10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.F_10);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });
        button_f11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.F_11);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });
        button_f12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.F_12);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });
        button_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.ENTER);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });
        button_win.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.WINDOWS);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });
        button_tab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.TAB);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });
        button_esc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.ESC);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });
        button_caps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.CAPS_LOCK);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });
        button_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.INSERT);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });
        button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.DELETE);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });
        button_alt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.ALT);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });
        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.PLUS);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });
        button_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Connection.isConnected && Connection.out!=null) {
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try  {
                                //Code here

                                Connection.out.println();
                                Connection.out.println(Constants.SUBTRACT);


                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    thread.start();
                }
            }
        });
        button_space.setOnClickListener(new View.OnClickListener() {
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




        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setSelectedItemId(R.id.multipleKeys);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(MultipleKeys.this,Home.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.mouse:
                        startActivity(new Intent(MultipleKeys.this, MouseActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.keyboard:
                        startActivity(new Intent(MultipleKeys.this,KeyBoard.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.multipleKeys:

                        return true;
                }

                return false;
            }
        });
    }
}