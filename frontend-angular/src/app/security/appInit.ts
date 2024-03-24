import {environment} from '../../environments/environment';
import {KeycloakOptions, KeycloakService} from "keycloak-angular";

export function keycloakInitialize(keycloak: KeycloakService): () => Promise<any> {
  const options: KeycloakOptions ={
    config: environment.keycloakConfig,
    initOptions: {
      onLoad:"check-sso",
      checkLoginIframe: true,
      silentCheckSsoRedirectUri:window.location.origin + '/assets/silent-check-sso.html' ,
      // checkLoginIframeInterval : 25
    },
    // loadUserProfileAtStartUp : true
  };
  return (): Promise<any> => keycloak.init(options).then();
}
