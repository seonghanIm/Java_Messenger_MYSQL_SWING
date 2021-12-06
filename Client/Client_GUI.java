package Client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client_GUI extends JFrame implements ActionListener {
	private JTextArea jta = new JTextArea(40, 25);
	private JTextField jtf = new JTextField(25);
	private static String nickName;
	private Client_connect c;

	public Client_GUI(String nickName) {
		c = new Client_connect();
        this.nickName = nickName;
		add(jta, BorderLayout.CENTER);
		add(jtf, BorderLayout.SOUTH);
		jtf.addActionListener(this);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(800, 100, 400, 600);
		setTitle(nickName+"채팅창");
		c.setGui(this);
		c.connect(nickName);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		String msg = nickName + ":" + jtf.getText() + "\n";
		c.SendMsg(msg);
		jtf.setText("");
	}
	
	public void appendMsg(String msg) {
		jta.append(msg);
	}

}
