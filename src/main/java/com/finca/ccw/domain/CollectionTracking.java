package com.finca.ccw.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A CollectionTracking.
 */
@Entity
@Table(name = "collection_tracking")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CollectionTracking implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "e_mpid", nullable = false)
    private String eMPID;

    @NotNull
    @Column(name = "e_mpname", nullable = false)
    private String eMPNAME;

    @NotNull
    @Column(name = "u_nitid", nullable = false)
    private String uNITID;

    @Column(name = "p_romisedate")
    private LocalDate pROMISEDATE;

    @NotNull
    @Column(name = "c_omments", nullable = false)
    private String cOMMENTS;

    @NotNull
    @Column(name = "b_usinessproposalno", nullable = false)
    private String bUSINESSPROPOSALNO;

    @NotNull
    @Column(name = "s_ubproposalno", nullable = false)
    private String sUBPROPOSALNO;

    @NotNull
    @Column(name = "m_obileno", nullable = false)
    private String mOBILENO;

    @NotNull
    @Column(name = "a_ccountno", nullable = false)
    private String aCCOUNTNO;

    @NotNull
    @Column(name = "account_title", nullable = false)
    private String accountTitle;

    @NotNull
    @Column(name = "o_d_days", nullable = false)
    private Integer oDDays;

    @NotNull
    @Column(name = "o_s_amount", precision = 21, scale = 2, nullable = false)
    private BigDecimal oSAmount;

    @NotNull
    @Column(name = "o_s_profit", precision = 21, scale = 2, nullable = false)
    private BigDecimal oSProfit;

    @NotNull
    @Column(name = "c_roid", nullable = false)
    private String cROID;

    @NotNull
    @Column(name = "c_roname", nullable = false)
    private String cRONAME;

    @NotNull
    @Column(name = "r_elationid", nullable = false)
    private String rELATIONID;

    @NotNull
    @Column(name = "w_illingtopay", nullable = false)
    private String wILLINGTOPAY;

    @Column(name = "f_ollowupdate")
    private LocalDate fOLLOWUPDATE;

    @Column(name = "d_elinquencyreason")
    private String dELINQUENCYREASON;

    @Column(name = "v_isitedby")
    private String vISITEDBY;

    @Column(name = "c_reatedon")
    private LocalDate cREATEDON;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String geteMPID() {
        return eMPID;
    }

    public CollectionTracking eMPID(String eMPID) {
        this.eMPID = eMPID;
        return this;
    }

    public void seteMPID(String eMPID) {
        this.eMPID = eMPID;
    }

    public String geteMPNAME() {
        return eMPNAME;
    }

    public CollectionTracking eMPNAME(String eMPNAME) {
        this.eMPNAME = eMPNAME;
        return this;
    }

    public void seteMPNAME(String eMPNAME) {
        this.eMPNAME = eMPNAME;
    }

    public String getuNITID() {
        return uNITID;
    }

    public CollectionTracking uNITID(String uNITID) {
        this.uNITID = uNITID;
        return this;
    }

    public void setuNITID(String uNITID) {
        this.uNITID = uNITID;
    }

    public LocalDate getpROMISEDATE() {
        return pROMISEDATE;
    }

    public CollectionTracking pROMISEDATE(LocalDate pROMISEDATE) {
        this.pROMISEDATE = pROMISEDATE;
        return this;
    }

    public void setpROMISEDATE(LocalDate pROMISEDATE) {
        this.pROMISEDATE = pROMISEDATE;
    }

    public String getcOMMENTS() {
        return cOMMENTS;
    }

    public CollectionTracking cOMMENTS(String cOMMENTS) {
        this.cOMMENTS = cOMMENTS;
        return this;
    }

    public void setcOMMENTS(String cOMMENTS) {
        this.cOMMENTS = cOMMENTS;
    }

    public String getbUSINESSPROPOSALNO() {
        return bUSINESSPROPOSALNO;
    }

    public CollectionTracking bUSINESSPROPOSALNO(String bUSINESSPROPOSALNO) {
        this.bUSINESSPROPOSALNO = bUSINESSPROPOSALNO;
        return this;
    }

    public void setbUSINESSPROPOSALNO(String bUSINESSPROPOSALNO) {
        this.bUSINESSPROPOSALNO = bUSINESSPROPOSALNO;
    }

    public String getsUBPROPOSALNO() {
        return sUBPROPOSALNO;
    }

    public CollectionTracking sUBPROPOSALNO(String sUBPROPOSALNO) {
        this.sUBPROPOSALNO = sUBPROPOSALNO;
        return this;
    }

    public void setsUBPROPOSALNO(String sUBPROPOSALNO) {
        this.sUBPROPOSALNO = sUBPROPOSALNO;
    }

    public String getmOBILENO() {
        return mOBILENO;
    }

    public CollectionTracking mOBILENO(String mOBILENO) {
        this.mOBILENO = mOBILENO;
        return this;
    }

    public void setmOBILENO(String mOBILENO) {
        this.mOBILENO = mOBILENO;
    }

    public String getaCCOUNTNO() {
        return aCCOUNTNO;
    }

    public CollectionTracking aCCOUNTNO(String aCCOUNTNO) {
        this.aCCOUNTNO = aCCOUNTNO;
        return this;
    }

    public void setaCCOUNTNO(String aCCOUNTNO) {
        this.aCCOUNTNO = aCCOUNTNO;
    }

    public String getAccountTitle() {
        return accountTitle;
    }

    public CollectionTracking accountTitle(String accountTitle) {
        this.accountTitle = accountTitle;
        return this;
    }

    public void setAccountTitle(String accountTitle) {
        this.accountTitle = accountTitle;
    }

    public Integer getoDDays() {
        return oDDays;
    }

    public CollectionTracking oDDays(Integer oDDays) {
        this.oDDays = oDDays;
        return this;
    }

    public void setoDDays(Integer oDDays) {
        this.oDDays = oDDays;
    }

    public BigDecimal getoSAmount() {
        return oSAmount;
    }

    public CollectionTracking oSAmount(BigDecimal oSAmount) {
        this.oSAmount = oSAmount;
        return this;
    }

    public void setoSAmount(BigDecimal oSAmount) {
        this.oSAmount = oSAmount;
    }

    public BigDecimal getoSProfit() {
        return oSProfit;
    }

    public CollectionTracking oSProfit(BigDecimal oSProfit) {
        this.oSProfit = oSProfit;
        return this;
    }

    public void setoSProfit(BigDecimal oSProfit) {
        this.oSProfit = oSProfit;
    }

    public String getcROID() {
        return cROID;
    }

    public CollectionTracking cROID(String cROID) {
        this.cROID = cROID;
        return this;
    }

    public void setcROID(String cROID) {
        this.cROID = cROID;
    }

    public String getcRONAME() {
        return cRONAME;
    }

    public CollectionTracking cRONAME(String cRONAME) {
        this.cRONAME = cRONAME;
        return this;
    }

    public void setcRONAME(String cRONAME) {
        this.cRONAME = cRONAME;
    }

    public String getrELATIONID() {
        return rELATIONID;
    }

    public CollectionTracking rELATIONID(String rELATIONID) {
        this.rELATIONID = rELATIONID;
        return this;
    }

    public void setrELATIONID(String rELATIONID) {
        this.rELATIONID = rELATIONID;
    }

    public String getwILLINGTOPAY() {
        return wILLINGTOPAY;
    }

    public CollectionTracking wILLINGTOPAY(String wILLINGTOPAY) {
        this.wILLINGTOPAY = wILLINGTOPAY;
        return this;
    }

    public void setwILLINGTOPAY(String wILLINGTOPAY) {
        this.wILLINGTOPAY = wILLINGTOPAY;
    }

    public LocalDate getfOLLOWUPDATE() {
        return fOLLOWUPDATE;
    }

    public CollectionTracking fOLLOWUPDATE(LocalDate fOLLOWUPDATE) {
        this.fOLLOWUPDATE = fOLLOWUPDATE;
        return this;
    }

    public void setfOLLOWUPDATE(LocalDate fOLLOWUPDATE) {
        this.fOLLOWUPDATE = fOLLOWUPDATE;
    }

    public String getdELINQUENCYREASON() {
        return dELINQUENCYREASON;
    }

    public CollectionTracking dELINQUENCYREASON(String dELINQUENCYREASON) {
        this.dELINQUENCYREASON = dELINQUENCYREASON;
        return this;
    }

    public void setdELINQUENCYREASON(String dELINQUENCYREASON) {
        this.dELINQUENCYREASON = dELINQUENCYREASON;
    }

    public String getvISITEDBY() {
        return vISITEDBY;
    }

    public CollectionTracking vISITEDBY(String vISITEDBY) {
        this.vISITEDBY = vISITEDBY;
        return this;
    }

    public void setvISITEDBY(String vISITEDBY) {
        this.vISITEDBY = vISITEDBY;
    }

    public LocalDate getcREATEDON() {
        return cREATEDON;
    }

    public CollectionTracking cREATEDON(LocalDate cREATEDON) {
        this.cREATEDON = cREATEDON;
        return this;
    }

    public void setcREATEDON(LocalDate cREATEDON) {
        this.cREATEDON = cREATEDON;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CollectionTracking)) {
            return false;
        }
        return id != null && id.equals(((CollectionTracking) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CollectionTracking{" +
            "id=" + getId() +
            ", eMPID='" + geteMPID() + "'" +
            ", eMPNAME='" + geteMPNAME() + "'" +
            ", uNITID='" + getuNITID() + "'" +
            ", pROMISEDATE='" + getpROMISEDATE() + "'" +
            ", cOMMENTS='" + getcOMMENTS() + "'" +
            ", bUSINESSPROPOSALNO='" + getbUSINESSPROPOSALNO() + "'" +
            ", sUBPROPOSALNO='" + getsUBPROPOSALNO() + "'" +
            ", mOBILENO='" + getmOBILENO() + "'" +
            ", aCCOUNTNO='" + getaCCOUNTNO() + "'" +
            ", accountTitle='" + getAccountTitle() + "'" +
            ", oDDays=" + getoDDays() +
            ", oSAmount=" + getoSAmount() +
            ", oSProfit=" + getoSProfit() +
            ", cROID='" + getcROID() + "'" +
            ", cRONAME='" + getcRONAME() + "'" +
            ", rELATIONID='" + getrELATIONID() + "'" +
            ", wILLINGTOPAY='" + getwILLINGTOPAY() + "'" +
            ", fOLLOWUPDATE='" + getfOLLOWUPDATE() + "'" +
            ", dELINQUENCYREASON='" + getdELINQUENCYREASON() + "'" +
            ", vISITEDBY='" + getvISITEDBY() + "'" +
            ", cREATEDON='" + getcREATEDON() + "'" +
            "}";
    }
}
