import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { ICollectionTracking } from 'app/shared/model/collection-tracking.model';

type EntityResponseType = HttpResponse<ICollectionTracking>;
type EntityArrayResponseType = HttpResponse<ICollectionTracking[]>;

@Injectable({ providedIn: 'root' })
export class CollectionTrackingService {
  public resourceUrl = SERVER_API_URL + 'api/collection-trackings';

  constructor(protected http: HttpClient) {}

  create(collectionTracking: ICollectionTracking): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(collectionTracking);
    return this.http
      .post<ICollectionTracking>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(collectionTracking: ICollectionTracking): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(collectionTracking);
    return this.http
      .put<ICollectionTracking>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<ICollectionTracking>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<ICollectionTracking[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(collectionTracking: ICollectionTracking): ICollectionTracking {
    const copy: ICollectionTracking = Object.assign({}, collectionTracking, {
      pROMISEDATE:
        collectionTracking.pROMISEDATE && collectionTracking.pROMISEDATE.isValid()
          ? collectionTracking.pROMISEDATE.format(DATE_FORMAT)
          : undefined,
      fOLLOWUPDATE:
        collectionTracking.fOLLOWUPDATE && collectionTracking.fOLLOWUPDATE.isValid()
          ? collectionTracking.fOLLOWUPDATE.format(DATE_FORMAT)
          : undefined,
      cREATEDON:
        collectionTracking.cREATEDON && collectionTracking.cREATEDON.isValid()
          ? collectionTracking.cREATEDON.format(DATE_FORMAT)
          : undefined,
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.pROMISEDATE = res.body.pROMISEDATE ? moment(res.body.pROMISEDATE) : undefined;
      res.body.fOLLOWUPDATE = res.body.fOLLOWUPDATE ? moment(res.body.fOLLOWUPDATE) : undefined;
      res.body.cREATEDON = res.body.cREATEDON ? moment(res.body.cREATEDON) : undefined;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((collectionTracking: ICollectionTracking) => {
        collectionTracking.pROMISEDATE = collectionTracking.pROMISEDATE ? moment(collectionTracking.pROMISEDATE) : undefined;
        collectionTracking.fOLLOWUPDATE = collectionTracking.fOLLOWUPDATE ? moment(collectionTracking.fOLLOWUPDATE) : undefined;
        collectionTracking.cREATEDON = collectionTracking.cREATEDON ? moment(collectionTracking.cREATEDON) : undefined;
      });
    }
    return res;
  }
}
