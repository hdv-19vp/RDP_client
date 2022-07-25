package group02.rdpclient.socket;

import org.apache.commons.io.FileUtils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public final static String SERVER_IP = "127.0.0.1";
    public final static int SERVER_PORT = 7;
    public static Socket socket = null;
    public static DataInputStream dis = null;
    public static DataOutputStream dos = null;

    public static boolean connect() {
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT); // Connect to server
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());
            System.out.println("Connected: " + socket);

            return true;
        } catch (IOException e) {
//            e.printStackTrace();

            return false;
        }
    }


    public static boolean getProcess(){
        try {
            dos.writeUTF("getProcess");

            while(!dis.readUTF().equals("end") ){
                System.out.println(dis.readUTF());
            }
            String res = dis.readUTF();

            return res.equals("success");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean getApp(){
        try {
            dos.writeUTF("getApp");

            while(!dis.readUTF().equals("end") ){
                System.out.println(dis.readUTF());
            }
            String res = dis.readUTF();

            return res.equals("success");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }



    public static boolean startApp(String appName){
        try {
            dos.writeUTF("startApp");

            dos.writeUTF(appName);

            String res = dis.readUTF();
            return res.equals("success");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean startProccess(String processName){
        try {
            dos.writeUTF("startProccess");

            dos.writeUTF(processName);

            String res = dis.readUTF();
            return res.equals("success");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static boolean killProcess(String processID){
        try {
            dos.writeUTF("killProcess");

            dos.writeUTF(processID);

            String res = dis.readUTF();
            return res.equals("success");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static boolean killApp(String appID){
        try {
            dos.writeUTF("killApp");

            dos.writeUTF(appID);

            String res = dis.readUTF();
            return res.equals("success");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    public static boolean shutDown(){
        try {
            dos.writeUTF("shutDown");

            String res = dis.readUTF();
            return res.equals("success");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void takePic(){
        try {
            dos.writeUTF("takeScreenShot");

            byte[] bytes = null;
            int length = dis.readInt();
            if(length>0)
            {
                bytes =new byte[length];
                dis.readFully(bytes,0,bytes.length);
            }
            FileUtils.writeByteArrayToFile(new File("D:\\pics\\ss.jpg"),bytes);

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }









}