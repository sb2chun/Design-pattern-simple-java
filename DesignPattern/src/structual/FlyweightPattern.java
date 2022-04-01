package structual;

import java.util.Map;
import java.util.TreeMap;

public class FlyweightPattern {
	public static void main(String[] args) {
		FlyWeightFactory flyWeightFactory = new FlyWeightFactory();
		FlyWeight flyWeight = flyWeightFactory.getFlyWeight("AA");
		System.out.println(flyWeight);

		flyWeight = flyWeightFactory.getFlyWeight("AA");
		System.out.println(flyWeight);

		flyWeight = flyWeightFactory.getFlyWeight("AA");
		System.out.println(flyWeight);

		flyWeight = flyWeightFactory.getFlyWeight("BB");
		System.out.println(flyWeight);

		flyWeight = flyWeightFactory.getFlyWeight("AA");
		System.out.println(flyWeight);
	}
}

//FlyWeight
class FlyWeight {
	private String data;

	public FlyWeight(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}
}

//FlyWeightFactory
class FlyWeightFactory {
	private Map<String, FlyWeight> pool;

	public FlyWeightFactory() {
		this.pool = new TreeMap<>();
	}

	public FlyWeight getFlyWeight(String key) {
		FlyWeight flyWeight = pool.get(key);
		if (flyWeight != null && pool.containsKey(key)) {
			System.out.println("재 사용" + key.getClass().getName());
		} else {
			flyWeight = new FlyWeight(key);
			pool.put(key, flyWeight);
			System.out.println("새로 생성" + key.getClass().getName());
		}
		return flyWeight;
	}
}
