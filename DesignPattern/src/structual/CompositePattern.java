package structual;

import java.util.ArrayList;
import java.util.List;

public class CompositePattern {
	public static void main(String[] args) {
		// 컴퓨터의 부품으로 Keyboard, Body, Monitor 객체를 생성
		Keyboard keyboard = new Keyboard(5, 2);
		Body body = new Body(100, 70);
		Monitor monitor = new Monitor(20, 30);

		// Computer 객체를 생성하고 addComponent()를 통해 부품 객체들을 설정
		Computer computer = new Computer();
		computer.addComponent(keyboard);
		computer.addComponent(body);
		computer.addComponent(monitor);

		// 컴퓨터의 가격과 전력 소비량을 구함
		int computerPrice = computer.getPrice();
		int computerPower = computer.getPower();
		System.out.println("Computer Price: " + computerPrice + "만원");
		System.out.println("Computer Power: " + computerPower + "W");
	}
}

abstract class ComputerDevice {
	public abstract int getPrice();

	public abstract int getPower();
}

class Keyboard extends ComputerDevice {
	private int price;
	private int power;

	public Keyboard(int power, int price) {
		this.power = power;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public int getPower() {
		return power;
	}
}

class Body extends ComputerDevice{
	private int price;
	private int power;

	public Body(int power, int price) {
		this.power = power;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public int getPower() {
		return power;
	}
}

class Monitor extends ComputerDevice{
	private int price;
	private int power;

	public Monitor(int power, int price) {
		this.power = power;
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public int getPower() {
		return power;
	}
}

class Computer extends ComputerDevice {
	// 복수 개의 ComputerDevice 객체를 가리킴
	private List<ComputerDevice> components = new ArrayList<ComputerDevice>();

	// ComputerDevice 객체를 Computer 클래스에 추가
	public void addComponent(ComputerDevice component) {
		components.add(component);
	}

	// ComputerDevice 객체를 Computer 클래스에서 제거
	public void removeComponent(ComputerDevice component) {
		components.remove(component);
	}

	// 전체 가격을 포함하는 각 부품의 가격을 합산
	public int getPrice() {
		int price = 0;
		for (ComputerDevice component : components) {
			price += component.getPrice();
		}
		return price;
	}

	// 전체 소비 전력량을 포함하는 각 부품의 소비 전력량을 합산
	public int getPower() {
		int power = 0;
		for (ComputerDevice component : components) {
			power += component.getPower();
		}
		return power;
	}
}
