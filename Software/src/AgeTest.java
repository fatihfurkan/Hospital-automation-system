import static org.junit.Assert.*;

import org.junit.Test;

public class AgeTest {

	@Test
	public void test() {
		
		Receptionist test = new Receptionist();
		boolean output= test.age_validation("44");//normal
		assertEquals(true, output);
		
	    output= test.age_validation("-14");// less than 0
		assertEquals(false, output);
		
		  output= test.age_validation("244");//greater than 150
			assertEquals(false, output);
			
	}

}
