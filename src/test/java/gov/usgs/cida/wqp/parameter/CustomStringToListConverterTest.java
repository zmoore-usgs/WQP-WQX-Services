package gov.usgs.cida.wqp.parameter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;

import org.junit.Test;

public class CustomStringToListConverterTest {

	CustomStringToListConverter converter = new CustomStringToListConverter();

	@Test
	public void emptyStringTest() {
		assertNull(converter.convert(null));
		assertNull(converter.convert(""));
		assertNull(converter.convert(";;;;;"));
	}

	@Test
	public void hasNoDelimiterTest() {
		assertEquals(Arrays.asList("wow"), converter.convert("wow"));
	}

	@Test
	public void hasDelimiterTest() {
		assertEquals(Arrays.asList("wow", "this", "is", "fun"), converter.convert(" ;wow;;this;is;fun;; "));
	}

}
