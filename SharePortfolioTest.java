import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SharePortfolioTest {
	SharePortfolio depot;
	Share ibm = new Share("ibm",123);
	Share siemens = new Share("siemens", 100);
	Share bmw = new Share("bmw",222);
	
	
	
	
	@Before
	public void setUp(){
		depot = new SharePortfolio("player1");
	}
	
	@Test
	public void testGetValue() {
		long value = (bmw.getPrice() +  ibm.getPrice() + siemens.getPrice())*2;
		depot.buy(ibm,2);
		depot.buy(siemens, 2);
		depot.buy(bmw, 2);
		long testValue = depot.getValue();
		assertTrue("testGetValue",testValue == value);
	}
	
	@Test 
	public void testGetValueZero(){
		long testValue = depot.getValue();
		assertTrue("testGetValueZero",testValue==0);
	}
	
	@Test
	public void testGetValuePerformance(){
		depot.buy(ibm,2);
		depot.buy(siemens, 2);
		depot.buy(bmw, 2);
		ibm.setPrice(100);
		long value = (bmw.getPrice() +  100 + siemens.getPrice())*2;
		long testValue = depot.getValue();
		assertTrue("testGetValuePerformance",testValue == value);
	}
	
	@Test
	public void testBuy() {
		depot.buy(ibm, 23);
		assertTrue(depot.getNumber(ibm)==23);
	}

}
