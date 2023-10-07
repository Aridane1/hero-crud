import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TienenI } from '../models/tienen.interface';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};
@Injectable({
  providedIn: 'root',
})
export class HerosPowersService {
  endpoint = 'http://localhost:8080/heros_powers';

  constructor(private httpClient: HttpClient) {}

  getAllTienen() {
    return this.httpClient.get<any[]>(this.endpoint);
  }

  deleteTiene(id_hero: number, id_power: number) {
    return this.httpClient.delete(this.endpoint + `/${id_hero}/${id_power}`);
  }

  addNewTienen(newTiene: TienenI) {
    return this.httpClient.post<TienenI[]>(
      this.endpoint + `/data_names`,
      newTiene,
      httpOptions
    );
  }

  modifyTienen(update: TienenI) {
    console.log(update);
    return this.httpClient.put<TienenI[]>(
      this.endpoint + `/update_data_names`,
      update,
      httpOptions
    );
  }
}
