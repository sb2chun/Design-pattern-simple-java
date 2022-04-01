package structual;

public class AdapterPattern {
	public static void main(String[] args) {

		// 220v 청소기
		Cleaner cleaner = new Cleaner();
		// cleaner를 110v 어댑터에 연결한다.
		Electronic110V adapter = new SocketAdapter(cleaner);
		// 110v 어댑터를 110v 콘센트에 연결한다.
		connect(adapter);

	}

	/**
	 * 110v 콘센트
	 * 
	 * @param electronic110V
	 */
	public static void connect(Electronic110V electronic110V) {
		electronic110V.powerOn();
	}
}

interface Electronic110V {

	void powerOn(); // 전원을 키다.

}

interface Electronic220V {

	void connect(); // 전원을 키다.

}

class HairDryer implements Electronic110V {

	@Override
	public void powerOn() {
		System.out.println("헤어드라이기 110v On");
	}

}

class AirConditioner implements Electronic220V {

	@Override
	public void connect() {
		System.out.println("에어컨 220v On");
	}

}

class Cleaner implements Electronic220V {

	@Override
	public void connect() {
		System.out.println("청소기 220v On");
	}

}

class SocketAdapter implements Electronic110V {

	public Electronic220V electronic220V;

	public SocketAdapter(Electronic220V electronic220V) {
		this.electronic220V = electronic220V;
	}

	@Override
	public void powerOn() {
		electronic220V.connect();
	}

}