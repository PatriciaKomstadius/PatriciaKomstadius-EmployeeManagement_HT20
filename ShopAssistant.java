public class ShopAssistant extends Employee {
    private int salesLevel;

    public ShopAssistant(String name, String gender, String id, double salary, int salesLevel) {
        super(name, gender, id, salary);
        this.salesLevel = salesLevel;
    }

    public int getSalesLevel() {
        return salesLevel;
    }

    public void setSalesLevel(int salesLevel) {
        this.salesLevel = salesLevel;
    }



    @Override
    public String toString() {
        return super.toString() + ", Title: Shop Assistant, Sales level: " + salesLevel;
    }
}
