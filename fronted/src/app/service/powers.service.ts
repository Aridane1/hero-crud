import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PowerI } from '../models/power.interface';
import { Observable } from 'rxjs';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};

@Injectable({
  providedIn: 'root',
})
export class PowersService {
  endpoint = 'http://localhost:8080/powers';

  constructor(private httpClient: HttpClient) {}

  getAllPowers() {
    return this.httpClient.get<any[]>(this.endpoint);
  }

  addNewPower(newPower: PowerI): Observable<PowerI> {
    return this.httpClient.post<PowerI>(this.endpoint, newPower, httpOptions);
  }
  getOnePower(id: any) {
    return this.httpClient.get<any[]>(this.endpoint + `/${id}`);
  }

  updatePower({ id, name }: PowerI): Observable<PowerI> {
    return this.httpClient.put<PowerI>(
      this.endpoint + `/${id}`,
      { name },
      httpOptions
    );
  }
}
