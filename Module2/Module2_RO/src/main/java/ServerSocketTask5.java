import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerSocketTask5 {
    protected int serverPort;
    protected ServerSocket serverSocket = null;
    protected boolean isStopped = false;

    private final DAOTask5 repository = new DAOTask5();
    private PrintWriter out;
    private BufferedReader in;

    public ServerSocketTask5(int port) {
        this.serverPort = port;
        try {
            serverSocket = new ServerSocket(serverPort);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ServerSocketTask5 socket = new ServerSocketTask5(8080);
        socket.run();
    }

    public void run() {
        while (!isStopped()) {
            Socket clientSocket = null;
            try {
                clientSocket = this.serverSocket.accept();
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
            } catch (IOException e) {
                if (isStopped()) {
                    System.out.println("Server Stopped.");
                    return;
                }
                throw new RuntimeException(
                        "Error accepting client connection", e);
            }

            String msg = null;
            try {
                msg = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Received message " + msg);

            executeDao(parseMessage(msg));
        }
        System.out.println("Server Stopped.");
    }


    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    private void executeDao(ArrayList<String> args) {
        switch (args.get(0)) {
            case "1" -> out.println(repository.getAllSouvenirsByProducerId(Integer.parseInt(args.get(1))));
            case "2" -> out.println(repository.getAllSouvenirsByCountry(args.get(1)));
            case "3" -> out.println(repository.getAllProducersBySouvenirPrice(Integer.parseInt(args.get(1))));
            case "4" -> out.println(repository.getAllProducersBySouvenirNameAndCountry(args.get(1), args.get(2)));
            case "5" -> out.println(repository.deleteProducerById(Integer.parseInt(args.get(1))));
        }
        out.flush();
    }

    private ArrayList<String> parseMessage(String str) {
        ArrayList<String> list = new ArrayList<>();
        String[] array = str.split(";");
        list.add(array[0]);
        for (int i = 1; i < array.length; i++) {
            String[] split = array[i].split("=");
            list.add(split[1]);
        }
        return list;
    }
}


