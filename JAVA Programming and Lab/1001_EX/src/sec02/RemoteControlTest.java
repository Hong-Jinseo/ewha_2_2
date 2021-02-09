package sec02;

public class RemoteControlTest {

	public static void main(String[] args) {
		
		Television tv = new Television();
		tv.turnOn();
		tv.setVolume(5);
		tv.setVolume(15);
		tv.turnOff();
	}
}