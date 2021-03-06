
package com.elina.acnspring.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Plant {
	
	@Id
	@GeneratedValue
	private Long id;
    private String title;
    private int amount;
    private PlantType type;
    private String description;

	public Plant() {
		super();
	}
	
    public Plant(Long id, String title, int amount, PlantType type, String description) {
		super();
    	this.id = id;
        this.title = title;
        this.amount = amount;
        this.type = type;
        this.description = (description == null ||description.isEmpty()?"":description);
    }

    public Plant(String title, int amount, PlantType type, String description) {
    	super();
        this.title = title;
        this.amount = amount;
        this.type = type;
        this.description = (description == null ||description.isEmpty()?"":description);
    }
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

    @Override
	public String toString() {
		return String.format("Plant [id=%s, title=%s, type=%s, ammount=%s, description=%s]", id, title, type,amount,description);
	}
    
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Plant plant = (Plant) o;
		return Objects.equals(id, plant.id) &&
				Objects.equals(title, plant.title) &&
				Objects.equals(amount, plant.amount) &&
				Objects.equals(type, plant.type) &&
				Objects.equals(description, plant.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, amount, type, description );
	}
	
}
