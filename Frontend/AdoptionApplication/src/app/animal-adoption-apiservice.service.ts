
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Animal } from './models/animal.model';

@Injectable({
  providedIn: 'root'
})
export class AnimalAdoptionAPIService {
  private readonly baseUrl: string = 'http://localhost:8000'; 

  readonly baseDogURL:string = "https://dog.ceo/api/breeds/image/random";
  readonly baseCatURL:string = "https://aws.random.cat/meow?ref=apilist.fun";

  constructor(private http: HttpClient) { }
  searchAnimals(ageFrom?: number, ageTo?: number, type?:string): Observable<Animal[]> {
    console.log(`What I get on the service ${type} with age between ${ageFrom} and ${ageTo}`)
    let httpParams = new HttpParams();
    if (ageFrom) httpParams = httpParams.append('ageFrom', ageFrom);      //payload
    if (ageTo) httpParams = httpParams.append('ageTo', ageTo);  
    if (type) httpParams = httpParams.append('type', type);  //payload

    const httpOptions = {
      params: httpParams
    };
    return this.http.get<Animal[]>(this.baseUrl + '/animals', httpOptions);
  }

  adoptAnimals(name: string, petId: number): Observable<Animal[]> {
    console.log(`What I get on the service ${name} with pet ID ${petId}`)
    let httpParams = new HttpParams();
    httpParams.append('name', name);      //payload
    httpParams.append('petId', petId);  




    const httpOptions = {
      params: httpParams
    };
    return this.http.post<Animal[]>(this.baseUrl + '/animals', httpOptions);
  }

  getDogImage() : Observable<any> {
    return this.http.get<any>(this.baseDogURL);
  }
  getCatImage() : Observable<any> {
    return this.http.get<any>(this.baseCatURL);
  }


}