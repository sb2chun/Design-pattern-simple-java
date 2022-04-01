package structual;

import java.util.ArrayList;
import java.util.List;

public class CompositePattern {
	public static void main(String[] args) {
		// ��ǻ���� ��ǰ���� Keyboard, Body, Monitor ��ü�� ����
		Keyboard keyboard = new Keyboard(5, 2);
		Body body = new Body(100, 70);
		Monitor monitor = new Monitor(20, 30);

		// Computer ��ü�� �����ϰ� addComponent()�� ���� ��ǰ ��ü���� ����
		Computer computer = new Computer();
		computer.addComponent(keyboard);
		computer.addComponent(body);
		computer.addComponent(monitor);

		// ��ǻ���� ���ݰ� ���� �Һ��� ����
		int computerPrice = computer.getPrice();
		int computerPower = computer.getPower();
		System.out.println("Computer Price: " + computerPrice + "����");
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
	// ���� ���� ComputerDevice ��ü�� ����Ŵ
	private List<ComputerDevice> components = new ArrayList<ComputerDevice>();

	// ComputerDevice ��ü�� Computer Ŭ������ �߰�
	public void addComponent(ComputerDevice component) {
		components.add(component);
	}

	// ComputerDevice ��ü�� Computer Ŭ�������� ����
	public void removeComponent(ComputerDevice component) {
		components.remove(component);
	}

	// ��ü ������ �����ϴ� �� ��ǰ�� ������ �ջ�
	public int getPrice() {
		int price = 0;
		for (ComputerDevice component : components) {
			price += component.getPrice();
		}
		return price;
	}

	// ��ü �Һ� ���·��� �����ϴ� �� ��ǰ�� �Һ� ���·��� �ջ�
	public int getPower() {
		int power = 0;
		for (ComputerDevice component : components) {
			power += component.getPower();
		}
		return power;
	}
}
