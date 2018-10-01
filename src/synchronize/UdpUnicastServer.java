package synchronize;

import java.io.IOException;
import java.net.*;
public class UdpUnicastServer implements Runnable {
    /**
     * The port where the client is listening.
     */
	private int step = 2048;
    private final int clientPort;
    private final String CLIENTIP = "192.168.1.12";
    public UdpUnicastServer(int clientPort) {
        this.clientPort = clientPort;
    }
    
    @Override
    public void run() {
        /**
         * Create a new server socket and bind it to a free port. I have chosen
         * one in the 49152 - 65535 range, which are allocated for internal applications
         */
        try (DatagramSocket serverSocket = new DatagramSocket(50000)) {
            // The server will generate 10000 messages and send them to the client
            // Each message will be sent at a 2 ms interval
            for (int i = 0; i < 10000; i++) {
                byte[] data= random();                
                
                DatagramPacket datagramPacket = new DatagramPacket(
                        data,
                        data.length,
                        InetAddress.getByName(CLIENTIP),
                        clientPort
                );
                serverSocket.send(datagramPacket);
                // Wait 2 ms before sending the next message
                Thread.sleep(20);
            }
            System.out.println("Finish");
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    private byte[] random() {
    	short[] array = new short[2048];
    	for (int i = 0; i < array.length; i++) {
			array[i] = (short)(Math.sin(i + step) * 100);
		}
    	step += 2048;
    	
    	return Converter.convert(array);
    }
}