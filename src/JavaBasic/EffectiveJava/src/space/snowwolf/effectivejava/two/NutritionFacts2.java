package space.snowwolf.effectivejava.two;

//JavaBeans Pattern - allows inconsistency, mandates mutability
@SuppressWarnings("unused")
public class NutritionFacts2 {
	//paramters initialized to default values (if any)
	private int servingSize = -1;	//required; no default value
	private int servings = -1;	//required; no default value
	private int calories = 0;
	private int fat = 0;
	private int sodium = 0;
	private int carbohydrate = 0;
	
	
	public NutritionFacts2() {
		
	}

	//setters
	public void setServingSize(int servingSize) {
		this.servingSize = servingSize;
	}
	public void setServings(int servings) {
		this.servings = servings;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public void setFat(int fat) {
		this.fat = fat;
	}
	public void setSodium(int sodium) {
		this.sodium = sodium;
	}
	public void setCarbohydrate(int carbohydrate) {
		this.carbohydrate = carbohydrate;
	}
	
	public static void main(String[] args) {
		NutritionFacts2 cocaCola = new NutritionFacts2();
		cocaCola.setServingSize(240);
		cocaCola.setServings(8);
		cocaCola.setCalories(100);
		cocaCola.setSodium(35);
		cocaCola.setCarbohydrate(27);
	}
}