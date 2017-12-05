package junits;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import graphics.MainInterface;

public class MainInterfaceTest {

	@Test
	final void testGetFrame() {
		MainInterface mi = new MainInterface();
		assertNotNull(mi.getFrame());
	}

	@Test
	final void testSetFrame() {
		MainInterface mi = new MainInterface();
		mi.setFrame(null);
		assertNull(mi.getFrame());
	}

	@Test
	final void testMainInterface() {
		MainInterface mi = new MainInterface();
		assertNotNull(mi.getJtfchosenfilepath());
		assertNotNull(mi.getAuto_table());
		assertNotNull(mi.getAuto_model());
		assertNotNull(mi.getValues_auto());
		assertNotNull(mi.getValues_manual());
		assertNotNull(mi.getRules_auto());
		assertNotNull(mi.getRules_manual());
		assertNotNull(mi.getPgrs_auto_fn());
		assertNotNull(mi.getPgrs_auto_fp());
		assertNotNull(mi.getPgrs_manual_fn());
		assertNotNull(mi.getPgrs_manual_fp());
		assertNotNull(mi.getManual_model());
		assertNotNull(mi.getManual_table());
		assertNotNull(mi.getModel_auto());
		assertNotNull(mi.getModel_manual());
		assertNull(mi.getJfilechooser());
		assertNotNull(mi.getBtnRun_auto());
		assertNotNull(mi.getBtnApply());
		assertNotNull(mi.getBtnGraphGeneretor());
		assertNotNull(mi.getBtnRun_auto());
		assertNotNull(mi.getBtnRun_manual());		
		assertNotNull(mi.getBtnSave_manual());
		assertNotNull(mi.getBtnSave_auto());
		assertNotNull(mi.getNextBtn());
		assertNotNull(mi.getBtnSearch());	
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
	final void testUpdateTableAuto() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testUpdateTableManual() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testFilterTableAuto() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testFilterTableManual() {
		fail("Not yet implemented"); // TODO
	}

	

	@Test
	final void testSetManual_model() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testSetAuto_model() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testSetBtnApply() {
		fail("Not yet implemented"); // TODO
	}

	

	@Test
	final void testSetJfilechooser() {
		fail("Not yet implemented"); // TODO
	}



	@Test
	final void testSetBtnSearch() {
		fail("Not yet implemented"); // TODO
	}

	

	@Test
	final void testSetModel_auto() {
		fail("Not yet implemented"); // TODO
	}

	

	@Test
	final void testSetModel_manual() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testSetAuto_table() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testSetValues_auto() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testSetRules_auto() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testSetPgrs_auto_fp() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testSetPgrs_auto_fn() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testSetPgrs_manual_fp() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testSetPgrs_manual_fn() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testSetBtnRun_auto() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testSetManual_table() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testSetValues_manual() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testSetRules_manual() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testSetBtnRun_manual() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testSetBtnEdit() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testSetBtnSave() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testSetBtnGraphGeneretor() {
		fail("Not yet implemented"); // TODO
	}

}
