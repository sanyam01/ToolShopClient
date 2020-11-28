package ClientModel;

/**
 * OrderLines represents the order generated for each item. It gets added to the
 * order for that particular day
 * 
 * It includes the item name, no of items ordered, and the supplier name
 * 
 * @author Sanyam
 *
 */
public class OrderLines {

	/**
	 * item represents the items object for which order line is generated
	 */
	private Items item;

	/**
	 * amount tells the number of items ordered
	 */
	private int amount;

	/**
	 * Constructs an object of OrderLines.
	 * 
	 * @param item   represents the item object for which order line is generated
	 * @param amount tells the number of items ordered
	 * 
	 */
	public OrderLines() {
		super();
	}
	public OrderLines(Items item, int amount) {

		this.setItem(item);
		this.setAmount(amount);

	}

	public Items getItem() {
		return item;
	}

	public void setItem(Items item) {
		this.item = item;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
