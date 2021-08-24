import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.MouseInfo;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Server {
	
	private static ServerSocket server = null;
	private static Socket client = null;
	private static BufferedReader in = null;
	private static String line;
	private static boolean isConnected=true;
	private static Robot robot;
	private static final int SERVER_PORT = 8998;  
 
	public static void main(String[] args) {
		boolean leftpressed=false;
		boolean rightpressed=false;
		System.out.println("Server has started");
 
	    try{
	    	robot = new Robot();
			server = new ServerSocket(SERVER_PORT); //Create a server socket on port 8998
			client = server.accept(); //Listens for a connection to be made to this socket and accepts it
			System.out.println("Client is connected ");
			in = new BufferedReader(new InputStreamReader(client.getInputStream())); //the input stream where data will come from client

		}catch (IOException e) {
			System.out.println("Error in opening Socket");
			System.exit(-1);
		}catch (AWTException e) {
			System.out.println("Error in creating robot instance");
			System.exit(-1);
		}
			
		//read input from client while it is connected
	    while(isConnected){
	        try{
			line = in.readLine(); //read input from client
			System.out.println(line); //print whatever we get from client
			String temp = "";
			if(line.contains("Brightness")){
				temp = line;
			}
			// String temp = line;
			// System.out.println(temp.length());
			if(temp.length() >0 && temp.substring(0,10).equals("Brightness")){
				int n = line.length();
				String intensity = line.substring(10,n);
				new BrightnessManager().setBrightness(Integer.parseInt(intensity));

			}
			
			//if user clicks on next
			if(line.equalsIgnoreCase("next")){
				//Simulate press and release of key 'n'
				robot.keyPress(KeyEvent.VK_N);
				robot.keyRelease(KeyEvent.VK_N);
			}
			//if user clicks on previous
			else if(line.equalsIgnoreCase("previous")){
				//Simulate press and release of key 'p'
				robot.keyPress(KeyEvent.VK_P);
				robot.keyRelease(KeyEvent.VK_P);		        	
			}
			//if user clicks on play/pause
			else if(line.equalsIgnoreCase("play")){
				//Simulate press and release of spacebar
				robot.keyPress(KeyEvent.VK_SPACE);
				robot.keyRelease(KeyEvent.VK_SPACE);
			}
			//input will come in x,y format if user moves mouse on mousepad
			else if(line.contains(",")){
				float movex=Float.parseFloat(line.split(",")[0]);//extract movement in x direction
				float movey=Float.parseFloat(line.split(",")[1]);//extract movement in y direction
				Point point = MouseInfo.getPointerInfo().getLocation(); //Get current mouse position
				float nowx=point.x;
				float nowy=point.y;
				robot.mouseMove((int)(nowx+movex),(int)(nowy+movey));//Move mouse pointer to new location
			}
			//if user taps on mousepad to simulate a left click
			else if(line.contains("left_click")){
				//Simulate press and release of mouse button 1(makes sure correct button is pressed based on user's dexterity)
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			}

			//if user taps on right click button to simulate a right click
			else if(line.contains("right_click")){
				//Simulate press and release of mouse button 1(makes sure correct button is pressed based on user's dexterity)
				robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
			}

			//if user clicks Space
			else if(line.equalsIgnoreCase("space")){
				//Simulate press and release of spacebar
				robot.keyPress(KeyEvent.VK_SPACE);
				robot.keyRelease(KeyEvent.VK_SPACE);
			}

			//if user clicks Caps lock
			else if(line.equalsIgnoreCase("caps_lock")){
				//Simulate press and release of spacebar
				robot.keyPress(KeyEvent.VK_CAPS_LOCK );
				robot.keyRelease(KeyEvent.VK_CAPS_LOCK );
			}

			//if user clicks Delete
			else if(line.equalsIgnoreCase("delete")){
				//Simulate press and release of spacebar
				robot.keyPress(KeyEvent.VK_DELETE  );
				robot.keyRelease(KeyEvent.VK_DELETE  );
			}

			//if user clicks Down arrow key
			else if(line.equalsIgnoreCase("down_arrow_key")){
				//Simulate press and release of spacebar
				robot.keyPress(KeyEvent.VK_DOWN  );
				robot.keyRelease(KeyEvent.VK_DOWN  );
			}

			//if user clicks Down Enter
			else if(line.equalsIgnoreCase("enter")){
				//Simulate press and release of spacebar
				robot.keyPress(KeyEvent.VK_ENTER   );
				robot.keyRelease(KeyEvent.VK_ENTER   );
			}

			//if user clicks ESC
			else if(line.equalsIgnoreCase("esc")){
				//Simulate press and release of spacebar
				robot.keyPress(KeyEvent.VK_ESCAPE    );
				robot.keyRelease(KeyEvent.VK_ESCAPE    );
			}

			//if user clicks F1
			else if(line.equalsIgnoreCase("f_1")){
				//Simulate press and release of spacebar
				robot.keyPress(KeyEvent.VK_F1    );
				robot.keyRelease(KeyEvent.VK_F1    );
			}

			//if user clicks F2
			else if(line.equalsIgnoreCase("f_2")){
				//Simulate press and release of spacebar
				robot.keyPress(KeyEvent.VK_F2    );
				robot.keyRelease(KeyEvent.VK_F2    );
			}

			//if user clicks F3
			else if(line.equalsIgnoreCase("f_3")){
				//Simulate press and release of spacebar
				robot.keyPress(KeyEvent.VK_F3    );
				robot.keyRelease(KeyEvent.VK_F3    );
			}

			//if user clicks F4
			else if(line.equalsIgnoreCase("f_4")){
				//Simulate press and release of spacebar
				robot.keyPress(KeyEvent.VK_F4   );
				robot.keyRelease(KeyEvent.VK_F4    );
			}

			//if user clicks F5
			else if(line.equalsIgnoreCase("f_5")){
				//Simulate press and release of spacebar
				robot.keyPress(KeyEvent.VK_F5    );
				robot.keyRelease(KeyEvent.VK_F5    );
			}

			//if user clicks F6
			else if(line.equalsIgnoreCase("f_6")){
				//Simulate press and release of spacebar
				robot.keyPress(KeyEvent.VK_F6    );
				robot.keyRelease(KeyEvent.VK_F6    );
			}

			//if user clicks F7
			else if(line.equalsIgnoreCase("f_7")){
				//Simulate press and release of spacebar
				robot.keyPress(KeyEvent.VK_F7    );
				robot.keyRelease(KeyEvent.VK_F7    );
			}

			//if user clicks F8
			else if(line.equalsIgnoreCase("f_8")){
				//Simulate press and release of spacebar
				robot.keyPress(KeyEvent.VK_F8    );
				robot.keyRelease(KeyEvent.VK_F8    );
			}

			//if user clicks F9
			else if(line.equalsIgnoreCase("f_9")){
				//Simulate press and release of spacebar
				robot.keyPress(KeyEvent.VK_F9    );
				robot.keyRelease(KeyEvent.VK_F9    );
			}

			//if user clicks F10
			else if(line.equalsIgnoreCase("f_10")){
				//Simulate press and release of spacebar
				robot.keyPress(KeyEvent.VK_F10    );
				robot.keyRelease(KeyEvent.VK_F10    );
			}

			//if user clicks F11
			else if(line.equalsIgnoreCase("f_11")){
				//Simulate press and release of spacebar
				robot.keyPress(KeyEvent.VK_F11    );
				robot.keyRelease(KeyEvent.VK_F11    );
			}

			//if user clicks F12
			else if(line.equalsIgnoreCase("f_12")){
				//Simulate press and release of spacebar
				robot.keyPress(KeyEvent.VK_F12    );
				robot.keyRelease(KeyEvent.VK_F12    );
			}

			//if user clicks Insert
			else if(line.equalsIgnoreCase("insert")){
				//Simulate press and release of spacebar
				robot.keyPress(KeyEvent.VK_INSERT     );
				robot.keyRelease(KeyEvent.VK_INSERT     );
			}

			//if user clicks Up arrow key
			else if(line.equalsIgnoreCase("up_arrow_key")){
				//Simulate press and release of spacebar
				robot.keyPress(KeyEvent.VK_UP  );
				robot.keyRelease(KeyEvent.VK_UP  );
			}

			//if user clicks Left arrow key
			else if(line.equalsIgnoreCase("left_arrow_key")){
				//Simulate press and release of spacebar
				robot.keyPress(KeyEvent.VK_LEFT  );
				robot.keyRelease(KeyEvent.VK_LEFT  );
			}

			//if user clicks Right arrow key
			else if(line.equalsIgnoreCase("right_arrow_key")){
				//Simulate press and release of spacebar
				robot.keyPress(KeyEvent.VK_RIGHT  );
				robot.keyRelease(KeyEvent.VK_RIGHT  );
			}

			//if user clicks Tab
			else if(line.equalsIgnoreCase("tab")){
				//Simulate press and release of spacebar
				robot.keyPress(KeyEvent.VK_TAB  );
				robot.keyRelease(KeyEvent.VK_TAB  );
			}

			//if user clicks Windows
			else if(line.equalsIgnoreCase("windows")){
				
				robot.keyPress(KeyEvent.VK_WINDOWS  );
				robot.keyRelease(KeyEvent.VK_WINDOWS  );
			}

			//if user clicks Subtract
			else if(line.equalsIgnoreCase("subtract")){
				//Simulate press and release of spacebar
				robot.keyPress(KeyEvent.VK_SUBTRACT   );
				robot.keyRelease(KeyEvent.VK_SUBTRACT   );
			}

			//if user clicks Plus
			else if(line.equalsIgnoreCase("plus")){
				//Simulate press and release of spacebar
				 robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_EQUALS);
			        robot.keyRelease(KeyEvent.VK_EQUALS);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			       
			}

			//if user clicks ALT
			else if(line.equalsIgnoreCase("alt")){
				//Simulate press and release of spacebar
				robot.keyPress(KeyEvent.VK_ALT    );
				robot.keyRelease(KeyEvent.VK_ALT    );
			}

			//if user clicks HOME
			else if(line.equalsIgnoreCase("home")){
				//Simulate press and release of spacebar
				robot.keyPress(KeyEvent.VK_HOME     );
				robot.keyRelease(KeyEvent.VK_HOME     );
			}

			//if user clicks Power off
			else if(line.equalsIgnoreCase("power_off")){
				
				Runtime runtime = Runtime.getRuntime();
				Process proc = runtime.exec("shutdown -s -t ");
				

			}

			//if user clicks lock screen
			else if(line.equalsIgnoreCase("lock_screen")){
				
				Runtime runtime = Runtime.getRuntime();
				try {
				    Process pr = runtime.exec("C:/WINDOWS/System32/rundll32.exe user32.dll,LockWorkStation");
				} catch (IOException e) {
				    e.printStackTrace();
				}
				

			}

			//if user clicks sleep the pc
			else if(line.equalsIgnoreCase("sleep_pc")){
				
				Runtime.getRuntime().exec("Rundll32.exe powrprof.dll,SetSuspendState Sleep");

			}

			//if user clicks restart the pc
			else if(line.equalsIgnoreCase("restart")){
				
				Runtime runtime = Runtime.getRuntime();
				Process proc = runtime.exec("shutdown -r");

			}


			//Exit if user ends the connection
			else if(line.equalsIgnoreCase("exit")){
				isConnected=false;
				//Close server and client socket
				server.close();
				client.close();
			}

			else {
				
				switch (line) {
			        case "a":
			        robot.keyPress(KeyEvent.VK_A    );
					robot.keyRelease(KeyEvent.VK_A    );
			        break;
			        case "b":
			        robot.keyPress(KeyEvent.VK_B    );
					robot.keyRelease(KeyEvent.VK_B    );
			        break;
			        case "c":
			        robot.keyPress(KeyEvent.VK_C    );
					robot.keyRelease(KeyEvent.VK_C    );
			        break;
			        case "d":
			        robot.keyPress(KeyEvent.VK_D    );
					robot.keyRelease(KeyEvent.VK_D    );
			        break;
			        case "e": 
			        robot.keyPress(KeyEvent.VK_E);
			        robot.keyRelease(KeyEvent.VK_E); 
			        break;
			        case "f": 
			        robot.keyPress(KeyEvent.VK_F);
			        robot.keyRelease(KeyEvent.VK_F); 
			        break;
			        case "g": 
			        robot.keyPress(KeyEvent.VK_G);
			        robot.keyRelease(KeyEvent.VK_G); 
			        break;
			        case "h": 
			        robot.keyPress(KeyEvent.VK_H);
			        robot.keyRelease(KeyEvent.VK_H); 
			        break;
			        case "i": 
			        robot.keyPress(KeyEvent.VK_I);
			        robot.keyRelease(KeyEvent.VK_I); 
			        break;
			        case "j": 
			        robot.keyPress(KeyEvent.VK_J);
			        robot.keyRelease(KeyEvent.VK_J); 
			        break;
			        case "k": 
			        robot.keyPress(KeyEvent.VK_K);
			        robot.keyRelease(KeyEvent.VK_K); 
			        break;
			        case "l": 
			        robot.keyPress(KeyEvent.VK_L);
			        robot.keyRelease(KeyEvent.VK_L); 
			        break;
			        case "m": 
			        robot.keyPress(KeyEvent.VK_M);
			        robot.keyRelease(KeyEvent.VK_M); 
			        break;
			        case "n": 
			        robot.keyPress(KeyEvent.VK_N);
			        robot.keyRelease(KeyEvent.VK_N); 
			        break;
			        case "o": 
			        robot.keyPress(KeyEvent.VK_O);
			        robot.keyRelease(KeyEvent.VK_O); 
			        break;
			        case "p": 
			        robot.keyPress(KeyEvent.VK_P);
			        robot.keyRelease(KeyEvent.VK_P); 
			        break;
			        case "q": 
			        robot.keyPress(KeyEvent.VK_Q);
			        robot.keyRelease(KeyEvent.VK_Q); 
			        break;
			        case "r": 
			        robot.keyPress(KeyEvent.VK_R);
			        robot.keyRelease(KeyEvent.VK_R); 
			        break;
			        case "s": 
			        robot.keyPress(KeyEvent.VK_S);
			        robot.keyRelease(KeyEvent.VK_S); 
			        break;
			        case "t": 
			        robot.keyPress(KeyEvent.VK_T);
			        robot.keyRelease(KeyEvent.VK_T); 
			        break;
			        case "u": 
			        robot.keyPress(KeyEvent.VK_U);
			        robot.keyRelease(KeyEvent.VK_U); 
			        break;
			        case "v": 
			        robot.keyPress(KeyEvent.VK_V);
			        robot.keyRelease(KeyEvent.VK_V); 
			        break;
			        case "w": 
			        robot.keyPress(KeyEvent.VK_W);
			        robot.keyRelease(KeyEvent.VK_W); 
			        break;
			        case "x": 
			        robot.keyPress(KeyEvent.VK_X);
			        robot.keyRelease(KeyEvent.VK_X); 
			        break;
			        case "y": 
			        robot.keyPress(KeyEvent.VK_Y);
			        robot.keyRelease(KeyEvent.VK_Y); 
			        break;
			        case "z": 
			        robot.keyPress(KeyEvent.VK_Z);
			        robot.keyRelease(KeyEvent.VK_Z); 
			        break;

			        case "A":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_A    );
					robot.keyRelease(KeyEvent.VK_A    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "B":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_B    );
					robot.keyRelease(KeyEvent.VK_B    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "C":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_C    );
					robot.keyRelease(KeyEvent.VK_C    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "D":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_D    );
					robot.keyRelease(KeyEvent.VK_D    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "E":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_E   );
					robot.keyRelease(KeyEvent.VK_E    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "F":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_F    );
					robot.keyRelease(KeyEvent.VK_F    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "G":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_G    );
					robot.keyRelease(KeyEvent.VK_G    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "H":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_H    );
					robot.keyRelease(KeyEvent.VK_H    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "I":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_I    );
					robot.keyRelease(KeyEvent.VK_I    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "J":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_J    );
					robot.keyRelease(KeyEvent.VK_J    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "K":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_K    );
					robot.keyRelease(KeyEvent.VK_K    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "L":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_L    );
					robot.keyRelease(KeyEvent.VK_L    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			       case "M":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_M    );
					robot.keyRelease(KeyEvent.VK_M    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "N":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_N    );
					robot.keyRelease(KeyEvent.VK_N    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "O":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_O    );
					robot.keyRelease(KeyEvent.VK_O    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "P":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_P    );
					robot.keyRelease(KeyEvent.VK_P    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "Q":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_Q    );
					robot.keyRelease(KeyEvent.VK_Q    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "R":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_R    );
					robot.keyRelease(KeyEvent.VK_R    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "S":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_S    );
					robot.keyRelease(KeyEvent.VK_S    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "T":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_T    );
					robot.keyRelease(KeyEvent.VK_T    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "U":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_U    );
					robot.keyRelease(KeyEvent.VK_U    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "V":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_V    );
					robot.keyRelease(KeyEvent.VK_V    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "W":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_W    );
					robot.keyRelease(KeyEvent.VK_W    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "X":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_X    );
					robot.keyRelease(KeyEvent.VK_X    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "Y":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_Y    );
					robot.keyRelease(KeyEvent.VK_Y    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "Z":
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_Z    );
					robot.keyRelease(KeyEvent.VK_Z    );
					robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			
			        case "`": 
			        robot.keyPress(KeyEvent.VK_BACK_QUOTE);
			        robot.keyRelease(KeyEvent.VK_BACK_QUOTE);
			        break;

			        case "0": 
			        robot.keyPress(KeyEvent.VK_0);
			        robot.keyRelease(KeyEvent.VK_0);
			        break;
			        case "1": 
			        robot.keyPress(KeyEvent.VK_1);
			        robot.keyRelease(KeyEvent.VK_1);
			        break;
			        case "2": 
			        robot.keyPress(KeyEvent.VK_2);
			        robot.keyRelease(KeyEvent.VK_2);
			        break;
			        case "3": 
			        robot.keyPress(KeyEvent.VK_3);
			        robot.keyRelease(KeyEvent.VK_3);
			        break;
			        case "4": 
			        robot.keyPress(KeyEvent.VK_4);
			        robot.keyRelease(KeyEvent.VK_4);
			        break;
			        case "5": 
			        robot.keyPress(KeyEvent.VK_5);
			        robot.keyRelease(KeyEvent.VK_5);
			        break;
			        case "6": 
			        robot.keyPress(KeyEvent.VK_6);
			        robot.keyRelease(KeyEvent.VK_6);
			        break;
			        case "7": 
			        robot.keyPress(KeyEvent.VK_7);
			        robot.keyRelease(KeyEvent.VK_7);
			        break;
			        case "8": 
			        robot.keyPress(KeyEvent.VK_8);
			        robot.keyRelease(KeyEvent.VK_8);
			        break;
			        case "9": 
			        robot.keyPress(KeyEvent.VK_9);
			        robot.keyRelease(KeyEvent.VK_9);
			        break;

			         case "-": 
			        robot.keyPress(KeyEvent.VK_MINUS);
			        robot.keyRelease(KeyEvent.VK_MINUS);
			        break;

			         case "+": 
			         robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_EQUALS);
			        robot.keyRelease(KeyEvent.VK_EQUALS);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;

			         case "=":
			        robot.keyPress(KeyEvent.VK_EQUALS);
			        robot.keyRelease(KeyEvent.VK_EQUALS);
			        break;

			         case "~": 
			        robot.keyPress(KeyEvent.VK_BACK_QUOTE);
			        robot.keyRelease(KeyEvent.VK_BACK_QUOTE);
			        break;
			         case "!": 
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_1);
			        robot.keyRelease(KeyEvent.VK_1);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			         case "@": 
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_2);
			        robot.keyRelease(KeyEvent.VK_2);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			         case "#": 
			         robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_3);
			        robot.keyRelease(KeyEvent.VK_3);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			         case "$": 
			         robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_4);
			        robot.keyRelease(KeyEvent.VK_4);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			         case "%": 
			         robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_5);
			        robot.keyRelease(KeyEvent.VK_5);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			         case "^":
			         robot.keyPress(KeyEvent.VK_SHIFT); 
			        robot.keyPress(KeyEvent.VK_6);
			        robot.keyRelease(KeyEvent.VK_6);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			         case "&":
			         robot.keyPress(KeyEvent.VK_SHIFT); 
			        robot.keyPress(KeyEvent.VK_7);
			        robot.keyRelease(KeyEvent.VK_7);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			         case "*": 
			         robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_8);
			        robot.keyRelease(KeyEvent.VK_8);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			         case "(": 
			         robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_9);
			        robot.keyRelease(KeyEvent.VK_9);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			         case ")": 
			         
			       robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_0);
			        robot.keyRelease(KeyEvent.VK_0);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        
			        break;
			         case "_":
			         robot.keyPress(KeyEvent.VK_SHIFT); 
			        robot.keyPress(KeyEvent.VK_MINUS);
			        robot.keyRelease(KeyEvent.VK_MINUS);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			         case "\t": 
			        robot.keyPress(KeyEvent.VK_TAB);
			        robot.keyRelease(KeyEvent.VK_TAB);
			        break;
			         case "\n": 
			        robot.keyPress(KeyEvent.VK_ENTER);
			        robot.keyRelease(KeyEvent.VK_ENTER);
			        break;
			         case "[": 
			        robot.keyPress(KeyEvent.VK_OPEN_BRACKET);
			        robot.keyRelease(KeyEvent.VK_OPEN_BRACKET);
			        break;
			         case "]": 
			        robot.keyPress(KeyEvent.VK_CLOSE_BRACKET);
			        robot.keyRelease(KeyEvent.VK_CLOSE_BRACKET);
			        break;
			        case "\\": 
			        robot.keyPress(KeyEvent.VK_BACK_SLASH);
			        robot.keyRelease(KeyEvent.VK_BACK_SLASH);
			        break;
			        case "{": 
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_OPEN_BRACKET);
			        robot.keyRelease(KeyEvent.VK_OPEN_BRACKET);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "}": 
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_CLOSE_BRACKET);
			        robot.keyRelease(KeyEvent.VK_CLOSE_BRACKET);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "|": 
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_BACK_SLASH);
			        robot.keyRelease(KeyEvent.VK_BACK_SLASH);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case ";": 
			        robot.keyPress(KeyEvent.VK_SEMICOLON);
			        robot.keyRelease(KeyEvent.VK_SEMICOLON);
			        break;
			        case ":": 
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_CLOSE_BRACKET);
			        robot.keyRelease(KeyEvent.VK_CLOSE_BRACKET);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;
			        case "\'": 
			        robot.keyPress(KeyEvent.VK_QUOTE);
			        robot.keyRelease(KeyEvent.VK_QUOTE);
			        break;

			        case "\"": 
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_QUOTE);
			        robot.keyRelease(KeyEvent.VK_QUOTE);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;

			        case "<": 
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_COMMA);
			        robot.keyRelease(KeyEvent.VK_COMMA);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;

			        case ",": 
			        robot.keyPress(KeyEvent.VK_COMMA);
			        robot.keyRelease(KeyEvent.VK_COMMA);
			        break;
			        case ".": 
			        robot.keyPress(KeyEvent.VK_PERIOD);
			        robot.keyRelease(KeyEvent.VK_PERIOD);
			        break;
			        case ">": 
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_PERIOD);
			        robot.keyRelease(KeyEvent.VK_PERIOD);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;

			        case "/": 
			        robot.keyPress(KeyEvent.VK_SLASH);
			        robot.keyRelease(KeyEvent.VK_SLASH);
			        break;

			        case "?": 
			        robot.keyPress(KeyEvent.VK_SHIFT);
			        robot.keyPress(KeyEvent.VK_SLASH);
			        robot.keyRelease(KeyEvent.VK_SLASH);
			        robot.keyRelease(KeyEvent.VK_SHIFT);
			        break;

			        case " ": 
			        robot.keyPress(KeyEvent.VK_SPACE);
			        robot.keyRelease(KeyEvent.VK_SPACE);
			        break;

			        case "\b": 
			        robot.keyPress(KeyEvent.VK_BACK_SPACE);
			        robot.keyRelease(KeyEvent.VK_BACK_SPACE);
			        break;

			        
			        // case '-': doType(VK_MINUS); break;
			        // case '=': doType(VK_EQUALS); break;
			        // case '~': doType(VK_BACK_QUOTE); break;
			        // case '!': doType(VK_SHIFT, VK_EXCLAMATION_MARK); break;
			        // case '@': doType(VK_SHIFT, VK_AT); break;
			        // case '#': doType(VK_SHIFT, VK_NUMBER_SIGN); break;
			        // case '$': doType(VK_SHIFT, VK_DOLLAR); break;
			        // case '%': doType(VK_SHIFT, VK_5); break;
			        // case '^': doType(VK_SHIFT, VK_CIRCUMFLEX); break;
			        // case '&': doType(VK_SHIFT, VK_AMPERSAND); break;
			        // case '*': doType(VK_SHIFT, VK_ASTERISK); break;
			        // case '(': doType(VK_LEFT_PARENTHESIS); break;
			        // case ')': doType(VK_RIGHT_PARENTHESIS); break;
			        // case '_': doType(VK_SHIFT, VK_UNDERSCORE); break;
			        // case '+': doType(VK_SHIFT, VK_PLUS); break;
			        // case '\t': doType(VK_TAB); break;
			        // case '\n': doType(VK_ENTER); break;
			        // case '[': doType(VK_OPEN_BRACKET); break;
			        // case ']': doType(VK_CLOSE_BRACKET); break;
			        // case '\\': doType(VK_BACK_SLASH); break;
			        // case '{': doType(VK_SHIFT, VK_OPEN_BRACKET); break;
			        // case '}': doType(VK_SHIFT, VK_CLOSE_BRACKET); break;
			        // case '|': doType(VK_SHIFT, VK_BACK_SLASH); break;
			        // case ';': doType(VK_SEMICOLON); break;
			        // case ':': doType(VK_SHIFT, VK_COLON); break;
			        // case '\'': doType(VK_QUOTE); break;
			        // case '"': doType(VK_SHIFT, VK_QUOTEDBL); break;
			        // case ',': doType(VK_COMMA); break;
			        // case '<': doType(VK_SHIFT, VK_COMMA); break;
			        // case '.': doType(VK_PERIOD); break;
			        // case '>': doType(VK_SHIFT, VK_PERIOD); break;
			        // case '/': doType(VK_SLASH); break;
			        // case '?': doType(VK_SHIFT, VK_SLASH); break;
			        // case ' ': doType(VK_SPACE); break;
			        // case '\b': doType(VK_BACK_SPACE); break;
			        default:
            // throw new IllegalArgumentException("Cannot type character " + line);
        }
			}
	        } catch (IOException e) {
				System.out.println("Read failed");
				System.exit(-1);
	        }
      	}
	}

// public void doType(int... keyCodes) {
//         int length = keyCodes.length;
//         for (int i = 0; i < length; i++) {
//             robot.keyPress(keyCodes[i]);
//         }
//         robot.delay(10);
//         for (int i = length - 1; i >= 0; i--) {
//             robot.keyRelease(keyCodes[i]);
//         }
//     }

	

}
