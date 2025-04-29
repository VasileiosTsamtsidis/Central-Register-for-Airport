import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FindAirport extends JFrame{

	private JPanel panel;
	private JTextField text;
	private JTextArea availableAirports;
	private JButton button, button2;
	private Airport airport;
	
	
	private ArrayList<Airport> airports;
	
	public FindAirport() {
		panel = new JPanel();
		text = new JTextField("Please enter the name of the city");
		button = new JButton("Find");
		availableAirports = new JTextArea();
		
		panel.add(text);
		panel.add(button);
		ButtonListener listener=new ButtonListener();
		button.addActionListener(listener);
		this.setContentPane(panel);
		
		this.setVisible(true);
		this.setTitle("Find Airport");
		this.setSize(400, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	class ButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			boolean flag=false;
			
			String cityFind = text.getText();
			Airport a = null;
			a = CentralRegistry.getAirport(cityFind);
			
			if(e.getSource().equals(button)) {

					if(a!=null) {
						flag = true;
					}
				
					if(flag == false){
						
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame,  cityFind +" does not have an airport");
						
					}
					else {
						dispose();
						new AirportPage(a);
					}
			}
			
				
			}
			
		}

	
	
	
	
	}
