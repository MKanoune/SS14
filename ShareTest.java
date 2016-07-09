import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ShareTest {
	Share share;
	long newPrice = 12421;
	long wrongPrice = -12421;
	
	
	@Before
	public void setUp(){
		share = new Share("ibm",123);
	}
	
	
	
	@Test
	public void testSetPrice() {
		share.setPrice(newPrice);
		assertTrue("testSetPrice",share.getPrice()==newPrice && share.getPerformance() == Share.Performance.INCREASING);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testSetPriceWithWrongArgument(){
		share.setPrice(wrongPrice);
		
	}

}
