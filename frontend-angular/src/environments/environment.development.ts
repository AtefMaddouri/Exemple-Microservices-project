// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  host:"http://localhost:9090",
  keycloakHost:"http://localhost:8080/auth/admin/realms/exemple-microservices-project",

  keycloakConfig: {
    url: 'http://localhost:8080',
    realm: 'exemple-microservices-project',
    clientId: 'frontend-angular',
  }
};
