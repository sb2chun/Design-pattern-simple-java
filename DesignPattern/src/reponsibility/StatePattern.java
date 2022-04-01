package reponsibility;

public class StatePattern {
	public static void main(String[] args) {
		Light light = new Light();
		light.setState(new OFF());
		light.on_button_pushed();
		light.setState(new ON());
		light.off_button_pushed();
//		light.off_button_pushed();
	}
}

interface State {
	public void on_button_pushed(Light light);

	public void off_button_pushed(Light light);
}

class Light {
	private State state;

	public Light() {
		state = new OFF();
	}

	public void setState(State state) {
		this.state = state;
	}

	public void on_button_pushed() {
		state.on_button_pushed(this);
	}

	public void off_button_pushed() {
		state.off_button_pushed(this);
	}
}

class ON implements State {
	private static ON on = new ON(); // ON Ŭ������ �ν��Ͻ��� �ʱ�ȭ��

	public ON() {
	}

	public static ON getInstance() { // �ʱ�ȭ�� ON Ŭ������ �ν��Ͻ��� ��ȯ��
		return on;
	}

	public void on_button_pushed(Light light) { // ON ������ �� On ��ư�� ������ ��ȭ ����
		System.out.println("���� ����");
	}

	public void off_button_pushed(Light light) {
		light.setState(OFF.getInstance());
		System.out.println("Light Off!");
	}
}

class OFF implements State {
	private static OFF off = new OFF(); // OFF Ŭ������ �ν��Ͻ��� �ʱ�ȭ��

	public OFF() {
	}

	public static OFF getInstance() { // �ʱ�ȭ�� OFF Ŭ������ �ν��Ͻ��� ��ȯ��
		return off;
	}

	public void on_button_pushed(Light light) { // Off ������ �� On ��ư�� ������ On ������
		light.setState(ON.getInstance());
		System.out.println("Light On!");
	}

	public void off_button_pushed(Light light) { // Off ������ �� Off ��ư�� ������ ��ȭ ����
		System.out.println("���� ����");
	}
}