package tn.esprit.stockms.services;
import tn.esprit.stockms.entities.Stock;
import tn.starter.shared.generiqueservice.IGenericService;

import java.util.Map;

public interface IStockService extends IGenericService<Stock,Long> {
    Stock patchUpdate(Map<Object, Object> fields, long id);
}
