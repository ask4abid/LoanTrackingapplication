import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { ICollectionTracking, CollectionTracking } from 'app/shared/model/collection-tracking.model';
import { CollectionTrackingService } from './collection-tracking.service';

@Component({
  selector: 'jhi-collection-tracking-update',
  templateUrl: './collection-tracking-update.component.html',
})
export class CollectionTrackingUpdateComponent implements OnInit {
  isSaving = false;
  pROMISEDATEDp: any;
  fOLLOWUPDATEDp: any;
  cREATEDONDp: any;

  editForm = this.fb.group({
    id: [],
    eMPID: [null, [Validators.required]],
    eMPNAME: [null, [Validators.required]],
    uNITID: [null, [Validators.required]],
    pROMISEDATE: [],
    cOMMENTS: [null, [Validators.required]],
    bUSINESSPROPOSALNO: [null, [Validators.required]],
    sUBPROPOSALNO: [null, [Validators.required]],
    mOBILENO: [null, [Validators.required]],
    aCCOUNTNO: [null, [Validators.required]],
    accountTitle: [null, [Validators.required]],
    oDDays: [null, [Validators.required]],
    oSAmount: [null, [Validators.required]],
    oSProfit: [null, [Validators.required]],
    cROID: [null, [Validators.required]],
    cRONAME: [null, [Validators.required]],
    rELATIONID: [null, [Validators.required]],
    wILLINGTOPAY: [null, [Validators.required]],
    fOLLOWUPDATE: [],
    dELINQUENCYREASON: [],
    vISITEDBY: [],
    cREATEDON: [],
  });

  constructor(
    protected collectionTrackingService: CollectionTrackingService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ collectionTracking }) => {
      this.updateForm(collectionTracking);
    });
  }

  updateForm(collectionTracking: ICollectionTracking): void {
    this.editForm.patchValue({
      id: collectionTracking.id,
      eMPID: collectionTracking.eMPID,
      eMPNAME: collectionTracking.eMPNAME,
      uNITID: collectionTracking.uNITID,
      pROMISEDATE: collectionTracking.pROMISEDATE,
      cOMMENTS: collectionTracking.cOMMENTS,
      bUSINESSPROPOSALNO: collectionTracking.bUSINESSPROPOSALNO,
      sUBPROPOSALNO: collectionTracking.sUBPROPOSALNO,
      mOBILENO: collectionTracking.mOBILENO,
      aCCOUNTNO: collectionTracking.aCCOUNTNO,
      accountTitle: collectionTracking.accountTitle,
      oDDays: collectionTracking.oDDays,
      oSAmount: collectionTracking.oSAmount,
      oSProfit: collectionTracking.oSProfit,
      cROID: collectionTracking.cROID,
      cRONAME: collectionTracking.cRONAME,
      rELATIONID: collectionTracking.rELATIONID,
      wILLINGTOPAY: collectionTracking.wILLINGTOPAY,
      fOLLOWUPDATE: collectionTracking.fOLLOWUPDATE,
      dELINQUENCYREASON: collectionTracking.dELINQUENCYREASON,
      vISITEDBY: collectionTracking.vISITEDBY,
      cREATEDON: collectionTracking.cREATEDON,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const collectionTracking = this.createFromForm();
    if (collectionTracking.id !== undefined) {
      this.subscribeToSaveResponse(this.collectionTrackingService.update(collectionTracking));
    } else {
      this.subscribeToSaveResponse(this.collectionTrackingService.create(collectionTracking));
    }
  }

  private createFromForm(): ICollectionTracking {
    return {
      ...new CollectionTracking(),
      id: this.editForm.get(['id'])!.value,
      eMPID: this.editForm.get(['eMPID'])!.value,
      eMPNAME: this.editForm.get(['eMPNAME'])!.value,
      uNITID: this.editForm.get(['uNITID'])!.value,
      pROMISEDATE: this.editForm.get(['pROMISEDATE'])!.value,
      cOMMENTS: this.editForm.get(['cOMMENTS'])!.value,
      bUSINESSPROPOSALNO: this.editForm.get(['bUSINESSPROPOSALNO'])!.value,
      sUBPROPOSALNO: this.editForm.get(['sUBPROPOSALNO'])!.value,
      mOBILENO: this.editForm.get(['mOBILENO'])!.value,
      aCCOUNTNO: this.editForm.get(['aCCOUNTNO'])!.value,
      accountTitle: this.editForm.get(['accountTitle'])!.value,
      oDDays: this.editForm.get(['oDDays'])!.value,
      oSAmount: this.editForm.get(['oSAmount'])!.value,
      oSProfit: this.editForm.get(['oSProfit'])!.value,
      cROID: this.editForm.get(['cROID'])!.value,
      cRONAME: this.editForm.get(['cRONAME'])!.value,
      rELATIONID: this.editForm.get(['rELATIONID'])!.value,
      wILLINGTOPAY: this.editForm.get(['wILLINGTOPAY'])!.value,
      fOLLOWUPDATE: this.editForm.get(['fOLLOWUPDATE'])!.value,
      dELINQUENCYREASON: this.editForm.get(['dELINQUENCYREASON'])!.value,
      vISITEDBY: this.editForm.get(['vISITEDBY'])!.value,
      cREATEDON: this.editForm.get(['cREATEDON'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<ICollectionTracking>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }
}
