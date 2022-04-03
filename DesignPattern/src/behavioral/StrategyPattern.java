package behavioral;

public class StrategyPattern {
	public static void main(String[] args) {
		Robot taekwonV = new TaekwonV("TaekwonV");
		Robot atom = new Atom("Atom");

		taekwonV.setMovingStrategy(new WalkingStrategy());
		taekwonV.setAttackStrategy(new MissileStrategy());

		atom.setMovingStrategy(new WalkingStrategy()); // 이동 전략을 날아간다는 전략으로 설정
		atom.setAttackStrategy(new PunchStrategy()); // 공격 전략을 펀치를 구사하는 전략으로 설정

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

// Atom 클래스
class Atom extends Robot {
	public Atom(String name) {
		super(name);
	}
}

// TaekwonV 클래스
class TaekwonV extends Robot {
	public TaekwonV(String name) {
		super(name);
	}
}

// MovingStrategy 인터페이스
interface MovingStrategy {
	public void move();
}

// FlyingStrategy 구현체
class FlyingStrategy implements MovingStrategy {
	public void move() {
		System.out.println("I can fly.");
	}
}

// WalkingStrategy 구현체
class WalkingStrategy implements MovingStrategy {
	public void move() {
		System.out.println("I can only walk.");
	}
}

// AttackStrategy 인터페이스
interface AttackStrategy {
	public void attack();
}

// MissileStrategy 구현체
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
