package com.alexeyre.foodie;

public class RecipeModelClone {
    private String title, desc, ingredients, methodTitle, recipe, time;
    private int image;


    public RecipeModelClone(String title, String ingredients, String methodTitle, String recipe, String time, int image) {
        this.title = title;
        this.desc = desc;
        this.ingredients = ingredients;
        this.methodTitle = methodTitle;
        this.recipe = recipe;
        this.time = time;
        this.image = image;
    }

    public RecipeModelClone() {
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getMethodTitle() {
        return methodTitle;
    }

    public String getRecipe() {
        return recipe;
    }

    public String getTime() {
        return time;
    }

    public int getImage() {
        return image;
    }
}
