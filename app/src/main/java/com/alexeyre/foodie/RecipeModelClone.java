package com.alexeyre.foodie;

public class RecipeModelClone {
    //variables
    private String title, ingredients, methodTitle, recipe, time;
    private int image, video;

    //constructor
    public RecipeModelClone(String title, String ingredients, String methodTitle, String recipe, String time, int image, int video) {
        this.title = title;
        this.ingredients = ingredients;
        this.methodTitle = methodTitle;
        this.recipe = recipe;
        this.time = time;
        this.image = image;
        this.video = video;
    }

    //empty constructor
    public RecipeModelClone() {
    }

    //getters
    public String getTitle() {
        return title;
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

    public int getVideo() {
        return video;
    }
}
