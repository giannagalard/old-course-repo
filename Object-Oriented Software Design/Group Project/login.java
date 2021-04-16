package realty;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class login extends JFrame implements ActionListener {
	JPanel panel;
	JLabel userName, passWord, text;
	JTextField userName_text;
	JPasswordField password_text;
	JButton submit, cancel;

	login() { // Labels for user name, password, and button

		userName = new JLabel();
		userName.setText("     Username:"); // please don't mess with the spacing ( its 5 spaces )
		userName_text = new JTextField();
		passWord = new JLabel();
		passWord.setText("     Password:"); // please don't mess with the spacing ( its 5 spaces )
		password_text = new JPasswordField();
		submit = new JButton("Submit"); // text for submit button
		panel = new JPanel(new GridLayout(3, 1));
		panel.add(userName); // User label
		panel.add(userName_text); // user input
		panel.add(passWord); // Pass label
		panel.add(password_text); // user input
		text = new JLabel();
		panel.add(text); // blank box to put submit button under user input
		panel.add(submit); // submit button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		submit.addActionListener(this);
		add(panel, BorderLayout.CENTER);
		setTitle("Please Login:");
		setSize(375, 150); // setting the size of the window
		setVisible(true);
	}

	public static void main(String[] args) {
		new login();
	}

	@Override // this is the login / register ( basically they can either login with admin
				// credentials or make a new account and login instantly lol )
	public void actionPerformed(ActionEvent ae) {
		String userName = userName_text.getText();
		String password = password_text.getText();
		if (userName.trim().equals("admin") && password.trim().equals("admin")) {
			text.setText("   Welcome " + userName + " !"); // (3 spaces before Welcome)
		} else {
			text.setText("   Welcome " + userName_text.getText() + " !"); // (3 spaces before Welcome)
		}
	}
}
