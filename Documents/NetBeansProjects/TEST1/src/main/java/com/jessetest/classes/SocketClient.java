/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jessetest.classes;

import com.jessetest.Interfaces.ClientInterface;
import java.io.*;
import java.net.*;
/**
 *
 * @author I540371
 */
public class SocketClient implements ClientInterface{
    
    private String[] args;
    private Socket client;
    private String serverName;
    private OutputStream outToServer;
    private DataOutputStream out;
    private InputStream inFromServer;
    private DataInputStream in;
    private int port;

    public SocketClient(String localhost, int port){
        serverName = localhost;
        this.port = port;
    };
    
    @Override
    public void connectServer() {
        try{
            
            System.out.println("connected to host：" + serverName + " ，Port：" + port);
            client = new Socket(serverName, port);
            System.out.println("remote server address：" + client.getRemoteSocketAddress());
            outToServer = client.getOutputStream();
            out = new DataOutputStream(outToServer);
        
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }

    @Override
    public void doAction() {
        try{
            out.writeUTF("Hello from " + client.getLocalSocketAddress());
            inFromServer = client.getInputStream();
            in = new DataInputStream(inFromServer);
            System.out.println("Server response： " + in.readUTF());
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void closeConnection() {
        try{
            client.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    
}
