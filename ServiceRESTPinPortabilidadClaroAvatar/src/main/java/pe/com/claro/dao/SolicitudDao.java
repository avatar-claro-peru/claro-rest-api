package pe.com.claro.dao;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import pe.com.claro.model.Solicitud;

/**
 * @author Jhonny Cisneros
 *
 */
@Transactional
public interface SolicitudDao extends JpaRepository<Solicitud, Integer>, GenericDao<Solicitud, Integer> {

	@Transactional(readOnly = true)
	Solicitud findByToken(String token);

	@Transactional(readOnly = true)
	@Query(nativeQuery = true, value = "SELECT count(*) FROM Solicitud s WHERE s.telefono = :telefono")
	Integer totalSolicitudesXLinea(@Param("telefono") int telefono);
	
	@Transactional(readOnly = true)
	@Query(nativeQuery = true, value = "SELECT count(*) FROM Solicitud s WHERE s.telefono = :telefono and s.fechageneracion = :fechageneracion")
	Integer totalSolicitudesXLineaYFechaGeneracion(@Param("telefono") int telefono, @Param("fechageneracion") Timestamp fechageneracion);

	@Modifying
	@Query(nativeQuery = true, value = "UPDATE Solicitud SET estado = 0 WHERE telefono = :telefono")
	void inactivarSolicitudesAnteriores(@Param("telefono") int telefono);

}
