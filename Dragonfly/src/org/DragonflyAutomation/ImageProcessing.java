package org.DragonflyAutomation;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Base64;
import javax.imageio.ImageIO;

class ImageProcessing {
	String encodeToString(BufferedImage objBufferedImage, String strImageType) {
		Logger.getInstance().add("  ==start==>ImageEncodeToString " + Util.getDateTimestamp());
		String strImageString = null;
		ByteArrayOutputStream objByteArrayOutputStreams = new ByteArrayOutputStream();
		try {
			ImageIO.write(objBufferedImage, strImageType, objByteArrayOutputStreams);
			byte[] arrImageByte = objByteArrayOutputStreams.toByteArray();
			strImageString = Base64.getEncoder().encodeToString(arrImageByte);
			objByteArrayOutputStreams.close();
		} catch (Exception e) {
			e.toString();
		}
		return strImageString.toString();
	}

	BufferedImage decodeFromString(String strImageString) {
		Logger.getInstance().add("  ==start==>ImageDecodeFromString " + Util.getDateTimestamp());
		BufferedImage objBufferedImage = null;
		byte[] arrImageByte;
		try {
			arrImageByte = Base64.getDecoder().decode(strImageString);
			ByteArrayInputStream objByteArrayInputStream = new ByteArrayInputStream(arrImageByte);
			objBufferedImage = ImageIO.read(objByteArrayInputStream);
			objByteArrayInputStream.close();
		} catch (Exception e) {
			e.toString();
		}
		return objBufferedImage;
	}
}
