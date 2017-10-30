package antiSpamFilter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import java.awt.Font;

public class MainInterface {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainInterface window = new MainInterface();
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
	public MainInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.window);
		panel.setBounds(0, 0, 600, 800);
		frame.getContentPane().add(panel);
		
		JTree tree = new JTree();
		tree.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		tree.setBounds(36, 76, 333, 20);
		panel.add(tree);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(37, 134, 526, 531);
		panel.add(panel_2);
		
		JList list = new JList();
		list.setForeground(Color.BLACK);
		list.setBounds(0, 100, 526, 342);
		panel_2.add(list);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(270, 71, 250, 27);
		panel_2.add(comboBox);
		
		JLabel label = new JLabel("Rules");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(6, 47, 252, 27);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("Values");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBackground(new Color(30, 144, 255));
		label_1.setBounds(270, 47, 250, 27);
		panel_2.add(label_1);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setValue(40);
		progressBar.setStringPainted(true);
		progressBar.setBounds(6, 493, 252, 20);
		panel_2.add(progressBar);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setValue(12);
		progressBar_1.setStringPainted(true);
		progressBar_1.setBounds(270, 493, 250, 20);
		panel_2.add(progressBar_1);
		
		JLabel lblFalseNegative = new JLabel("False Negative");
		lblFalseNegative.setHorizontalAlignment(SwingConstants.CENTER);
		lblFalseNegative.setBounds(270, 454, 250, 27);
		panel_2.add(lblFalseNegative);
		
		JLabel lblFalsePositive = new JLabel("False Positive");
		lblFalsePositive.setHorizontalAlignment(SwingConstants.CENTER);
		lblFalsePositive.setBounds(6, 454, 250, 27);
		panel_2.add(lblFalsePositive);
		
		JLabel label_14 = new JLabel("Automatic Configuration");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setBounds(174, 6, 177, 27);
		panel_2.add(label_14);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(8, 71, 250, 27);
		panel_2.add(comboBox_2);
		
		JButton button_6 = new JButton("Run");
		button_6.setBounds(211, 677, 178, 34);
		panel.add(button_6);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(385, 70, 178, 34);
		panel.add(btnSave);
		
		JLabel lblNewLabel = new JLabel("Anti-Spam Filter by Team Incredible");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(37, 6, 426, 58);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(SystemColor.window);
		panel_1.setBounds(600, 0, 600, 800);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(37, 134, 526, 531);
		panel_1.add(panel_3);
		
		JList list_1 = new JList();
		list_1.setForeground(Color.BLACK);
		list_1.setBounds(0, 100, 526, 342);
		panel_3.add(list_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(270, 71, 250, 27);
		panel_3.add(comboBox_1);
		
		JLabel label_4 = new JLabel("Rules");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(6, 47, 252, 27);
		panel_3.add(label_4);
		
		JLabel label_5 = new JLabel("Values");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBackground(new Color(30, 144, 255));
		label_5.setBounds(270, 47, 250, 27);
		panel_3.add(label_5);
		
		JProgressBar progressBar_2 = new JProgressBar();
		progressBar_2.setValue(40);
		progressBar_2.setStringPainted(true);
		progressBar_2.setBounds(6, 493, 252, 20);
		panel_3.add(progressBar_2);
		
		JProgressBar progressBar_3 = new JProgressBar();
		progressBar_3.setValue(12);
		progressBar_3.setStringPainted(true);
		progressBar_3.setBounds(270, 493, 250, 20);
		panel_3.add(progressBar_3);
		
		JLabel lblFalseNegative_1 = new JLabel("False Negative");
		lblFalseNegative_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFalseNegative_1.setBounds(270, 454, 250, 27);
		panel_3.add(lblFalseNegative_1);
		
		JLabel lblFalsePositive_1 = new JLabel("False Positive");
		lblFalsePositive_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFalsePositive_1.setBounds(6, 454, 250, 27);
		panel_3.add(lblFalsePositive_1);
		
		JLabel lblManualConfiguration = new JLabel("Manual Configuration");
		lblManualConfiguration.setHorizontalAlignment(SwingConstants.CENTER);
		lblManualConfiguration.setBounds(195, 6, 136, 27);
		panel_3.add(lblManualConfiguration);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(8, 71, 250, 27);
		panel_3.add(comboBox_3);
		
		JButton button = new JButton("Run");
		button.setBounds(385, 677, 178, 34);
		panel_1.add(button);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(37, 677, 178, 34);
		panel_1.add(btnEdit);
		
		JButton btnSave_1 = new JButton("Save");
		btnSave_1.setBounds(211, 677, 178, 34);
		panel_1.add(btnSave_1);
		
		JButton btnGraphGeneretor = new JButton("Graph Generetor");
		btnGraphGeneretor.setBounds(155, 51, 290, 61);
		panel_1.add(btnGraphGeneretor);
	}
}
