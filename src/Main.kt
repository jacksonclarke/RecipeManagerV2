fun main() {
    // Initialize Values and Lists
    var again = true
    var recipes = mutableListOf<Recipe>()

    // Welcome Message
    println("Welcome to the recipe manager!")
    // MAIN loop
    while(again){
        println("Please select an option:")
        println("0. Exit")
        println("1. Create recipe")
        println("2. Display recipes")
        println("3. Save Recipes to file")
        println("4. Read Recipes from file")
        print("Selection: ")
        val input = readln()
        when (input) {
            "0" -> {
                again = false
                println("Come again!")
            }
            "1" -> {
                val recipe = Recipe()
                println("What is the name of the recipe?")
                recipe.setName(readln())
                println("What are the ingredients?")
                recipe.setIngredients(readln())
                println("What are the instructions?")
                recipe.setInstructions(readln())
                println("What is the category?")
                recipe.setCategory(readln())
                recipes.add(recipe)
                println()
            }
            "2" -> {
                recipes.forEach { recipe ->
                    println("Recipe: ${recipe.getName()}  | Category: ${recipe.getCategory()}")
                    println()
                }
            }
            "3" -> {
                println("Please enter the file name:")
                val readWrite = ReadWrite(readln())
                readWrite.writeRecipes(recipes)
                println("Recipes saved!")
                println()
            }
            "4" -> {
                println("Please enter the file name:")
                val readWrite = ReadWrite(readln())
                val loadedRecipes = readWrite.readRecipes()
                recipes = loadedRecipes.toMutableList()
                println()
            }
        }
    }


}