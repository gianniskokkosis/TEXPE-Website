package texpeclasses;

import static java.lang.System.*;
public class Income{

	//variables
	private String incomeDate;
	private float incomeAmount;
	private String incomeCategory;
	private String incomeDescription;
	private String username;

	//Constructor
	public Income(String incomeDate, float incomeAmount, String incomeCategory, String incomeDescription,String username){
		this.incomeDate = incomeDate;
		this.incomeAmount = incomeAmount;
		this.incomeCategory = incomeCategory;
		this.incomeDescription = incomeDescription;
		this.username = username;
	}
	//seters
	public void setIncomeDate(String incomeDate){
		this.incomeDate = incomeDate;
	}
	public void setIncomeAmount(float incomeAmount){
		this.incomeAmount = incomeAmount;
	}
	public void setIncomeCategory(String incomeCategory){
		this.incomeCategory = incomeCategory;
	}
	public void setIncomeDescription(String incomeDescription){
		this.incomeDescription = incomeDescription;
	}
	public void setUsername(String username){
		this.username = username;
	}
	//geters
	public String getIncomeDate(){
		return incomeDate;
	}
	public float getIncomeAmount(){
		return incomeAmount;
	}
	public String getIncomeCategory(){
		return incomeCategory;
	}
	public String getIncomeDescription(){
		return incomeDescription;
	}
	public String getUsername(){
		return username;
	}
	//toString
	public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(incomeDate).append(System.getProperty("line.separator"));
    sb.append(incomeAmount).append(System.getProperty("line.separator"));
	    sb.append(incomeCategory).append(System.getProperty("line.separator"));
	    sb.append(incomeDescription).append(System.getProperty("line.separator"));
	    return sb.toString();
}
}

//toString
//	public String toString() {
  //      return "Income Date = " + incomeDate + "\n" + " Income Amount = " + incomeAmount + "Category = " + incomeCategory + "Description = " + incomeDescription ;
 //  }
 //  }


