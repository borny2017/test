package de.test.java8.stream;

import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BeanStreamTest {
	
	List<TransactionBean> transactions; 
	
	@BeforeEach
    void initBeforeEach() {
		transactions = new ArrayList<>(); 
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
    }

	/**
	 * Multi-Filter 
	 * 1. Filter TransactionBean.type == Transaction.GROCERY
	 * 2. Filter TransactionBean.value == "r3"
	 */
	@Test
    void multiLevelFilter() {
		Stream<TransactionBean> transactionBeanStream = transactions.stream().filter(t -> t.getType() == Transaction.GROCERY).filter(t -> "r3".equals(t.getValue()));
		List<TransactionBean> afterStreamList = transactionBeanStream.peek(System.out::println).collect(Collectors.toCollection(ArrayList::new));
		assertSame("wrong type", Transaction.GROCERY, afterStreamList.get(0).getType());
		assertSame("wrong value", "r3", afterStreamList.get(0).getValue());
    }
	
	/**
	 * Single Filter 
	 * Filter TransactionBean.type == Transaction.GROCERY
	 */
	@Test
    void filterMethod() {
		Stream<TransactionBean> transactionBeanStream = transactions.stream().filter(t -> t.getType() == Transaction.GROCERY);
		List<TransactionBean> afterStreamList = transactionBeanStream.peek(System.out::println).collect(Collectors.toCollection(ArrayList::new));
		assertSame("wrong type", Transaction.GROCERY, afterStreamList.get(0).getType());
		assertSame("wrong type", Transaction.GROCERY, afterStreamList.get(1).getType());
    }
	
	/**
	 * Limits the original stream (3 items ) to a list with 2 items
	 */
	@Test
    void limitMethod() {
		Stream<TransactionBean> transactionBeanStream = transactions.stream().limit(2);
		List<TransactionBean> afterStreamList = transactionBeanStream.peek(System.out::println).collect(Collectors.toCollection(ArrayList::new));
		assertSame("wrong type", 2, afterStreamList.size());
    }
	
	/**
	 * Skips/remove the first item. 
	 */
	@Test
    void skipMethod() {
		// Überspringt 2 Datensaetze
		Stream<TransactionBean> transactionBeanStream = transactions.stream().skip(1);
		List<TransactionBean> afterStreamList = transactionBeanStream.peek(System.out::println).collect(Collectors.toCollection(ArrayList::new));
		// 1 Datensatz ist noch uebrig
		assertSame("wrong type", 1, afterStreamList.size());
    }
	
	/**
	 * Converts a stream to a list.
	 */
	@Test
    void convertStreamBean2ListMethod() {
		Stream<TransactionBean> transactionBeanStream = transactions.stream();
		List<TransactionBean> afterStreamList = transactionBeanStream.peek(System.out::println).collect(Collectors.toCollection(ArrayList::new));
		assertSame("wrong type", Transaction.GROCERY, afterStreamList.get(0).getType());
		assertSame("wrong type", Transaction.Test, afterStreamList.get(1).getType());
		assertSame("wrong type", Transaction.GROCERY, afterStreamList.get(2).getType());
    }

	/**
	 * Converts a stream of beans to a String-Bean-map. 
	 */
	@Test
    void convertStreamBean2MapMethod() {
		Stream<TransactionBean> transactionBeanStream = transactions.stream();
		// Convert stream -> Map<Object, Object> -> Map<String, TransactionBean>
		Map<String, TransactionBean> afterStreamMap = (Map<String, TransactionBean>)transactionBeanStream.peek(System.out::println).collect(Collectors.toMap(p -> p.getValue(), p -> p));
		assertSame("wrong type", Transaction.GROCERY, afterStreamMap.get("r1").getType());
		assertSame("wrong type", Transaction.Test, afterStreamMap.get("r2").getType());
		assertSame("wrong type", Transaction.GROCERY, afterStreamMap.get("r3").getType());
    }
	
	/**
	 * Convert a stream of beans to a stream of integer
	 */
	@Test
	void mapMethod() {
		Stream<TransactionBean> transactionBeanStream = transactions.stream();
		Stream<Integer> streamInteger = transactionBeanStream.peek(System.out::println).map(TransactionBean::getId);
		List<Integer> afterStreamList = streamInteger.peek(System.out::println).collect(Collectors.toCollection(ArrayList::new));
		assertSame("wrong value", 1, afterStreamList.get(0).intValue());
		assertSame("wrong value", 2, afterStreamList.get(1).intValue());
		assertSame("wrong value", 3, afterStreamList.get(2).intValue());
	}
	

	/**
	 * Convert a stream of beans to a stream of integer
	 */
	@Test
	void mapLMethod() {
		Map<String, List<TransactionBean>> postsPerType = transactions.stream()
                .collect(Collectors.groupingBy(TransactionBean::getValue));
		System.out.println(postsPerType);

	}
	
}
