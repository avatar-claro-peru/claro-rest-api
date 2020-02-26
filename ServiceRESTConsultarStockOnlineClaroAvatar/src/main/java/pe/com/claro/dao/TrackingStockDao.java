package pe.com.claro.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.claro.model.TrackingStock;

@Transactional
public interface TrackingStockDao extends JpaRepository<TrackingStock, Integer>, GenericDao<TrackingStock, Integer> {

	@Transactional(readOnly = true)
	TrackingStock findByCodmaterialchip(String codmaterialChip);

	@Transactional(readOnly = true)
	TrackingStock findByCodmaterial(String codMaterial);
}