package com.beiji.wyyyyjmgj;

import android.util.Log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Tools {

    //文本合并
    void Un(String path) throws IOException {
        if(path.endsWith("/")){
            path=path.substring(0,path.length()-1);}
        File f=new File(path);
        Log.d("引用文件路径:",path);
        File[] files;
        if(f.isDirectory()){
            files = f.listFiles();
            Log.d("该文件夹下的目录数量是",String.valueOf(files.length));
        }else {
            files=new File[1];
            files[0]=f;
        }
        for (File file:files) {
            //如果是目录则返回遍历函数
            if (file.exists()&&file.isDirectory()) {

                //如果选择了方法1，则遍历所有子目录下的.txt文件

                Un(file.getPath());
                //是文件,并且后缀.txt
                //} else if((file.getName()).endsWith(".txt")){

            }
            else if (file.getPath().toLowerCase().endsWith(".uc!"))
            {
                DataInputStream dis = new DataInputStream(new FileInputStream(file));
                DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File(file.getPath().substring(0,file.getPath().length()-4))));
                byte[] b = new byte[1024];
                int len;
                while ((len = dis.read(b)) != -1) {
                    for (int i = 0; i < len; i++) {
                        b[i] ^= 0xa3;
                    }
                    dos.write(b, 0, len);
                }
                if (dos != null) {
                    try {
                        dos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (dis != null) {
                    try {
                        dis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }









            }
        }









        DataInputStream dis = null;
        DataOutputStream dos = null;
        try {
            File inFile = new File("D:/1.uc");
            File outFile = new File("D:/1.mp3");

            dis = new DataInputStream(new FileInputStream(inFile));
            dos = new DataOutputStream(new FileOutputStream(outFile));
            byte[] b = new byte[1024];
            int len;
            while ((len = dis.read(b)) != -1) {
                for (int i = 0; i < len; i++) {
                    b[i] ^= 0xa3;
                }
                dos.write(b, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (dis != null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }











    }
}
