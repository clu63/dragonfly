package org.DragonflyAutomation;



public class Dragonfly2 {
	public static void main(String[] args) {
		Logger.getInstance().add("  ==start==>mainDragonfly " + new DateTimestamp().get());
		if(new Execution().getSource().equals("local")){
			
			try {
				new DialogLocal();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		 
Paths.getInstance().setDirectory(new ManualTestSelection().testArea);
		objTestConfigurationSetup.run(strNameTestConfiguration);
	
	}
}
