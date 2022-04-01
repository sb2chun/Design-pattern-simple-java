package structual;

public class AdapterPattern {
	public static void main(String[] args) {

		// 220v û�ұ�
		Cleaner cleaner = new Cleaner();
		// cleaner�� 110v ����Ϳ� �����Ѵ�.
		Electronic110V adapter = new SocketAdapter(cleaner);
		// 110v ����͸� 110v �ܼ�Ʈ�� �����Ѵ�.
		connect(adapter);

	}

	/**
	 * 110v �ܼ�Ʈ
	 * 
	 * @param electronic110V
	 */
	public static void connect(Electronic110V electronic110V) {
		electronic110V.powerOn();
	}
}

interface Electronic110V {

	void powerOn(); // ������ Ű��.

}

interface Electronic220V {

	void connect(); // ������ Ű��.

}

class HairDryer implements Electronic110V {

	@Override
	public void powerOn() {
		System.out.println("������̱� 110v On");
	}

}

class AirConditioner implements Electronic220V {

	@Override
	public void connect() {
		System.out.println("������ 220v On");
	}

}

class Cleaner implements Electronic220V {

	@Override
	public void connect() {
		System.out.println("û�ұ� 220v On");
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