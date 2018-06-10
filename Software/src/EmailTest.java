import static org.junit.Assert.*;

import org.junit.Test;

public class EmailTest {

	@Test
	public void test() {
		
		
		Receptionist test = new Receptionist();
		boolean output= test.email_validation("example@gmail.com");//normal
		assertEquals(true, output);
		
		output= test.email_validation("example");// without @
		assertFalse(output);
		
		 output= test.email_validation("example@gmailcom");// without .(dot)
			assertEquals(false, output);
			
			 output= test.email_validation("@gmail.com");//There is no previous part from @ 
				assertEquals(false, output);
				
				 output= test.email_validation("example@");//There is no after part from @ 
					assertEquals(false, output);
					
				 output= test.email_validation("example@gmail.");//There is no after part from .(dot)
					assertEquals(false, output);
					
					 output= test.email_validation("example@.com");//without gmail hotmail etc.
						assertEquals(false, output);
				
				
	}

}
