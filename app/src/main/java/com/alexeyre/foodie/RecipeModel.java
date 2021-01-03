package com.alexeyre.foodie;

public class RecipeModel {
    private String recipeName, recipeIngredients, recipeMethod, recipeTime, recipeImage, key;


    public RecipeModel(String recipeName, String recipeIngredients, String recipeMethod, String recipeTime, String recipeImage) {
        this.recipeName = recipeName;
        this.recipeIngredients = recipeIngredients;
        this.recipeMethod = recipeMethod;
        this.recipeTime = recipeTime;
        this.recipeImage = recipeImage;
    }

    public  RecipeModel(){}


    public String getRecipeName() {
        return recipeName;
    }

    public String getRecipeIngredients() {
        return recipeIngredients;
    }

    public String getRecipeMethod() {
        return recipeMethod;
    }

    public String getRecipeTime() {
        return recipeTime;
    }

    public String getRecipeImage() {
        return recipeImage;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
