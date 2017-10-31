import java.net.*;
import java.io.*;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

public class Client {

    public static void main(String[] args) {
        String serverName = args[0];
        int port = Integer.parseInt(args[1]);

        EventQueue.invokeLater(new Runnable() {
            ChatWindow chatWindow = null;
            Socket client = null;
            ObjectOutputStream out = null;
            ObjectInputStream in = null;

            @Override
            public void run() {
                chatWindow = new ChatWindow();

                chatWindow.send.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        ChatMessage msg = new ChatMessage();
                        String messageText = chatWindow.userInput.getText();
                        msg.author = "Unnknown";
                        msg.message = messageText;
                        if (!client.isConnected()) {
                            chatWindow.messages.append("Wait for the chat to connect to the server! \n");
                        } else {
                            out.writeObject(msg);
                        }
                    }
                });

                chatWindow.addWindowListener(new WindowAdapter() { //FIXME
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.out.println("Closed");
                        client.close();
                    }
                });

                try {
                    chatWindow.messages.append("Connecting to " + serverName + " on port " + port + "\n");
                    client = new Socket(serverName, port);

                    chatWindow.messages.append("Just connected to " + client.getRemoteSocketAddress() + "\n");
                    //OutputStream outToServer = client.getOutputStream();
                    out = new ObjectOutputStream(client.getOutputStream());

                    out.writeUTF("Hello from " + client.getLocalSocketAddress());
                    //InputStream inFromServer = client.getInputStream();
                    in = new ObjectInputStream(client.getInputStream());

                    chatWindow.messages.append("Server says " + in.readUTF() + "\n");
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}