/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jessetest.classes;

import com.jessetest.Interfaces.ServerInterface;
import java.io.*;
import java.net.*;
/**
 *
 * @author I540371
 */
public class SocketServer1 implements ServerInterface {
    
    private ServerSocket serverSocket;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    
    public SocketServer1(int port) throws IOException{
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    @Override
    public void serviceStart(){
         try{
             System.out.println("wait remote connection，Port：" + serverSocket.getLocalPort() + "...");
             socket = serverSocket.accept(); //侦听并接受到此套接字的连接。
             System.out.println("remote host address：" + socket.getRemoteSocketAddress());
             in = new DataInputStream(socket.getInputStream());
             System.out.println(in.readUTF());
             out = new DataOutputStream(socket.getOutputStream());
             out.writeUTF("Thanks for your connection：" + socket.getLocalSocketAddress() );
         }catch(SocketTimeoutException s){  
             System.out.println("Socket timed out!");   
         }catch(IOException e){             
            e.printStackTrace();
         }
    }

    @Override
    public void serviceEnd() throws IOException {
        socket.close();
        serverSocket.close();;
    }
    
}
