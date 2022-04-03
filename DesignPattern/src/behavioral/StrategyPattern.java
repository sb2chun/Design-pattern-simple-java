package behavioral;

public class StrategyPattern {
	public static void main(String[] args) {
		Robot taekwonV = new TaekwonV("TaekwonV");
		Robot atom = new Atom("Atom");

		taekwonV.setMovingStrategy(new WalkingStrategy());
		taekwonV.setAttackStrategy(new MissileStrategy());

		atom.setMovingStrategy(new WalkingStrategy()); // �̵� ������ ���ư��ٴ� �������� ����
		atom.setAttackStrategy(new PunchStrategy()); // ���� ������ ��ġ�� �����ϴ� �������� ����

		System.out.println("My name is " + taekwonV.getName());
		taekwonV.move();
		taekwonV.attack();

		System.out.println();

		System.out.println("My name is " + atom.getName());
		atom.move();
		atom.attack();
	}
}

abstract class Robot{
    private String name;
    private MovingStrategy movingStrategy;
    private AttackStrategy attackStrategy;
    
    public Robot(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void move(){
        movingStrategy.move();
    }
    
    public void attack(){
        attackStrategy.attack();
    }
    
    public void setMovingStrategy(MovingStrategy movingStrategy){
        this.movingStrategy = movingStrategy;
    }
    
    public void setAttackStrategy(AttackStrategy attackStrategy){
        this.attackStrategy = attackStrategy;
    }
}

// Atom Ŭ����
class Atom extends Robot {
	public Atom(String name) {
		super(name);
	}
}

// TaekwonV Ŭ����
class TaekwonV extends Robot {
	public TaekwonV(String name) {
		super(name);
	}
}

// MovingStrategy �������̽�
interface MovingStrategy {
	public void move();
}

// FlyingStrategy ����ü
class FlyingStrategy implements MovingStrategy {
	public void move() {
		System.out.println("I can fly.");
	}
}

// WalkingStrategy ����ü
class WalkingStrategy implements MovingStrategy {
	public void move() {
		System.out.println("I can only walk.");
	}
}

// AttackStrategy �������̽�
interface AttackStrategy {
	public void attack();
}

// MissileStrategy ����ü
class MissileStrategy implements AttackStrategy {
	public void attack() {
		System.out.println("I have Missile and can attack with it.");
	}
}

class PunchStrategy implements AttackStrategy {
	public void attack() {
		System.out.println("I have strong punch and can attack with it.");
	}
}
