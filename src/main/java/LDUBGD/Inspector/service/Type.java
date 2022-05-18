package LDUBGD.Inspector.service;

public enum Type {

	Виробничі_складські(1), Громадські(2), Житлові(3), Гаражі_автомайстерні(4), Колісні_ТЗ(5);

	private final int id;

	private Type(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
