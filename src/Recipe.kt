class Recipe {
    private var name : String = ""
    private var ingredients : String = ""//MutableList<String> = arrayListOf()
    private var instructions : String = ""
    private var category : String = ""

    // Getters and Setters
    fun getName(): String{
        return this.name
    }
    fun setName(name : String){
        this.name = name
    }
    fun getIngredients(): String {// Mutable List?
        return this.ingredients
    }
    fun setIngredients(ingredientsList: String){//MutableList<String>){
        this.ingredients = ingredientsList
    }
    fun getInstructions(): String{
        return this.instructions
    }
    fun setInstructions(instructions: String){
        this.instructions = instructions
    }
    fun getCategory(): String{
        return this.category
    }
    fun setCategory(category: String){
        this.category = category
    }
}