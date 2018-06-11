package com.kosmo.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class OperatorTest {

	@Test
	public void test() {
		Operator o = new Operator();
		double result = o.sum(10, 50);
		assertEquals(60, result, 0);
	}

}
