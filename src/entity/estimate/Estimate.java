package entity.estimate;


import entity.estimate_item.EstimateItem;
import java.time.LocalDate;
import java.util.ArrayList;


public class Estimate {

    private int id;
    private LocalDate date;
    private ArrayList<EstimateItem> items;
    private float taxable;
    private float percentageTaxRate;
    private float total;
    
    public ArrayList<EstimateItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<EstimateItem> items) {
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getTaxable() {
        return taxable;
    }

    public void setTaxable(float taxable) {
        this.taxable = taxable;
    }

    public float getPercentageTaxRate() {
        return percentageTaxRate;
    }

    public void setPercentageTaxRate(float percentageTaxRate) {
        this.percentageTaxRate = percentageTaxRate;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
