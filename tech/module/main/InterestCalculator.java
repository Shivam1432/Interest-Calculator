package tech.module.main;
import tech.module.bean.*;
//import java.util.Scanner;

import javax.swing.*;
import java.awt.event.*;

public class InterestCalculator implements ActionListener{
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2,b3,b4;
	JLabel l1,l2,l3,l4,l5;
	InterestCalculator()
	{
		JFrame f = new JFrame();
		f.setBounds(100, 100, 667, 471);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setLayout(null);
		
		JButton b1 = new JButton("SB");
		b1.setBounds(470, 76, 85, 21);
		f.getContentPane().add(b1);
		
		JButton b2 = new JButton("FD");
		b2.setBounds(470, 159, 85, 21);
		f.getContentPane().add(b2);
		
		JButton b3 = new JButton("RD");
		b3.setBounds(470, 245, 85, 21);
		f.getContentPane().add(b3);
		
		JButton b4 = new JButton("Submit");
		b4.setBounds(47, 328, 85, 21);
		f.getContentPane().add(b4);
		
		t1 = new JTextField();
		t1.setBounds(47, 77, 288, 19);
		f.getContentPane().add(t1);
		t1.setColumns(10);
		
		JLabel l1 = new JLabel("Enter amount:");
		l1.setBounds(47, 43, 130, 13);
		f.getContentPane().add(l1);
		
		JLabel l2 = new JLabel("Enter age:");
		l2.setBounds(47, 126, 100, 13);
		f.getContentPane().add(l2);
		l2.setVisible(false);
		
		t2 = new JTextField();
		t2.setBounds(47, 160, 288, 19);
		f.getContentPane().add(t2);
		t2.setColumns(10);
		t2.setVisible(false);
		
		JLabel l3 = new JLabel("Enter number of days:");
		l3.setBounds(47, 212, 147, 13);
		f.getContentPane().add(l3);
		l3.setVisible(false);
		
		t3 = new JTextField();
		t3.setBounds(47, 246, 288, 19);
		f.getContentPane().add(t3);
		t3.setColumns(10);
		t3.setVisible(false);
		
		t5 = new JTextField();
		t5.setBounds(47, 246, 288, 19);
		f.getContentPane().add(t5);
		t5.setColumns(10);
		t5.setVisible(false);
		
		JLabel l4 = new JLabel("Enter number of Months:");
		l4.setBounds(47, 212, 230, 13);
		f.getContentPane().add(l4);
		l4.setVisible(false);
		
		t4 = new JTextField();
		t4.setBounds(239, 329, 316, 19);
		f.getContentPane().add(t4);
		t4.setColumns(10);
		
		JLabel l5 = new JLabel("Interest Gained:");
		l5.setBounds(239, 299, 96, 13);
		f.getContentPane().add(l5);
		f.setVisible(true);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				l2.setVisible(false);
				t2.setVisible(false);
				t3.setVisible(false);
				t5.setVisible(false);
				l4.setVisible(false);
				l3.setVisible(false);
					t1.setText("");
					t4.setText("");
					t2.setText("");
					t3.setText("");
					t5.setText("");
					b4.setActionCommand("sb");
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					l2.setVisible(true);
					t2.setVisible(true);
					l3.setVisible(true);
					t3.setVisible(true);
					t5.setVisible(false);
					l4.setVisible(false);
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					b4.setActionCommand("fd");
				
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					l2.setVisible(true);
					t2.setVisible(true);
					l4.setVisible(true);
					t3.setVisible(false);
					l3.setVisible(false);
					t5.setVisible(true);
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					b4.setActionCommand("rd");
				
			}
		});
		b4.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if("sb".equals(e.getActionCommand()))
		{
			SBAccount sbAccount = new SBAccount();
			String s1=t1.getText();
			if(s1==null)
			{
				JOptionPane.showMessageDialog(null, "Reenter Amount");
				t1.setText("");
			}
			else
			{
				double amt=Double.parseDouble(s1);
				sbAccount.setAmount(amt);
				double i=sbAccount.calculateInterest();
				String f="Interest gained: Rs. ";
				f+=String.valueOf(i);
				t4.setText(f);
			}
		}
		if("fd".equals(e.getActionCommand()))
		{
			FDAccount fdAccount = new FDAccount();
			String s1=t1.getText();
			String s2=t2.getText();
			int age=Integer.parseInt(s2);
			String s3=t3.getText();
			int noOfDays=Integer.parseInt(s3);
			if(s1==null)
			{
				JOptionPane.showMessageDialog(null, "Reenter Amount");
				t1.setText("");
				if( noOfDays<0)
				{
					JOptionPane.showMessageDialog(null, "Invalid Number of days. Please enter non - negative values.");
					t3.setText("");
					if(age<0)
					{
						JOptionPane.showMessageDialog(null, "Invalid age. Please enter non - negative values.");
						t2.setText("");
					}
				}
			}
			else
			{
				double amt=Double.parseDouble(s1);
				fdAccount.setAmount(amt);
				fdAccount.setAgeOfACHolder(age);
				fdAccount.setNoOfDays(noOfDays);
				double i=fdAccount.calculateInterest();
				String f="Interest gained: Rs. ";
				f+=String.valueOf(i);
				t4.setText(f);
			}
		}
		if("rd".equals(e.getActionCommand()))
		{
			RDAccount rdAccount = new RDAccount();
			String s1=t1.getText();
			String s2=t2.getText();
			int age=Integer.parseInt(s2);
			String s3=t5.getText();
			int noOfMonths=Integer.parseInt(s3);
			if(s1==null)
			{
				JOptionPane.showMessageDialog(null, "Reenter Amount");
				t1.setText("");
				if( noOfMonths<0)
				{
					JOptionPane.showMessageDialog(null, "Invalid Number of days. Please enter non - negative values.");
					t5.setText("");
					if(age<0)
					{
						JOptionPane.showMessageDialog(null, "Invalid age. Please enter non - negative values.");
						t2.setText("");
					}
				}
			}
			else
			{
				double amt=Double.parseDouble(s1);
				rdAccount.setAmount(amt);
				rdAccount.setNoOfMonth(noOfMonths);
				rdAccount.setAgeOfACHolder(age);
				double i=rdAccount.calculateInterest();
				String f="Interest gained: Rs. ";
				f+=String.valueOf(i);
				t4.setText(f);
			}
		}
	}
	public static void main(String[] args) {
		new InterestCalculator();
		/*Scanner sc = new Scanner(System.in);
		int choice = 0;
		
		do {
			System.out.print("\n1. Interest Calculator – SB: ");
			System.out.print("\n2. Interest Calculator – FD: ");
			System.out.print("\n3. Interest Calculator – RD: ");
			System.out.print("\n4. Exit");
			System.out.print("\nEnter your option (1..4): ");
			
			choice  = sc.hasNextInt() ? sc.nextInt() : 0;
			
			switch (choice) {
			case 1:
				SBAccount sbAccount = new SBAccount();
				System.out.print("\nEnter the Average amount in your account: ");
				sbAccount.setAmount(sc.nextDouble());
				System.out.println("Interest gained: Rs. " + sbAccount.calculateInterest());
				break;
				
			case 2:
				FDAccount fdAccount = new FDAccount();
				System.out.print("\nEnter the FD ammount: ");
				fdAccount.setAmount(sc.nextDouble());
				
				System.out.print("\nEnter number of days: ");
				int noOfDays = sc.nextInt();
				while (noOfDays < 0) {
					System.out.println("Invalid Number of days. Please enter non - negative values.");
					System.out.print("\nEnter number of days: ");
					noOfDays = sc.nextInt();
				}
				fdAccount.setNoOfDays(noOfDays);
				
				System.out.print("\nEnter your age: ");
				int age = sc.nextInt();
				while (age < 0) {
					System.out.println("Invalid age. Please enter non - negative values.");
					System.out.print("\nEnter your age: ");
					age = sc.nextInt();
				}
				fdAccount.setAgeOfACHolder(age);
				
				System.out.println("Interest gained: Rs. " + fdAccount.calculateInterest());
				break;
				
			case 3:
				RDAccount rdAccount = new RDAccount();
				System.out.print("\nEnter the RD ammount: ");
				rdAccount.setAmount(sc.nextDouble());
				
				System.out.print("\nEnter number of months: ");
				int noOfMonths = sc.nextInt();
				while (noOfMonths < 0) {
					System.out.println("Invalid Number of months. Please enter non - negative values.");
					System.out.print("\nEnter number of months: ");
					noOfMonths = sc.nextInt();
				}
				rdAccount.setNoOfMonth(noOfMonths);
				
				System.out.print("\nEnter your age: ");
				age = sc.nextInt();
				while (age < 0) {
					System.out.println("Invalid age. Please enter non - negative values.");
					System.out.print("\nEnter your age: ");
					age = sc.nextInt();
				}
				rdAccount.setAgeOfACHolder(age);
				
				System.out.println("Interest gained: Rs. " + rdAccount.calculateInterest());
				break;
				
			case 4:
				System.out.println("Thanks for using Interest Calculator.");
				break;
				
			default:
				break;
			}
				
		} while (choice != 4);
		
		sc.close();*/
	}
	
}
