package application.items;

import java.util.UUID;

public class ItemObject {

	private UUID id;
	private ItemType type;
	private int price;
	private String itemName;
	private String signature;

	public ItemObject() {
		
	}
	
	public ItemObject(ItemType type, int price, String itemName, String signature) {
		id = UUID.randomUUID();
		this.type = type;
		this.price = price;
		this.itemName = itemName;
		this.signature = signature;
	}

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	public UUID getID() {
		return id;
	}
	
}
