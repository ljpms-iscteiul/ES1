package antiSpamFilter.main;

import java.util.ArrayList;
import java.util.HashMap;

import functionals.InfoStorage;
import graphics.MainInterface;

public class AntiSpamFilterMain {
	public static void main(String[] args) {
		InfoStorage storage = new InfoStorage();
		storage.loadAll();
		HashMap<String, Double> rules = storage.getRules();
		MainInterface mainInterface = new MainInterface();
		mainInterface.initialize();
		mainInterface.specifyRules(rules);
	}
}
