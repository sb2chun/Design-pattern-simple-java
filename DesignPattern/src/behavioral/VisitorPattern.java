package behavioral;

public class VisitorPattern {
	public static void main(String[] args) {
		Member goldMember = new GoldMember();
		Member vipMember = new VipMember();
		Benefit pointBenefit = new PointBenefit();
		Benefit discountBenefit = new DiscountBenefit();
		Benefit freeRentBenefit = new FreeRentBenefit();

		goldMember.getBenefit(pointBenefit);
		vipMember.getBenefit(pointBenefit);
		goldMember.getBenefit(discountBenefit);
		vipMember.getBenefit(discountBenefit);
		goldMember.getBenefit(freeRentBenefit);
		vipMember.getBenefit(freeRentBenefit);
	}
}

interface Benefit {
	void getBenefit(GoldMember member);

	void getBenefit(VipMember member);
}

class DiscountBenefit implements Benefit {
	@Override
	public void getBenefit(GoldMember member) {
		System.out.println("Discount for Gold Member");
	}

	@Override
	public void getBenefit(VipMember member) {
		System.out.println("Discount for Vip Member");
	}
}

class PointBenefit implements Benefit {
	@Override
	public void getBenefit(GoldMember member) {
		System.out.println("Point for Gold Member");
	}

	@Override
	public void getBenefit(VipMember member) {
		System.out.println("Point for Vip Member");
	}
}

interface Member {
	void getBenefit(Benefit benefit);
}

class GoldMember implements Member {
	@Override
	public void getBenefit(Benefit benefit) {
		benefit.getBenefit(this);
	}
}

class VipMember implements Member {
	@Override
	public void getBenefit(Benefit benefit) {
		benefit.getBenefit(this);
	}
}

//added Funciton

class FreeRentBenefit implements Benefit {
	@Override
	public void getBenefit(GoldMember member) {
		System.out.println("FreeRent for Gold Member");
	}

	@Override
	public void getBenefit(VipMember member) {
		System.out.println("FreeRent for Vip Member");
	}
}