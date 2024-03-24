export const environment = {
  production: true,
  host:"http://gateway-api",
  keycloakHost:"http://keycloak:8080/auth/admin/realms/exemple-microservices-project-realm",

  keycloakConfig: {
    url: 'http://keycloak:8080/auth/',
    realm: 'exemple-microservices-project-realm',
    clientId: 'frontend-angular',
  }
};
