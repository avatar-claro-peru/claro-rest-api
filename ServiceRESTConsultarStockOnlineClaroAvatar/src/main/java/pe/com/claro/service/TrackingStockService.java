package pe.com.claro.service;

import java.util.List;

import pe.com.claro.model.TrackingStock;

public interface TrackingStockService extends GenericService<TrackingStock, Integer> {

	List<TrackingStock> buscarXCodigo(String codigo);
}