package mihajlovic.jelena.menuCalculator;

public class Items {

	private String name;
	private float price;

	public Items(String name, float price) {
		this.name = name;
		this.price = price;
	}

	public float getPrice() {
		return this.price;
	}

	public String getName() {
		return this.name;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("%s - %.2f$", name, price);
	}
}
