package toysShop.model;

public class Prize {
    private int id;
    private String name;
    private int amount;
    private float dropoutFrequency;

    public Prize(int id, String name, int amount, float dropoutFrequency) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.dropoutFrequency = dropoutFrequency;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getDropoutFrequency() {
        return dropoutFrequency;
    }

    public void setDropoutFrequency(float dropoutFrequency) {
        this.dropoutFrequency = dropoutFrequency;
    }

    @Override
    public String toString() {
        return "id: " + id +
                "\nname: " + name +
                "\namount: " + amount +
                "\ndropoutFrequency: " + dropoutFrequency;
    }


}
