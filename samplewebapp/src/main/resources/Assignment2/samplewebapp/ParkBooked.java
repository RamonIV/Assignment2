package samplewebapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;

public class ParkBooked {

	private JFrame frame;
	static String StreetName;
	static String TimeBooked;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParkBooked window = new ParkBooked(StreetName, TimeBooked);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ParkBooked(String name, String timeBooked) {
		StreetName = name;
		TimeBooked = timeBooked;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCurrentlyBooked = new JLabel("Currently Booked:");
		lblCurrentlyBooked.setBounds(10, 25, 434, 14);
		frame.getContentPane().add(lblCurrentlyBooked);
		
		JLabel StreetName = new JLabel(this.StreetName);
		StreetName.setBounds(10, 50, 289, 14);
		frame.getContentPane().add(StreetName);
		
		JLabel lblTimeParked = new JLabel("Time Parked:");
		lblTimeParked.setBounds(10, 90, 108, 14);
		frame.getContentPane().add(lblTimeParked);
		
		JLabel labelTimeBooked = new JLabel(TimeBooked);
		labelTimeBooked.setBounds(10, 120, 155, 14);
		frame.getContentPane().add(labelTimeBooked);
		
		JButton btnRebook = new JButton("Rebook");
		btnRebook.setBounds(10, 186, 170, 39);
		frame.getContentPane().add(btnRebook);
		
		JButton btnCheckOut = new JButton("Check Out");
		btnCheckOut.setBounds(190, 186, 170, 39);
		frame.getContentPane().add(btnCheckOut);
	}
}
