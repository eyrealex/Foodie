package Helpers;

public class FoodModel {
    private String recipeName, recipeDesc, recipeTime, recipeImage;


    public FoodModel(String recipeName, String recipeDesc, String recipeTime, String recipeImage) {
        this.recipeName = recipeName;
        this.recipeDesc = recipeDesc;
        this.recipeTime = recipeTime;
        this.recipeImage = recipeImage;
    }

    public FoodModel() {
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

    public String getRecipeImage() {
        return recipeImage;
    }
}
