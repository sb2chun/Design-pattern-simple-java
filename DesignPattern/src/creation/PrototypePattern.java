package creation;

import java.util.ArrayList;
import java.util.List;

public class PrototypePattern {
	public static void main(String[] args) throws CloneNotSupportedException {
		Employees emps = new Employees();
		emps.loadData(); // Ann, John, Methew...

		Employees emps1 = (Employees) emps.clone();
		Employees emps2 = (Employees) emps.clone();

		List<String> list1 = emps1.getEmpList();
		list1.add("Peter");

		List<String> list2 = emps2.getEmpList();
		list2.remove("John");

		System.out.println("emps: " + emps.getEmpList());
		System.out.println("emps1: " + list1.toString());
		System.out.println("emps2: " + list2.toString());
	}

}

//Employees.java
class Employees implements Cloneable {
	private List<String> empList;

	public Employees() {
		empList = new ArrayList<>();
	}

	public List<String> getEmpList() {
		if (empList == null) {
			return new ArrayList<String>();
		}
		return empList;
	}

	public Employees(List<String> list) {
		this.empList = list;
	}

	public void loadData() {
		empList.add("Ann");
		empList.add("David");
		empList.add("John");
		empList.add("Methew");
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		List<String> temp = new ArrayList<>();
		for (String str : this.empList) {
			temp.add(str);
		}
		return new Employees(temp);
	}
}