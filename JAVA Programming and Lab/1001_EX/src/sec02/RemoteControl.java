package sec02;

public interface RemoteControl {

	//��� �ʵ�
	static final int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;	//static final ���� ����
	
	//�߻�޼ҵ�
	abstract void turnOn();
	void turnOff();			//interface������ abstract ���� ����
	void setVolume(int volume);
}
