package sec02;

public interface RemoteControl {

	//상수 필드
	static final int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;	//static final 생략 가능
	
	//추상메소드
	abstract void turnOn();
	void turnOff();			//interface에서는 abstract 생략 가능
	void setVolume(int volume);
}
