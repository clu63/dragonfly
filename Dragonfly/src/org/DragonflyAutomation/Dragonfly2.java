package org.DragonflyAutomation;

import java.util.concurrent.TimeUnit;
import com.google.common.base.Stopwatch;

public class Dragonfly2 {
	public static void main(String[] args) {
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
