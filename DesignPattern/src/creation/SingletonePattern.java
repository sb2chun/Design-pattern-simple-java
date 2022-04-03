package creation;

public class SingletonePattern {
	public static void main(String[] args) {

		AClass aClass = new AClass();
		BClass bClass = new BClass();

		SocketClient aClient = aClass.getSocketClient();
		SocketClient bClient = bClass.getSocketClient();

		System.out.println(aClient.equals(bClient));

	}

}

class AClass {
	private SocketClient socketClient;

	public AClass() {
		this.socketClient = SocketClient.getInstance();
	}

	public SocketClient getSocketClient() {
		return this.socketClient;
	}
}

class BClass {
	private SocketClient socketClient;

	public BClass() {
		this.socketClient = SocketClient.getInstance();
	}

	public SocketClient getSocketClient() {
		return this.socketClient;
	}
}

class SocketClient {
	private static SocketClient socketClient = null;

	private SocketClient() {
	}

	public static SocketClient getInstance() {
		if (socketClient == null)
			socketClient = new SocketClient();

		return socketClient;
	}
}