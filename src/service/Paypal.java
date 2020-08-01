package service;

public class Paypal implements Payment{

 
	public Double simpleInterest(Double amount,Integer months) {
		 return (amount/100*months) ;
	}

	public Double tax(Double amount) {
		
		return (amount/100*2) ;
	}

	
}
