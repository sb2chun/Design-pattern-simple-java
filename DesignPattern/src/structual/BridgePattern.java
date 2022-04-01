package structual;

public class BridgePattern {
	public static void main(String argsp[]) {
		Animal tiger = new Tiger(new Hunting_Method2());
		Animal bird = new Bird(new Hunting_Method1());

		tiger.hunt();
		System.out.println("--------------");
		bird.hunt();
	}
}

interface Hunting_Handler {
	public void Find_Quarry();

	public void Detected_Quarry();

	public void attack();
}

class Hunting_Method1 implements Hunting_Handler {
	public void Find_Quarry() {
		System.out.println("�� ������ ã�´�");
	}

	public void Detected_Quarry() {
		System.out.println("����� �߰�!");
	}

	public void attack() {
		System.out.println("����æ��.");
	}
}

class Hunting_Method2 implements Hunting_Handler {
	public void Find_Quarry() {
		System.out.println("���󿡼� ã�´�");
	}

	public void Detected_Quarry() {
		System.out.println("��� �߰�");
	}

	public void attack() {
		System.out.println("�����´�.");
	}
}

class Animal {
	private Hunting_Handler hunting;

	public Animal(Hunting_Handler hunting) {
		this.hunting = hunting;
	}

	public void Find_Quarry() {
		hunting.Find_Quarry();
	}

	public void Detected_Quarry() {
		hunting.Detected_Quarry();
	}

	public void attack() {
		hunting.attack();
	}

	public void hunt() {
		Find_Quarry();
		Detected_Quarry();
		attack();
	}
}

class Tiger extends Animal {
	public Tiger(Hunting_Handler hunting) {
		super(hunting);
	}

	public void hunt() {
		System.out.println("ȣ������ ��ɹ��");
		Find_Quarry();
		Detected_Quarry();
		attack();
	}

}

class Bird extends Animal {
	public Bird(Hunting_Handler hunting) {
		super(hunting);
	}

	public void hunt() {
		System.out.println("���� ��ɹ��");
		Find_Quarry();
		Detected_Quarry();
		attack();
	}

}