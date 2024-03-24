package tn.esprit.stockms.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.stockms.entities.Stock;
import tn.starter.shared.dto.StockDto;
import tn.starter.shared.dto.StockDtoTest;
import tn.starter.shared.generiqueservice.IGenericServiceImp;


@Slf4j
@Service
@RequiredArgsConstructor
public class IStockServiceIpm extends IGenericServiceImp<StockDtoTest,Stock,Long> implements IStockService {


}
