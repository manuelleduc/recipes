package fr.mleduc.resteasyjackson;

import javax.persistence.Entity;

public class Recipe {
    public String title;

    public Recipe() {
    }

    public Recipe(String title) {
        this.title = title;
    }

    public Recipe(RecipeEntity e) {
        this.title = e.getTitle();
    }
}
