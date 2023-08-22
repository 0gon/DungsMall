package receipt.model;

import java.util.ArrayList;
import java.util.List;

import item.model.Item;

public class ReceiptDetail {
	private int no;
	private String item;
	private int count;
	private int price;
	private Item itemDetail;

	public ReceiptDetail(int no, String item, int count, int price) {
		super();
		this.no = no;
		this.item = item;
		this.count = count;
		this.price = price;
		this.itemDetail = null;
	}
	
	public Item getItemDetail() {
		return itemDetail;
	}

	public void setItemDetail(Item itemDetail) {
		this.itemDetail = itemDetail;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
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
		return "ReceiptDetail [no=" + no + ", item=" + item + ", count=" + count + ", price=" + price + "]";
	}

}
