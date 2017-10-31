import java.net.*;
import java.io.*;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

public class Client {

    public static void main(String[] args) {
        String serverName = args[0];
        int port = Integer.parseInt(args[1]);

        EventQueue.invokeLater(new Runnable() {
            ChatWindow chatWindow;

            @Override
            public void run() {
                chatWindow = new ChatWindow();

                try {
                    chatWindow.messages.append("Connecting to " + serverName + " on port " + port + "\n");
                    Socket client = new Socket(serverName, port);

                    chatWindow.messages.append("Just connected to " + client.getRemoteSocketAddress() + "\n");
                    OutputStream outToServer = client.getOutputStream();
                    DataOutputStream out = new DataOutputStream(outToServer);

                    out.writeUTF("Hello from " + client.getLocalSocketAddress());
                    InputStream inFromServer = client.getInputStream();
                    DataInputStream in = new DataInputStream(inFromServer);

                    chatWindow.messages.append("Server says " + in.readUTF() + "\n");
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}