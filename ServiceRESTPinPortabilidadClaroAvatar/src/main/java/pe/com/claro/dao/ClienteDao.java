package pe.com.claro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.claro.model.Cliente;

/**
 * @author Jhonny Cisneros
 *
 */
@Transactional
public interface ClienteDao extends JpaRepository<Cliente, Integer>, GenericDao<Cliente, Integer> {

	@Transactional(readOnly = true)
	Cliente findByNumDoc(String numDoc);

}
