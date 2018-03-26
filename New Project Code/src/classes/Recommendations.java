package classes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Recommendations {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recommendations window = new Recommendations();
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
	public Recommendations() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "name_280259102687753");
		panel.setLayout(null);
		
		JButton btnRecomm = new JButton("Recommendations");
		btnRecomm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRecomm.setBounds(120, 90, 220, 60);
		panel.add(btnRecomm);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, "name_280286358221424");
		panel_1.setLayout(null);
		
		JLabel lblRecommendedSelections = new JLabel("Recommended Selections");
		lblRecommendedSelections.setBounds(10, 11, 129, 60);
		panel_1.add(lblRecommendedSelections);
		
		JLabel lblMains = new JLabel("Mains");
		lblMains.setBounds(20, 65, 46, 14);
		panel_1.add(lblMains);
		
		JLabel lblSides = new JLabel("Sides");
		lblSides.setBounds(149, 65, 46, 14);
		panel_1.add(lblSides);
		
		JLabel lblDesserts = new JLabel("Desserts");
		lblDesserts.setBounds(350, 65, 46, 14);
		panel_1.add(lblDesserts);
		
		JLabel lblNewLabel = new JLabel("Drinks");
		lblNewLabel.setBounds(238, 65, 46, 14);
		panel_1.add(lblNewLabel);
	}
}
