/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pajic.client;

import com.pajic.communication.Request;
import com.pajic.communication.Response;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Pavle
 */
public class Client {
    
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    
    public void connect() throws IOException {
        socket = new Socket("localhost", 9000);
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
        System.out.println("[Client] Connected to server.");
    }
    
    public void sendRequest(Request request) throws IOException {
        out.writeObject(request);
        System.out.println("[Client] Sent request to server.");
        out.flush();
    }
    
    public Response receiveResponse() throws IOException, ClassNotFoundException {
        System.out.println("[Client] Awaiting response...");
        Response response = (Response) in.readObject();
        System.out.println("[Client] Received response from server: " + response.getData());
        return response;
    }
    
    public void close() throws IOException {
        socket.close();
        out.close();
        in.close();
    }
}
