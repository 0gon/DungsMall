package basket.model;

public class BasketSub {
	private String id;
	private String name;
	private int count;
	private int price;
	
	public BasketSub(String id, String name, int count) {
		super();
		this.id = id;
		this.name = name;
		this.count = count;
	}
	
	public BasketSub(String id, String name, int count, int price) {
		super();
		this.id = id;
		this.name = name;
		this.count = count;
		this.price = price;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Basket [id=" + id + ", name=" + name + ", count=" + count + ", price = " + price + "]";
	}
	
}
