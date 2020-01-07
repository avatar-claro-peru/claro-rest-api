package pe.com.claro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.claro.model.Linea;

@Transactional(readOnly = true)
public interface LineDao extends JpaRepository<Linea, Integer>, GenericoDao<Linea, Integer> {
    	
}
