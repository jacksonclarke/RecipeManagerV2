import java.io.File

class ReadWrite(private val fileName: String) {

    // Write the recipes to a txt file.
    fun writeRecipes(recipes: List<Recipe>) {
        File(fileName).printWriter().use { out ->
            recipes.forEach { recipe ->
                out.println("Name: ${recipe.getName()}")
                out.println("Ingredients: ${recipe.getIngredients()}")
                out.println("Instructions: ${recipe.getInstructions()}")
                out.println("Category: ${recipe.getCategory()}")
                out.println() // Blank line between recipes
            }
        }
    }

    // Read the recipes from a txt file.
    fun readRecipes(): List<Recipe> {
        val recipes = mutableListOf<Recipe>()
        val lines = File(fileName).readLines()
        var currentRecipe = Recipe()

        lines.forEach { line ->
            when {
                line.startsWith("Name: ") -> {
                    if (currentRecipe.getName().isNotEmpty()) {
                        recipes.add(currentRecipe)
                        currentRecipe = Recipe()
                    }
                    currentRecipe.setName(line.removePrefix("Name: "))
                }
                line.startsWith("Ingredients: ") -> {
                    currentRecipe.setIngredients(line.removePrefix("Ingredients: "))
                }
                line.startsWith("Instructions: ") -> {
                    currentRecipe.setInstructions(line.removePrefix("Instructions: "))
                }
                line.startsWith("Category: ") -> {
                    currentRecipe.setCategory(line.removePrefix("Category: "))
                }
                line.isBlank() -> {
                    if (currentRecipe.getName().isNotEmpty()) {
                        recipes.add(currentRecipe)
                        currentRecipe = Recipe()
                    }
                }
            }
        }
        if (currentRecipe.getName().isNotEmpty()) {
            recipes.add(currentRecipe)
        }
        return recipes
    }
}
