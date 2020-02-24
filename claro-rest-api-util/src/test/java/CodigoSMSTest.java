import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import pe.com.claro.util.RandomUtil;


public class CodigoSMSTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void generarCodigoSMSTest() {	
		assertNotNull(RandomUtil.generarCodigoSMS(10));
	}
	
	@Test
	public void generarTokenTest() {
		assertNotNull(RandomUtil.generarToken(10));
	}

}
