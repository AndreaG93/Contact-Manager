package entity.estimate_item;


/**
 * 
 * @author andrea
 *
 */
public class EstimateItem {

    private int id;
    private String description;
    private UnitsOfMeasurement unitsOfMeasurement;
    private double quantity;
    private double amount;
    private double total;
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public UnitsOfMeasurement getUnitsOfMeasurement() {
		return unitsOfMeasurement;
	}
	public void setUnitsOfMeasurement(UnitsOfMeasurement unitsOfMeasurement) {
		this.unitsOfMeasurement = unitsOfMeasurement;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
    
    



}
