package com.BarShelf.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cocktail {
	@Id
	@Column(length = 50)
	private String name;
	@Column(columnDefinition = "TEXT")
	private String image;
	@Column(columnDefinition = "BOOLEAN")
	private Boolean alcoholic;
	@Column(columnDefinition = "TEXT")
	private String instructions;
//	@ElementCollection
//    @MapKeyJoinColumn(name="ingredient_NAME")
//    @Column(name="measure", length=50)
//    @CollectionTable(name="ingredient_measures")
//    private Map<Ingredient, String> ingredientmeasures = new HashMap<Ingredient, String>();
//		

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Boolean getAlcoholic() {
		return alcoholic;
	}

	public void setAlcoholic(Boolean alcoholic) {
		this.alcoholic = alcoholic;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

}
