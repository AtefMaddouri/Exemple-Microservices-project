package tn.esprit.productms.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import tn.starter.shared.dto.StockDto;


public class IStockServicesFeignClientImp implements IStockServicesFeignClient {

    RestTemplate restTemplate = new RestTemplate();

    @Value("param.baseurl")
    private String baseURL ;

    @Override
    public StockDto getStockById(Long id) {

  /*      HttpEntity<String> request = new HttpEntity<String>(getHeaders());
        ResponseEntity response = restTemplate.exchange(baseURL+"STOCK-MS/"+id, HttpMethod.GET,request, StockDto.class);
        ObjectMapper mapper = new ObjectMapper();

        List<User> users = mapper.convertValue(response.getBody() , new com.fasterxml.jackson.core.type.TypeReference<List<User>>() { });
*/

        return null;
    }
}
