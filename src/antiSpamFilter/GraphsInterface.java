package antiSpamFilter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class GraphsInterface {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraphsInterface window = new GraphsInterface();
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
	public GraphsInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(113, 86, 374, 352);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Graphic Analysis");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(136, 26, 327, 49);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnReturn = new JButton("Return");
		btnReturn.setBounds(395, 525, 178, 34);
		frame.getContentPane().add(btnReturn);
		
		JLabel label = new JLabel("False Positive");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(300, 450, 250, 27);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("False Positive");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(50, 450, 250, 27);
		frame.getContentPane().add(label_1);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(40);
		progressBar.setStringPainted(true);
		progressBar.setBounds(48, 489, 252, 20);
		frame.getContentPane().add(progressBar);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setValue(40);
		progressBar_1.setStringPainted(true);
		progressBar_1.setBounds(310, 489, 252, 20);
		frame.getContentPane().add(progressBar_1);
	}

}
