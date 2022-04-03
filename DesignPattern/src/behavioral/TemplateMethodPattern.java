package behavioral;

public class TemplateMethodPattern {
	public static void main(String[] args) {
		Korean_Teacher kr = new Korean_Teacher(); // ����
		Math_Teacher mt = new Math_Teacher(); // ����
		English_Teacher en = new English_Teacher(); // ����

		kr.start_class();
		System.out.println("----------------------------");
		mt.start_class();
		System.out.println("----------------------------");
		en.start_class();
	}
}

abstract class Teacher {

	public void start_class() {
		inside();
		attendance();
		teach();
		outside();
	}

	// ���� �޼���
	public void inside() {
		System.out.println("�������� ���ǽǷ� ���ɴϴ�.");
	}

	public void attendance() {
		System.out.println("�������� �⼮�� �θ��ϴ�.");
	}

	public void outside() {
		System.out.println("�������� ���ǽ��� �����ϴ�.");
	}

	// �߻� �޼���
	abstract void teach();
}

// ���� ������
class Korean_Teacher extends Teacher {

	@Override
	public void teach() {
		System.out.println("�������� ��� �����մϴ�.");
	}
}

//���� ������
class Math_Teacher extends Teacher {

	@Override
	public void teach() {
		System.out.println("�������� ������ �����մϴ�.");
	}
}

//���� ������
class English_Teacher extends Teacher {

	@Override
	public void teach() {
		System.out.println("�������� ��� �����մϴ�.");
	}
}
