package com.company;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.company.Calc;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

	@Test
	public void sumTest() {
		Calc clac = new Calc();
		assertEquals(clac.sum(1, 2), 1 + 1);
	}
}
