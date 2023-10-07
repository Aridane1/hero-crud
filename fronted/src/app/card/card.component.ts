import { Component, Output, EventEmitter, Input, OnInit } from '@angular/core';
import { HeroI } from '../models/hero.interface';
import { HerosPowersService } from '../service/heros-powers.service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss'],
})
export class CardComponent implements OnInit {
  @Input() id!: number;
  @Input() name!: string;
  @Input() power!: string;
  selector?: boolean = false;
  powers: Array<any> = [];
  myPower: Array<any> = [];
  @Output() clickButtonUpdate = new EventEmitter<boolean>();
  @Output() heroClickedToRemove = new EventEmitter<number>();
  @Output() powerRemoveToHero = new EventEmitter<any>();
  @Output() heroClickedToUpdate = new EventEmitter<HeroI>();
  ngOnInit() {
    this.findPowerByHero();
  }

  constructor(private herosPowersService: HerosPowersService) {}

  deleteHero(id: number): void {
    this.heroClickedToRemove.emit(id);
  }

  deletePower(idHero: number, idPower: number): void {
    this.herosPowersService
      .deleteTiene(idHero, idPower)
      .subscribe((response) => {
        this.powerRemoveToHero.emit(response);
      });
  }

  findPowerByHero() {
    this.herosPowersService.getAllTienen().subscribe((response: any) => {
      this.powers = response;
      this.powers = this.powers.filter((data) => data.heroes.id == this.id);
    });
  }

  updatePowerLevel(update: any) {
    this.heroClickedToUpdate.emit(update);
    this.clickButtonUpdate.emit((this.selector = true));
  }
}
