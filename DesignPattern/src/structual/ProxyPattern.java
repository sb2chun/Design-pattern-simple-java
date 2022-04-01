package structual;

public class ProxyPattern {
	public static void main(String[] args) {
		// ���� ȣ������ �ʰ� ���Ͻø� ȣ���Ѵ�.
		IService proxy = new Proxy();
		System.out.println(proxy.runSomething());
	}
}

interface IService {
	String runSomething();
}

class Service implements IService {
	@Override
	public String runSomething() {
		return "���� ¯!!!";
	}
}

class Proxy implements IService {
	IService service1;

	@Override
	public String runSomething() {
		System.out.println("ȣ�⿡ ���� �帧 ��� �ָ���, ��ȯ ����� �״�� ����");
		service1 = new Service();
		return service1.runSomething();
	}
}