package hw1_BigNumber;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class AdderApp {

	private JFrame frame;
	private JTextField txtX;
	private JTextField txtY;
	private JButton addBtn;
	private JTextArea outputArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdderApp window = new AdderApp();
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
	public AdderApp() {
		initialize();
		createEvents();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 815, 398);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel title = new JLabel("Enter ONLY positive integers");
		title.setFont(new Font("Tahoma", Font.BOLD, 16));
		title.setBounds(299, 24, 261, 40);
		frame.getContentPane().add(title);
		
		JLabel lblX = new JLabel("X");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblX.setBounds(60, 85, 45, 13);
		frame.getContentPane().add(lblX);
		
		JLabel lblY = new JLabel("Y");
		lblY.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblY.setBounds(60, 127, 45, 13);
		frame.getContentPane().add(lblY);
		
		txtX = new JTextField();
		txtX.setBounds(99, 83, 619, 19);
		frame.getContentPane().add(txtX);
		txtX.setColumns(10);
		
		txtY = new JTextField();
		txtY.setBounds(99, 125, 619, 19);
		frame.getContentPane().add(txtY);
		txtY.setColumns(10);
		
		addBtn = new JButton("ADD");
		addBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addBtn.setBounds(351, 203, 100, 21);
		frame.getContentPane().add(addBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(135, 251, 538, 52);
		frame.getContentPane().add(scrollPane);
		
		outputArea = new JTextArea();
		scrollPane.setViewportView(outputArea);
	}
	
	private void createEvents() {
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNums();
			}
		});
	}
	
	private void addNums() {
		outputArea.setText("");
		
		if (!numInput()) {
			outputArea.setText("input error");
		} else {
			/*
			BigNumber x = new BigNumber(txtX.getText());
			String y = txtY.getText();
			outputArea.setText("" + x.add(y));
			*/
			
			
			BigInteger x = new BigInteger(txtX.getText());
			BigInteger y = new BigInteger(txtY.getText());
			
			BigInteger z = x.add(y);
			outputArea.setText("" + z);
			
		}
		
	}
	
	private boolean numInput() {
		boolean inputsAreNum = true;
		
		for (int i = 0; i < txtX.getText().length(); i++) {
			if (!Character.isDigit(txtX.getText().charAt(i))) {
				inputsAreNum = false;
				break;
			}
		}
		for (int i = 0; i < txtY.getText().length(); i++) {
			if (!Character.isDigit(txtY.getText().charAt(i))) {
				inputsAreNum = false;
				break;
			}
		}
		
		return inputsAreNum;
	}
	
	
}
