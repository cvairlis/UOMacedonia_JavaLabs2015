import java.text.DecimalFormat;

public class Converter {
	private String name;
	private double equiv;
	private String homeCurrencyName;
	private String foreignCurrencyName;
	private DecimalFormat df = new DecimalFormat("#.##");
	
	public Converter(String name, double equiv) {	
		this.name = name;
		this.equiv = equiv;
		homeCurrencyName = (name.substring(0, Math.min(name.length(), 3))).toUpperCase();
		foreignCurrencyName = (name.substring(5, Math.min(name.length(), 8))).toUpperCase();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getEquiv() {
		return equiv;
	}

	public void setEquiv(double equiv) {
		this.equiv = equiv;
	}

	public String getHomeCurrencyName() {
		return homeCurrencyName;
	}

	public void setHomeCurrencyName(String homeCurrencyName) {
		this.homeCurrencyName = homeCurrencyName;
	}

	public String getForeignCurrencyName() {
		return foreignCurrencyName;
	}

	public void setForeignCurrencyName(String foreignCurrencyName) {
		this.foreignCurrencyName = foreignCurrencyName;
	}
	
	public double calculate(double x) {	
		return x*equiv;
	}
	
	public double antCalculate(double x) {
		return x/equiv;
	}
	
	public void print(double x){
		System.out.println(df.format(x) + " " + getHomeCurrencyName()+" = "+df.format(calculate(x)) + " " + getForeignCurrencyName());
	}
	
	public void antPrint(double x){
		System.out.println(df.format(x) + " " + getForeignCurrencyName()+" = "+df.format(antCalculate(x)) + " " + getHomeCurrencyName());
	}
	
	public void printResult(){
		System.out.println("This is a " +getHomeCurrencyName()+" to "+getForeignCurrencyName()+" converter. The current exchange rate is "+ getEquiv() + ".");
	}
}
