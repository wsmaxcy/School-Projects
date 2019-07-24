import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

import javax.swing.*;

public class DentalPayment extends JFrame
{
	private JPanel panel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel panel6;
	private JPanel panel7;
	private JPanel panel8;
	private JPanel panel9;
	private JPanel panel10;
	private JPanel panel11;
	private JPanel panel12;
	private JPanel panel13;
	private JPanel panel14;
	private JPanel panel15;
	private JPanel panel16;
	private JPanel panel17;
	private JPanel panel18;
	private JPanel panel19;
	private JPanel panel20;

	private ButtonGroup group;
	private JRadioButton radio1;
	private JRadioButton radio2;
	private JRadioButton radio3;
	private JLabel messageLabel;
	private JTextField patientName;
	private JButton calcButton;
	private JButton saveButton;
	private JButton exitButton;
	private JLabel top;
	private JLabel total;
	private JLabel payment;
	private JCheckBox check1;
	private JCheckBox check2;
	private JCheckBox check3;
	private JLabel n35;
	private JLabel n150;
	private JLabel n85;
	private JLabel labelTotal;
	private String insurance;
	private String patient;
	private String strGrandTotal;
	private int grandTotal = 0;
	ArrayList<String> list;
	private FileInputStream inputfile;
	private ObjectInputStream objectInputFile;
	private FileOutputStream outputfile;
	private ObjectOutputStream objectOutputFile;
	
	
	public DentalPayment() throws IOException
	{
		setTitle("Dental Payment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(265,370);
		buildPanel();
		add(panel);
		setResizable(false);
		setVisible(true);
		//inputfile = new FileInputStream("info.dat");
		//objectInputFile = new ObjectInputStream (inputfile);
		
	}

	private void buildPanel()
	{
		check1 = new JCheckBox("Cleaning");
		check2= new JCheckBox("Cavity Filling");
		check3 = new JCheckBox("X-Ray");
		group = new ButtonGroup();
		radio1 = new JRadioButton("Insurance", true);
		radio2 = new JRadioButton("Medicare");
		radio3 = new JRadioButton("None");
		group.add(radio1);
		group.add(radio2);
		group.add(radio3);
		n35 = new JLabel("$35");
		n150 = new JLabel("$150");
		n85 = new JLabel("$85");
		top = new JLabel ("Dental Payment Form");
		top.setFont(new Font("Serif",Font.PLAIN, 22));
		total = new JLabel("Total: ");
		payment = new JLabel("Insurance Type:");
		messageLabel = new JLabel("Patient Name:");
		patientName = new JTextField(10);
		calcButton = new JButton("Calculate");
		saveButton = new JButton("Save");
		exitButton = new JButton("Exit");
		labelTotal = new JLabel("$"+String.valueOf(grandTotal));
		calcButton.addActionListener(new buttonListener());
		exitButton.addActionListener(new buttonListener());
		saveButton.addActionListener(new buttonListener());
		
		panel = new JPanel(new BorderLayout());
		panel1 = new JPanel(new FlowLayout());
		panel2 = new JPanel(new GridLayout(8,1));
		panel3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel4 = new JPanel(new GridLayout(8,1));
		panel5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel6 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel7 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel8 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel9 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel10 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel11 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel12 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel13 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel14 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel15 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel16 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel17 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel18 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel19 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel20 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		
		panel.add(panel1, BorderLayout.NORTH);
		panel.add(panel2, BorderLayout.EAST);
		panel.add(panel3, BorderLayout.SOUTH);
		panel.add(panel4, BorderLayout.WEST);
		panel.add(panel5, BorderLayout.CENTER);
		
		panel1.add(top);
		panel2.add(panel5);
		panel2.add(panel6);
		panel2.add(panel7);
		panel2.add(panel8);
		panel2.add(panel10);
		panel2.add(panel18);
		panel2.add(panel19);
		panel2.add(panel9);
		panel4.add(panel11);
		panel4.add(panel12);
		panel4.add(panel13);
		panel4.add(panel14);
		panel4.add(panel20);
		panel4.add(panel15);
		panel4.add(panel16);
		panel4.add(panel17);
		panel5.add(patientName);
		panel6.add(n35);
		panel7.add(n150);
		panel8.add(n85);
		panel9.add(total);
		panel3.add(calcButton);
		panel9.add(labelTotal);
		panel11.add(messageLabel);
		panel12.add(check1);
		panel13.add(check2);
		panel14.add(check3);
		panel15.add(radio1);
		panel16.add(radio2);
		panel17.add(radio3);
		panel3.add(saveButton);
		panel3.add(exitButton);
		panel20.add(payment);
		
		
		
	}
	private class buttonListener implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == calcButton)
			{
			grandTotal = grandTotal*0;
				if (check1.isSelected())
				{
					grandTotal += 35;
				}
				if (check2.isSelected())
				{
					grandTotal +=150;
				}
				if (check3.isSelected())
				{
					grandTotal += 85;
				}
	
				labelTotal.setText("$"+String.valueOf(grandTotal));
				
			}
			
			if (e.getSource() == exitButton)
			{
				
				ArrayList<String> list = new ArrayList<String>();
				try {
					inputfile = new FileInputStream("info.dat");
				} catch (FileNotFoundException e3) {
					e3.printStackTrace();
				}
				try {
					objectInputFile = new ObjectInputStream(inputfile);
				} catch (IOException e3) {
					e3.printStackTrace();
				}
				int count = 0;
				
				try
				{
					while(true)
					{
						list.add(count, (String) objectInputFile.readObject());
						++count;
					}
					
				}
				catch (FileNotFoundException e2)
				{
					System.out.println("File was not found.");
				}
				catch (ClassNotFoundException e2)
				{
					System.out.println("attempt to read an object of a type not defined");
				}
				catch (EOFException e2)
				{
					try {
						objectInputFile.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "Dental Receipt:\n\nName: "+list.get(0)+""
						+"\n\nExpenses:\n"+list.get(2)+""+list.get(3)+"\n"+list.get(4)+""+list.get(5)+"\n"
						+list.get(6)+""+list.get(7)+"\n\nInsurance"+list.get(8)+"\n\nGrand Total: $"+list.get(1)+"");
				
				dispose();
			}
			
			if (e.getSource() == saveButton)
			{
				list = new ArrayList<String>();
				patient = patientName.getText();
				list.add(patient);
				
				strGrandTotal = String.valueOf(grandTotal);
				list.add(strGrandTotal);
				
				if(check1.isSelected())
				{
					list.add("-   Cleaning");
					list.add(":   $35");
				}
				else
				{
					list.add("");
					list.add("");
				}
				if(check2.isSelected())
				{
					list.add("-   Cavity Filling");
					list.add(":   $150");
				}
				else
				{
					list.add("");
					list.add("");
				}
				if(check3.isSelected())
				{
					list.add("-   X-Ray");
					list.add(":   $85");
				}
				else
				{
					list.add("");
					list.add("");
				}
				
				if(radio1.isSelected())
				{
					insurance = ":   Insurance";
				}
				if(radio2.isSelected())
				{
					insurance = ":   Medicare";
				}
				if(radio3.isSelected())
				{
					insurance = ":   None";
				}
				list.add(insurance);
				
				try {
					outputfile = new FileOutputStream("info.dat");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				try {
					objectOutputFile = new ObjectOutputStream(outputfile);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				for (int i = 0; i < list.size(); i++)
				{
					try {
						objectOutputFile.writeObject(list.get(i));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				try {
					objectOutputFile.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		}
	}

}
