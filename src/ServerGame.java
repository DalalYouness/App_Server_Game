import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ServerGame extends Thread {
   private int playerNumber;
   public static   boolean isOver;
   public static int gagnant;


    static {
        isOver = false;
        gagnant = 0;
    }
    public static void main(String[] args) {
        new ServerGame().start();
    }


    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            Random random = new Random();
            int secretNumber = random.nextInt(20);
            System.out.println("Server started....");
            while(!isOver) {
                Socket socket = serverSocket.accept();
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                ++playerNumber;
                String ipAdress = socket.getRemoteSocketAddress().toString();
                System.out.println("Client " + playerNumber + " with ip addess : " + ipAdress + " is connected");
                Communication communication = new Communication(socket,playerNumber,secretNumber);
                communication.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
