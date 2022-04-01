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
	private static ON on = new ON(); // ON 클래스의 인스턴스로 초기화됨

	public ON() {
	}

	public static ON getInstance() { // 초기화된 ON 클래스의 인스턴스를 반환함
		return on;
	}

	public void on_button_pushed(Light light) { // ON 상태일 때 On 버튼을 눌러도 변화 없음
		System.out.println("반응 없음");
	}

	public void off_button_pushed(Light light) {
		light.setState(OFF.getInstance());
		System.out.println("Light Off!");
	}
}

class OFF implements State {
	private static OFF off = new OFF(); // OFF 클래스의 인스턴스로 초기화됨

	public OFF() {
	}

	public static OFF getInstance() { // 초기화된 OFF 클래스의 인스턴스를 반환함
		return off;
	}

	public void on_button_pushed(Light light) { // Off 상태일 때 On 버튼을 눌러도 On 상태임
		light.setState(ON.getInstance());
		System.out.println("Light On!");
	}

	public void off_button_pushed(Light light) { // Off 상태일 때 Off 버튼을 눌러도 변화 없음
		System.out.println("반응 없음");
	}
}