package de.mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

@RunWith(MockitoJUnitRunner.class)
public class ServiceImplMockApiTest {

	@Mock
	private Service service;

	@Before
	public void setUp() {
		// Create an instance of ApplicantQueue
		service = mock(Service.class);

	}

	@Test
	public void testExecute() throws Exception {
		when(service.execute()).thenAnswer(new Answer<Result>() {
			@Override
			public Result answer(InvocationOnMock invocation) throws Throwable {

				Result result = new Result();
				result.setErrorCode(2);
				result.setMessage("Error 2 occured");
				return result;
			}
		});

		assertEquals(service.execute().getErrorCode(), 2);
		assertFalse(service.verify());
	}
	
	@Test
	public void testVerify() throws Exception {
		when(service.verify()).thenReturn(true);
		assertTrue(service.verify());
	}

}
