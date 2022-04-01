package structual;

public class DecoratorPattern {
	public static void main(String[] args) {
		Display road = new RoadDisplay();
		road.draw(); // �⺻ ���� ǥ��
		Display roadWithLane = new LaneDecorator(new RoadDisplay());
		roadWithLane.draw(); // �⺻ ���� ǥ�� + ���� ǥ��
		Display roadWithTraffic = new TrafficDecorator(new RoadDisplay());
		roadWithTraffic.draw(); // �⺻ ���� ǥ�� + ���뷮 ǥ��
	}

}

abstract class Display {
	public abstract void draw();
}

abstract class DisplayDecorator extends Display {
	private Display decoratedDisplay;

	// '�ռ�(composition) ����'�� ���� RoadDisplay ��ü�� ���� ����
	public DisplayDecorator(Display decoratedDisplay) {
		this.decoratedDisplay = decoratedDisplay;
	}

	@Override
	public void draw() {
		decoratedDisplay.draw();
	}
}

class RoadDisplay extends Display {
	@Override
	public void draw() {
		System.out.println("�⺻ ���� ǥ��");
	}
}

class LaneDecorator extends DisplayDecorator {
	// ���� ǥ�� Ŭ������ ����
	public LaneDecorator(Display decoratedDisplay) {
		super(decoratedDisplay);
	}

	@Override
	public void draw() {
		super.draw(); // ������ ���� ǥ�� ����� ����
		drawLane(); // �߰������� ������ ǥ��
	}

	// ���� ǥ�� ��ɸ� ���� ����
	private void drawLane() {
		System.out.println("\t���� ǥ��");
	}
}

/* ���뷮 ǥ�ø� �߰��ϴ� Ŭ���� */
class TrafficDecorator extends DisplayDecorator {
	// ���� ǥ�� Ŭ������ ����
	public TrafficDecorator(Display decoratedDisplay) {
		super(decoratedDisplay);
	}

	@Override
	public void draw() {
		super.draw(); // ������ ���� ǥ�� ����� ����
		drawTraffic(); // �߰������� ���뷮�� ǥ��
	}

	// ���뷮 ǥ�� ��ɸ� ���� ����
	private void drawTraffic() {
		System.out.println("\t���뷮 ǥ��");
	}
}