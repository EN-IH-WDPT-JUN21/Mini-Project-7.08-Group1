import { Adopter } from './../models/adopter.model';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-adopter',
  templateUrl: './adopter.component.html',
  styleUrls: ['./adopter.component.css']
})
export class AdopterComponent implements OnInit {

  @Input() adopter!: Adopter;

  @Output() animalAdopted: EventEmitter<number> = new EventEmitter();
  constructor() { }

  ngOnInit(): void {
  }
  
  adoptAnimal(position:number):void{
    this.animalAdopted.emit(position);
  }

}
