package de.mockito;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Test;

public class ListTest {
	@SuppressWarnings("unchecked")
    @Test
    public void testInvocations() throws Exception {
        List<String> mock = (List<String>) mock(List.class);
        mock.add("first element");
        mock.add("second element");
        verify(mock, times(2)).add(anyString());
        verify(mock, never()).add("third element");
    }
}
