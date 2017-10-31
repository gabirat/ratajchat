import java.awt.FlowLayout;
import javax.swing.*;

public class ChatWindow extends JFrame{
    public JTextArea messages;
    public JButton send;
    public JTextField userInput;
    JMenuBar menuBar;
    JMenu options;
    FlowLayout layout;

    ChatWindow(){
        super("RatajChat v1.0");
        setSize(400, 400);
        messages = new JTextArea();
        messages.setColumns(32);
        messages.setRows(18);
        messages.setEditable(false);
        messages.setLineWrap(true);
        send = new JButton("Wyslij");
        userInput = new JTextField();
        userInput.setColumns(25);
        menuBar = new JMenuBar();
        options = new JMenu("Opcje");
        layout = new FlowLayout();
        menuBar.add(options);
        setLayout(layout);
        setJMenuBar(menuBar);
        add(messages);
        add(userInput);
        add(send);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
