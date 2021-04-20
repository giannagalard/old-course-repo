package realty;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
	JPanel panel;
	JLabel username, password, text;
	JTextField usernameText;
	JPasswordField passwordText;
	JButton submit, cancel;
	boolean isLoggedIn = false;

	Login() {
		username = new JLabel();
		username.setText("     Username:"); // (must be 5 spaces )
		usernameText = new JTextField();
		password = new JLabel();
		password.setText("     Password:"); // (must be 5 spaces )
		passwordText = new JPasswordField();
		submit = new JButton("Submit"); // text for submit button
		
		submit.addActionListener(this);

		panel = new JPanel(new GridLayout(3, 1));
		panel.add(username); // user label
		panel.add(usernameText); // user input
		panel.add(password); // pass label
		panel.add(passwordText); // user input
		text = new JLabel();
		panel.add(text); // blank box to put submit button under user input
		panel.add(submit); // submit button
		
		add(panel, BorderLayout.CENTER);
		setTitle("Please Login:");
		setSize(375, 150); // setting the size of the window
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Login();
	}

	@Override // this is the login / register ( basically they can either login with admin
				// credentials or make a new account and login instantly lol )
	public void actionPerformed(ActionEvent ae) {
		String username = usernameText.getText();
		String password = passwordText.getText();
		if (username.trim().equals("admin") && password.trim().equals("admin")) {
			setVisible(false);
			System.out.println("Welcome back " + username + "!");
			new Choice();
		}
		else if (username == "" || password == "") {
			System.out.println("Missing Value!");
		}
		else {
			setVisible(false);
			System.out.println("Welcome back " + usernameText.getText() + "!");
			new Choice();
		}
	}
}
