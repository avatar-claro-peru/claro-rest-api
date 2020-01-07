package pe.com.claro.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Jhonny Cisneros
 *
 */
public class DateUtil {

	private static final Logger log = LoggerFactory.getLogger(DateUtil.class);

	public static Date getFullCurrentDate() {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH) + 1;
		int day = now.get(Calendar.DAY_OF_MONTH);
//		int hour = now.get(Calendar.HOUR_OF_DAY);
//		int minute = now.get(Calendar.MINUTE);
//		int second = now.get(Calendar.SECOND);
//		int millis = now.get(Calendar.MILLISECOND);
		String fechaConcat = year + "-" + day + "-" + month;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
		Date fechaGeneracion = new Date();
		try {
			fechaGeneracion = sdf.parse(fechaConcat);
			log.info("Fecha actual: " + sdf.format(fechaGeneracion));
		} catch (ParseException e) {
			log.error("Error en DateUtil: " + e.getMessage());
		}
		return fechaGeneracion;
	}

}
