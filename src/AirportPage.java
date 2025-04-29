import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class AirportPage extends JFrame{

	private JPanel finalPanel, panel1, panel2, panel3, panel4;
	private JTextField airportName, code, cityName, country, anotherCity;
	private JButton findFlightsButton, backToScreenButton;
	private JTextArea companyNamesList, directFlights, inDirectFlights;
	private Airport airport;
	public AirportPage(Airport anAirport) {
		
		airport = anAirport;
		finalPanel = new JPanel();
		
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		
		airportName = new JTextField(10);
		code = new JTextField(10);
		cityName = new JTextField(10);
		country = new JTextField(10);
		
		companyNamesList = new JTextArea(3,10);
		directFlights = new JTextArea();
		inDirectFlights = new JTextArea();		
		
		anotherCity = new JTextField(10);
		findFlightsButton = new JButton("Find Flights");
		backToScreenButton = new JButton("Back to Search Screen");
		
		ArrayList<String> companyName=anAirport.getCompanyName();
		for(String companyNames: companyName)
		{
			companyNamesList.append(companyNames+"\n");
		}
		companyNamesList.setEditable(false);
		
		airportName.setText(anAirport.getName());
		code.setText(anAirport.getCode());
		code.setText(anAirport.getCode());
		cityName.setText(anAirport.getCityName());
		country.setText(anAirport.getCountry());
		
		directFlights.setEditable(false);
		inDirectFlights.setEditable(false);
		directFlights.append("DIRECT FLIGHTS DETAILS");
		inDirectFlights.append("INDIRECT FLIGHTS through");

		panel1.add(airportName);
		panel1.add(code);
		panel1.add(cityName);
		panel1.add(country);
		panel1.add(companyNamesList);
		
		panel2.add(anotherCity);
		panel2.add(findFlightsButton);
		
		panel3.add(directFlights);
		panel4.add(inDirectFlights);
		
		finalPanel.add(panel1);
		finalPanel.add(panel2);
		finalPanel.add(panel3);
		finalPanel.add(panel4);
		finalPanel.add(backToScreenButton);
		
		ButtonListener listener = new ButtonListener();
		findFlightsButton.addActionListener(listener);
		
		ButtonListener2 listener2 = new ButtonListener2();
		backToScreenButton.addActionListener(listener2);
		
		this.setContentPane(finalPanel);
		this.setVisible(true);
		this.setTitle("Airport Page");
		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			boolean flag=false;
			boolean flag2=false;
			
			String cityFind = anotherCity.getText();
			Airport b = null;
			b = CentralRegistry.getAirport(cityFind);
			
			if(e.getSource().equals(findFlightsButton)) {
				if(b==airport) {
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame,  "You gave me the same airport twice");
					flag2 = true;
				}
				if(b!=null) {
					flag = true;
				}
				
				if(flag == false){	
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame,  cityFind +" does not have an airport");
				}
				else if(flag  && !flag2){
					directFlights.append(CentralRegistry.getDirectFlightsDetails(airport, b));
					inDirectFlights.append(CentralRegistry.getInDirectFlightsDetails(airport, b));
				}
			}
		}
	
	}
	
	class ButtonListener2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(backToScreenButton)) {
				dispose();
				new FindAirport();
			}
			
		}
	}

}


