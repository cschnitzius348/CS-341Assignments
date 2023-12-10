package sept13_SalesList;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyMain {

	private static JFrame frame;
	private static JTextField itemField;
	private static JTextField costField;
	private static JTextField qtyField;
	private static JButton btn;
	private static JTextArea salesListArea;
	private static JTextField totalField;
	
	private static SalesList salesList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyMain window = new MyMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application
	 */
	public MyMain() {
		initialize();
		salesList = new SalesList();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Item:");
		lblNewLabel.setBounds(100, 50, 100, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cost:    $");
		lblNewLabel_1.setBounds(100, 86, 100, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantity: ");
		lblNewLabel_2.setBounds(100, 121, 100, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		itemField = new JTextField();
		itemField.setBounds(220, 47, 181, 19);
		frame.getContentPane().add(itemField);
		itemField.setColumns(10);
		
		costField = new JTextField();
		costField.setBounds(220, 83, 181, 19);
		frame.getContentPane().add(costField);
		costField.setColumns(10);
		
		qtyField = new JTextField();
		qtyField.setBounds(220, 118, 181, 19);
		frame.getContentPane().add(qtyField);
		qtyField.setColumns(10);
		
		btn = new JButton("Add Item to the Sales List");
		btn.setBounds(90, 180, 275, 29);
		frame.getContentPane().add(btn);
		
		salesListArea = new JTextArea();
		salesListArea.setBounds(82, 263, 291, 142);
		frame.getContentPane().add(salesListArea);
		
		JLabel lblNewLabel_4 = new JLabel("Total Sales:");
		lblNewLabel_4.setBounds(64, 425, 135, 16);
		frame.getContentPane().add(lblNewLabel_4);
		
		totalField = new JTextField();
		totalField.setBounds(155, 425, 130, 26);
		frame.getContentPane().add(totalField);
		totalField.setColumns(10);
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addItem();
			}
		});
	}
	
	public static void addItem() {
		//TASK 1: collect user input
		String itemName = itemField.getText();
		Double itemPrice = Double.parseDouble(costField.getText());
		Integer itemQty = Integer.parseInt(qtyField.getText());
		
		//TASK 2: add new SalesItem to SalesList
		salesList.addNewItem(new SalesItem(itemName, itemPrice, itemQty));
		
		//TASK 3: update SalesList output
		salesListArea.setText(salesList.getSalesList());
		Double totalAmount = salesList.computeTotal();
		totalField.setText(String.format("%.2f", totalAmount));
	}
}
