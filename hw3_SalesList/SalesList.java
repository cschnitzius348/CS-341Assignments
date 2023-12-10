package sept13_SalesList;

import java.util.ArrayList;

public class SalesList {
	private ArrayList<SalesItem> allItems;
	
	public SalesList() {
		allItems = new ArrayList<SalesItem>();
	}
	
	public void addNewItem(SalesItem item) {
		allItems.add(item);
	}
	
	public String getSalesList() {
		String str = "";
		for (int i = 0; i < allItems.size(); i++) {
			str += allItems.get(i).toString() + "\n";		//makes new line
		}
		return str;
	}
	
	public Double computeTotal() {
		double totalCost = 0;
		for (int i = 0; i < allItems.size(); i++) {
			totalCost += allItems.get(i).getItemTotal();
		}
		return totalCost;
	}
}
