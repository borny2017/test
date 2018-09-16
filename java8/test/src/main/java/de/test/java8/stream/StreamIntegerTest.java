package de.test.java8.stream;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StreamIntegerTest {
	
	private Stream<Integer> streamInteger;

	@BeforeEach
    void initBeforeEach() {
		streamInteger = Stream.of(7,1,4,3,7,2);
    }
	
	
	@Test
    void distinct() {
		Stream<Integer> streamDistinct = streamInteger.distinct();
		assertEquals(5, streamDistinct.collect(Collectors.toCollection(ArrayList::new)).size()
				);
	}
	
	@Test
    void count() {
		long count = streamInteger.count();
		assertEquals(6, count);
	}

	@Test
    void sum() {
		int sum = streamInteger.mapToInt(e -> e.intValue()).sum();
		assertEquals(24, sum);
	}


	@Test
    void average() {
		OptionalDouble optionalDouble = streamInteger.mapToInt(e -> e.intValue()).average();
		assertEquals("4.0", String.valueOf(optionalDouble.getAsDouble()));
	}
}
