package junits;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import graphics.MainInterface;

public class MainInterfaceTest {

	@Test
	final void testMainInterface() {
		MainInterface mi = new MainInterface();
		assertNotNull(mi.getJtfchosenfilepath());
		
		assertNotNull(mi.getAuto_table());
		mi.setAuto_table(null);
		assertNull(mi.getAuto_table());
		
		assertNotNull(mi.getAuto_model());
		mi.setAuto_model(null);
		assertNull(mi.getAuto_model());
		
		assertNotNull(mi.getValues_auto());
		mi.setValues_auto(null);
		assertNull(mi.getValues_auto());
		
		assertNotNull(mi.getValues_manual());
		mi.setValues_manual(null);
		assertNull(mi.getValues_manual());
		
		assertNotNull(mi.getRules_auto());
		mi.setRules_auto(null);
		assertNull(mi.getRules_auto());
		
		assertNotNull(mi.getRules_manual());
		mi.setRules_manual(null);
		assertNull(mi.getRules_manual());
		
		assertNotNull(mi.getPgrs_auto_fn());
		mi.setPgrs_auto_fn(8.0);
		assertTrue(mi.getPgrs_auto_fn().getValue()==8);
		
		assertNotNull(mi.getPgrs_auto_fp());
		mi.setPgrs_auto_fp(88.0);
		assertTrue(mi.getPgrs_auto_fp().getValue()==88);
		
		assertNotNull(mi.getPgrs_manual_fn());
		mi.setPgrs_manual_fn(55);
		assertTrue(mi.getPgrs_manual_fn().getValue()==55);
		
		assertNotNull(mi.getPgrs_manual_fp());
		mi.setPgrs_manual_fp(92);
		assertTrue(mi.getPgrs_manual_fp().getValue()==92);
		
		assertNotNull(mi.getManual_model());
		mi.setManual_model(null);
		assertNull(mi.getManual_model());
		
		assertNotNull(mi.getManual_table());
		mi.setManual_table(null);
		assertNull(mi.getManual_table());
		
		assertNull(mi.getJfilechooser());
		
		assertNotNull(mi.getBtnSearch());
		mi.setBtnSearch(null);
		assertNull(mi.getBtnSearch());
		
		assertNotNull(mi.getBtnApply());
		mi.setBtnApply(null);
		assertNull(mi.getBtnApply());

		assertNotNull(mi.getBtnGraphGeneretor());
		mi.setBtnGraphGeneretor(null);              
		assertNull(mi.getBtnGraphGeneretor());
		
		assertNotNull(mi.getBtnRun_auto());		
		mi.setBtnRun_auto(null);
		assertNull(mi.getBtnRun_auto());
		
		assertNotNull(mi.getBtnRun_manual());
		mi.setBtnRun_manual(null);
		assertNull(mi.getBtnRun_manual());
		
		assertNotNull(mi.getBtnSave_manual());
		mi.setBtnSave_manual(null);
		assertNull(mi.getBtnSave_manual());
		
		assertNotNull(mi.getBtnSave_auto());
		mi.setBtnSave_auto(null);
		assertNull(mi.getBtnSave_auto());
		
		assertNotNull(mi.getNextBtn());
		mi.setBtnNext(null);
		assertNull(mi.getNextBtn());
		
		
		assertNotNull(mi.getBtnEdit());	
		mi.setBtnEdit(null);
		assertNull(mi.getBtnEdit());

		assertNotNull(mi.getFrame());
		mi.setFrame(null);
		assertNull(mi.getFrame());
	}

	@Test
	final void testStart() {
		MainInterface mi = new MainInterface();
		mi.start();
		assertTrue(mi.getFrame().isVisible());
	}
	
	@Test
	final void testSpecifyRules() {
		MainInterface mi = new MainInterface();
		
		HashMap<String, Double> rules = new HashMap<String,Double>();
		rules.put("a", 1.0);
		rules.put("b",0.1);
		
		assertNull(mi.getAllRulesAuto());
		assertNull(mi.getAllRulesManual());
		assertNull(mi.getRulesShownedTableAuto());
		assertNull(mi.getRulesShownedTableManual());
		
		mi.specifyRules(rules);
		
		assertNotNull(mi.getAllRulesAuto());
		assertNotNull(mi.getAllRulesManual());
		assertNotNull(mi.getRulesShownedTableAuto());
		assertNotNull(mi.getRulesShownedTableManual());
	}
	
	@Test
	final void testFilterTableAuto() {
		MainInterface mi = new MainInterface();
		mi.getJtfchosenfilepath().setText(new File(System.getProperty("user.dir")).getPath()+"\\rules.cf");
		mi.getBtnApply().doClick();
		mi.filterTableAuto("D", "ALL");
		mi.filterTableAuto("D", "1");
		mi.filterTableAuto("D", "0");
		mi.filterTableAuto("D", "-1");
		mi.filterTableAuto("D", "1000");
		mi.filterTableAuto("", "ALL");
		mi.filterTableAuto("", "1");
		mi.filterTableAuto("", "0");
		mi.filterTableAuto("", "-1");
		mi.filterTableAuto("", "1000");
		mi.filterTableAuto("NAO_EXISTE_DE_CERTEZA", "ALL");
		mi.filterTableAuto("NAO_EXISTE_DE_CERTEZA", "1");
		mi.filterTableAuto("NAO_EXISTE_DE_CERTEZA", "0");
		mi.filterTableAuto("NAO_EXISTE_DE_CERTEZA", "-1");
		mi.filterTableAuto("NAO_EXISTE_DE_CERTEZA", "1000");
		
		mi.getRulesShownedTableAuto().clear();
		mi.filterTableAuto("D", "ALL");
		
	}
	
	@Test
	final void testFilterTableManual() {
		MainInterface mi = new MainInterface();
		mi.getJtfchosenfilepath().setText(new File(System.getProperty("user.dir")).getPath()+"\\rules.cf");
		mi.getBtnApply().doClick();
		mi.filterTableManual("D", "ALL");
		mi.filterTableManual("D", "1");
		mi.filterTableManual("D", "0");
		mi.filterTableManual("D", "-1");
		mi.filterTableManual("D", "1000");
		mi.filterTableManual("", "ALL");
		mi.filterTableManual("", "1");
		mi.filterTableManual("", "0");
		mi.filterTableManual("", "-1");
		mi.filterTableManual("", "1000");
		mi.filterTableManual("NAO_EXISTE_DE_CERTEZA", "ALL");
		mi.filterTableManual("NAO_EXISTE_DE_CERTEZA", "1");
		mi.filterTableManual("NAO_EXISTE_DE_CERTEZA", "0");
		mi.filterTableManual("NAO_EXISTE_DE_CERTEZA", "-1");
		mi.filterTableManual("NAO_EXISTE_DE_CERTEZA", "1000");
		
		mi.getRulesShownedTableManual().clear();
		mi.filterTableManual("D", "ALL");

	}

	
	// TESTING CLICKS
	
//	@Test
//	final void testSearchClick() {
//		MainInterface mi = new MainInterface();
//		assertNotNull(mi.getBtnSearch());
//		assertNull(mi.getJfilechooser());
//		mi.getBtnSearch().doClick();
//		assertNotNull(mi.getJfilechooser());
//		mi.setBtnSearch(null);
//		assertNull(mi.getBtnSearch());
//	}
	
//	@Test
//	final void testApplyClick() {
//		MainInterface mi = new MainInterface();
//		assertNotNull(mi.getBtnApply());
//		
//		String pasta = new File(System.getProperty("user.dir")).getPath();
//		String file = "rules.cf";
//		
//		mi.getJtfchosenfilepath().setText(pasta + "\\" + file);
//		mi.getBtnApply().doClick();
//		
//		
//		mi.setBtnApply(null);
//		assertNull(mi.getBtnApply());
//		
//	}
	
}
