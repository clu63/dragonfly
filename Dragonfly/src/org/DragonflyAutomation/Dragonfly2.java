package org.DragonflyAutomation;

import  static org.DragonflyAutomation.Logger.getInstance;
import static java.lang.Math.PI;
import static java.lang.Math.*;

public class Dragonfly2 {
	public static void main(String[] args) {
		Logger.getInstance().add("  ==start==>mainDragonfly " + new DateTimestamp().get());
		if(new Execution().getSource().equals("local")){
			System.out.println( OperatingSystem.get());
			
			System.out.println(	Config.getInstance().devicePixelRatio);

			System.out.println(	Math.PI);
			
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
