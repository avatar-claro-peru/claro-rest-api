package pe.com.claro.junit.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pe.com.claro.junit.*;

public class BoxTest {
	pe.com.claro.junit.Box box;
	@Before
	public void setUp() throws Exception {
		box = new Box(10,15);
	}

	@Test
	public void test() {
		assertEquals(150, box.getArea());
	}
}
