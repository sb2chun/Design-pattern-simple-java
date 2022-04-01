package reponsibility;

public class ChainOfResponsibilityPattern {
	private DispenseChain c1;

	public ChainOfResponsibilityPattern() {
		this.c1 = new Won100Dispenser();
		DispenseChain c2 = new Won10Dispenser();
		DispenseChain c3 = new Won1Dispenser();

		c1.setNextChain(c2);
		c2.setNextChain(c3);
	}

	public static void main(String[] args) {
		ChainOfResponsibilityPattern atmDispenser = new ChainOfResponsibilityPattern();
		atmDispenser.c1.dispense(new Currency(378));
	}
}

interface DispenseChain {
	void setNextChain(DispenseChain nextChain);

	void dispense(Currency cur);
}

class Currency {
	private int amount;

	public Currency(int amt) {
		this.amount = amt;
	}

	public int getAmount() {
		return this.amount;
	}
}

class Won100Dispenser implements DispenseChain {
	private DispenseChain chain;

	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void dispense(Currency cur) {
		if (cur.getAmount() >= 100) {
			int num = cur.getAmount() / 100;
			int remainder = cur.getAmount() % 100;

			System.out.println("Dispensing " + num + " 100₩ note");

			if (remainder != 0)
				this.chain.dispense(new Currency(remainder));
		} else
			this.chain.dispense(cur);
	}
}

class Won10Dispenser implements DispenseChain {
	private DispenseChain chain;

	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void dispense(Currency cur) {
		if (cur.getAmount() >= 10) {
			int num = cur.getAmount() / 10;
			int remainder = cur.getAmount() % 10;

			System.out.println("Dispensing " + num + " 10₩ note");

			if (remainder != 0)
				this.chain.dispense(new Currency(remainder));
		} else
			this.chain.dispense(cur);
	}
}

class Won1Dispenser implements DispenseChain {
	private DispenseChain chain;

	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void dispense(Currency cur) {
		int num = cur.getAmount() / 1;
		System.out.println("Dispensing " + num + " 1₩ note");
	}
}
