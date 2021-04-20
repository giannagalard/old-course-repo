package realty;

import javax.swing.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Location {

  public static void main(String[] args) {
    //		List<StateData> listOfStates = AccessibleStateDataAPI.findStateDataByID("1");
    List < StateData > listOfStates = AccessibleStateDataAPI.findStateDataByZipcode("10314");
    if (!listOfStates.isEmpty()) {
      StateData state = listOfStates.get(0);
      JOptionPane.showMessageDialog(null,
        "Address: " + state.getStreetNum() + " " + state.getStreet() + ", City: " + state.getCity() +
        ", State: " + state.getState() + ", Zipcode: " + state.getZipcode() + ", Money Value: " + state.getMoneyValue());
    } else {
      JOptionPane.showMessageDialog(null, "Not Found");
    }
  }
}

// This is a model class nothing important here just your typical getters and setters.
class StateData {
  private String id;
  private String streetNum;
  private String street;
  private String city;
  private String state;
  private String zipcode;
  private String moneyValue;
  private String rentValue;
  private String acres;
  private String school;

  public StateData(String id, String streetNum, String street, String city, String state, String zipcode, String moneyValue, String rentValue, String acres, String school) {
    this.id = id;
    this.streetNum = streetNum;
    this.street = street;
    this.city = city;
    this.state = state;
    this.zipcode = zipcode;
    this.moneyValue = moneyValue;
    this.rentValue = rentValue;
    this.acres = acres;
    this.school = school;
  }

  // Getters
  public String getID() {
    return id;
  }

  public String getStreetNum() {
    return streetNum;
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

  public String getMoneyValue() {
    return moneyValue;
  }

  public String getRentValue() {
    return rentValue;
  }

  public String getAcres() {
    return acres;
  }

  public String getSchool() {
    return school;
  }

  // Setters
  public void setID(String id) {
    this.id = id;
  }

  public void setStreetNum(String street_num) {
    this.streetNum = street_num;
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

  public void setMoneyValue(String moneyValue) {
    this.moneyValue = moneyValue;
  }

  public void setRentValue(String rentValue) {
    this.rentValue = rentValue;
  }

  public void setAcres(String acres) {
    this.acres = acres;
  }

  public void setSchool(String school) {
    this.school = school;
  }
}
// line 104 - 107 search through whatever parameters u want
class AccessibleStateDataAPI {
  public static ArrayList < StateData > STATE_DATA = new ArrayList < > ();
  public static String STATE_DATA_FILE_PATH = "src\\realty\\file.csv";

  public static List < StateData > findStateDataByID(String id) {
    return AccessibleStateDataAPI.getStateData().stream()
      .filter(stateData -> stateData.getID().equalsIgnoreCase(id)).collect(Collectors.toList());
  }

  public static List < StateData > findStateDataByStreetNum(String streetNum) {
    return AccessibleStateDataAPI.getStateData().stream()
      .filter(stateData -> stateData.getStreetNum().equalsIgnoreCase(streetNum))
      .collect(Collectors.toList());
  }

  public static List < StateData > findStateDataByStreet(String street) {
    return AccessibleStateDataAPI.getStateData().stream()
      .filter(stateData -> stateData.getStreet().equalsIgnoreCase(street)).collect(Collectors.toList());
  }

  public static List < StateData > findStateDataByCity(String city) {
    return AccessibleStateDataAPI.getStateData().stream()
      .filter(stateData -> stateData.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
  }

  public static List < StateData > findStateDataByState(String state) {
    return AccessibleStateDataAPI.getStateData().stream()
      .filter(stateData -> stateData.getState().equalsIgnoreCase(state)).collect(Collectors.toList());
  }

  public static List < StateData > findStateDataByZipcode(String zipcode) {
    return AccessibleStateDataAPI.getStateData().stream()
      .filter(stateData -> stateData.getZipcode().equalsIgnoreCase(zipcode)).collect(Collectors.toList());
  }

  public static List < StateData > findStateDataByMoneyValue(String moneyValue) {
    return AccessibleStateDataAPI.getStateData().stream()
      .filter(stateData -> stateData.getMoneyValue().equalsIgnoreCase(moneyValue)).collect(Collectors.toList());
  }

  public static List < StateData > findStateDataByRentValue(String rentValue) {
    return AccessibleStateDataAPI.getStateData().stream()
      .filter(stateData -> stateData.getRentValue().equalsIgnoreCase(rentValue)).collect(Collectors.toList());
  }

  public static List < StateData > findStateDataByAcres(String acres) {
    return AccessibleStateDataAPI.getStateData().stream()
      .filter(stateData -> stateData.getAcres().equalsIgnoreCase(acres)).collect(Collectors.toList());
  }

  public static List < StateData > findStateDataBySchool(String school) {
    return AccessibleStateDataAPI.getStateData().stream()
      .filter(stateData -> stateData.getSchool().equalsIgnoreCase(school)).collect(Collectors.toList());
  }

  private static ArrayList < StateData > getStateData() {
    String id = " ";
    String streetNum = " ";
    String street = " ";
    String city = " ";
    String state = " ";
    String zipcode = " ";
    String moneyValue = " ";
    String rentValue = " ";
    String acres = " ";
    String school = " ";

    ArrayList < StateData > list = new ArrayList < > ();
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
        streetNum = tokenNextLine.nextToken();
        street = tokenNextLine.nextToken();
        city = tokenNextLine.nextToken();
        state = tokenNextLine.nextToken();
        zipcode = tokenNextLine.nextToken();
        moneyValue = tokenNextLine.nextToken();
        rentValue = tokenNextLine.nextToken();
        acres = tokenNextLine.nextToken();
        school = tokenNextLine.nextToken();

        list.add(new StateData(id, streetNum, street, city, state, zipcode, moneyValue, rentValue, acres, school));
      }
      STATE_DATA = list;
    } catch (Exception e) {
      System.out.println("That's an error");
      e.printStackTrace();
    }

    return STATE_DATA;
  }

}
