import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Communication extends Thread {
    private Socket socket;
    private int playerNumber;
    private int secretNumber;



    public Communication(Socket socket, int playerNumber,int secretNumber) {
        this.socket = socket;
        this.playerNumber = playerNumber;
        this.secretNumber = secretNumber;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("bienvenue joueur " + playerNumber);

            int clientNumber = -1;

            while (!ServerGame.isOver) {

                do {
                    out.println("devinez un nombre entre 0 et 19");
                    String request = in.readLine();

                    try {
                        clientNumber = Integer.parseInt(request);

                    } catch (NumberFormatException e) {
                        out.println("\nmerci d'entrez un nombre et non pas des caracteres :)");
                    }

                } while (clientNumber < 0 || clientNumber > 19);

                out.println(clientNumber);
                out.println("parfait vous avez choisis un nombre entre 0 et 19");

                if (clientNumber < secretNumber) {
                    out.println("le nombre que vous avez entrez est inferieur du nombre secret :(");
                }
                else if (clientNumber > secretNumber) {
                    out.println("le nombre que vous avez entrez est superieur du nombre secret :(");
                }
                else {
                    out.println("BRAVO joueur " + playerNumber + "vous avez gagné");
                    ServerGame.gagnant = playerNumber;
                    ServerGame.isOver = true;
                }


            }



        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
