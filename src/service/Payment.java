package service;

public interface Payment {
		
	public Double simpleInterest(Double amount,Integer months);
	public Double tax(Double amount);
}
