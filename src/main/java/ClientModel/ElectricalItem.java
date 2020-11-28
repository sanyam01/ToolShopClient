package ClientModel;

public class ElectricalItem extends Items {

	private String powerType;

	public ElectricalItem() {
		super();
	}

	public ElectricalItem(int itemID, String itemName, int itemQuantity, float itemPrice, String itemType,
			int supplierID, String powerType) {
		
		super(itemID, itemName, itemQuantity, itemPrice, itemType, supplierID);
		
		this.powerType = powerType;


	}

	public String getPowerType() {
		return powerType;
	}

	public void setPowerType(String powerType) {
		this.powerType = powerType;
	}

	private static final long serialVersionUID = 1L;

}
