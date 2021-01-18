import { Moment } from 'moment';

export interface ICollectionTracking {
  id?: number;
  eMPID?: string;
  eMPNAME?: string;
  uNITID?: string;
  pROMISEDATE?: Moment;
  cOMMENTS?: string;
  bUSINESSPROPOSALNO?: string;
  sUBPROPOSALNO?: string;
  mOBILENO?: string;
  aCCOUNTNO?: string;
  accountTitle?: string;
  oDDays?: number;
  oSAmount?: number;
  oSProfit?: number;
  cROID?: string;
  cRONAME?: string;
  rELATIONID?: string;
  wILLINGTOPAY?: string;
  fOLLOWUPDATE?: Moment;
  dELINQUENCYREASON?: string;
  vISITEDBY?: string;
  cREATEDON?: Moment;
}

export class CollectionTracking implements ICollectionTracking {
  constructor(
    public id?: number,
    public eMPID?: string,
    public eMPNAME?: string,
    public uNITID?: string,
    public pROMISEDATE?: Moment,
    public cOMMENTS?: string,
    public bUSINESSPROPOSALNO?: string,
    public sUBPROPOSALNO?: string,
    public mOBILENO?: string,
    public aCCOUNTNO?: string,
    public accountTitle?: string,
    public oDDays?: number,
    public oSAmount?: number,
    public oSProfit?: number,
    public cROID?: string,
    public cRONAME?: string,
    public rELATIONID?: string,
    public wILLINGTOPAY?: string,
    public fOLLOWUPDATE?: Moment,
    public dELINQUENCYREASON?: string,
    public vISITEDBY?: string,
    public cREATEDON?: Moment
  ) {}
}
