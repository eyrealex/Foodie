package com.alexeyre.foodie;

public class RecipeModel {
    private String recipeName, recipeDesc, recipeTime, recipeImage, key;


    public RecipeModel(String recipeName, String recipeDesc, String recipeTime, String recipeImage) {
        this.recipeName = recipeName;
        this.recipeDesc = recipeDesc;
        this.recipeTime = recipeTime;
        this.recipeImage = recipeImage;
    }

    public RecipeModel() {
    }

    public String getRecipeName() {
        return recipeName;
    }

    public String getRecipeDesc() {
        return recipeDesc;
    }

    public String getRecipeTime() {
        return recipeTime;
    }

    public String getRecipeImage() { return recipeImage; }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
