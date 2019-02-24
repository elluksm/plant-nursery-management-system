package plantnursery.model;

public class Plant {
    private String title;
    private int amount;
    private PlantType type;
    private String description;

    public Plant(String title, int amount, PlantType type) {
        this.title = title;
        this.amount = amount;
        this.type = type;
        this.description = "";
    }

    public Plant(String title, int amount, PlantType type, String description) {
        this.title = title;
        this.amount = amount;
        this.type = type;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public PlantType getType() {
        return type;
    }

    public void setType(PlantType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
