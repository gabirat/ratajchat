import java.awt.FlowLayout;
import javax.swing.*;

public class ChatWindow extends JFrame{
    public JTextArea messages;
    public JButton send;
    public JTextField userInput;
    public JMenuBar menuBar;
    JMenu options;
    FlowLayout layout;

    ChatWindow(){
        super("RatajChat v1.0");
        setSize(400, 400);
        messages = new JTextArea();
        send = new JButton("Wyslij");
        userInput = new JTextField();
        menuBar = new JMenuBar();
        options = new JMenu("Opcje");
        layout = new FlowLayout();
        menuBar.add(options);
        setLayout(layout);
        add(messages);
        add(send);
        add(userInput);
        add(menuBar);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
