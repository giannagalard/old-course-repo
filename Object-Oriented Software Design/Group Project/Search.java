package realty;

import java.util.List;

import javax.swing.JOptionPane;

public class Search {
	
	public Search() {
		System.out.println("What would you like to look for today?");
		
		List<StateData> listOfStates = AccessibleStateDataAPI.findStateDataByAddress("forest ave");
		StateData state = listOfStates.get(0);
		JOptionPane.showMessageDialog(null,
				"Address: " + state.getAddress() + " " + state.getAddress() + ", City: " + state.getCity()
						+ ", State: " + state.getState() + ", Zipcode: " + state.getZipcode());
		
	}

	public static void main(String[] args) {
		new Search();
	}
}
