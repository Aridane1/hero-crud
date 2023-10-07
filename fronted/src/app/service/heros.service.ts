import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { HeroI } from '../models/hero.interface';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};

@Injectable({
  providedIn: 'root',
})
export class HerosService {
  endpoint = 'http://localhost:8080/heros';

  constructor(private httpClient: HttpClient) {}

  getAllHeros(): Observable<HeroI[]> {
    return this.httpClient.get<HeroI[]>(this.endpoint);
  }

  deleteOneHero(id: number) {
    return this.httpClient.delete(this.endpoint + `/${id}`);
  }

  addNewHero(newHero: HeroI): Observable<HeroI> {
    return this.httpClient.post<HeroI>(this.endpoint, newHero, httpOptions);
  }

  deleteAllHero() {
    return this.httpClient.delete(this.endpoint);
  }

  updateHero({ id, name }: HeroI): Observable<HeroI> {
    console.log(id, name);
    return this.httpClient.put<HeroI>(
      this.endpoint + `/${id}`,
      { name },
      httpOptions
    );
  }
}
