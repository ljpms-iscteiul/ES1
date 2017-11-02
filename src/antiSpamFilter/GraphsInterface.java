package antiSpamFilter;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class GraphsInterface {

	protected JFrame frame;
	protected JProgressBar pgrs_fp;
	protected JProgressBar pgrs_fn;
	protected JButton btnReturn;
	protected JPanel panel_results;
	
	
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
		
		//panels
		panel_results = new JPanel();
		panel_results.setBackground(new Color(255, 255, 255));
		panel_results.setBounds(113, 86, 374, 352);
		frame.getContentPane().add(panel_results);
		
		//labels
		JLabel lblNewLabel = new JLabel("Graphic Analysis");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(136, 26, 327, 49);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("False Positive");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(300, 450, 250, 27);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("False Positive");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(50, 450, 250, 27);
		frame.getContentPane().add(label_1);
		
		// results 
		
		pgrs_fn = new JProgressBar();
		pgrs_fn.setValue(40);
		pgrs_fn.setStringPainted(true);
		pgrs_fn.setBounds(48, 489, 252, 20);
		frame.getContentPane().add(pgrs_fn);
		
		pgrs_fp = new JProgressBar();
		pgrs_fp.setValue(40);
		pgrs_fp.setStringPainted(true);
		pgrs_fp.setBounds(310, 489, 252, 20);
		frame.getContentPane().add(pgrs_fp);
		
		btnReturn = new JButton("Return");
		btnReturn.setBounds(395, 525, 178, 34);
		frame.getContentPane().add(btnReturn);
		
		
	}

	protected JFrame getFrame() {
		return frame;
	}

	protected JProgressBar getPgrs_fp() {
		return pgrs_fp;
	}

	protected JProgressBar getPgrs_fn() {
		return pgrs_fn;
	}

	protected JButton getBtnReturn() {
		return btnReturn;
	}

	protected JPanel getPanel_results() {
		return panel_results;
	}

	protected void setFrame(JFrame frame) {
		this.frame = frame;
	}

	protected void setPgrs_fp(JProgressBar pgrs_fp) {
		this.pgrs_fp = pgrs_fp;
	}

	protected void setPgrs_fn(JProgressBar pgrs_fn) {
		this.pgrs_fn = pgrs_fn;
	}

	protected void setBtnReturn(JButton btnReturn) {
		this.btnReturn = btnReturn;
	}

	protected void setPanel_results(JPanel panel_results) {
		this.panel_results = panel_results;
	}
	

}
