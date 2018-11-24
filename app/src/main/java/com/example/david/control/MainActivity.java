package com.example.david.control;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    //Reference
    //https://github.com/BoldizsarZopcsak/Android-Studio-code

    private final String DEVICE_ADDRESS = "98:D3:31:FC:4A:84"; //MAC Address of Bluetooth Module
    private final UUID PORT_UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");

    private BluetoothDevice device;
    private BluetoothSocket socket;
    private BluetoothAdapter bluetoothAdapter;
    private OutputStream outputStream;

    Button forwardButton, backwardButton, rightButton, leftButton, rightSpinButton, leftSpinButton, downSpeedButton, upSpeedButton, stopButton,
            button44;
    Switch connectBluetoothButton, modeButton;
    String command;

    private int[][] table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        forwardButton = findViewById(R.id.forwardButton);
        backwardButton = findViewById(R.id.backwardButton);
        rightButton = findViewById(R.id.rightButton);
        leftButton = findViewById(R.id.leftButton);
        rightSpinButton = findViewById(R.id.rightSpinButton);
        leftSpinButton = findViewById(R.id.leftSpinButton);
        downSpeedButton = findViewById(R.id.downSpeedButton);
        upSpeedButton = findViewById(R.id.upSpeedButton);
        stopButton = findViewById(R.id.stopButton);
        connectBluetoothButton = findViewById(R.id.connectBluetoothButton);
        modeButton = findViewById(R.id.btnMode);

        connectBluetoothButton.setChecked(false);
        connectBluetoothButton.setTextOff("Off");
        connectBluetoothButton.setTextOn("On");

        modeButton.setChecked(false);

        button44 = findViewById(R.id.button44);

        table = new int[9][9];


        button44.setBackgroundColor(Color.BLACK);


        forwardButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    command = "W";
                    try {
                        outputStream.write(command.getBytes());
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if(event.getAction() == MotionEvent.ACTION_UP) {
                    command = "X";
                    try {
                        outputStream.write(command.getBytes());
                    }
                    catch(IOException e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
        });


        backwardButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    command = "S";
                    try {
                        outputStream.write(command.getBytes());
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if(event.getAction() == MotionEvent.ACTION_UP) {
                    command = "X";
                    try {
                        outputStream.write(command.getBytes());
                    }
                    catch(IOException e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
        });


        rightButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    command = "D";
                    try {
                        outputStream.write(command.getBytes());
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if(event.getAction() == MotionEvent.ACTION_UP) {
                    command = "X";
                    try {
                        outputStream.write(command.getBytes());
                    }
                    catch(IOException e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
        });


        leftButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    command = "A";
                    try {
                        outputStream.write(command.getBytes());
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if(event.getAction() == MotionEvent.ACTION_UP) {
                    command = "X";
                    try {
                        outputStream.write(command.getBytes());
                    }
                    catch(IOException e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
        });


        rightSpinButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    command = "C";
                    try {
                        outputStream.write(command.getBytes());
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if(event.getAction() == MotionEvent.ACTION_UP) {
                    command = "X";
                    try {
                        outputStream.write(command.getBytes());
                    }
                    catch(IOException e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
        });


        leftSpinButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    command = "Z";
                    try {
                        outputStream.write(command.getBytes());
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if(event.getAction() == MotionEvent.ACTION_UP) {
                    command = "X";
                    try {
                        outputStream.write(command.getBytes());
                    }
                    catch(IOException e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
        });


        downSpeedButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    command = "U";
                    try {
                        outputStream.write(command.getBytes());
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if(event.getAction() == MotionEvent.ACTION_UP) {
                    command = "X";
                    try {
                        outputStream.write(command.getBytes());
                    }
                    catch(IOException e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
        });


        upSpeedButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    command = "u";
                    try {
                        outputStream.write(command.getBytes());
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if(event.getAction() == MotionEvent.ACTION_UP) {
                    command = "X";
                    try {
                        outputStream.write(command.getBytes());
                    }
                    catch(IOException e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
        });


        stopButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    command = "X";
                    try {
                        outputStream.write(command.getBytes());
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else if(event.getAction() == MotionEvent.ACTION_UP) {
                    command = "X";
                    try {
                        outputStream.write(command.getBytes());
                    }
                    catch(IOException e) {
                        e.printStackTrace();
                    }
                }
                return false;
            }
        });


        modeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean toggleMode = modeButton.isChecked();

                if (toggleMode.equals(true)) {
                    modeButton.setText("auto");
                } else {
                    modeButton.setText("manual");
                }


            }
        });


        connectBluetoothButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean toggleState = connectBluetoothButton.isChecked();
                bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

                if(toggleState.equals(true)) {

                    //Find Bluetooth device
                    if(!bluetoothAdapter.isEnabled()) {
                        Intent enableAdapter = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                        startActivityForResult(enableAdapter,0);
                    }

                    Set<BluetoothDevice> bondedDevices = bluetoothAdapter.getBondedDevices();

                    for(BluetoothDevice iterator : bondedDevices) {
                        if(iterator.getAddress().equals(DEVICE_ADDRESS)) {
                            device = iterator;
                            break;
                        }
                    }

                    //Connect Bluetooth device
                    boolean connected = true;

                    try {
                        socket = device.createRfcommSocketToServiceRecord(PORT_UUID);
                        socket.connect();
                        setTitle("Remote " + DEVICE_ADDRESS);
                    }
                    catch(IOException e) {
                        e.printStackTrace();
                        connected = false;
                    }

                    if(connected) {
                        try {
                            outputStream = socket.getOutputStream();
                        }
                        catch(IOException e) {
                            e.printStackTrace();
                        }
                    }
                } else if(toggleState.equals(false)) {
                    //Disconnect Bluetooth device
                    setTitle("Remote");
                    bluetoothAdapter.disable();
                    try {
                        socket.close();
                    }
                    catch(IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
    }
}

