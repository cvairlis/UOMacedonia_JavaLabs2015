package askPolynom;

import java.text.DecimalFormat;

public class Term {
	
	private double syntelesths;
	private int vathmos;
	DecimalFormat df = new DecimalFormat("+#,#0.00;-#"); 
	DecimalFormat df2 = new DecimalFormat("##");
	
	public Term(double syntelesths, int vathmos) {
		if (vathmos == 0){
			System.out.println("Den epitrepontai oroi mhdenikou vathmou!");			
		} else {
			this.syntelesths = syntelesths;
			this.vathmos = vathmos;
		}		
	}

	public double getSyntelesths() {
		return syntelesths;
	}

	public void setSyntelesths(double syntelesths) {
		this.syntelesths = syntelesths;
	}

	public int getVathmos() {
		return vathmos;
	}

	public void setVathmos(int vathmos) {
		this.vathmos = vathmos;
	}

	@Override
	public String toString() {
		if (syntelesths==1){
			if (vathmos ==1){
				return "+x";
			} else {
				return "+x^" + vathmos;
			}			
		} else if (syntelesths ==-1){
			if (vathmos ==1){
				return "-x";
			} else {
				return "-x^" + vathmos;
			}					
		} else {
			return df.format(syntelesths)  + "x^" + vathmos;
		}
	}
	
	public double addEquivalentTerm(Term t){
		return syntelesths + t.syntelesths;
	}
	
	public double calculateTerm(int x){
		//long retValue = Math.multiplyExact(Double.doubleToLongBits(syntelesths), Double.doubleToLongBits(Math.pow(x, vathmos)));
		// another way: long retValue = Math.round(syntelesths*(Math.pow(x, vathmos)));
		int retValue = (int) (syntelesths*(Math.pow(x, vathmos)));
		return retValue;
	}
	
	public Term sygkrishOrwn(Term t){		
		if (vathmos>t.vathmos){
			return this;			
		} else if (vathmos<t.vathmos){
			return t;
		} else {
			return this;
		}		
	}
	
	public boolean einaiIsovathmioi(Term t){		
		if (vathmos==t.vathmos){
			return true;
		} else {
			return false;
		}		
	}	

}
