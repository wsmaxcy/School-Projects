import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JLabel messageLabel;
	private JTextField patientName;
	private JButton calcButton;		
	private JLabel top;
	private JLabel total;
	private JCheckBox check1;
	private JCheckBox check2;
	private JCheckBox check3;
	private JLabel n35;
	private JLabel n150;
	private JLabel n85;
	private JLabel labelTotal;
	private int grandTotal = 0;

	
	
	public DentalPayment()
	{
		setTitle("Dental Payment");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(265,370);
		buildPanel();
		add(panel);
		setResizable(true);
		setVisible(true);
		
	}

	private void buildPanel()
	{
		check1 = new JCheckBox("Cleaning");
		check2= new JCheckBox("Cavity Filling");
		check3 = new JCheckBox("X-Ray");
		n35 = new JLabel("$35");
		n150 = new JLabel("$150");
		n85 = new JLabel("$85");
		top = new JLabel ("Dental Payment Form");
		top.setFont(new Font("Serif",Font.PLAIN, 22));
		total = new JLabel("Total: ");
		messageLabel = new JLabel("Patient Name:");
		patientName = new JTextField(10);
		calcButton = new JButton("Calculate");
		labelTotal = new JLabel("$"+String.valueOf(grandTotal));
		calcButton.addActionListener(new CheckBoxListener());
		
		
		panel = new JPanel(new BorderLayout());
		panel1 = new JPanel(new FlowLayout());
		panel2 = new JPanel(new GridLayout(6,0));
		panel3 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel4 = new JPanel(new GridLayout(6,0));
		panel5 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel6 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel7 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel8 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel9 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panel10 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panel11 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel12 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel13 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel14 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		
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
		panel2.add(panel9);
		panel2.add(panel10);
		panel4.add(panel11);
		panel4.add(panel12);
		panel4.add(panel13);
		panel4.add(panel14);
		panel5.add(patientName);
		panel6.add(n35);
		panel7.add(n150);
		panel8.add(n85);
		panel9.add(total);
		panel10.add(calcButton);
		panel9.add(labelTotal);
		panel11.add(messageLabel);
		panel12.add(check1);
		panel13.add(check2);
		panel14.add(check3);
		
	}
	private class CheckBoxListener implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
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
	}
}
