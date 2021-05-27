package org.DragonflyAutomation;

class Logger {
	private static volatile Logger instance = null;
	private ThreadLocal<String> string = new ThreadLocal<String>();

	private Logger() {
		if (instance != null) {
			throw new RuntimeException("");
		}
	}

	static Logger getInstance() {
		if (instance == null) {
			instance = new Logger();
			synchronized (Logger.class) {
				if (instance == null) {
					instance = new Logger();
				}
			}
		}
		return instance;
	}

	void add(String strTextToAdd) {
		//System.out.println(strTextToAdd);
		String fileNameLineNumber = "(" + Thread.currentThread().getStackTrace()[2].getFileName() + ":" + Thread.currentThread().getStackTrace()[2].getLineNumber() + ") ";
		System.out.println(fileNameLineNumber + strTextToAdd);
		//		System.out.println(Thread.currentThread().getStackTrace()[2]);
		//		System.out.println(Thread.currentThread().getStackTrace()[2].getClassName());
		//		System.out.println(Thread.currentThread().getStackTrace()[2].getFileName());
		//		System.out.println(Thread.currentThread().getStackTrace()[2].getLineNumber());
		//		System.out.println(Thread.currentThread().getStackTrace()[2].getMethodName());
		//		System.out.println("("+Thread.currentThread().getStackTrace()[2].getFileName()+":"+Thread.currentThread().getStackTrace()[2].getLineNumber()+")");
		if (this.string.get() == null) {
			this.string.set(strTextToAdd);
		} else {
			this.string.set(this.string.get() + System.getProperty("line.separator") + strTextToAdd);
		}
	}

	void deleteLog() {
		//this.stringBuilder.set("");
		this.string.remove();
	}

	String getLog() {
		return this.string.get();
	}
}