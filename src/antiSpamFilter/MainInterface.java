package antiSpamFilter;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

public class MainInterface {

	private JFrame frame;

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

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
		
		// paineis
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.window);
		panel.setBounds(0, 0, 600, 800);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(SystemColor.window);
		panel_1.setBounds(600, 0, 600, 800);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(37, 134, 526, 531);
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(37, 134, 526, 531);
		panel_1.add(panel_3);
		
		
		//labels
		
		JLabel label = new JLabel("Rules");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(6, 47, 252, 27);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("Values");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBackground(new Color(30, 144, 255));
		label_1.setBounds(270, 47, 250, 27);
		panel_2.add(label_1);
		
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
		
		JLabel lblNewLabel = new JLabel("Anti-Spam Filter by Team Incredible");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(37, 6, 426, 58);
		panel.add(lblNewLabel);
		
		JLabel label_4 = new JLabel("Rules");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(6, 47, 252, 27);
		panel_3.add(label_4);
		
		JLabel label_5 = new JLabel("Values");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBackground(new Color(30, 144, 255));
		label_5.setBounds(270, 47, 250, 27);
		panel_3.add(label_5);
		
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

		//Select file path
		JTree tree = new JTree();
		tree.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		tree.setBounds(36, 76, 333, 20);
		panel.add(tree);
		
		//Aplly file path
		JButton btnApply = new JButton("Apply");
		btnApply.setBounds(385, 70, 178, 34);
		panel.add(btnApply);
		
		
		// CONFIGURA��O AUTOM�TICA//
		
		//Jlist automatic configuration
		
		JList auto_list = new JList();
		auto_list.setForeground(Color.BLACK);
		auto_list.setBounds(0, 100, 526, 342);
		panel_2.add(auto_list);
		
		//Values Automatic configuration
		JComboBox values_auto = new JComboBox();
		values_auto.setBounds(270, 71, 250, 27);
		panel_2.add(values_auto);
		
		// Rules automatic Configuration
		JComboBox rules_auto = new JComboBox();
		rules_auto.setBounds(8, 71, 250, 27);
		panel_2.add(rules_auto);
		
		//progressbar falsos positivos
		JProgressBar pgrs_auto_fp = new JProgressBar();
		pgrs_auto_fp.setValue(40);
		pgrs_auto_fp.setStringPainted(true);
		pgrs_auto_fp.setBounds(6, 493, 252, 20);
		panel_2.add(pgrs_auto_fp);
		
		//progressbar falsos negativos
		JProgressBar pgrs_auto_fn = new JProgressBar();
		pgrs_auto_fn.setValue(12);
		pgrs_auto_fn.setStringPainted(true);
		pgrs_auto_fn.setBounds(270, 493, 250, 20);
		panel_2.add(pgrs_auto_fn);
		
		//bota� para correr o algoritmo autom�tico
		JButton btnRun_auto = new JButton("Run");
		btnRun_auto.setBounds(211, 677, 178, 34);
		panel.add(btnRun_auto);
		

	
		
		
		//CONFIGURA��ES MANUAIS//
		
		//Jlist Manual configuration
		JList manual_list = new JList();
		manual_list.setForeground(Color.BLACK);
		manual_list.setBounds(0, 100, 526, 342);
		panel_3.add(manual_list);
		
		//Values combobox manual

		JComboBox values_manual = new JComboBox();
		values_manual.setBounds(270, 71, 250, 27);
		panel_3.add(values_manual);
		
		//Rules combobox manual
	
		JComboBox rules_manual = new JComboBox();
		rules_manual.setBounds(8, 71, 250, 27);
		panel_3.add(rules_manual);
		
		//falsos positivos progressbar
		JProgressBar pgrs_manual_fp = new JProgressBar();
		pgrs_manual_fp.setValue(41);
		pgrs_manual_fp.setStringPainted(true);
		pgrs_manual_fp.setBounds(6, 493, 252, 20);
		panel_3.add(pgrs_manual_fp);
		
		//falsos negativos progressbar
		JProgressBar pgrs_manual_fn = new JProgressBar();
		pgrs_manual_fn.setValue(13);
		pgrs_manual_fn.setStringPainted(true);
		pgrs_manual_fn.setBounds(270, 493, 250, 20);
		panel_3.add(pgrs_manual_fn);
		
		
		//bot�o para correr as configur��es manuais
		JButton btnRun_manual = new JButton("Run");
		btnRun_manual.setBounds(385, 677, 178, 34);
		panel_1.add(btnRun_manual);
		
		// bot�o para Editar configura��es manuais
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(37, 677, 178, 34);
		panel_1.add(btnEdit);
		
		//botao guardar as configur��es manuais
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(211, 677, 178, 34);
		panel_1.add(btnSave);
		
		//botao para gerar gr�ficos
		JButton btnGraphGeneretor = new JButton("Graph Generetor");
		btnGraphGeneretor.setBounds(155, 51, 290, 61);
		panel_1.add(btnGraphGeneretor);
	}
}