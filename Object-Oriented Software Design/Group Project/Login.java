package realty;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
  JPanel panel;
  JLabel username, password, text;
  JTextField username_text;
  JPasswordField password_text;
  JButton submit, cancel;
  boolean isLoggedIn = false;

  Login() { // Labels for user name, password, and button
    username = new JLabel();
    username.setText("     Username:"); // please don't mess with the spacing ( its 5 spaces )
    username_text = new JTextField();
    password = new JLabel();
    password.setText("     Password:"); // please don't mess with the spacing ( its 5 spaces )
    password_text = new JPasswordField();
    submit = new JButton("Submit"); // text for submit button
    panel = new JPanel(new GridLayout(3, 1));
    panel.add(username); // User label
    panel.add(username_text); // user input
    panel.add(password); // Pass label
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
    //		isLoggedIn(isLoggedIn);
  }

  public static void main(String[] args) {
    new Login();
  }

  @Override // this is the login / register ( basically they can either login with admin
  // credentials or make a new account and login instantly lol )
  public void actionPerformed(ActionEvent ae) {
    String username = username_text.getText();
    String password = password_text.getText();
    if (username.trim().equals("admin") && password.trim().equals("admin")) {
      //			text.setText("   Welcome " + userName + " !"); // (3 spaces before Welcome)
      setVisible(false);
      System.out.println("Welcome back " + username + "!");
      //			this.isLoggedIn = true;
      new Choice();
    } else {
      //			text.setText("   Welcome " + userName_text.getText() + " !"); // (3 spaces before Welcome)
      setVisible(false);
      System.out.println("Welcome back " + username_text.getText() + "!");
      //			this.isLoggedIn = true;
      new Choice();
    }
  }

  //	public static boolean isLoggedIn(boolean isLoggedIn) {
  //		if(this.isLoggedIn = true) {
  //			return isLoggedIn = true;
  //		}
  //		else {
  //			return isLoggedIn = false;
  //		}
  //		actionPerformed();
  //	}
}
