package org.DragonflyAutomation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;
import org.DragonflyAutomation.TestConfiguration.Root;
import org.apache.commons.io.IOUtils;
import com.google.common.base.Stopwatch;
import com.google.gson.Gson;

public class Dragonfly2 {
	public static void main(String[] args) {
		try {
			URL url = new URL("");
			URLConnection con = url.openConnection();
			InputStream in = con.getInputStream();
			String encoding = con.getContentEncoding();
			encoding = encoding == null ? "UTF-8" : encoding;
			String body = IOUtils.toString(in, encoding);
			System.out.println(body);
		} catch (Exception e2) {
			// TODO Auto-generated catch block		e2.printStackTrace();
		}
		System.exit(0);
		//		try {
		//		FileReader jsonFile =	new FileReader("C:\\workspace-joseph\\dragonfly\\Dragonfly\\Data\\local\\test_modules\\tm_atw_framestest.json");
		//		Gson gson = new Gson().newBuilder().setPrettyPrinting().serializeNulls().create();
		//		TestModule[] userArray = gson.fromJson(jsonFile, TestModule[].class);
		//		System.out.println(gson.toJson(userArray));
		//		} catch (FileNotFoundException e2) {
		//			// TODO Auto-generated catch block
		//			e2.printStackTrace();
		//		}
		//		try {
		//		FileReader jsonFile =	new FileReader("C:\\workspace-joseph\\dragonfly\\Dragonfly\\Data\\local\\test_configuration\\atw_frames.json");
		//		//System.out.println(jsonFile);
		//		Gson gson = new Gson().newBuilder().setPrettyPrinting().serializeNulls().create();
		//		
		//		Root userArray = gson.fromJson(jsonFile, Root.class);
		//		System.out.println(userArray.getTest_modules());
		//		System.out.println(gson.toJson(userArray));
		//		} catch (FileNotFoundException e2) {
		//			// TODO Auto-generated catch block
		//			e2.printStackTrace();
		//		}	
		try {
			FileReader jsonFile = new FileReader("C:\\workspace-joseph\\dragonfly\\Dragonfly\\Data\\local\\test_elements\\te_test.json");
			//System.out.println(jsonFile);
			Gson gson = new Gson().newBuilder().setPrettyPrinting().serializeNulls().create();
			TestElement.Root2 testElement = gson.fromJson(jsonFile, TestElement.Root2.class);
			System.out.println(testElement.getTestElements());
			System.out.println(gson.toJson(testElement));
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		System.exit(0);
		Stopwatch.createStarted();
		//Logger.getInstance().add("  ==start==>mainDragonfly2 " + Util.getDateTimestamp());
		TimeLogger outside = new TimeLogger("Dragonfly2");
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		TimeLogger inside = new TimeLogger("CoordinatesElement");
		try {
			TimeUnit.MILLISECONDS.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//inside.stop("Dragonfly2");
		outside.stopFinally("done already");
		//System.out.println("inside  " + inside.getDuration());
		//System.out.println("outside  " + outside.getDuration());
		int test = 95;
		new TimeLogger("Dragonfly2");
		inside.stop("");
		inside.stop("objElementPoint.x " + test);
		inside.stop("objElementPoint.x " + test++);
		inside.stop("objElementPoint.x " + test++);
		outside.stop("objElementPoint.x " + test++);
		outside.stop("");
		inside.stamp("objElementPoint.x " + test++);
		inside.stamp("objElementPoint.x " + test++);
		inside.stamp("objElementPoint.x " + test++);
		outside.stamp("objElementPoint.x " + test++);
		inside.stopCatch("");
		inside.stopFinally("objElementPoint.x " + test++);
		outside.stopCatch("objElementPoint.x " + test++);
		outside.stopFinally("objElementPoint.x " + test++);
		//System.out.println(Stopwatch.createStarted().elapsed());
		System.exit(0);
		Logger.getInstance().add("  ==start==>mainDragonfly " + Util.getDateTimestamp());
		if (new Execution().getSource().equals("local")) {
			System.out.println(OperatingSystem.get());
			System.out.println(Config.getInstance().devicePixelRatio);
			System.out.println(Math.PI);
			try {
				//	new DialogLocal();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Path.getInstance().setDirectory(new ManualTestSelection().testArea);
		//objTestConfigurationSetup.run(strNameTestConfiguration);
	}
}
