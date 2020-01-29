package org.DragonflyAutomation;

class StepsManual {
	private static volatile StepsManual instance = null;
	private ThreadLocal<String> string = new ThreadLocal<String>();

	private StepsManual() {
		if (instance != null) {
			throw new RuntimeException("");
		}
	}

	static StepsManual getInstance() {
		if (instance == null) {
			instance = new StepsManual();
			synchronized (StepsManual.class) {
				if (instance == null) {
					instance = new StepsManual();
				}
			}
		}
		return instance;
	}

	void delete() {
		this.string.remove();
	}

	String get() {
		return this.string.get();
	}

	void set(String strTextToAdd) {
		if (this.string.get() == null) {
			this.string.set(strTextToAdd);
		} else {
			this.string.set(this.string.get() + System.getProperty("line.separator") + strTextToAdd);
		}
	}
}
