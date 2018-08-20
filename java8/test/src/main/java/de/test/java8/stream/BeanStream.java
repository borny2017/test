package de.test.java8.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BeanStream {

	public static void main(String[] args) {
		List<TransactionBean> transactions = new ArrayList<>(); 
		TransactionBean transactionBean1 = new TransactionBean();
		transactionBean1.setId(1);
		transactionBean1.setType(Transaction.GROCERY);
		transactionBean1.setValue("r1");
		transactions.add(transactionBean1);
		transactionBean1 =  new TransactionBean();
		transactionBean1.setId(2);
		transactionBean1.setType(Transaction.Test);
		transactionBean1.setValue("r2");
		transactions.add(transactionBean1);
		transactionBean1 =  new TransactionBean();
		transactionBean1.setId(3);
		transactionBean1.setType(Transaction.GROCERY);
		transactionBean1.setValue("r3");
		
		transactions.add(transactionBean1);
		List<TransactionBean> groceryTransactions = new ArrayList<>();
		for(TransactionBean t: transactions){
		  if(t.getType() == Transaction.GROCERY){
		    groceryTransactions.add(t);
		  }
		}
		Collections.sort(groceryTransactions, new Comparator<TransactionBean>(){
		  public int compare(TransactionBean t1, TransactionBean t2){
		    return t2.getValue().compareTo(t1.getValue());
		  }


		});
		List<Integer> transactionIds = new ArrayList<>();
		for(TransactionBean t: groceryTransactions){
			transactionIds.add(t.getId());
		}

	}

}
