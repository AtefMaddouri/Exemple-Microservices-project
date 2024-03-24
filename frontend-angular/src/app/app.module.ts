import {APP_INITIALIZER, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {keycloakInitialize} from "./security/appInit";
import {KeycloakAngularModule, KeycloakService} from "keycloak-angular";
import { ProductsComponent } from './components/products/products.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    KeycloakAngularModule
  ],
  providers: [
    KeycloakService,
    {
      provide: APP_INITIALIZER,
      useFactory: keycloakInitialize,
      deps: [ KeycloakService ],
      multi: true
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
