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
 * Predstavlja klasu zaduzenu za komunikaciju klijentske sa serverskom stranom.
 *
 * @author Pavle Pajic
 * @since 1.0.0
 *
 */
public class Client {

    /**
     * Soket koji se koristi kao sredstvo komunikacije klijenta i servera.
     */
    private Socket socket;
    /**
     * Izlazni tok podataka.
     */
    private ObjectOutputStream out;
    /**
     * Ulazni tok podataka.
     */
    private ObjectInputStream in;

    /**
     * Povezuje klijent sa serverom.
     * @throws IOException - Ukoliko dodje do greske prilikom komunikacije sa serverom.
     */
    public void connect() throws IOException {
        socket = new Socket("localhost", 9000);
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
        System.out.println("[Client] Connected to server.");
    }

    /**
     * Salje prosledjeni zahtev serveru.
     * @param request - Prosledjeni zahtev.
     * @throws IOException - Ukoliko dodje do greske prilikom komunikacije sa serverom.
     */
    public void sendRequest(Request request) throws IOException {
        out.writeObject(request);
        System.out.println("[Client] Sent request to server.");
        out.flush();
    }

    /**
     * Prima odgovor poslat od strane servera.
     * @return response - Odgovor servera.
     * @throws IOException - Ukoliko dodje do greske prilikom komunikacije sa serverom.
     * @throws ClassNotFoundException - Ukoliko klasa serijalizovanog objekta ne moze biti pronadjena.
     */
    public Response receiveResponse() throws IOException, ClassNotFoundException {
        System.out.println("[Client] Awaiting response...");
        Response response = (Response) in.readObject();
        System.out.println("[Client] Received response from server: " + response.getData());
        return response;
    }

    /**
     * Zatvara konekciju klijenta sa serverom.
     * @throws IOException - Ukoliko dodje do greske prilikom komunikacije sa serverom.
     */
    public void close() throws IOException {
        socket.close();
        out.close();
        in.close();
    }
}
