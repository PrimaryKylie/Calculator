import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalcTest {
	private CalcView view = new CalcView();
	private  CalcModel model = new CalcModel();
	private CalcController control = new CalcController();
	
	
	@Test
	void testAdd() {
		model.setValue1(5);
		model.setValue2(4);
		model.add();
		assertEquals(model.getAnswer(), 9);
		
		fail("Not yet implemented"); 
	}

	@Test
	void testSubtract() {
		model.setValue1(5);
		model.setValue2(4);
		model.subtract();
		assertEquals(model.getAnswer(), 1);
		fail("Not yet implemented");
	}

	@Test
	void testMultiply() {
		model.setValue1(5);
		model.setValue2(4);
		model.multiply();
		assertEquals(model.getAnswer(), 20);
		fail("Not yet implemented");
	}

	@Test
	void testDivide() {
		model.setValue1(5);
		model.setValue2(4);
		model.divide();
		assertEquals(model.getAnswer(), 1.25);
		fail("Not yet implemented");
	}

	@Test
	void testSquareRoot() {
		model.setValue1(5);
		model.squareRoot();
		assertEquals(model.getAnswer(), 2.236);
		fail("Not yet implemented");
	}

	@Test
	void testExponent() {
		model.setValue1(9);
		model.setValue2(2);
		assertEquals(model.getAnswer(), 81);
		fail("Not yet implemented");
	}

	@Test
	void testLogWithBase() {
		model.setValue1(5);
		model.setValue2(2);
		assertEquals(model.getAnswer(), 2.322);
		fail("Not yet implemented");
	}

	@Test
	void testNaturalLog() {
		model.setValue1(8);
		model.setValue2(2);
		assertEquals(model.getAnswer(), 5.545);
		fail("Not yet implemented");
	}

	@Test
	void testPercent() {
		model.setValue1(20); 
		model.setValue2(100);
		assertEquals(model.getAnswer(), 20.000);
		fail("Not yet implemented");
	}

}
