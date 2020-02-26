package pe.com.claro.service;

import pe.com.claro.model.TrackingStock;

public interface TrackingStockService extends GenericService<TrackingStock, Integer> {

	TrackingStock buscarXCodmaterialchip(String codmaterialchip);
	TrackingStock buscarXCodmaterial(String codmaterial);
}