import { AnimalAdoptionAPIService } from './../animal-adoption-apiservice.service';
import { Component, OnInit } from '@angular/core';
import { Animal } from '../models/animal.model';

@Component({
  selector: 'app-animal-list',
  templateUrl: './animal-list.component.html',
  styleUrls: ['./animal-list.component.css']
})
export class AnimalListComponent implements OnInit {


  type: string;
  ageFrom: number;
  ageTo: number;
  animalList: Array<Animal>;


  constructor(private animalAdoptionAPIService: AnimalAdoptionAPIService) { 
    this.ageTo=0;
    this.ageFrom=0;
    this.type="";
    this.animalList=[];
  }

  ngOnInit(): void {
  }

  searchAnimals():void{
    this.animalAdoptionAPIService.searchAnimals(this.ageFrom, this.ageTo, this.type).subscribe(dataResult => {
      console.log(dataResult);
      this.animalList = dataResult;
    },
    errors => {
      console.log('Error searchAnimals');
      console.error(errors);
    });
  }

  adoptAnimal($event: any){
    console.log($event.target.value(0));
    var name = $event.target.value(0);
    var petId = $event.target.value(1);
    $event.target?.addEventListener
    this.animalAdoptionAPIService.adoptAnimals(name, petId).subscribe(
    errors => {
      console.log('Error adoptAnimals');
      console.error(errors);
    });
  }

}
