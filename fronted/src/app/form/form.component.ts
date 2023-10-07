import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { HeroI } from '../models/hero.interface';
import { PowerI } from '../models/power.interface';
import { HerosService } from '../service/heros.service';
import { PowersService } from '../service/powers.service';
import { HerosPowersService } from '../service/heros-powers.service';
import { FormControl, FormGroup, Validator } from '@angular/forms';
import { RangeCustomEvent } from '@ionic/angular';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss'],
})
export class FormComponent implements OnInit {
  ionicForm!: FormGroup;
  constructor(
    private heroService: HerosService,
    private powerService: PowersService,
    private herosPowersService: HerosPowersService
  ) {}
  heros: Array<HeroI> = [];
  powers: Array<PowerI> = [];
  tienen: Array<any> = [];
  idHero!: number | undefined;
  idPower!: number | undefined;
  @Input() selector!: boolean;
  @Input() heroCardName!: string;
  @Input() heroCardNamePower!: string;
  @Input() heroCardPowerLevel!: string;

  @Output() cancel = new EventEmitter<any>();
  @Output() hero = new EventEmitter<any>();
  ngOnInit() {
    this.ionicForm = new FormGroup({
      nameHero: new FormControl(this.heroCardName),
      namePower: new FormControl(this.heroCardName),
      powerLevel: new FormControl(this.heroCardName),
    });
  }

  onIonKnobMoveEnd(ev: Event) {
    console.log('ionKnobMoveEnd:', (ev as RangeCustomEvent).detail.value);
  }
  cancelModify() {
    this.cancel.emit(false);
  }
  add() {
    const nameHero = this.ionicForm.get('nameHero')?.value;
    const namePower = this.ionicForm.get('namePower')?.value;
    const powerLevel = this.ionicForm.get('powerLevel')?.value;

    this.heroService.addNewHero({ name: nameHero }).subscribe((response) => {
      this.hero.emit(response);
    });

    this.powerService
      .addNewPower({ name: namePower })
      .subscribe((response) => {});

    sleep(100).then(() => {
      this.herosPowersService
        .addNewTienen({
          name_hero: nameHero,
          name_power: namePower,
          power_level: powerLevel,
        })
        .subscribe((response) => {
          this.hero.emit(response);
        });
    });
  }

  modify() {
    const powerLevel = this.ionicForm.get('powerLevel')?.value;
    this.herosPowersService
      .modifyTienen({
        name_hero: this.heroCardName,
        name_power: this.heroCardNamePower,
        power_level: powerLevel,
      })
      .subscribe((response) => {
        this.hero.emit(response);
        this.cancel.emit(false);
      });
  }

  update(heroModify: HeroI, powerModify: PowerI) {
    this.heroService.getAllHeros().subscribe((response) => {
      this.heros = response;
      if (!this.heros.some((hero) => hero.name === heroModify.name)) {
        this.heroService.updateHero(heroModify).subscribe((response) => {
          this.hero.emit(response);
        });
      }
    });

    this.powerService.getAllPowers().subscribe((response) => {
      this.powers = response;
      if (!this.powers.some((power) => power.name === powerModify.name)) {
        this.powerService.updatePower(powerModify).subscribe((response) => {
          this.hero.emit(response);
        });
      }
    });
  }

  parseInt(id: string) {
    return parseInt(id);
  }
}

function sleep(ms: number) {
  return new Promise((resolve) => setTimeout(resolve, ms));
}
