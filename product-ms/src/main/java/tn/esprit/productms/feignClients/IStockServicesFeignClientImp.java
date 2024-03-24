package tn.esprit.productms.feignClients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import tn.esprit.productms.feignClients.IStockServicesFeignClient;
import tn.starter.shared.dto.StockDto;
import tn.starter.shared.dto.StockDtoTest;


public class IStockServicesFeignClientImp implements IStockServicesFeignClient {

    RestTemplate restTemplate = new RestTemplate();

    @Value("param.baseurl")
    private String baseURL ;

    @Override
    public StockDtoTest getStockById(long id) {

  /*      HttpEntity<String> request = new HttpEntity<String>(getHeaders());
        ResponseEntity response = restTemplate.exchange(baseURL+"STOCK-MS/"+id, HttpMethod.GET,request, StockDto.class);
        ObjectMapper mapper = new ObjectMapper();

        List<User> users = mapper.convertValue(response.getBody() , new com.fasterxml.jackson.core.type.TypeReference<List<User>>() { });
*/

        return null;
    }
}
