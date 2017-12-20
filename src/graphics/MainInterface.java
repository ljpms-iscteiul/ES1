package graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import antiSpamFilter.AntiSpamFilterAutomaticConfiguration;
import functionals.AutomaticWeigthVector;
import functionals.HamSpamReader;
import functionals.InfoStorage;
import functionals.WeightUploader;
/**Classe da interface */
public class MainInterface {
	private  JFrame frame;
	/**
	 * Frame principal
	 * @return frame
	 */
	public JFrame getFrame() {
		return frame;
	}
	/**
	 * Mudar frame
	 * @param frame janela
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	private  JFileChooser jfilechooser;
	private  JButton btnSearch;
	private  JTextField jtfchosenfilepath;
	private  JButton btnApply;
	private  JComboBox values_auto;
	private  JTextField rules_auto;
	private  JProgressBar pgrs_auto_fp;
	private  JProgressBar pgrs_auto_fn;
	private  JButton btnRun_auto;
	private  JComboBox values_manual;
	private  JTextField rules_manual;
	private  JProgressBar pgrs_manual_fp;
	private  JProgressBar pgrs_manual_fn;
	private  JButton btnRun_manual;
	private  JButton btnEdit ;
	private  Boolean canBtnEdit= false;
	private  JButton btnSave_manual;
	private  JButton btnSave_auto;
	private  JButton btnGraphGeneretor;
	private  JTable auto_table;
	private  DefaultTableModel model_auto;
	private  JTable manual_table;
	private  DefaultTableModel model_manual;
	/**Cria a aplicacao */
	public MainInterface() {
		initialize();
	}
	/**Janela Visivel */
	public void start() {
		frame.setVisible(true);
	}
	/**Inicializa a frame */
	private void initialize() {
		//CRIAÇÃO DE OBJETOS
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		// PAINEIS --
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
		//LABELS --
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
		//Aplly file path
		btnApply = new JButton("Apply");
		btnApply.setBounds(474, 70, 89, 34);
		btnApply.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InfoStorage storage = new InfoStorage();
				System.out.println(jtfchosenfilepath.getText());
				storage.loadRules(jtfchosenfilepath.getText());
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
		btnRun_auto.setBounds(300, 677, 263, 34);
		btnRun_auto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					AntiSpamFilterAutomaticConfiguration.main(null);
					AutomaticWeigthVector a = new AutomaticWeigthVector();
					a.loadResults("experimentBaseDirectory/referenceFronts/AntiSpamFilterProblem.NSGAII.rf");
					int c = 0;
					for(HashMap.Entry<String,Double> entry: allRulesAuto.entrySet()) {
						if(c<a.getBestVector().size()) {
							entry.setValue(a.getBestVector().get(c));
							c++;
						}
					}
					setPgrs_auto_fn(a.getFNAndFP()[1]);
					setPgrs_auto_fp(a.getFNAndFP()[0]);
					rulesShownOnTableAuto = (HashMap<String, Double>)allRulesAuto.clone();
					rulesSavedAuto = (HashMap<String, Double>) rulesShownOnTableAuto.clone();
					rules_auto.setText("");
					values_auto.setSelectedItem("ALL");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
				 // PARA PLOT
//			    System.out.println("Start plotting...");
//			    String[] params = new String [3];
//			    params[0]="C:/Program Files/R/R-3.4.3/bin/Rscript.exe";  // executa o R Script
//			    params[1]="C:/Program Files (x86)/Adobe/Acrobat Reader DC/Reader/AcroRd32.exe";  // vais buscar o adobe
//			    params[2]="C:/Users/diogo/Documentos/ficheiro.pdf";     // vai buscar o ficheiro
//			    System.out.println("params defined");
//			    try {
////					Runtime.getRuntime().exec(params);
//			    	Runtime.getRuntime().exec("C:/Program Files/R/R-3.4.3/bin/Rscript.exe /experimentBaseDirectory/AntiSpamStudy/R/HV.Boxplot.R"); 
//				} catch (IOException e1) {
//					System.out.println("error Runtime exec - btnRun_auto.addActionListener");
//					e1.printStackTrace();
//				}
//			    
//			    
//			    System.out.println("after execution");
			    //
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			    
			}
		});
		panel.add(btnRun_auto);


		//Botão auto to manual
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

		btnSave_auto = new JButton("Save");
		btnSave_auto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// escolhe onde guardar
				jfilechooser = new JFileChooser();
				jfilechooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				jfilechooser.setApproveButtonText("Save");
				jfilechooser.setDialogTitle("Selecionar o sitio onde guardar");
				jfilechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				jfilechooser.setAcceptAllFileFilterUsed(false);
				//para escolher folder
				if (jfilechooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { 
					System.out.println("getCurrentDirectory(): "+  jfilechooser.getCurrentDirectory());
					System.out.println("getSelectedFile() : " +  jfilechooser.getSelectedFile());
					new WeightUploader().update(rulesSavedAuto,jfilechooser.getSelectedFile().getAbsolutePath());
				}
				else {
					System.out.println("No Selection - save cancelled");
				}
			}
		});
		btnSave_auto.setBounds(37, 677, 263, 34);
		panel.add(btnSave_auto);

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
		pgrs_manual_fp.setValue(0);
		pgrs_manual_fp.setStringPainted(true);
		pgrs_manual_fp.setBounds(6, 493, 252, 20);
		panel_3.add(pgrs_manual_fp);
		//falsos negativos progressbar
		pgrs_manual_fn = new JProgressBar();
		pgrs_manual_fn.setValue(0);
		pgrs_manual_fn.setStringPainted(true);
		pgrs_manual_fn.setBounds(270, 493, 250, 20);
		panel_3.add(pgrs_manual_fn);
		//Configurações Manuais	
		model_manual = new DefaultTableModel(data, columnNames);
		manual_table = new JTable(model_manual) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column == 1 && canBtnEdit==true) 
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
				// verificar os [-5,-5]
				HashMap<String,Double> invalidvalues = new HashMap<String,Double>();
				for(HashMap.Entry<String,Double> entry: allRulesManual.entrySet()) {
					if(Double.isNaN(entry.getValue()) || (!Double.isNaN(entry.getValue()) && (entry.getValue()<-5 || entry.getValue()>5)))
						invalidvalues.put(entry.getKey(), entry.getValue());
				}
				if(!invalidvalues.isEmpty()) {
					JOptionPane.showMessageDialog(null, "values should be between -5 and 5 to be valid!");
					rulesShownOnTableManual = (HashMap<String, Double>) invalidvalues.clone();
					updateTableManual();
				}else {
					rulesSavedManual = (HashMap<String, Double>) allRulesManual.clone();
					HamSpamReader reader= new HamSpamReader();
					setPgrs_manual_fn(reader.weigthCalculator("spam.log", rulesSavedManual));
					setPgrs_manual_fp(reader.weigthCalculator("ham.log", rulesSavedManual));
				}
			}
		});
		panel_1.add(btnRun_manual);
		// bot�o para Editar configura��es manuais
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(canBtnEdit==false) 
					canBtnEdit=true;		
				else 
					canBtnEdit=false;
			}
		}); 
		btnEdit.setBounds(37, 677, 178, 34);
		panel_1.add(btnEdit);
		//botao guardar as configur��es manuais
		btnSave_manual = new JButton("Save");
		btnSave_manual.setBounds(211, 677, 178, 34);
		btnSave_manual.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// escolhe onde guardar
				jfilechooser = new JFileChooser();
				jfilechooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
				jfilechooser.setApproveButtonText("Save");
				jfilechooser.setDialogTitle("Escolher sitio onde guardar");
				jfilechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				jfilechooser.setAcceptAllFileFilterUsed(false);
				//para escolher folder
				if (jfilechooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) { 
					System.out.println("getCurrentDirectory(): "+  jfilechooser.getCurrentDirectory());
					System.out.println("getSelectedFile() : " +  jfilechooser.getSelectedFile());
					new WeightUploader().update(rulesSavedManual,jfilechooser.getSelectedFile().getAbsolutePath());
				}
				else
					System.out.println("No Selection - save cancelled");
			}
		});
		panel_1.add(btnSave_manual);
		//botao para gerar gr�ficos
		btnGraphGeneretor = new JButton("Graph Generetor");
		btnGraphGeneretor.setBounds(155, 51, 290, 61);
		panel_1.add(btnGraphGeneretor);
		btnGraphGeneretor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//				GraphsInterface graph= new GraphsInterface();
				//				graph.getFrame().setVisible(true);
			}
		});
	}
	private HashMap<String, Double> rulesSavedAuto;
	private HashMap<String, Double> rulesSavedManual;
	private HashMap<String, Double> allRulesAuto;
	private HashMap<String, Double> allRulesManual;
	private HashMap<String, Double> rulesShownOnTableAuto;
	private HashMap<String, Double> rulesShownOnTableManual;
	private JButton btnNewButton;
	/**
	 * Atualiza todas as rules
	 * @param rules Hasmap rules atualizadas
	 */
	@SuppressWarnings("unchecked")
	public void specifyRules(HashMap<String, Double> rules) {
		allRulesAuto = (HashMap<String, Double>) rules.clone();
		allRulesManual = (HashMap<String, Double>) rules.clone();
		rulesShownOnTableAuto = (HashMap<String, Double>) rules.clone();
		updateTableAuto();

		rulesShownOnTableManual = (HashMap<String, Double>) rules.clone();
		updateTableManual();
	}
	/** Atualiza a tabela automatica */
	public void updateTableAuto() {
		model_auto.getDataVector().removeAllElements();
		for(HashMap.Entry<String,Double> entry: rulesShownOnTableAuto.entrySet()) {
			model_auto.addRow(new Object[] {entry.getKey(),entry.getValue()});
		}
		auto_table.updateUI();
	}
	/** Atualiza a tabela manual*/
	public void updateTableManual() {
		model_manual.getDataVector().removeAllElements();
		for(HashMap.Entry<String,Double> entry: rulesShownOnTableManual.entrySet()) {
			model_manual.addRow(new Object[] {entry.getKey(),entry.getValue()});
		}
		manual_table.updateUI();
	}
	/**
	 * Filtro da tabela automatica
	 * @param ruleFilter Filtro nome
	 * @param valueFilter Filtro valor
	 */
	public void filterTableAuto(String ruleFilter, String valueFilter) {
		if(!rulesShownOnTableAuto.isEmpty())
			rulesShownOnTableAuto.clear();

		if(!ruleFilter.isEmpty()) {
			for(HashMap.Entry<String,Double> entry: allRulesAuto.entrySet()) {
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
				rulesShownOnTableAuto = (HashMap<String, Double>) allRulesAuto.clone();
			else {
				for(HashMap.Entry<String,Double> entry: allRulesAuto.entrySet()) {
					if(entry.getValue().toString().contains(valueFilter+"."))
						if(!valueFilter.contains("-") && entry.getValue().toString().contains("-")) { // casos em que o - esta a mais
							String changed = entry.getValue().toString().substring(1, entry.getValue().toString().length()-1);
							rulesShownOnTableAuto.put(entry.getKey(), Double.valueOf(changed));
						}else { // casos normais
							rulesShownOnTableAuto.put(entry.getKey(), entry.getValue());
						}
				}
			}

		}
		updateTableAuto();
	}
	/**
	 *  * Filtro da tabela manual
	 * @param ruleFilter Filtro nome 
	 * @param valueFilter Filtro valor
	 */
	public void filterTableManual(String ruleFilter, String valueFilter) {
		// holding filter changes
		for(int i = 0; i < manual_table.getModel().getRowCount(); i++) {
			allRulesManual.replace(manual_table.getModel().getValueAt(i, 0).toString(), Double.valueOf((manual_table.getModel().getValueAt(i, 1).toString())));
		}
		if(!rulesShownOnTableManual.isEmpty())
			rulesShownOnTableManual.clear();
		if(!ruleFilter.isEmpty()) {
			for(HashMap.Entry<String,Double> entry: allRulesManual.entrySet()) {
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
				rulesShownOnTableManual = (HashMap<String, Double>) allRulesManual.clone();
			else {
				for(HashMap.Entry<String,Double> entry: allRulesManual.entrySet()) {
					if(entry.getValue().toString().contains(valueFilter+".")) {
						if(!valueFilter.contains("-") && entry.getValue().toString().contains("-")) { // casos em que o - esta a mais
							String changed = entry.getValue().toString().substring(1, entry.getValue().toString().length()-1);
							rulesShownOnTableManual.put(entry.getKey(), Double.valueOf(changed));
						}else { // casos normais
							rulesShownOnTableManual.put(entry.getKey(), entry.getValue());
						}
					}
				}
			}
		}
		updateTableManual();
	}
	//GETS E SETS NORMAIS
		public HashMap<String,Double> getRulesShownedTableAuto(){
			return rulesShownOnTableAuto;
		}

		public HashMap<String,Double> getAllRulesAuto(){
			return allRulesAuto;
		}

		public HashMap<String,Double> getRulesShownedTableManual(){
			return rulesShownOnTableManual;
		}

		public HashMap<String,Double> getAllRulesManual(){
			return allRulesManual;
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

		public JButton getBtnSave_manual() {
			return btnSave_manual;
		}

		public JButton getNextBtn() {
			return btnNewButton;
		}

		public JButton getBtnSave_auto() {
			return btnSave_auto;
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

		public void setBtnApply(JButton btnApply) {
			this.btnApply = btnApply;
		}

		public JFileChooser getJfilechooser() {
			return jfilechooser;
		}

		public JButton getBtnSearch() {
			return btnSearch;
		}

		public void setBtnSearch(JButton btnSearch) {
			this.btnSearch = btnSearch;
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

		public void setPgrs_auto_fp(Double newValue) {
			this.pgrs_auto_fp.setValue((int) (int) Math.round(newValue));
		}
		
		public void setPgrs_auto_fn(Double newValue) {
			this.pgrs_auto_fn.setValue((int) Math.round(newValue));
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

		public void setBtnSave_manual(JButton btnSave) {
			this.btnSave_manual = btnSave;
		}

		public void setBtnSave_auto(JButton btnSave) {
			this.btnSave_auto = btnSave;
		}

		public void setBtnNext(JButton newnext) {
			this.btnNewButton = newnext;
		}

		public void setBtnGraphGeneretor(JButton btnGraphGeneretor) {
			this.btnGraphGeneretor = btnGraphGeneretor;
		}

		public boolean getIfEditable() {
			return canBtnEdit;
		}
		public JTextField getJtfchosenfilepath() {
			return jtfchosenfilepath;
		}


}

