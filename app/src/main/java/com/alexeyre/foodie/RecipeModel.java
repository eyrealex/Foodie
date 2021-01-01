package com.alexeyre.foodie;

public class RecipeModel {
    private String recipeName, recipeDesc, recipeTime;
    private int recipeImage;


    public RecipeModel(String recipeName, String recipeDesc, String recipeTime, int recipeImage) {
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

    public int getRecipeImage() {
        return recipeImage;
    }
}
