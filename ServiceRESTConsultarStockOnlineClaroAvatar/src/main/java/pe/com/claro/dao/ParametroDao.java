package pe.com.claro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.claro.model.Parametro;

/**
 * @author Jhonny Cisneros
 *
 */
@Transactional
public interface ParametroDao extends JpaRepository<Parametro, Integer>, GenericDao<Parametro, Integer> {

	@Transactional(readOnly = true)
	Parametro findByNombreParam(String nombreParam);

}
