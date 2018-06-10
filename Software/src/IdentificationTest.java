import static org.junit.Assert.*;

import org.junit.Test;

public class IdentificationTest {

	@Test
	public void test() {

		
		Receptionist test = new Receptionist();
		boolean output= test.identification_no_validation("12345678910");//normal 11 digit
		assertEquals(true, output);
		
		 output= test.identification_no_validation("123456789101234");//wrong 15 digit
			assertEquals(false, output);
			
			output= test.identification_no_validation("12345");//wrong 5 digit
			assertEquals(false, output);
		
	}

}
