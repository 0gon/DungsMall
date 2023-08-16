package item.model;

public class Item {
	private String name;
	private String descript;
	private int price;
	private String img;
	private String origin;
	private int weight;
	private String unit;
	
	public Item(String name, int price, String img) {
		super();
		this.name = name;
		this.price = price;
		this.img = img;
	}

	public Item(String name, String descript, int price, String img, String origin, int weight, String unit) {
		super();
		this.name = name;
		this.descript = descript;
		this.price = price;
		this.img = img;
		this.origin = origin;
		this.weight = weight;
		this.unit = unit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "Item [name=" + name + ", descript=" + descript + ", price=" + price + ", img=" + img + ", origin="
				+ origin + ", weight=" + weight + ", unit=" + unit + "]";
	}
	
	
}
