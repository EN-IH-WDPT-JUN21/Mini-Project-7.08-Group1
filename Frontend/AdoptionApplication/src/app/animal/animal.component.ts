import { AnimalAdoptionAPIService } from './../animal-adoption-apiservice.service';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Adopter } from '../models/adopter.model';
import { Animal } from '../models/animal.model';


@Component({
  selector: 'app-animal',
  templateUrl: './animal.component.html',
  styleUrls: ['./animal.component.css']
})
export class AnimalComponent implements OnInit {

  isButtonClicked=false;
  picture: string="";

  @Input() animal! : Animal;
  @Input() adopter! : Adopter;

  @Output() animalAdopted: EventEmitter<{name: string, petId: number}> = new EventEmitter();


  @Input() position!:number;
  constructor(private animalAdoptionAPIService: AnimalAdoptionAPIService) { }

  ngOnInit(): void {
  }
  

  adoptAnimal( name:string, petId:number):void{
    this.animalAdopted.emit({name, petId});
  }

  showForm(position : number): void{
    this.isButtonClicked=true;
  }
}
