package de.mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class ServiceImplMockAnnotationTest {

	private Service service;

	@Before
	public void setUp() {
		// Create an instance of ApplicantQueue
		service = mock(Service.class);
		when(service.execute()).thenAnswer(new Answer<Result>() {
			@Override
			public Result answer(InvocationOnMock invocation) throws Throwable {

				Result result = new Result();
				result.setErrorCode(2);
				result.setMessage("Error 2 occured");
				return result;
			}
		});

	}

	@Test
	public void testExecute() throws Exception {
		assertEquals(service.execute().getErrorCode(), 2);
		assertFalse(service.verify());
	}
}
