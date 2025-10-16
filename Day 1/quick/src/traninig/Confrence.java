package traninig;

public class Confrence {
	
	private String confrenceTitle;
	private String location;
	private Speaker[] speakers;
	
	public Confrence() {
		this.speakers = new Speaker[]{new Speaker("Java AI", "Pune", "90"), new Speaker("c++++","Jaipur","0")};
	}
	
	public void printSpeakerDetails() {
		for(Speaker s : speakers) {
			System.out.println(s.toString());
		}
	}
	
	// Can be done but it will give ambigutiy
//	public void Confrence() {
//		
//	}
}
