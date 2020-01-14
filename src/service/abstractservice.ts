import { Service } from './service';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Auth } from './auth';
/**
 * Service astratto, implementa tutti i metodi CRUD inviando request al server di SpringBoot. 
 * @param port il port del backend
 * @param type la mappatura del controller di ciascuna entità.
 * 
 * @see Service
 * 
 * @author Vittorio Valent
 */
export abstract class AbstractService<DTO> implements Service<DTO> {

    type: string;
    port: string;
    name: string;

    constructor(protected http: HttpClient, protected authorization: Auth) {
    }

    getAll(): Observable<DTO[]> {
        return this.http.get<DTO[]>('http://localhost:' + this.port + '/' + this.name + '/' + 'api' + '/' + this.type, {
            headers: {
                Authorization: this.authorization.auth()
            }
        });
    }

    read(id: number): Observable<DTO> {
        return this.http.get<DTO>('http://localhost:' + this.port + '/' + this.name + '/' + 'api' + '/' + this.type + id, {
            headers: {
                Authorization: this.authorization.auth()
            }
        });
    }

    delete(id: number): Observable<DTO> {
        return this.http.delete<DTO>('http://localhost:' + this.port + '/' + this.name + '/' + 'api' + '/' + this.type + '/' + id, {
            headers: {
                Authorization: this.authorization.auth()
            }
        });
    }

    insert(dto: DTO): Observable<DTO> {
        return this.http.post<DTO>('http://localhost:' + this.port + '/' + this.name + '/' + 'api' + '/' + this.type, dto, {
            headers: {
                Authorization: this.authorization.auth()
            }
        });
    }

    update(dto: DTO): Observable<DTO> {
        return this.http.put<DTO>('http://localhost:' + this.port + '/' + this.name + '/' + 'api' + '/' + this.type, dto, {
            headers: {
                Authorization: this.authorization.auth()
            }
        });
    }
}