package tn.esprit.stockms.services;
import tn.esprit.stockms.entities.Stock;
import tn.starter.shared.dto.StockDto;
import tn.starter.shared.dto.StockDtoTest;
import tn.starter.shared.generiqueservice.IGenericService;

public interface IStockService extends IGenericService<StockDtoTest,Stock,Long> {
}
