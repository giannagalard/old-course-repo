package realty;

import java.util.List;

import javax.swing.JOptionPane;

public class Search {

  public Search() {
    System.out.println("What would you like to look for today?");

    List < StateData > listOfStates = AccessibleStateDataAPI.findStateDataByStreet("forest ave");
    StateData state = listOfStates.get(0);
    JOptionPanepackage realty;

    import java.awt.*;
    import java.awt.event.*;
    import javax.swing.*;

    import realty.Choice;

    public class SearchLocation extends JFrame {

      JPanel panel;
      JLabel location, text;
      JButton search;
      JTextField search_text;

      public SearchLocation() {
        location = new JLabel();
        location.setText("     Street Name:"); // please don't mess with the spacing ( its 5 spaces )
        search_text = new JTextField();
        search = new JButton("Search"); // text for submit button
        panel = new JPanel(new GridLayout(3, 1));
        panel.add(location); // User label
        panel.add(search_text); // user input
        text = new JLabel();
        panel.add(text); // blank box to put submit button under user input
        panel.add(search); // submit button

        setTitle("Search for houses");
        setSize(375, 150); // setting the size of the window
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel, BorderLayout.CENTER);
      }

      private class ClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
      }

      public static void main(String[] args) {
        new SearchLocation();
      }
    }
    .showMessageDialog(null,
      "Address: " + state.getStreetNum() + " " + state.getStreet() + ", City: " + state.getCity() +
      ", State: " + state.getState() + ", Zipcode: " + state.getZipcode());

  }

  public static void main(String[] args) {
    new Search();
  }
}
