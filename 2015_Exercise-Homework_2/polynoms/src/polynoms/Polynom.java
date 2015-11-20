package askPolynom;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Polynom {
	
	private ArrayList<Term> terms;
	private String name;
	private double statherosOros;
	DecimalFormat df = new DecimalFormat("+#,#0.0;-#"); 
	
	public Polynom(String name, double statherosOros) {
		terms = new ArrayList<Term>();
		this.name = name;
		this.statherosOros = statherosOros;
	}

	public ArrayList<Term> getTerms() {
		return terms;
	}

	public void setTerms(ArrayList<Term> terms) {
		this.terms = terms;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getStatherosOros() {
		return statherosOros;
	}

	public void setStatherosOros(double statherosOros) {
		this.statherosOros = statherosOros;
	}
	
	public void addTerm(Term t){
		if (t.getVathmos()!=0 && t.getSyntelesths()!=0 && !terms.contains(t) ){
			terms.add(t);
		} else {
			if (t.getVathmos()==0){
				System.out.println("vrethike mhdenikos vathmos.");
			} else if (t.getSyntelesths()==0) {
				System.out.println("vrethike mhdenikos syntelestis.");
			} else if (terms.contains(t)){
				System.out.println("O oros yparxei hdh sto polyonymo.");
				System.out.println("Tha prostethoun oi syntelestes.");				
				for (Term term : terms){
					if (term.getVathmos() == t.getVathmos()){
						term.setSyntelesths(term.getSyntelesths()+t.getSyntelesths());
					}					
				}				
			}
		}		
	}
	
	public void print(){
		System.out.print(getName()+"(x) = ");
		for (Term term : terms) {
			System.out.print(term.toString()+" ");
		}
		System.out.println(df.format(getStatherosOros()));
		
	}
	
	public Polynom add(Polynom p){
		Polynom newPol = new Polynom(name+"+"+p.name, statherosOros+p.statherosOros);		
		int temp = 0;
		if (degree()>=p.degree()){
			temp = degree();
		} else if (degree()<p.degree()){
			temp = p.degree();			
		}
		for (int i = temp; i>0; i--){
			Term temp1 = find(i);
			Term temp2 = p.find(i);
			Term te1 = new Term(temp1.addEquivalentTerm(temp2), i);
			newPol.addTerm(te1);		
		}		
		return newPol;		
	}
	
	public long calculateValue(int x){
		long result = 0;
		for (Term term : terms){
			result += term.calculateTerm(x);
		}
		result += statherosOros;
		return result;
	}
	
	public void printValue(int x){		
		System.out.println(name + "("+x+") = " + calculateValue(x));
	}
	
	
	public int degree(){
		int max = 0;
		for (Term t : terms){
			if (t.getVathmos()>max){
				max = t.getVathmos();
			}
		}
		return max;
	}
	
	public Term find(int v){		
		Term t = null;
		boolean vrethike = false;
		for (Term term : terms){
			if (vrethike == false && term.getVathmos()==v){
				vrethike = true;
				t = term;												
			}					
		}		
		if (vrethike==false){
			return (new Term(0, 1));
			
		} else {
			return t;
		}		
	}
}
