import { Component, OnInit } from '@angular/core';
import { HerosService } from '../service/heros.service';
import { PowersService } from '../service/powers.service';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {
  miFormGroup: FormGroup;
  heros: any = [];
  powers: any = [];
  idHero?: number;
  name!: string;
  power!: string;
  selector: boolean = false;
  heroCardName: any;
  heroCardPowerName: any;
  heroCardPowerLevel: any;

  constructor(
    private herosService: HerosService,
    private powerService: PowersService,
    private formBuilder: FormBuilder
  ) {
    this.miFormGroup = this.formBuilder.group({
      firstName: new FormControl(null), // Puedes establecer un valor inicial aquí si es necesario
      lastName: new FormControl(null),
      age: new FormControl(null),
    });
  }

  ngOnInit() {
    this.getAllHeros();
    this.getAllPowers();
  }

  cancelModify(cancel: any) {
    this.heroCardName = '';
    this.heroCardPowerName = '';
    this.heroCardPowerLevel = 0;
    this.selector = cancel;
  }

  getAllHeros() {
    this.herosService.getAllHeros().subscribe((response) => {
      this.heros = response;
    });
  }

  getAllPowers() {
    this.powerService.getAllPowers().subscribe((response) => {
      this.powers = response;
    });
  }

  addNewHero() {
    this.getAllHeros();
  }

  deletePowerToHero() {
    this.getAllHeros();
  }

  deleteOneHero(id: number) {
    this.herosService.deleteOneHero(id).subscribe((response) => {
      this.heros = response;
      this.getAllHeros();
    });
  }

  deleteAllHero() {
    this.herosService.deleteAllHero().subscribe((response) => {
      this.heros = response;
      this.getAllHeros();
    });
  }

  saveInfoCard(heroInfo: any) {
    this.heroCardName = heroInfo.nameHero;
    this.heroCardPowerName = heroInfo.namePower;
    this.heroCardPowerLevel = heroInfo.powerLevel;
  }

  saveSelector(select: boolean) {
    this.selector = select;
  }
}
