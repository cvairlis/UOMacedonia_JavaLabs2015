
public class Main {

	public static void main(String[] args) {		
		Converter euroToDollarConverter = new Converter("EurToUsdConverter",1.06869);
		Converter euroToCanadianDollarConverter = new Converter("EurToCadConverter", 1.42249);
		Converter euroToAustralianDollarConverter = new Converter("EurToAudConverter", 1.48133);
		
		euroToDollarConverter.printResult();
		euroToDollarConverter.print(100);
		euroToDollarConverter.antPrint(100);
		
		euroToCanadianDollarConverter.printResult();
		euroToCanadianDollarConverter.print(100);
		euroToCanadianDollarConverter.antPrint(100);
		
		euroToAustralianDollarConverter.printResult();
		euroToAustralianDollarConverter.print(100);
		euroToAustralianDollarConverter.antPrint(100);
	}
}
