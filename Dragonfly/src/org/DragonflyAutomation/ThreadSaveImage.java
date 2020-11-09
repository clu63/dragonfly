package org.DragonflyAutomation;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

class ThreadSaveImage implements Runnable {
	private BufferedImage screenShot;
	private String imageType;
	private String pathFileName;

	ThreadSaveImage(BufferedImage screenShot, String imageType, String pathFileName) {
		this.screenShot = screenShot;
		this.imageType = imageType;
		this.pathFileName = pathFileName;
	}

	@Override
	public void run() {
		try {
			ImageIO.write(this.screenShot, this.imageType.toUpperCase(), new File(this.pathFileName));
		} catch (Exception e) {
			Logger.getInstance().add("ThreadSaveImage:run Exception = " + e.toString());
		}
	}
}