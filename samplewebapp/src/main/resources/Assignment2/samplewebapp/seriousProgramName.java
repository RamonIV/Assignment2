package samplewebapp;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;

public class seriousProgramName {

	private JFrame frame;
	DBConnect dbConnection = new DBConnect();
	Street[] Streetz = dbConnection.returnStreetNames();
	DateFormat df = new SimpleDateFormat("HH:mm:ss");
	Date dateobj;
	Date timeBooked;
	int timesRebooked = 0;
	float totalCost = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					seriousProgramName window = new seriousProgramName();
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
	public seriousProgramName() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 515);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JComboBox StreetNamesComboBox = new JComboBox();
		StreetNamesComboBox.setBounds(62, 53, 289, 37);
		for (int i = 0; i < Streetz.length; i++)
		{
			StreetNamesComboBox.addItem(Streetz[i].getName());
		}	
		frame.getContentPane().add(StreetNamesComboBox);
			
		JTextPane txtpnStreetName = new JTextPane();
		txtpnStreetName.setText("StReEt NaMe");
		txtpnStreetName.setBounds(62, 23, 223, 20);
		frame.getContentPane().add(txtpnStreetName);
		
		JTextPane txtpnParksThree = new JTextPane();
		txtpnParksThree.setEditable(false);
		txtpnParksThree.setText("Parks Three");
		txtpnParksThree.setBounds(72, 114, 107, 20);
		frame.getContentPane().add(txtpnParksThree);
		
		JTextPane txtpnCost = new JTextPane();
		txtpnCost.setEditable(false);
		txtpnCost.setText("Cost Per Hour");
		txtpnCost.setBounds(62, 149, 79, 20);
		frame.getContentPane().add(txtpnCost);
		
		final JButton btnBook = new JButton("BOOK NAO =^_^=");
		
		btnBook.setBounds(62, 287, 304, 23);
		frame.getContentPane().add(btnBook);
		
		final JLabel freeParksText = new JLabel("aaaaa");
		freeParksText.setBounds(188, 114, 46, 14);
		frame.getContentPane().add(freeParksText);
		
		final JLabel ParkCost = new JLabel("$2.00");
		ParkCost.setBounds(188, 155, 46, 14);
		frame.getContentPane().add(ParkCost);
		
		freeParksText.setText(Integer.toString((Streetz[findStreetID((String)StreetNamesComboBox.getSelectedItem())].getAmountOfParks())));
		ParkCost.setText("$" + Float.toString((Streetz[findStreetID((String)StreetNamesComboBox.getSelectedItem())].getCost())));
		
		final JButton btnCheckOut = new JButton("Check Out");
		btnCheckOut.setEnabled(false);
		btnCheckOut.setBounds(62, 321, 304, 23);
		frame.getContentPane().add(btnCheckOut);
		
		final JButton btnRebook = new JButton("Rebook");
		btnRebook.setEnabled(false);
		btnRebook.setBounds(62, 355, 304, 23);
		frame.getContentPane().add(btnRebook);
		
		final JLabel lblTimeBooked = new JLabel("Time Booked");
		lblTimeBooked.setEnabled(false);
		lblTimeBooked.setBounds(62, 203, 93, 14);
		frame.getContentPane().add(lblTimeBooked);
		
		final JLabel TimeParkBooked = new JLabel(" ");
		TimeParkBooked.setBounds(188, 200, 223, 20);
		frame.getContentPane().add(TimeParkBooked);
		
		JLabel lblTotalCost = new JLabel("Total Cost:");
		lblTotalCost.setEnabled(false);
		lblTotalCost.setBounds(67, 405, 74, 14);
		frame.getContentPane().add(lblTotalCost);
		
		final JLabel Cost = new JLabel("");
		Cost.setBounds(188, 405, 46, 14);
		frame.getContentPane().add(Cost);
		
		final JButton btnPayNow = new JButton("Pay Now");
		btnPayNow.setEnabled(false);
		btnPayNow.setBounds(62, 430, 304, 23);
		frame.getContentPane().add(btnPayNow);
		
		JLabel lblTimesRebooked = new JLabel("Times Rebooked:");
		lblTimesRebooked.setEnabled(false);
		lblTimesRebooked.setBounds(62, 389, 93, 14);
		frame.getContentPane().add(lblTimesRebooked);
		
		final JLabel AmountRebooked = new JLabel("0");
		AmountRebooked.setBounds(200, 389, 46, 14);
		frame.getContentPane().add(AmountRebooked);
		
		StreetNamesComboBox.addActionListener(new ActionListener() 
		{ 
				public void actionPerformed(ActionEvent e) 
				{
				
					freeParksText.setText(Integer.toString((Streetz[findStreetID((String)StreetNamesComboBox.getSelectedItem())].getAmountOfParks())));
					ParkCost.setText("$" + Float.toString((Streetz[findStreetID((String)StreetNamesComboBox.getSelectedItem())].getCost())));
				}
		}
		);
		
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dbUrl = "jdbc:mysql://localhost:3306/assignment2data";
				String user = "root";
				String password = "1234";
				dateobj = new Date();
				
				
				try 
				{
					Connection myConn = DriverManager.getConnection(dbUrl, user, password);
					
					String query = "update parkinginfo set NumberOfParks = ? where StreetID = ?"; 
					PreparedStatement preparedStmt = myConn.prepareStatement(query);
				    preparedStmt.setInt   (1, (((Streetz[findStreetID((String)StreetNamesComboBox.getSelectedItem())].getAmountOfParks())) - 1) );
					
				    preparedStmt.setInt(2, (Streetz[findStreetID((String)StreetNamesComboBox.getSelectedItem())].getId()));
				    preparedStmt.executeUpdate();
				    myConn.close();
				    preparedStmt.close();
				    
				    btnBook.setEnabled(false);
				    btnCheckOut.setEnabled(true);
				    btnRebook.setEnabled(true);
				    lblTimeBooked.setEnabled(true);
				    TimeParkBooked.setText(df.format(dateobj));
				    
				    freeParksText.setText(Integer.toString((Streetz[findStreetID((String)StreetNamesComboBox.getSelectedItem())].getAmountOfParks())));
					
					
				} catch (SQLException e1) {
					
				}
				
				
				
			}
		});
		
		btnRebook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				timesRebooked++;
				AmountRebooked.setText(Integer.toString(timesRebooked));
			}
			
		});
		
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Date timeRnFam = new Date();
				float totalTimeCost = (timeRnFam.getTime() - dateobj.getTime()) / 360000;
				
				if( totalTimeCost < 1)
					totalCost = (float) ((Streetz[findStreetID((String)StreetNamesComboBox.getSelectedItem())].getCost()) + (timesRebooked * 3.50));
				else
					totalCost = (float) (((Streetz[findStreetID((String)StreetNamesComboBox.getSelectedItem())].getCost()) * 2) + (timesRebooked * 3.50));
				
				//totalCost = (float) (((timeRnFam.getTime() - dateobj.getTime()) / 360000) + (timesRebooked * 3.50));
			
				btnPayNow.setEnabled(true);
				Cost.setText(Float.toString(totalCost));
			}
			
		});
		
		btnPayNow.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				String dbUrl = "jdbc:mysql://localhost:3306/assignment2data";
				String user = "root";
				String password = "1234";
				dateobj = new Date();
				
				
				try 
				{
					Connection myConn = DriverManager.getConnection(dbUrl, user, password);
					
					String query = "update parkinginfo set NumberOfParks = ? where StreetID = ?"; 
					PreparedStatement preparedStmt = myConn.prepareStatement(query);
				    preparedStmt.setInt   (1, (((Streetz[findStreetID((String)StreetNamesComboBox.getSelectedItem())].getAmountOfParks())) + 1) );
					
				    preparedStmt.setInt(2, (Streetz[findStreetID((String)StreetNamesComboBox.getSelectedItem())].getId()));
				    preparedStmt.executeUpdate();
				    myConn.close();
				    preparedStmt.close();
				    
				    btnBook.setEnabled(true);
				    btnCheckOut.setEnabled(false);
				    btnRebook.setEnabled(false);
				    lblTimeBooked.setEnabled(false);
				    btnPayNow.setEnabled(false);
				    TimeParkBooked.setText();
				    Cost.setText(Float.toString());
				    timesRebooked = 0;
				    AmountRebooked.setText(Integer.toString(timesRebooked));
				    
				    freeParksText.setText(Integer.toString((Streetz[findStreetID((String)StreetNamesComboBox.getSelectedItem())].getAmountOfParks())));
					
					
				} catch (SQLException e1) {
					
				}
				
			}
		}
		
		}
	
	private int findStreetID(String StreetName)
	{
		Streetz = dbConnection.returnStreetNames();
		for (int i = 0; i < Streetz.length; i++)
		{
			if( Streetz[i].getName().equals(StreetName))
			{

				return i;
			}
		}
		
		System.out.println("Name not found");
		return 0;	
	}
	



}
