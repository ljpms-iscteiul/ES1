package graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import functionals.HamSpamReader;
import functionals.InfoStorage;
import functionals.WeightUploader;
import javax.swing.ImageIcon;

public class MainInterface {

	protected  JFrame frame;

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public JFileChooser jfilechooser;
	public JButton btnSearch;
	public  static JTextField jtfchosenfilepath;
	
	public static JTextField getJtfchosenfilepath() {
		return jtfchosenfilepath;
	}

	public JButton btnApply;
	public JComboBox values_auto;
	public JTextField rules_auto;
	public JProgressBar pgrs_auto_fp;
	public JProgressBar pgrs_auto_fn;
	public JButton btnRun_auto;
	public JComboBox values_manual;
	public JTextField rules_manual;
	public JProgressBar pgrs_manual_fp;
	public JProgressBar pgrs_manual_fn;
	public JButton btnRun_manual;
	public JButton btnEdit ;
	public Boolean CanbtnEdit= false;
	public JButton btnSave;
	public JButton btnGraphGeneretor;
	public JTable auto_table;
	public DefaultTableModel model_auto;
	public JTable manual_table;
	public DefaultTableModel model_manual;
	
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainInterface window = new MainInterface();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public MainInterface() {
		initialize();
	}
	
	public void start() {
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// paineis
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(SystemColor.window);
		panel.setBounds(0, 0, 635, 800);
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

//		//Select file path
//		tree.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
//		tree.setBounds(36, 76, 333, 20);
//		panel.add(tree);
		
		//Aplly file path
		btnApply = new JButton("Apply");
		btnApply.setBounds(474, 70, 89, 34);
		btnApply.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				InfoStorage storage = new InfoStorage();
				System.out.println(jtfchosenfilepath.getText());
				storage.loadAll(jtfchosenfilepath.getText());
				specifyRules(storage.getRules());
			}
		});
		panel.add(btnApply);
		
		

		//Search file path
		btnSearch = new JButton("Search");
		btnSearch.setBounds(385, 70, 89, 34);
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jfilechooser = new JFileChooser();
				jfilechooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				jfilechooser.setDialogTitle("Select File to Open");
				jfilechooser.showOpenDialog(null);
				if(jfilechooser.getSelectedFile()!=null)
					jtfchosenfilepath.setText(jfilechooser.getSelectedFile().getAbsolutePath());
			}
		});
		panel.add(btnSearch);
		
		
		// Text Field to show chosen file path
		jtfchosenfilepath = new JTextField("Search File...");
		jtfchosenfilepath.setEditable(false);
		jtfchosenfilepath.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		jtfchosenfilepath.setBounds(36, 76, 333, 20);
		panel.add(jtfchosenfilepath);
		
		//Values Automatic configuration
		values_auto = new JComboBox();	
		values_auto.setBounds(270, 71, 250, 27);
		values_auto.addItem("ALL");
		for(int i = -5; i < 6; i++)
			values_auto.addItem(i);
		values_auto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String ruleFilter = rules_auto.getText().toUpperCase().trim();
				
				filterTableAuto(ruleFilter, values_auto.getSelectedItem().toString());
			}
		});
		panel_2.add(values_auto);
		
		
		// Rules automatic Configuration
		rules_auto = new JTextField();
		rules_auto.setBounds(8, 71, 250, 27);
		rules_auto.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0) {}
			public void keyPressed(KeyEvent arg0) {

			if(arg0.getKeyCode() != 32 && arg0.getKeyCode() != 10 && arg0.getKeyCode() != 20) {
				String filter = "";
				if(arg0.getKeyCode() == 8 && rules_auto.getText().length() > 0) { // caso em que se apaga
					int filterSize = rules_auto.getText().length()-1;
					if(filterSize != 0) {
						filter = (rules_auto.getText().substring(0, filterSize).toUpperCase()).trim();
					}
				}else // restantes
					filter = ((rules_auto.getText()+arg0.getKeyChar()).toUpperCase()).trim();
				
				filterTableAuto(filter, values_auto.getSelectedItem().toString());
			}
			}
		});
		panel_2.add(rules_auto);
		

		//progressbar falsos positivos
		pgrs_auto_fp = new JProgressBar();
		pgrs_auto_fp.setValue(0);
		pgrs_auto_fp.setStringPainted(true);
		pgrs_auto_fp.setBounds(6, 493, 252, 20);
		panel_2.add(pgrs_auto_fp);
	
		//progressbar falsos negativos
		pgrs_auto_fn = new JProgressBar();
		pgrs_auto_fn.setValue(0);
		pgrs_auto_fn.setStringPainted(true);
		pgrs_auto_fn.setBounds(270, 493, 250, 20);
		panel_2.add(pgrs_auto_fn);
		
		//Configuracao Automatica
		Object[][] data = {};
		String[] columnNames = {"Rules", "Values"};		
		model_auto = new DefaultTableModel(data, columnNames);
		auto_table = new JTable(model_auto);
		auto_table.setEnabled(false);
		JScrollPane scrollPane_auto = new JScrollPane(auto_table);
		scrollPane_auto.setBounds(6, 110, 514, 332);
		panel_2.add(scrollPane_auto);

		//bota� para correr o algoritmo autom�tico
		btnRun_auto = new JButton("Run");
		btnRun_auto.setBounds(211, 677, 178, 34);
		btnRun_auto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//corre o codigo bla bla bla
				
				// escolhe onde guardar
				jfilechooser = new JFileChooser();
				jfilechooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				jfilechooser.setDialogTitle("Select Ham & Spam Saving Folder");
				jfilechooser.setApproveButtonText("Save");
				jfilechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				jfilechooser.setAcceptAllFileFilterUsed(false);
				//para escolher folder
				 if (jfilechooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { 
				      System.out.println("getCurrentDirectory(): "+  jfilechooser.getCurrentDirectory());
				      System.out.println("getSelectedFile() : " +  jfilechooser.getSelectedFile());
				      }
				    else {
				      System.out.println("No Selection ");
				      }
			}
		});
		panel.add(btnRun_auto);
		
		
		
		btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("next.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rules_auto.setText("");
				values_auto.setSelectedItem("ALL");
				rulesShownOnTableManual = (HashMap<String, Double>) rulesShownOnTableAuto.clone();
				updateTableManual();
				rules_manual.setText("");
				values_manual.setSelectedItem("ALL");
			
			}
		});
		btnNewButton.setBounds(565, 377, 70, 46);
		panel.add(btnNewButton);
		
		//Values combobox manual

		values_manual = new JComboBox();
		values_manual.setBounds(270, 71, 250, 27);
		values_manual.addItem("ALL");
		for(int i = -5; i < 6; i++)
			values_manual.addItem(i);
		values_manual.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String ruleFilter = rules_manual.getText().toUpperCase().trim();
				
				filterTableManual(ruleFilter, values_manual.getSelectedItem().toString());
			}
		});
		panel_3.add(values_manual);
		
		//Rules jtextfield manual
	
		rules_manual = new JTextField();
		rules_manual.setBounds(8, 71, 250, 27);
		rules_manual.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent arg0) {}
			public void keyReleased(KeyEvent arg0) {}
			public void keyPressed(KeyEvent arg0) {

			if(arg0.getKeyCode() != 32 && arg0.getKeyCode() != 10 && arg0.getKeyCode() != 20) {
				String filter = "";
				if(arg0.getKeyCode() == 8 && rules_manual.getText().length() > 0) { // caso em que se apaga
					int filterSize = rules_manual.getText().length()-1;
					if(filterSize != 0) {
						filter = (rules_manual.getText().substring(0, filterSize).toUpperCase()).trim();
					}
				}else // restantes
					filter = ((rules_manual.getText()+arg0.getKeyChar()).toUpperCase()).trim();
				
				filterTableManual(filter, values_manual.getSelectedItem().toString());
			}
			}
		});
		panel_3.add(rules_manual);
		
		//falsos positivos progressbar
		pgrs_manual_fp = new JProgressBar();
		pgrs_manual_fp.setValue(41);
		pgrs_manual_fp.setStringPainted(true);
		pgrs_manual_fp.setBounds(6, 493, 252, 20);
		panel_3.add(pgrs_manual_fp);
		
		//falsos negativos progressbar
		pgrs_manual_fn = new JProgressBar();
		pgrs_manual_fn.setValue(13);
		pgrs_manual_fn.setStringPainted(true);
		pgrs_manual_fn.setBounds(270, 493, 250, 20);
		panel_3.add(pgrs_manual_fn);
		
		//Configurações Manuais	
		model_manual = new DefaultTableModel(data, columnNames);
		manual_table = new JTable(model_manual) {
			 @Override
			    public boolean isCellEditable(int row, int column) {
				 if(column == 1 && CanbtnEdit==true) 
			        return true;
				 else 
				return false;
				 
			    }
		};
		
		JScrollPane scrollPane_manual = new JScrollPane(manual_table);
		scrollPane_manual.setBounds(6, 110, 514, 332);
		panel_3.add(scrollPane_manual);
		
		
		//bot�o para correr as configur��es manuais
		btnRun_manual = new JButton("Run");
		btnRun_manual.setBounds(385, 677, 178, 34);
		btnRun_manual.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				rules_manual.setText("");
				values_manual.setSelectedItem("ALL");
				rulesSaved = (HashMap<String, Double>) rules.clone();
				
				// TODO ESCREVER NO RULES.CF
				new WeightUploader().update(rulesSaved);

				
				
				//corre o codigo bla bla bla
				HamSpamReader reader= new HamSpamReader();
				setPgrs_manual_fn(reader.WeigthCalculator("spam.log", rulesSaved));
				setPgrs_manual_fp(reader.WeigthCalculator("ham.log", rulesSaved));
				
				
				
			}
		});
		panel_1.add(btnRun_manual);
		
		// bot�o para Editar configura��es manuais
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(CanbtnEdit==false) 
				CanbtnEdit=true;		
				else CanbtnEdit=false;
				
		}
		}); 
		btnEdit.setBounds(37, 677, 178, 34);
		panel_1.add(btnEdit);
		
		//botao guardar as configur��es manuais
		btnSave = new JButton("Save");
		btnSave.setBounds(211, 677, 178, 34);
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// escolhe onde guardar
				jfilechooser = new JFileChooser();
				jfilechooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				jfilechooser.setApproveButtonText("Save");
				jfilechooser.setDialogTitle("Select Ham & Spam Saving Folder");
				jfilechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				jfilechooser.setAcceptAllFileFilterUsed(false);
				//para escolher folder
				 if (jfilechooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { 
				      System.out.println("getCurrentDirectory(): "+  jfilechooser.getCurrentDirectory());
				      System.out.println("getSelectedFile() : " +  jfilechooser.getSelectedFile());
				      }
				    else {
				      System.out.println("No Selection ");
				      }
			}
		});
		panel_1.add(btnSave);
		
		//botao para gerar gr�ficos
		btnGraphGeneretor = new JButton("Graph Generetor");
		btnGraphGeneretor.setBounds(155, 51, 290, 61);
		panel_1.add(btnGraphGeneretor);
		btnGraphGeneretor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GraphsInterface graph= new GraphsInterface();
				graph.getFrame().setVisible(true);
			}
		});
		
	

		
	}
	
	private HashMap<String, Double> rulesSaved;
	private HashMap<String, Double> rules;
	private HashMap<String, Double> rulesShownOnTableAuto;
	private HashMap<String, Double> rulesShownOnTableManual;
	private JButton btnNewButton;
	
	public void specifyRules(HashMap<String, Double> rules) {
		this.rules = rules;
		rulesShownOnTableAuto = (HashMap<String, Double>) rules.clone();
		updateTableAuto();
		
		rulesShownOnTableManual = (HashMap<String, Double>) rules.clone();
		updateTableManual();
	}
	
	
	public void updateTableAuto() {
		model_auto.getDataVector().removeAllElements();
		for(HashMap.Entry<String,Double> entry: rulesShownOnTableAuto.entrySet()) {
			model_auto.addRow(new Object[] {entry.getKey(),entry.getValue()});
		}
		auto_table.updateUI();
	}
	
	public void updateTableManual() {
		model_manual.getDataVector().removeAllElements();
		for(HashMap.Entry<String,Double> entry: rulesShownOnTableManual.entrySet()) {
			model_manual.addRow(new Object[] {entry.getKey(),entry.getValue()});
		}
		manual_table.updateUI();
	}
	
	public void filterTableAuto(String ruleFilter, String valueFilter) {
		if(!rulesShownOnTableAuto.isEmpty())
			rulesShownOnTableAuto.clear();

		if(!ruleFilter.isEmpty()) {
			for(HashMap.Entry<String,Double> entry: rules.entrySet()) {
				if(valueFilter.equals("ALL")) {
					if(entry.getKey().contains(ruleFilter)) {
						rulesShownOnTableAuto.put(entry.getKey(), entry.getValue());
					}
				}else {
					if(entry.getKey().contains(ruleFilter) && entry.getValue().toString().contains(valueFilter)) {
						rulesShownOnTableAuto.put(entry.getKey(), entry.getValue());
					}
				}
			}
		}else {
			if(valueFilter.equals("ALL")) 
				rulesShownOnTableAuto = (HashMap<String, Double>) rules.clone();
			else {
				for(HashMap.Entry<String,Double> entry: rules.entrySet()) {
					if(entry.getValue().toString().contains(valueFilter))
						rulesShownOnTableAuto.put(entry.getKey(), entry.getValue());
				}
			}
					
		}
		
		updateTableAuto();
	}
	
	public void filterTableManual(String ruleFilter, String valueFilter) {
		
		// holding filter changes
			
		
		for(int i = 0; i < manual_table.getModel().getRowCount(); i++) {
			rules.replace(manual_table.getModel().getValueAt(i, 0).toString(), Double.valueOf((manual_table.getModel().getValueAt(i, 1).toString())));
		}
		
		//
		
		if(!rulesShownOnTableManual.isEmpty())
			rulesShownOnTableManual.clear();

		if(!ruleFilter.isEmpty()) {
			for(HashMap.Entry<String,Double> entry: rules.entrySet()) {
				if(valueFilter.equals("ALL")) {
					if(entry.getKey().contains(ruleFilter)) {
						rulesShownOnTableManual.put(entry.getKey(), entry.getValue());
					}
				}else {
					if(entry.getKey().contains(ruleFilter) && entry.getValue().toString().contains(valueFilter)) {
						rulesShownOnTableManual.put(entry.getKey(), entry.getValue());
					}
				}
			}
		}else {
			if(valueFilter.equals("ALL")) 
				rulesShownOnTableManual = (HashMap<String, Double>) rules.clone();
			else {
				for(HashMap.Entry<String,Double> entry: rules.entrySet()) {
					if(entry.getValue().toString().contains(valueFilter))
						rulesShownOnTableManual.put(entry.getKey(), entry.getValue());
				}
			}
					
		}
		
		updateTableManual();
	}
	
	public JButton getBtnApply() {
		return btnApply;
	}

	public JTable getAuto_table() {
		return auto_table;
	}

	public JComboBox getValues_auto() {
		return values_auto;
	}

	public JTextField getRules_auto() {
		return rules_auto;
	}

	public JProgressBar getPgrs_auto_fp() {
		return pgrs_auto_fp;
	}

	public JProgressBar getPgrs_auto_fn() {
		return pgrs_auto_fn;
	}

	public JButton getBtnRun_auto() {
		return btnRun_auto;
	}

	public JTable getManual_table() {
		return manual_table;
	}
	public DefaultTableModel getManual_model(){
		return model_manual;
	}
	public DefaultTableModel getAuto_model(){
		return model_auto;
	}
	public JComboBox getValues_manual() {
		return values_manual;
	}

	public JTextField getRules_manual() {
		return rules_manual;
	}

	public JProgressBar getPgrs_manual_fp() {
		return pgrs_manual_fp;
	}

	public JProgressBar getPgrs_manual_fn() {
		return pgrs_manual_fn;
	}

	public JButton getBtnRun_manual() {
		return btnRun_manual;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public JButton getBtnGraphGeneretor() {
		return btnGraphGeneretor;
	}
	public DefaultTableModel setManual_model(DefaultTableModel model_manual){
		return this.model_manual=model_manual;
	}
	public DefaultTableModel setAuto_model(DefaultTableModel model_auto){
		return this.model_auto=model_auto;
	}
//	public void setTree(JTree tree) {
//		this.tree = tree;
//	}

	public void setBtnApply(JButton btnApply) {
		this.btnApply = btnApply;
	}

	public JFileChooser getJfilechooser() {
		return jfilechooser;
	}

	public void setJfilechooser(JFileChooser jfilechooser) {
		this.jfilechooser = jfilechooser;
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public void setBtnSearch(JButton btnSearch) {
		this.btnSearch = btnSearch;
	}

	public DefaultTableModel getModel_auto() {
		return model_auto;
	}

	public void setModel_auto(DefaultTableModel model_auto) {
		this.model_auto = model_auto;
	}

	public DefaultTableModel getModel_manual() {
		return model_manual;
	}

	public void setModel_manual(DefaultTableModel model_manual) {
		this.model_manual = model_manual;
	}

	public void setAuto_table(JTable auto_table) {
		this.auto_table = auto_table;
	}

	public void setValues_auto(JComboBox values_auto) {
		this.values_auto = values_auto;
	}

	public void setRules_auto(JTextField rules_auto) {
		this.rules_auto = rules_auto;
	}

	public void setPgrs_auto_fp(Integer newValue) {
		this.pgrs_auto_fp.setValue(newValue);
	}
	public void setPgrs_auto_fn(Integer newValue) {
		this.pgrs_auto_fn.setValue(newValue);
	}
	public void setPgrs_manual_fp(Integer newValue) {
		this.pgrs_manual_fp.setValue(newValue);
	}

	public void setPgrs_manual_fn(Integer newValue) {
		this.pgrs_manual_fn.setValue(newValue);
	}


	public void setBtnRun_auto(JButton btnRun_auto) {
		this.btnRun_auto = btnRun_auto;
	}

	public void setManual_table(JTable manual_table) {
		this.manual_table = manual_table;
	}

	public void setValues_manual(JComboBox values_manual) {
		this.values_manual = values_manual;
	}

	public void setRules_manual(JTextField rules_manual) {
		this.rules_manual = rules_manual;
	}

	public void setBtnRun_manual(JButton btnRun_manual) {
		this.btnRun_manual = btnRun_manual;
	}

	public void setBtnEdit(JButton btnEdit) {
		this.btnEdit = btnEdit;
	}

	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}

	public void setBtnGraphGeneretor(JButton btnGraphGeneretor) {
		this.btnGraphGeneretor = btnGraphGeneretor;
	}
}

