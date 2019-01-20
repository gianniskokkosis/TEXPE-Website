package texpeclasses;


public class Expenses{

	//variables
	private String expDate;
	private float expAmount;
	private String expCategory;
	private String expDescription;
	private String username;

	//Constructor
	public Expenses(String expDate, float expAmount, String expCategory, String expDescription,String username){
		this.expDate = expDate;
		this.expAmount = expAmount;
		this.expCategory = expCategory;
		this.expDescription = expDescription;
		this.username = username;
	}
	//seters
	public void setExpensesDate(String expDate){
		this.expDate = expDate;
	}
	public void setExpensesAmount(float expAmount){
		this.expAmount = expAmount;
	}
	public void setExpensesCategory(String expCategory){
		this.expCategory = expCategory;
	}
	public void setExpensesDescription(String expDescription){
		this.expDescription = expDescription;
	}
	public void setUsername(String username){
		this.username = username;
	}
	//geters
	public String getExpensesDate(){
		return expDate;
	}
	public float getExpensesAmount(){
		return expAmount;
	}
	public String getExpensesCategory(){
		return expCategory;
	}
	public String getExpensesDescription(){
		return expDescription;
	}
	public String getUsername(){
		return username;
	}
	//toString
	public String toString() {
        return "expenses Date = " + expDate + "|| expenses Amount = " + expAmount + "|| expenses Category = " + expCategory + "|| expenses Description = " + expDescription;
    }
}