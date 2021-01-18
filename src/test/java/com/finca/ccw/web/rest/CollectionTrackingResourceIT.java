package com.finca.ccw.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.finca.ccw.CcwApplicationApp;
import com.finca.ccw.domain.CollectionTracking;
import com.finca.ccw.repository.CollectionTrackingRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link CollectionTrackingResource} REST controller.
 */
@SpringBootTest(classes = CcwApplicationApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class CollectionTrackingResourceIT {
    private static final String DEFAULT_E_MPID = "AAAAAAAAAA";
    private static final String UPDATED_E_MPID = "BBBBBBBBBB";

    private static final String DEFAULT_E_MPNAME = "AAAAAAAAAA";
    private static final String UPDATED_E_MPNAME = "BBBBBBBBBB";

    private static final String DEFAULT_U_NITID = "AAAAAAAAAA";
    private static final String UPDATED_U_NITID = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_P_ROMISEDATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_P_ROMISEDATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_C_OMMENTS = "AAAAAAAAAA";
    private static final String UPDATED_C_OMMENTS = "BBBBBBBBBB";

    private static final String DEFAULT_B_USINESSPROPOSALNO = "AAAAAAAAAA";
    private static final String UPDATED_B_USINESSPROPOSALNO = "BBBBBBBBBB";

    private static final String DEFAULT_S_UBPROPOSALNO = "AAAAAAAAAA";
    private static final String UPDATED_S_UBPROPOSALNO = "BBBBBBBBBB";

    private static final String DEFAULT_M_OBILENO = "AAAAAAAAAA";
    private static final String UPDATED_M_OBILENO = "BBBBBBBBBB";

    private static final String DEFAULT_A_CCOUNTNO = "AAAAAAAAAA";
    private static final String UPDATED_A_CCOUNTNO = "BBBBBBBBBB";

    private static final String DEFAULT_ACCOUNT_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_ACCOUNT_TITLE = "BBBBBBBBBB";

    private static final Integer DEFAULT_O_D_DAYS = 1;
    private static final Integer UPDATED_O_D_DAYS = 2;

    private static final BigDecimal DEFAULT_O_S_AMOUNT = new BigDecimal(1);
    private static final BigDecimal UPDATED_O_S_AMOUNT = new BigDecimal(2);

    private static final BigDecimal DEFAULT_O_S_PROFIT = new BigDecimal(1);
    private static final BigDecimal UPDATED_O_S_PROFIT = new BigDecimal(2);

    private static final String DEFAULT_C_ROID = "AAAAAAAAAA";
    private static final String UPDATED_C_ROID = "BBBBBBBBBB";

    private static final String DEFAULT_C_RONAME = "AAAAAAAAAA";
    private static final String UPDATED_C_RONAME = "BBBBBBBBBB";

    private static final String DEFAULT_R_ELATIONID = "AAAAAAAAAA";
    private static final String UPDATED_R_ELATIONID = "BBBBBBBBBB";

    private static final String DEFAULT_W_ILLINGTOPAY = "AAAAAAAAAA";
    private static final String UPDATED_W_ILLINGTOPAY = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_F_OLLOWUPDATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_F_OLLOWUPDATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_D_ELINQUENCYREASON = "AAAAAAAAAA";
    private static final String UPDATED_D_ELINQUENCYREASON = "BBBBBBBBBB";

    private static final String DEFAULT_V_ISITEDBY = "AAAAAAAAAA";
    private static final String UPDATED_V_ISITEDBY = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_C_REATEDON = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_C_REATEDON = LocalDate.now(ZoneId.systemDefault());

    @Autowired
    private CollectionTrackingRepository collectionTrackingRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restCollectionTrackingMockMvc;

    private CollectionTracking collectionTracking;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CollectionTracking createEntity(EntityManager em) {
        CollectionTracking collectionTracking = new CollectionTracking()
            .eMPID(DEFAULT_E_MPID)
            .eMPNAME(DEFAULT_E_MPNAME)
            .uNITID(DEFAULT_U_NITID)
            .pROMISEDATE(DEFAULT_P_ROMISEDATE)
            .cOMMENTS(DEFAULT_C_OMMENTS)
            .bUSINESSPROPOSALNO(DEFAULT_B_USINESSPROPOSALNO)
            .sUBPROPOSALNO(DEFAULT_S_UBPROPOSALNO)
            .mOBILENO(DEFAULT_M_OBILENO)
            .aCCOUNTNO(DEFAULT_A_CCOUNTNO)
            .accountTitle(DEFAULT_ACCOUNT_TITLE)
            .oDDays(DEFAULT_O_D_DAYS)
            .oSAmount(DEFAULT_O_S_AMOUNT)
            .oSProfit(DEFAULT_O_S_PROFIT)
            .cROID(DEFAULT_C_ROID)
            .cRONAME(DEFAULT_C_RONAME)
            .rELATIONID(DEFAULT_R_ELATIONID)
            .wILLINGTOPAY(DEFAULT_W_ILLINGTOPAY)
            .fOLLOWUPDATE(DEFAULT_F_OLLOWUPDATE)
            .dELINQUENCYREASON(DEFAULT_D_ELINQUENCYREASON)
            .vISITEDBY(DEFAULT_V_ISITEDBY)
            .cREATEDON(DEFAULT_C_REATEDON);
        return collectionTracking;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static CollectionTracking createUpdatedEntity(EntityManager em) {
        CollectionTracking collectionTracking = new CollectionTracking()
            .eMPID(UPDATED_E_MPID)
            .eMPNAME(UPDATED_E_MPNAME)
            .uNITID(UPDATED_U_NITID)
            .pROMISEDATE(UPDATED_P_ROMISEDATE)
            .cOMMENTS(UPDATED_C_OMMENTS)
            .bUSINESSPROPOSALNO(UPDATED_B_USINESSPROPOSALNO)
            .sUBPROPOSALNO(UPDATED_S_UBPROPOSALNO)
            .mOBILENO(UPDATED_M_OBILENO)
            .aCCOUNTNO(UPDATED_A_CCOUNTNO)
            .accountTitle(UPDATED_ACCOUNT_TITLE)
            .oDDays(UPDATED_O_D_DAYS)
            .oSAmount(UPDATED_O_S_AMOUNT)
            .oSProfit(UPDATED_O_S_PROFIT)
            .cROID(UPDATED_C_ROID)
            .cRONAME(UPDATED_C_RONAME)
            .rELATIONID(UPDATED_R_ELATIONID)
            .wILLINGTOPAY(UPDATED_W_ILLINGTOPAY)
            .fOLLOWUPDATE(UPDATED_F_OLLOWUPDATE)
            .dELINQUENCYREASON(UPDATED_D_ELINQUENCYREASON)
            .vISITEDBY(UPDATED_V_ISITEDBY)
            .cREATEDON(UPDATED_C_REATEDON);
        return collectionTracking;
    }

    @BeforeEach
    public void initTest() {
        collectionTracking = createEntity(em);
    }

    @Test
    @Transactional
    public void createCollectionTracking() throws Exception {
        int databaseSizeBeforeCreate = collectionTrackingRepository.findAll().size();
        // Create the CollectionTracking
        restCollectionTrackingMockMvc
            .perform(
                post("/api/collection-trackings")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(collectionTracking))
            )
            .andExpect(status().isCreated());

        // Validate the CollectionTracking in the database
        List<CollectionTracking> collectionTrackingList = collectionTrackingRepository.findAll();
        assertThat(collectionTrackingList).hasSize(databaseSizeBeforeCreate + 1);
        CollectionTracking testCollectionTracking = collectionTrackingList.get(collectionTrackingList.size() - 1);
        assertThat(testCollectionTracking.geteMPID()).isEqualTo(DEFAULT_E_MPID);
        assertThat(testCollectionTracking.geteMPNAME()).isEqualTo(DEFAULT_E_MPNAME);
        assertThat(testCollectionTracking.getuNITID()).isEqualTo(DEFAULT_U_NITID);
        assertThat(testCollectionTracking.getpROMISEDATE()).isEqualTo(DEFAULT_P_ROMISEDATE);
        assertThat(testCollectionTracking.getcOMMENTS()).isEqualTo(DEFAULT_C_OMMENTS);
        assertThat(testCollectionTracking.getbUSINESSPROPOSALNO()).isEqualTo(DEFAULT_B_USINESSPROPOSALNO);
        assertThat(testCollectionTracking.getsUBPROPOSALNO()).isEqualTo(DEFAULT_S_UBPROPOSALNO);
        assertThat(testCollectionTracking.getmOBILENO()).isEqualTo(DEFAULT_M_OBILENO);
        assertThat(testCollectionTracking.getaCCOUNTNO()).isEqualTo(DEFAULT_A_CCOUNTNO);
        assertThat(testCollectionTracking.getAccountTitle()).isEqualTo(DEFAULT_ACCOUNT_TITLE);
        assertThat(testCollectionTracking.getoDDays()).isEqualTo(DEFAULT_O_D_DAYS);
        assertThat(testCollectionTracking.getoSAmount()).isEqualTo(DEFAULT_O_S_AMOUNT);
        assertThat(testCollectionTracking.getoSProfit()).isEqualTo(DEFAULT_O_S_PROFIT);
        assertThat(testCollectionTracking.getcROID()).isEqualTo(DEFAULT_C_ROID);
        assertThat(testCollectionTracking.getcRONAME()).isEqualTo(DEFAULT_C_RONAME);
        assertThat(testCollectionTracking.getrELATIONID()).isEqualTo(DEFAULT_R_ELATIONID);
        assertThat(testCollectionTracking.getwILLINGTOPAY()).isEqualTo(DEFAULT_W_ILLINGTOPAY);
        assertThat(testCollectionTracking.getfOLLOWUPDATE()).isEqualTo(DEFAULT_F_OLLOWUPDATE);
        assertThat(testCollectionTracking.getdELINQUENCYREASON()).isEqualTo(DEFAULT_D_ELINQUENCYREASON);
        assertThat(testCollectionTracking.getvISITEDBY()).isEqualTo(DEFAULT_V_ISITEDBY);
        assertThat(testCollectionTracking.getcREATEDON()).isEqualTo(DEFAULT_C_REATEDON);
    }

    @Test
    @Transactional
    public void createCollectionTrackingWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = collectionTrackingRepository.findAll().size();

        // Create the CollectionTracking with an existing ID
        collectionTracking.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restCollectionTrackingMockMvc
            .perform(
                post("/api/collection-trackings")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(collectionTracking))
            )
            .andExpect(status().isBadRequest());

        // Validate the CollectionTracking in the database
        List<CollectionTracking> collectionTrackingList = collectionTrackingRepository.findAll();
        assertThat(collectionTrackingList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkeMPIDIsRequired() throws Exception {
        int databaseSizeBeforeTest = collectionTrackingRepository.findAll().size();
        // set the field null
        collectionTracking.seteMPID(null);

        // Create the CollectionTracking, which fails.

        restCollectionTrackingMockMvc
            .perform(
                post("/api/collection-trackings")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(collectionTracking))
            )
            .andExpect(status().isBadRequest());

        List<CollectionTracking> collectionTrackingList = collectionTrackingRepository.findAll();
        assertThat(collectionTrackingList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkeMPNAMEIsRequired() throws Exception {
        int databaseSizeBeforeTest = collectionTrackingRepository.findAll().size();
        // set the field null
        collectionTracking.seteMPNAME(null);

        // Create the CollectionTracking, which fails.

        restCollectionTrackingMockMvc
            .perform(
                post("/api/collection-trackings")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(collectionTracking))
            )
            .andExpect(status().isBadRequest());

        List<CollectionTracking> collectionTrackingList = collectionTrackingRepository.findAll();
        assertThat(collectionTrackingList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkuNITIDIsRequired() throws Exception {
        int databaseSizeBeforeTest = collectionTrackingRepository.findAll().size();
        // set the field null
        collectionTracking.setuNITID(null);

        // Create the CollectionTracking, which fails.

        restCollectionTrackingMockMvc
            .perform(
                post("/api/collection-trackings")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(collectionTracking))
            )
            .andExpect(status().isBadRequest());

        List<CollectionTracking> collectionTrackingList = collectionTrackingRepository.findAll();
        assertThat(collectionTrackingList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkcOMMENTSIsRequired() throws Exception {
        int databaseSizeBeforeTest = collectionTrackingRepository.findAll().size();
        // set the field null
        collectionTracking.setcOMMENTS(null);

        // Create the CollectionTracking, which fails.

        restCollectionTrackingMockMvc
            .perform(
                post("/api/collection-trackings")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(collectionTracking))
            )
            .andExpect(status().isBadRequest());

        List<CollectionTracking> collectionTrackingList = collectionTrackingRepository.findAll();
        assertThat(collectionTrackingList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkbUSINESSPROPOSALNOIsRequired() throws Exception {
        int databaseSizeBeforeTest = collectionTrackingRepository.findAll().size();
        // set the field null
        collectionTracking.setbUSINESSPROPOSALNO(null);

        // Create the CollectionTracking, which fails.

        restCollectionTrackingMockMvc
            .perform(
                post("/api/collection-trackings")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(collectionTracking))
            )
            .andExpect(status().isBadRequest());

        List<CollectionTracking> collectionTrackingList = collectionTrackingRepository.findAll();
        assertThat(collectionTrackingList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checksUBPROPOSALNOIsRequired() throws Exception {
        int databaseSizeBeforeTest = collectionTrackingRepository.findAll().size();
        // set the field null
        collectionTracking.setsUBPROPOSALNO(null);

        // Create the CollectionTracking, which fails.

        restCollectionTrackingMockMvc
            .perform(
                post("/api/collection-trackings")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(collectionTracking))
            )
            .andExpect(status().isBadRequest());

        List<CollectionTracking> collectionTrackingList = collectionTrackingRepository.findAll();
        assertThat(collectionTrackingList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkmOBILENOIsRequired() throws Exception {
        int databaseSizeBeforeTest = collectionTrackingRepository.findAll().size();
        // set the field null
        collectionTracking.setmOBILENO(null);

        // Create the CollectionTracking, which fails.

        restCollectionTrackingMockMvc
            .perform(
                post("/api/collection-trackings")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(collectionTracking))
            )
            .andExpect(status().isBadRequest());

        List<CollectionTracking> collectionTrackingList = collectionTrackingRepository.findAll();
        assertThat(collectionTrackingList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkaCCOUNTNOIsRequired() throws Exception {
        int databaseSizeBeforeTest = collectionTrackingRepository.findAll().size();
        // set the field null
        collectionTracking.setaCCOUNTNO(null);

        // Create the CollectionTracking, which fails.

        restCollectionTrackingMockMvc
            .perform(
                post("/api/collection-trackings")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(collectionTracking))
            )
            .andExpect(status().isBadRequest());

        List<CollectionTracking> collectionTrackingList = collectionTrackingRepository.findAll();
        assertThat(collectionTrackingList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkAccountTitleIsRequired() throws Exception {
        int databaseSizeBeforeTest = collectionTrackingRepository.findAll().size();
        // set the field null
        collectionTracking.setAccountTitle(null);

        // Create the CollectionTracking, which fails.

        restCollectionTrackingMockMvc
            .perform(
                post("/api/collection-trackings")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(collectionTracking))
            )
            .andExpect(status().isBadRequest());

        List<CollectionTracking> collectionTrackingList = collectionTrackingRepository.findAll();
        assertThat(collectionTrackingList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkoDDaysIsRequired() throws Exception {
        int databaseSizeBeforeTest = collectionTrackingRepository.findAll().size();
        // set the field null
        collectionTracking.setoDDays(null);

        // Create the CollectionTracking, which fails.

        restCollectionTrackingMockMvc
            .perform(
                post("/api/collection-trackings")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(collectionTracking))
            )
            .andExpect(status().isBadRequest());

        List<CollectionTracking> collectionTrackingList = collectionTrackingRepository.findAll();
        assertThat(collectionTrackingList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkoSAmountIsRequired() throws Exception {
        int databaseSizeBeforeTest = collectionTrackingRepository.findAll().size();
        // set the field null
        collectionTracking.setoSAmount(null);

        // Create the CollectionTracking, which fails.

        restCollectionTrackingMockMvc
            .perform(
                post("/api/collection-trackings")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(collectionTracking))
            )
            .andExpect(status().isBadRequest());

        List<CollectionTracking> collectionTrackingList = collectionTrackingRepository.findAll();
        assertThat(collectionTrackingList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkoSProfitIsRequired() throws Exception {
        int databaseSizeBeforeTest = collectionTrackingRepository.findAll().size();
        // set the field null
        collectionTracking.setoSProfit(null);

        // Create the CollectionTracking, which fails.

        restCollectionTrackingMockMvc
            .perform(
                post("/api/collection-trackings")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(collectionTracking))
            )
            .andExpect(status().isBadRequest());

        List<CollectionTracking> collectionTrackingList = collectionTrackingRepository.findAll();
        assertThat(collectionTrackingList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkcROIDIsRequired() throws Exception {
        int databaseSizeBeforeTest = collectionTrackingRepository.findAll().size();
        // set the field null
        collectionTracking.setcROID(null);

        // Create the CollectionTracking, which fails.

        restCollectionTrackingMockMvc
            .perform(
                post("/api/collection-trackings")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(collectionTracking))
            )
            .andExpect(status().isBadRequest());

        List<CollectionTracking> collectionTrackingList = collectionTrackingRepository.findAll();
        assertThat(collectionTrackingList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkcRONAMEIsRequired() throws Exception {
        int databaseSizeBeforeTest = collectionTrackingRepository.findAll().size();
        // set the field null
        collectionTracking.setcRONAME(null);

        // Create the CollectionTracking, which fails.

        restCollectionTrackingMockMvc
            .perform(
                post("/api/collection-trackings")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(collectionTracking))
            )
            .andExpect(status().isBadRequest());

        List<CollectionTracking> collectionTrackingList = collectionTrackingRepository.findAll();
        assertThat(collectionTrackingList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkrELATIONIDIsRequired() throws Exception {
        int databaseSizeBeforeTest = collectionTrackingRepository.findAll().size();
        // set the field null
        collectionTracking.setrELATIONID(null);

        // Create the CollectionTracking, which fails.

        restCollectionTrackingMockMvc
            .perform(
                post("/api/collection-trackings")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(collectionTracking))
            )
            .andExpect(status().isBadRequest());

        List<CollectionTracking> collectionTrackingList = collectionTrackingRepository.findAll();
        assertThat(collectionTrackingList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkwILLINGTOPAYIsRequired() throws Exception {
        int databaseSizeBeforeTest = collectionTrackingRepository.findAll().size();
        // set the field null
        collectionTracking.setwILLINGTOPAY(null);

        // Create the CollectionTracking, which fails.

        restCollectionTrackingMockMvc
            .perform(
                post("/api/collection-trackings")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(collectionTracking))
            )
            .andExpect(status().isBadRequest());

        List<CollectionTracking> collectionTrackingList = collectionTrackingRepository.findAll();
        assertThat(collectionTrackingList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllCollectionTrackings() throws Exception {
        // Initialize the database
        collectionTrackingRepository.saveAndFlush(collectionTracking);

        // Get all the collectionTrackingList
        restCollectionTrackingMockMvc
            .perform(get("/api/collection-trackings?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(collectionTracking.getId().intValue())))
            .andExpect(jsonPath("$.[*].eMPID").value(hasItem(DEFAULT_E_MPID)))
            .andExpect(jsonPath("$.[*].eMPNAME").value(hasItem(DEFAULT_E_MPNAME)))
            .andExpect(jsonPath("$.[*].uNITID").value(hasItem(DEFAULT_U_NITID)))
            .andExpect(jsonPath("$.[*].pROMISEDATE").value(hasItem(DEFAULT_P_ROMISEDATE.toString())))
            .andExpect(jsonPath("$.[*].cOMMENTS").value(hasItem(DEFAULT_C_OMMENTS)))
            .andExpect(jsonPath("$.[*].bUSINESSPROPOSALNO").value(hasItem(DEFAULT_B_USINESSPROPOSALNO)))
            .andExpect(jsonPath("$.[*].sUBPROPOSALNO").value(hasItem(DEFAULT_S_UBPROPOSALNO)))
            .andExpect(jsonPath("$.[*].mOBILENO").value(hasItem(DEFAULT_M_OBILENO)))
            .andExpect(jsonPath("$.[*].aCCOUNTNO").value(hasItem(DEFAULT_A_CCOUNTNO)))
            .andExpect(jsonPath("$.[*].accountTitle").value(hasItem(DEFAULT_ACCOUNT_TITLE)))
            .andExpect(jsonPath("$.[*].oDDays").value(hasItem(DEFAULT_O_D_DAYS)))
            .andExpect(jsonPath("$.[*].oSAmount").value(hasItem(DEFAULT_O_S_AMOUNT.intValue())))
            .andExpect(jsonPath("$.[*].oSProfit").value(hasItem(DEFAULT_O_S_PROFIT.intValue())))
            .andExpect(jsonPath("$.[*].cROID").value(hasItem(DEFAULT_C_ROID)))
            .andExpect(jsonPath("$.[*].cRONAME").value(hasItem(DEFAULT_C_RONAME)))
            .andExpect(jsonPath("$.[*].rELATIONID").value(hasItem(DEFAULT_R_ELATIONID)))
            .andExpect(jsonPath("$.[*].wILLINGTOPAY").value(hasItem(DEFAULT_W_ILLINGTOPAY)))
            .andExpect(jsonPath("$.[*].fOLLOWUPDATE").value(hasItem(DEFAULT_F_OLLOWUPDATE.toString())))
            .andExpect(jsonPath("$.[*].dELINQUENCYREASON").value(hasItem(DEFAULT_D_ELINQUENCYREASON)))
            .andExpect(jsonPath("$.[*].vISITEDBY").value(hasItem(DEFAULT_V_ISITEDBY)))
            .andExpect(jsonPath("$.[*].cREATEDON").value(hasItem(DEFAULT_C_REATEDON.toString())));
    }

    @Test
    @Transactional
    public void getCollectionTracking() throws Exception {
        // Initialize the database
        collectionTrackingRepository.saveAndFlush(collectionTracking);

        // Get the collectionTracking
        restCollectionTrackingMockMvc
            .perform(get("/api/collection-trackings/{id}", collectionTracking.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(collectionTracking.getId().intValue()))
            .andExpect(jsonPath("$.eMPID").value(DEFAULT_E_MPID))
            .andExpect(jsonPath("$.eMPNAME").value(DEFAULT_E_MPNAME))
            .andExpect(jsonPath("$.uNITID").value(DEFAULT_U_NITID))
            .andExpect(jsonPath("$.pROMISEDATE").value(DEFAULT_P_ROMISEDATE.toString()))
            .andExpect(jsonPath("$.cOMMENTS").value(DEFAULT_C_OMMENTS))
            .andExpect(jsonPath("$.bUSINESSPROPOSALNO").value(DEFAULT_B_USINESSPROPOSALNO))
            .andExpect(jsonPath("$.sUBPROPOSALNO").value(DEFAULT_S_UBPROPOSALNO))
            .andExpect(jsonPath("$.mOBILENO").value(DEFAULT_M_OBILENO))
            .andExpect(jsonPath("$.aCCOUNTNO").value(DEFAULT_A_CCOUNTNO))
            .andExpect(jsonPath("$.accountTitle").value(DEFAULT_ACCOUNT_TITLE))
            .andExpect(jsonPath("$.oDDays").value(DEFAULT_O_D_DAYS))
            .andExpect(jsonPath("$.oSAmount").value(DEFAULT_O_S_AMOUNT.intValue()))
            .andExpect(jsonPath("$.oSProfit").value(DEFAULT_O_S_PROFIT.intValue()))
            .andExpect(jsonPath("$.cROID").value(DEFAULT_C_ROID))
            .andExpect(jsonPath("$.cRONAME").value(DEFAULT_C_RONAME))
            .andExpect(jsonPath("$.rELATIONID").value(DEFAULT_R_ELATIONID))
            .andExpect(jsonPath("$.wILLINGTOPAY").value(DEFAULT_W_ILLINGTOPAY))
            .andExpect(jsonPath("$.fOLLOWUPDATE").value(DEFAULT_F_OLLOWUPDATE.toString()))
            .andExpect(jsonPath("$.dELINQUENCYREASON").value(DEFAULT_D_ELINQUENCYREASON))
            .andExpect(jsonPath("$.vISITEDBY").value(DEFAULT_V_ISITEDBY))
            .andExpect(jsonPath("$.cREATEDON").value(DEFAULT_C_REATEDON.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingCollectionTracking() throws Exception {
        // Get the collectionTracking
        restCollectionTrackingMockMvc.perform(get("/api/collection-trackings/{id}", Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateCollectionTracking() throws Exception {
        // Initialize the database
        collectionTrackingRepository.saveAndFlush(collectionTracking);

        int databaseSizeBeforeUpdate = collectionTrackingRepository.findAll().size();

        // Update the collectionTracking
        CollectionTracking updatedCollectionTracking = collectionTrackingRepository.findById(collectionTracking.getId()).get();
        // Disconnect from session so that the updates on updatedCollectionTracking are not directly saved in db
        em.detach(updatedCollectionTracking);
        updatedCollectionTracking
            .eMPID(UPDATED_E_MPID)
            .eMPNAME(UPDATED_E_MPNAME)
            .uNITID(UPDATED_U_NITID)
            .pROMISEDATE(UPDATED_P_ROMISEDATE)
            .cOMMENTS(UPDATED_C_OMMENTS)
            .bUSINESSPROPOSALNO(UPDATED_B_USINESSPROPOSALNO)
            .sUBPROPOSALNO(UPDATED_S_UBPROPOSALNO)
            .mOBILENO(UPDATED_M_OBILENO)
            .aCCOUNTNO(UPDATED_A_CCOUNTNO)
            .accountTitle(UPDATED_ACCOUNT_TITLE)
            .oDDays(UPDATED_O_D_DAYS)
            .oSAmount(UPDATED_O_S_AMOUNT)
            .oSProfit(UPDATED_O_S_PROFIT)
            .cROID(UPDATED_C_ROID)
            .cRONAME(UPDATED_C_RONAME)
            .rELATIONID(UPDATED_R_ELATIONID)
            .wILLINGTOPAY(UPDATED_W_ILLINGTOPAY)
            .fOLLOWUPDATE(UPDATED_F_OLLOWUPDATE)
            .dELINQUENCYREASON(UPDATED_D_ELINQUENCYREASON)
            .vISITEDBY(UPDATED_V_ISITEDBY)
            .cREATEDON(UPDATED_C_REATEDON);

        restCollectionTrackingMockMvc
            .perform(
                put("/api/collection-trackings")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(updatedCollectionTracking))
            )
            .andExpect(status().isOk());

        // Validate the CollectionTracking in the database
        List<CollectionTracking> collectionTrackingList = collectionTrackingRepository.findAll();
        assertThat(collectionTrackingList).hasSize(databaseSizeBeforeUpdate);
        CollectionTracking testCollectionTracking = collectionTrackingList.get(collectionTrackingList.size() - 1);
        assertThat(testCollectionTracking.geteMPID()).isEqualTo(UPDATED_E_MPID);
        assertThat(testCollectionTracking.geteMPNAME()).isEqualTo(UPDATED_E_MPNAME);
        assertThat(testCollectionTracking.getuNITID()).isEqualTo(UPDATED_U_NITID);
        assertThat(testCollectionTracking.getpROMISEDATE()).isEqualTo(UPDATED_P_ROMISEDATE);
        assertThat(testCollectionTracking.getcOMMENTS()).isEqualTo(UPDATED_C_OMMENTS);
        assertThat(testCollectionTracking.getbUSINESSPROPOSALNO()).isEqualTo(UPDATED_B_USINESSPROPOSALNO);
        assertThat(testCollectionTracking.getsUBPROPOSALNO()).isEqualTo(UPDATED_S_UBPROPOSALNO);
        assertThat(testCollectionTracking.getmOBILENO()).isEqualTo(UPDATED_M_OBILENO);
        assertThat(testCollectionTracking.getaCCOUNTNO()).isEqualTo(UPDATED_A_CCOUNTNO);
        assertThat(testCollectionTracking.getAccountTitle()).isEqualTo(UPDATED_ACCOUNT_TITLE);
        assertThat(testCollectionTracking.getoDDays()).isEqualTo(UPDATED_O_D_DAYS);
        assertThat(testCollectionTracking.getoSAmount()).isEqualTo(UPDATED_O_S_AMOUNT);
        assertThat(testCollectionTracking.getoSProfit()).isEqualTo(UPDATED_O_S_PROFIT);
        assertThat(testCollectionTracking.getcROID()).isEqualTo(UPDATED_C_ROID);
        assertThat(testCollectionTracking.getcRONAME()).isEqualTo(UPDATED_C_RONAME);
        assertThat(testCollectionTracking.getrELATIONID()).isEqualTo(UPDATED_R_ELATIONID);
        assertThat(testCollectionTracking.getwILLINGTOPAY()).isEqualTo(UPDATED_W_ILLINGTOPAY);
        assertThat(testCollectionTracking.getfOLLOWUPDATE()).isEqualTo(UPDATED_F_OLLOWUPDATE);
        assertThat(testCollectionTracking.getdELINQUENCYREASON()).isEqualTo(UPDATED_D_ELINQUENCYREASON);
        assertThat(testCollectionTracking.getvISITEDBY()).isEqualTo(UPDATED_V_ISITEDBY);
        assertThat(testCollectionTracking.getcREATEDON()).isEqualTo(UPDATED_C_REATEDON);
    }

    @Test
    @Transactional
    public void updateNonExistingCollectionTracking() throws Exception {
        int databaseSizeBeforeUpdate = collectionTrackingRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restCollectionTrackingMockMvc
            .perform(
                put("/api/collection-trackings")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(collectionTracking))
            )
            .andExpect(status().isBadRequest());

        // Validate the CollectionTracking in the database
        List<CollectionTracking> collectionTrackingList = collectionTrackingRepository.findAll();
        assertThat(collectionTrackingList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteCollectionTracking() throws Exception {
        // Initialize the database
        collectionTrackingRepository.saveAndFlush(collectionTracking);

        int databaseSizeBeforeDelete = collectionTrackingRepository.findAll().size();

        // Delete the collectionTracking
        restCollectionTrackingMockMvc
            .perform(delete("/api/collection-trackings/{id}", collectionTracking.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<CollectionTracking> collectionTrackingList = collectionTrackingRepository.findAll();
        assertThat(collectionTrackingList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
