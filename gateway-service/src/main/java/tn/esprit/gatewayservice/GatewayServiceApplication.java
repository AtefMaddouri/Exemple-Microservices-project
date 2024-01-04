package tn.esprit.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

/*	//Static Route configuration
	@Bean
	RouteLocator gatewayRoutes(RouteLocatorBuilder routeLocatorBuilder) {
		return routeLocatorBuilder.routes()
				.route(r -> r.path("/article/**").uri("http://localhost:9012/"))
				.route(r -> r.path("/article/**").uri("lb://PRODUCT-MS/"))
				.route(r -> r.path("/stock/**").uri("lb://STOCK-MS/"))
				.build();
	}

	//Dynamic Route configuration
	@Bean
	DiscoveryClientRouteDefinitionLocator definitionLocator(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties properties) {
		return new DiscoveryClientRouteDefinitionLocator(rdc,properties);
	}*/

}
