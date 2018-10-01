package dev.java;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class EchoClient {
	final static String SERVER_IP = "127.0.0.1";
	final static int SERVER_PORT = 7;
	final static byte[] BUFFER = new byte[4096];
	
	public static void main(String[] args) {
		DatagramSocket ds = null;
		try {
			ds = new DatagramSocket();
			System.out.println("Client started");
			
			InetAddress server = InetAddress.getByName(SERVER_IP);
			while(true) {
				String s = "Client hello";
				byte[] data = s.getBytes();
				
				DatagramPacket dp = new DatagramPacket(data, data.length, server, SERVER_PORT);
				ds.send(dp);
				
				DatagramPacket incoming = new DatagramPacket(BUFFER, BUFFER.length);
				ds.receive(incoming);
				
				dp = new DatagramPacket("message 2".getBytes(), "message 2".getBytes().length, server, SERVER_PORT);
				ds.send(dp);
				ds.setSoTimeout(100);
				
				System.out.println("Receive: " + new String(incoming.getData()));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
