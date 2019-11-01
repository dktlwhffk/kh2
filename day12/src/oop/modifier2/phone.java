package oop.modifier2;

public class phone {

	private String name, type, telecom;
	private int contract, money;

	void setName(String name) {
		this.name = name;
	}

	void setType(String type) {
		this.type = type;
	}

	void setTelecom(String telecom) {
		switch (telecom=telecom.toUpperCase()) {
		case "SKT": // telecom="SKT";
		case "KT": // telecom="KT";
		case "LG": // telecom="LG";
			this.telecom = telecom;
		}
	}

	void setContract(int contract) {
//		if (contract == 0 || contract == 24 || 
//			contract == 30 || contract == 36) 
//		{
//			this.contract = contract;
//		}
		switch (contract) {
		case 0:
		case 24:
		case 30:
		case 36:
			this.contract = contract;
		}
	}

	void setMoney(int money) {
		if (money < 0) {
			return;
		}
		this.money = money;
	}

	String getName() {
		return this.name;
	}

	String getType() {
		return this.type;
	}

	String getTelecom() {
		return this.telecom;
	}

	int getContract() {
		return this.contract;
	}

	int getMoney() {
		return this.money;
	}
	void set(String name, String type, String telecom, int contract, int money) 
	{		
		this.setName(name);
		this.setType(type);
		this.setTelecom(telecom);
		this.setContract(contract);
		this.setMoney(money);
	}
	void print() {
		System.out.println(this.getName());
		System.out.println(this.getType());
		System.out.println(this.getTelecom());
		System.out.println(this.getContract() + "개월");
		System.out.println(this.getMoney() + "만원");
		System.out.println();
	}
}
