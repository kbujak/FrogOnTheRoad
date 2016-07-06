package pl.edu.pk.frogOnTheRoad;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class myMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myMenu window = new myMenu();
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
	public myMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();

//		frame.getContentPane().setFont(new Font("Arial Black", Font.PLAIN, 13));
//		frame.getContentPane().setBackground(new Color(240, 240, 240));
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("START");
		btnNewButton.setFont(new Font("HP Simplified", Font.PLAIN, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose(); //Destroy the JFrame object
				CollisionEx ex = new CollisionEx();
                ex.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(79, 134, 134, 57);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("KONIEC");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		JButton btnAutorzy = new JButton("AUTORZY");
		btnAutorzy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Autorzy window = new Autorzy();
					window.frameA.setVisible(true);
				} catch (Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		
		btnAutorzy.setFont(new Font("HP Simplified", Font.PLAIN, 13));
		btnAutorzy.setBounds(97, 257, 97, 25);
		frame.getContentPane().add(btnAutorzy);
		btnNewButton_1.setFont(new Font("HP Simplified", Font.PLAIN, 13));
		btnNewButton_1.setBounds(97, 295, 97, 25);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("O GRZE");
		btnNewButton_2.setFont(new Font("HP Simplified", Font.PLAIN, 13));
		btnNewButton_2.setBounds(97, 222, 97, 25);
		frame.getContentPane().add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("road.png"));
		lblNewLabel.setBounds(0, 0, 296, 364);
		frame.getContentPane().add(lblNewLabel);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 300, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
