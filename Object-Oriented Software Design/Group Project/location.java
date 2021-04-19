package realty;

import javax.swing.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class location {

	public static void main(String[] args) {
		List<StateData> listOfStates = AccessibleStateDataAPI.findStateDataByID("1");
		if (!listOfStates.isEmpty()) {
			StateData state = listOfStates.get(0);
			JOptionPane.showMessageDialog(null,
					"Address: " + state.getStreetNum() + " " + state.getStreet() + ", City: " + state.getCity()
							+ ", State: " + state.getState() + ", Zipcode: " + state.getZipcode());
		} else {
			JOptionPane.showMessageDialog(null, "Not Found");
		}
	}
}

// This is a model class nothing important here just your typical getters and setters.
class StateData {
	private String id;
	private String street_num;
	private String street;
	private String city;
	private String state;
	private String zipcode;

	public StateData(String id, String street_num, String street, String city, String state, String zipcode) {
		this.id = id;
		this.street_num = street_num;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	// Getters
	public String getID() {
		return id;
	}

	public String getStreetNum() {
		return street_num;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZipcode() {
		return zipcode;
	}

	// Setters
	public void setID(String id) {
		this.id = id;
	}

	public void setStreetNum(String street_num) {
		this.street_num = street_num;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
}

// line 104 - 107 search through whatever parameters u want
class AccessibleStateDataAPI {
	public static ArrayList<StateData> STATE_DATA = new ArrayList<>();
	public static String STATE_DATA_FILE_PATH = "src\\realty\\file.csv";

	public static List<StateData> findStateDataByID(String id) {
		return AccessibleStateDataAPI.getStateData().stream()
				.filter(stateData -> stateData.getID().equalsIgnoreCase(id)).collect(Collectors.toList());
	}

	public static List<StateData> findStateDataByStreetNum(String street_num) {
		return AccessibleStateDataAPI.getStateData().stream()
				.filter(stateData -> stateData.getStreetNum().equalsIgnoreCase(street_num))
				.collect(Collectors.toList());
	}

	public static List<StateData> findStateDataByStreet(String street) {
		return AccessibleStateDataAPI.getStateData().stream()
				.filter(stateData -> stateData.getStreet().equalsIgnoreCase(street)).collect(Collectors.toList());
	}

	public static List<StateData> findStateDataByCity(String city) {
		return AccessibleStateDataAPI.getStateData().stream()
				.filter(stateData -> stateData.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
	}

	public static List<StateData> findStateDataByState(String state) {
		return AccessibleStateDataAPI.getStateData().stream()
				.filter(stateData -> stateData.getState().equalsIgnoreCase(state)).collect(Collectors.toList());
	}

	public static List<StateData> findStateDataByZipcode(String zipcode) {
		return AccessibleStateDataAPI.getStateData().stream()
				.filter(stateData -> stateData.getZipcode().equalsIgnoreCase(zipcode)).collect(Collectors.toList());
	}

	private static ArrayList<StateData> getStateData() {
		String id = " ";
		String street_num = " ";
		String street = " ";
		String city = " ";
		String state = " ";
		String zipcode = " ";
		ArrayList<StateData> list = new ArrayList<>();
		try {
			Scanner x = new Scanner(new File(AccessibleStateDataAPI.STATE_DATA_FILE_PATH));
			String nextLine;
			while (x.hasNextLine()) {
				nextLine = x.nextLine();
				if (nextLine == "") {
					break;
				}
				StringTokenizer tokenNextLine = new StringTokenizer(nextLine, ",");
				id = tokenNextLine.nextToken();
				street_num = tokenNextLine.nextToken();
				street = tokenNextLine.nextToken();
				city = tokenNextLine.nextToken();
				state = tokenNextLine.nextToken();
				zipcode = tokenNextLine.nextToken();

				list.add(new StateData(id, street_num, street, city, state, zipcode));
			}
			STATE_DATA = list;
		} catch (Exception e) {
			System.out.println("That's an error");
			e.printStackTrace();
		}

		return STATE_DATA;
	}

}
