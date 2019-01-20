package texpeclasses;

public class CategoryIncome{
	
	private String income_category;
	
	public CategoryIncome(String income_category){
		this.income_category = income_category;
	}
	
	public void setIncomeCategory(String income_category){
		this.income_category = income_category;
	}
	
	public String getIncomeCategory(){
		return income_category; 
	}
}