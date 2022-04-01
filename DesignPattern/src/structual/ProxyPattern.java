package structual;

public class ProxyPattern {
	public static void main(String[] args) {
		// 직접 호출하지 않고 프록시를 호출한다.
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
		return "서비스 짱!!!";
	}
}

class Proxy implements IService {
	IService service1;

	@Override
	public String runSomething() {
		System.out.println("호출에 대한 흐름 제어가 주목적, 반환 결과를 그대로 전달");
		service1 = new Service();
		return service1.runSomething();
	}
}