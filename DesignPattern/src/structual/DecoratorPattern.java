package structual;

public class DecoratorPattern {
	public static void main(String[] args) {
		Display road = new RoadDisplay();
		road.draw(); // 기본 도로 표시
		Display roadWithLane = new LaneDecorator(new RoadDisplay());
		roadWithLane.draw(); // 기본 도로 표시 + 차선 표시
		Display roadWithTraffic = new TrafficDecorator(new RoadDisplay());
		roadWithTraffic.draw(); // 기본 도로 표시 + 교통량 표시
	}

}

abstract class Display {
	public abstract void draw();
}

abstract class DisplayDecorator extends Display {
	private Display decoratedDisplay;

	// '합성(composition) 관계'를 통해 RoadDisplay 객체에 대한 참조
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
		System.out.println("기본 도로 표시");
	}
}

class LaneDecorator extends DisplayDecorator {
	// 기존 표시 클래스의 설정
	public LaneDecorator(Display decoratedDisplay) {
		super(decoratedDisplay);
	}

	@Override
	public void draw() {
		super.draw(); // 설정된 기존 표시 기능을 수행
		drawLane(); // 추가적으로 차선을 표시
	}

	// 차선 표시 기능만 직접 제공
	private void drawLane() {
		System.out.println("\t차선 표시");
	}
}

/* 교통량 표시를 추가하는 클래스 */
class TrafficDecorator extends DisplayDecorator {
	// 기존 표시 클래스의 설정
	public TrafficDecorator(Display decoratedDisplay) {
		super(decoratedDisplay);
	}

	@Override
	public void draw() {
		super.draw(); // 설정된 기존 표시 기능을 수행
		drawTraffic(); // 추가적으로 교통량을 표시
	}

	// 교통량 표시 기능만 직접 제공
	private void drawTraffic() {
		System.out.println("\t교통량 표시");
	}
}