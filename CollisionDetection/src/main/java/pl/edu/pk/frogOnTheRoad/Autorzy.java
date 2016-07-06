package pl.edu.pk.frogOnTheRoad;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Autorzy {

	JFrame frameA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Autorzy window = new Autorzy();
					window.frameA.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Autorzy() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameA = new JFrame();
		frameA.setBounds(100, 100, 300, 400);
		frameA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameA.getContentPane().setLayout(null);
		
		JTextPane txtpnAutorzy = new JTextPane();
		txtpnAutorzy.setFont(new Font("Calibri", Font.BOLD, 16));
		txtpnAutorzy.setBackground(UIManager.getColor("Button.background"));
		txtpnAutorzy.setEditable(false);
		txtpnAutorzy.setText("Autorzy:\r\n\t\u2022 Micha\u0142 Boryczko\r\n\t\u2022 Krystian Bujak\r\n\t\u2022 Arkadiusz Bontur\r\n\t\u2022 Konrad Bysiek");
		txtpnAutorzy.setBounds(40, 66, 211, 157);
		frameA.getContentPane().add(txtpnAutorzy);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameA.dispose();
			}
		});
		btnOk.setBounds(89, 286, 97, 25);
		frameA.setLocationRelativeTo(null);
		frameA.getContentPane().add(btnOk);
	}
}
