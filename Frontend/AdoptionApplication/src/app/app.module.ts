import { MatCardModule } from '@angular/material/card';
import { HttpClientModule} from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AnimalComponent } from './animal/animal.component';
import { AdopterComponent } from './adopter/adopter.component';
import { AnimalListComponent } from './animal-list/animal-list.component';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatDivider} from '@angular/material/divider';


@NgModule({
  declarations: [
    AppComponent,
    AnimalComponent,
    AdopterComponent,
    AnimalListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatCardModule
      ],
  providers: [AdopterComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
