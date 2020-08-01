package service;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installment;

public class ContractService {

	private Payment payment;
	
	public ContractService() {
		
	}
	public ContractService(Payment payment) {
		this.payment  = payment;
	}
	public void processContract(Contract contract,Integer months) {
			double parcel = contract.getTotalValue()/months;
			for(int i = 1;i<=months;i++) {
				Date date = addMonths(contract.getDate(),i);
				double updParcel = parcel + payment.simpleInterest(parcel,i);
				double fullParcel = updParcel + payment.tax(updParcel);
				contract.addInstallments(new Installment(date, fullParcel) );
			}
		}
	private Date addMonths(Date date,int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH,n);
		return cal.getTime();
	}
		
	}

