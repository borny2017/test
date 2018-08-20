package de.test.java8.stream;


public class TransactionBean {
	private Transaction type;
	private String value;
	private Integer id;
	

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Transaction getType() {
		return type;
	}

	public void setType(Transaction type) {
		this.type = type;
	}
}
