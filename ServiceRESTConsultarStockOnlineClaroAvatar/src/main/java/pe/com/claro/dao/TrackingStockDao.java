package pe.com.claro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.claro.model.TrackingStock;

@Transactional
public interface TrackingStockDao extends JpaRepository<TrackingStock, Integer>, GenericDao<TrackingStock, Integer> {

	@Transactional(readOnly = true)
	List<TrackingStock> findByCodigo(String codigo);
}