package pe.com.claro.service.rest.pinportabilidad;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pe.com.claro.util.RandomUtil;

public class CodigoSMSTest {
	
	private static final Logger log = LoggerFactory.getLogger(CodigoSMSTest.class);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void generarCodigoSMSTest() {
		log.info("Prueba Unitaria del servicio {ServiceRESTPinPortabilidadClaroAvatar} - metodo [generarCodigoSMS]");
		assertNotNull(RandomUtil.generarCodigoSMS(10));
	}
	
	@Test
	public void generarTokenTest() {
		log.info("Prueba Unitaria del servicio {ServiceRESTPinPortabilidadClaroAvatar} - metodo [generarToken]");
		assertNotNull(RandomUtil.generarToken(10));
	}

}
