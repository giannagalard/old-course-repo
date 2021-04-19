package realty;

import javax.swing.*;

import realty.AgentData.AccessAgentData;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class agentfinder {

	public static void main(String[] args) {
		List<AgentData> listofAgents = AccessAgentData.findAgentDataByID("1");
		if (!listofAgents.isEmpty()) {
			AgentData FirstName = listofAgents.get(0);
			JOptionPane.showMessageDialog(null, "ID: " + FirstName.getID() + "First Name: " + FirstName.getFirstName()
					+ "Second Name: " + FirstName.getSecondName());
		} else {
			JOptionPane.showMessageDialog(null, "Not Found");
		}
	}

}

// getters and setters
class AgentData {
	private String id;
	private String FirstName;
	private String SecondName;

	public AgentData(String id, String FirstName, String SecondName) {
		this.id = id;
		this.FirstName = FirstName;
		this.SecondName = SecondName;
	}

	// Getters
	public String getID() {
		return id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public String getSecondName() {
		return SecondName;
	}

	// Setters
	public void setID(String id) {
		this.id = id;
	}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	public void setSecondName(String SecondName) {
		this.SecondName = SecondName;
	}

	static class AccessAgentData {
		public static ArrayList<realty.AgentData> AgentData = new ArrayList<>();
		public static String AGENT_DATA_FILE_PATH = "src\\realty\\agent.csv";

		public static List<AgentData> findAgentDataByID(String id) {
			return AccessAgentData.getAgentData().stream().filter(AgentData -> AgentData.getID().equalsIgnoreCase(id))
					.collect(Collectors.toList());
		}

		public static List<AgentData> findAgentDataByFirstName(String FirstName) {
			return AccessAgentData.getAgentData().stream()
					.filter(AgentData -> AgentData.getFirstName().equalsIgnoreCase(FirstName))
					.collect(Collectors.toList());
		}

		public static List<AgentData> findAgentDataBySecondName(String SecondName) {
			return AccessAgentData.getAgentData().stream()
					.filter(AgentData -> AgentData.getSecondName().equalsIgnoreCase(SecondName))
					.collect(Collectors.toList());
		}

		private static ArrayList<AgentData> getAgentData() {
			String ID = " ";
			String FirstName = " ";
			String SecondName = " ";
			ArrayList<AgentData> list = new ArrayList<>();
			try {
				Scanner x = new Scanner(new File(AccessAgentData.AGENT_DATA_FILE_PATH));
				String nextLine;
				while (x.hasNextLine()) {
					nextLine = x.nextLine();
					if (nextLine == " ") {
						break;
					}

					StringTokenizer tokenNextLine = new StringTokenizer(nextLine, ",");
					ID = tokenNextLine.nextToken();
					FirstName = tokenNextLine.nextToken();
					SecondName = tokenNextLine.nextToken();

					list.add(new AgentData(ID, FirstName, SecondName));
				}
				AgentData = list;
			} catch (Exception e) {
				System.out.println("Thats an error");
				e.printStackTrace();
			}

			return AgentData;
		}

	}
}
