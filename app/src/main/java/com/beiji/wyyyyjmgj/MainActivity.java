package com.beiji.wyyyyjmgj;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Con=findViewById(R.id.Confirm);
        Con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread UNN=new Thread(UN);
                UNN.start();
            }
        });
    }
Tools tools=new Tools();
    Thread UN=new Thread(){
        @Override
        public void run() {
            EditText Path=findViewById(R.id.Path);
            String Pathabs="";
            if (Path.getText().toString().isEmpty()){
                Pathabs= Environment.getExternalStorageDirectory().getPath()+"/netease/cloudmusic/Cache";
            }
            else{
                Pathabs=Path.getText().toString();
            }
            try {
                tools.Un(Pathabs);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    };
}
