package synchronize;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.concurrent.BlockingQueue;
public class UdpUnicastClient implements Runnable {
    private final int port;
    private final BlockingQueue<byte[]> messageQueue;
    public UdpUnicastClient(int port, BlockingQueue<byte[]> messageQueue) {
        this.port = port;
        this.messageQueue = messageQueue;
    }
    @Override
    public void run() {
        /**
         * Bind the client socket to the port on which you expect to
         * read incoming messages
         */
        try (DatagramSocket clientSocket = new DatagramSocket(port)) {
            // Set a timeout of 3000 ms for the client.
            clientSocket.setSoTimeout(3000);
            while (true) {
                byte[] buffer = new byte[4096];
                DatagramPacket datagramPacket = new DatagramPacket(buffer, 0, buffer.length);

                clientSocket.receive(datagramPacket);
                this.messageQueue.put(datagramPacket.getData());
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Timeout. Client is closing.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}