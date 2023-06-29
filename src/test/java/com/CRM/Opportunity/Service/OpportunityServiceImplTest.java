package com.CRM.Opportunity.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.CRM.Opportunity.Entity.PersonOrCompany;
import com.CRM.Opportunity.Entity.Product;
import com.CRM.Opportunity.Model.OpportunityRequest;
import com.CRM.Opportunity.Model.OpportunityResponse;
import com.CRM.Opportunity.Repository.OpportunityRepository;
import com.CRM.Opportunity.Repository.ProductRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {OpportunityServiceImpl.class})
@ExtendWith(SpringExtension.class)
class OpportunityServiceImplTest {
    @MockBean
    private ModelMapper modelMapper;

    @MockBean
    private OpportunityRepository opportunityRepository;

    @Autowired
    private OpportunityServiceImpl opportunityServiceImpl;

    @MockBean
    private ProductRepository productRepository;


    @Test
    void testSaveOpportunity() {
        PersonOrCompany personOrCompany = new PersonOrCompany();
        personOrCompany.setActionExecutionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setActionExecutionStatus("Action Execution Status");
        personOrCompany.setActionRemarks("Action Remarks");
        personOrCompany.setAddress("42 Main St");
        personOrCompany.setDiscountAmount(10.0d);
        personOrCompany.setDiscountPercentage(10.0d);
        personOrCompany.setFirstName("Jane");
        personOrCompany.setId(1);
        personOrCompany.setLastNameOrCompanyName("Doe");
        personOrCompany.setMiddleName("Middle Name");
        personOrCompany.setNextOpportunityAction("Next Opportunity Action");
        personOrCompany.setNextOpportunityActionAssignedTo(1);
        personOrCompany.setNextOpportunityActionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setOpportunityAgingDays(1);
        personOrCompany.setOpportunityAmount(10.0d);
        personOrCompany.setOpportunityAssignedDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setOpportunityCaptureDatetime(LocalDate.ofEpochDay(1L));
        personOrCompany.setOpportunityClosureProbability(0.25d);
        personOrCompany.setOpportunityDisplayName("Opportunity Display Name");
        personOrCompany.setOpportunityLastContactDays(1);
        personOrCompany.setOpportunityProductList("Opportunity Product List");
        personOrCompany.setOpportunityStage("Opportunity Stage");
        personOrCompany.setOpportunityStatus(true);
        personOrCompany.setOwnerID(1);
        personOrCompany.setPersonOrCompany("Person Or Company");
        personOrCompany.setProduct(new ArrayList<>());
        personOrCompany.setProductDescription("Product Description");
        personOrCompany.setQuantity(1);
        personOrCompany.setQuotationAmount(10.0d);
        personOrCompany.setQuotationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setQuotationGivenBy(1);
        personOrCompany.setQuotationNumber("42");
        personOrCompany.setQuoteGenerated(true);
        personOrCompany.setSalutation("Salutation");
        personOrCompany.setTotalPrice(10.0d);
        personOrCompany.setUnitPrice(1);
        when(modelMapper.map((Object) any(), (Class<PersonOrCompany>) any())).thenReturn(personOrCompany);

//        PersonOrCompany personOrCompany1 = new PersonOrCompany();
//        personOrCompany1.setActionExecutionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
//        personOrCompany1.setActionExecutionStatus("Action Execution Status");
//        personOrCompany1.setActionRemarks("Action Remarks");
//        personOrCompany1.setAddress("42 Main St");
//        personOrCompany1.setDiscountAmount(10.0d);
//        personOrCompany1.setDiscountPercentage(10.0d);
//        personOrCompany1.setFirstName("Jane");
//        personOrCompany1.setId(1);
//        personOrCompany1.setLastNameOrCompanyName("Doe");
//        personOrCompany1.setMiddleName("Middle Name");
//        personOrCompany1.setNextOpportunityAction("Next Opportunity Action");
//        personOrCompany1.setNextOpportunityActionAssignedTo(1);
//        personOrCompany1.setNextOpportunityActionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
//        personOrCompany1.setOpportunityAgingDays(1);
//        personOrCompany1.setOpportunityAmount(10.0d);
//        personOrCompany1.setOpportunityAssignedDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
//        personOrCompany1.setOpportunityCaptureDatetime(LocalDate.ofEpochDay(1L));
//        personOrCompany1.setOpportunityClosureProbability(0.25d);
//        personOrCompany1.setOpportunityDisplayName("Opportunity Display Name");
//        personOrCompany1.setOpportunityLastContactDays(1);
//        personOrCompany1.setOpportunityProductList("Opportunity Product List");
//        personOrCompany1.setOpportunityStage("Opportunity Stage");
//        personOrCompany1.setOpportunityStatus(true);
//        personOrCompany1.setOwnerID(1);
//        personOrCompany1.setPersonOrCompany("Person Or Company");
//        personOrCompany1.setProduct(new ArrayList<>());
//        personOrCompany1.setProductDescription("Product Description");
//        personOrCompany1.setQuantity(1);
//        personOrCompany1.setQuotationAmount(10.0d);
//        personOrCompany1.setQuotationDate(LocalDateTime.of(1, 1, 1, 1, 1));
//        personOrCompany1.setQuotationGivenBy(1);
//        personOrCompany1.setQuotationNumber("42");
//        personOrCompany1.setQuoteGenerated(true);
//        personOrCompany1.setSalutation("Salutation");
//        personOrCompany1.setTotalPrice(10.0d);
//        personOrCompany1.setUnitPrice(1);
        when(opportunityRepository.save((PersonOrCompany) any())).thenReturn(personOrCompany);
        ResponseEntity<OpportunityResponse<PersonOrCompany>> actualSaveOpportunityResult = opportunityServiceImpl
                .saveOpportunity(new OpportunityRequest());
        assertTrue(actualSaveOpportunityResult.hasBody());
        assertTrue(actualSaveOpportunityResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.BAD_REQUEST, actualSaveOpportunityResult.getStatusCode());
        OpportunityResponse<PersonOrCompany> body = actualSaveOpportunityResult.getBody();
        assertEquals(
                "Exception In OpportunityServiceImpl : saveOpportunity() :: class com.CRM.Opportunity.Entity.PersonOrCompany"
                        + " cannot be cast to class com.CRM.Opportunity.Model.OpportunityRequest (com.CRM.Opportunity.Entity"
                        + ".PersonOrCompany and com.CRM.Opportunity.Model.OpportunityRequest are in unnamed module of loader"
                        + " com.diffblue.cover.f.g @3fe377ff)",
                body.getReasonText());
        assertEquals("Fail", body.getStatus());
        verify(modelMapper, atLeast(1)).map((Object) any(), (Class<Object>) any());
        verify(opportunityRepository).save((PersonOrCompany) any());
    }

    /**
     * Method under test: {@link OpportunityServiceImpl#saveOpportunity(OpportunityRequest)}
     */
    @Test
    void testSaveOpportunity2() {
        PersonOrCompany personOrCompany = mock(PersonOrCompany.class);
        when(personOrCompany.getFirstName()).thenReturn("Jane");
        when(personOrCompany.getLastNameOrCompanyName()).thenReturn("Doe");
        when(personOrCompany.getMiddleName()).thenReturn("Middle Name");
        when(personOrCompany.getSalutation()).thenReturn("Salutation");
        doNothing().when(personOrCompany).setActionExecutionDatetime((LocalDateTime) any());
        doNothing().when(personOrCompany).setActionExecutionStatus((String) any());
        doNothing().when(personOrCompany).setActionRemarks((String) any());
        doNothing().when(personOrCompany).setAddress((String) any());
        doNothing().when(personOrCompany).setDiscountAmount(anyDouble());
        doNothing().when(personOrCompany).setDiscountPercentage(anyDouble());
        doNothing().when(personOrCompany).setFirstName((String) any());
        doNothing().when(personOrCompany).setId(anyInt());
        doNothing().when(personOrCompany).setLastNameOrCompanyName((String) any());
        doNothing().when(personOrCompany).setMiddleName((String) any());
        doNothing().when(personOrCompany).setNextOpportunityAction((String) any());
        doNothing().when(personOrCompany).setNextOpportunityActionAssignedTo(anyInt());
        doNothing().when(personOrCompany).setNextOpportunityActionDatetime((LocalDateTime) any());
        doNothing().when(personOrCompany).setOpportunityAgingDays(anyInt());
        doNothing().when(personOrCompany).setOpportunityAmount(anyDouble());
        doNothing().when(personOrCompany).setOpportunityAssignedDatetime((LocalDateTime) any());
        doNothing().when(personOrCompany).setOpportunityCaptureDatetime((LocalDate) any());
        doNothing().when(personOrCompany).setOpportunityClosureProbability(anyDouble());
        doNothing().when(personOrCompany).setOpportunityDisplayName((String) any());
        doNothing().when(personOrCompany).setOpportunityLastContactDays(anyInt());
        doNothing().when(personOrCompany).setOpportunityProductList((String) any());
        doNothing().when(personOrCompany).setOpportunityStage((String) any());
        doNothing().when(personOrCompany).setOpportunityStatus(anyBoolean());
        doNothing().when(personOrCompany).setOwnerID(anyInt());
        doNothing().when(personOrCompany).setPersonOrCompany((String) any());
        doNothing().when(personOrCompany).setProduct((List<Product>) any());
        doNothing().when(personOrCompany).setProductDescription((String) any());
        doNothing().when(personOrCompany).setQuantity(anyInt());
        doNothing().when(personOrCompany).setQuotationAmount(anyDouble());
        doNothing().when(personOrCompany).setQuotationDate((LocalDateTime) any());
        doNothing().when(personOrCompany).setQuotationGivenBy(anyInt());
        doNothing().when(personOrCompany).setQuotationNumber((String) any());
        doNothing().when(personOrCompany).setQuoteGenerated(anyBoolean());
        doNothing().when(personOrCompany).setSalutation((String) any());
        doNothing().when(personOrCompany).setTotalPrice(anyDouble());
        doNothing().when(personOrCompany).setUnitPrice(anyInt());
        personOrCompany.setActionExecutionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setActionExecutionStatus("Action Execution Status");
        personOrCompany.setActionRemarks("Action Remarks");
        personOrCompany.setAddress("42 Main St");
        personOrCompany.setDiscountAmount(10.0d);
        personOrCompany.setDiscountPercentage(10.0d);
        personOrCompany.setFirstName("Jane");
        personOrCompany.setId(1);
        personOrCompany.setLastNameOrCompanyName("Doe");
        personOrCompany.setMiddleName("Middle Name");
        personOrCompany.setNextOpportunityAction("Next Opportunity Action");
        personOrCompany.setNextOpportunityActionAssignedTo(1);
        personOrCompany.setNextOpportunityActionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setOpportunityAgingDays(1);
        personOrCompany.setOpportunityAmount(10.0d);
        personOrCompany.setOpportunityAssignedDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setOpportunityCaptureDatetime(LocalDate.ofEpochDay(1L));
        personOrCompany.setOpportunityClosureProbability(0.25d);
        personOrCompany.setOpportunityDisplayName("Opportunity Display Name");
        personOrCompany.setOpportunityLastContactDays(1);
        personOrCompany.setOpportunityProductList("Opportunity Product List");
        personOrCompany.setOpportunityStage("Opportunity Stage");
        personOrCompany.setOpportunityStatus(true);
        personOrCompany.setOwnerID(1);
        personOrCompany.setPersonOrCompany("Person Or Company");
        personOrCompany.setProduct(new ArrayList<>());
        personOrCompany.setProductDescription("Product Description");
        personOrCompany.setQuantity(1);
        personOrCompany.setQuotationAmount(10.0d);
        personOrCompany.setQuotationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setQuotationGivenBy(1);
        personOrCompany.setQuotationNumber("42");
        personOrCompany.setQuoteGenerated(true);
        personOrCompany.setSalutation("Salutation");
        personOrCompany.setTotalPrice(10.0d);
        personOrCompany.setUnitPrice(1);
        when(modelMapper.map((Object) any(), (Class<PersonOrCompany>) any())).thenReturn(personOrCompany);

//        PersonOrCompany personOrCompany1 = new PersonOrCompany();
//        personOrCompany1.setActionExecutionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
//        personOrCompany1.setActionExecutionStatus("Action Execution Status");
//        personOrCompany1.setActionRemarks("Action Remarks");
//        personOrCompany1.setAddress("42 Main St");
//        personOrCompany1.setDiscountAmount(10.0d);
//        personOrCompany1.setDiscountPercentage(10.0d);
//        personOrCompany1.setFirstName("Jane");
//        personOrCompany1.setId(1);
//        personOrCompany1.setLastNameOrCompanyName("Doe");
//        personOrCompany1.setMiddleName("Middle Name");
//        personOrCompany1.setNextOpportunityAction("Next Opportunity Action");
//        personOrCompany1.setNextOpportunityActionAssignedTo(1);
//        personOrCompany1.setNextOpportunityActionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
//        personOrCompany1.setOpportunityAgingDays(1);
//        personOrCompany1.setOpportunityAmount(10.0d);
//        personOrCompany1.setOpportunityAssignedDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
//        personOrCompany1.setOpportunityCaptureDatetime(LocalDate.ofEpochDay(1L));
//        personOrCompany1.setOpportunityClosureProbability(0.25d);
//        personOrCompany1.setOpportunityDisplayName("Opportunity Display Name");
//        personOrCompany1.setOpportunityLastContactDays(1);
//        personOrCompany1.setOpportunityProductList("Opportunity Product List");
//        personOrCompany1.setOpportunityStage("Opportunity Stage");
//        personOrCompany1.setOpportunityStatus(true);
//        personOrCompany1.setOwnerID(1);
//        personOrCompany1.setPersonOrCompany("Person Or Company");
//        personOrCompany1.setProduct(new ArrayList<>());
//        personOrCompany1.setProductDescription("Product Description");
//        personOrCompany1.setQuantity(1);
//        personOrCompany1.setQuotationAmount(10.0d);
//        personOrCompany1.setQuotationDate(LocalDateTime.of(1, 1, 1, 1, 1));
//        personOrCompany1.setQuotationGivenBy(1);
//        personOrCompany1.setQuotationNumber("42");
//        personOrCompany1.setQuoteGenerated(true);
//        personOrCompany1.setSalutation("Salutation");
//        personOrCompany1.setTotalPrice(10.0d);
//        personOrCompany1.setUnitPrice(1);
        when(opportunityRepository.save((PersonOrCompany) any())).thenReturn(personOrCompany);
        ResponseEntity<OpportunityResponse<PersonOrCompany>> actualSaveOpportunityResult = opportunityServiceImpl
                .saveOpportunity(new OpportunityRequest());
        assertTrue(actualSaveOpportunityResult.hasBody());
        assertTrue(actualSaveOpportunityResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.BAD_REQUEST, actualSaveOpportunityResult.getStatusCode());
        OpportunityResponse<PersonOrCompany> body = actualSaveOpportunityResult.getBody();
        assertEquals(
                "Exception In OpportunityServiceImpl : saveOpportunity() :: class com.CRM.Opportunity.Entity.PersonOrCompany",
//                        + "$MockitoMock$762312487 cannot be cast to class com.CRM.Opportunity.Model.OpportunityRequest"
//                        + " (com.CRM.Opportunity.Entity.PersonOrCompany$MockitoMock$762312487 and com.CRM.Opportunity.Model"
//                        + ".OpportunityRequest are in unnamed module of loader com.diffblue.cover.f.g @3fe377ff)",
                body.getReasonText());
        assertEquals("Fail", body.getStatus());
        verify(modelMapper, atLeast(1)).map((Object) any(), (Class<Object>) any());
        verify(personOrCompany).getFirstName();
        verify(personOrCompany).getLastNameOrCompanyName();
        verify(personOrCompany).getMiddleName();
        verify(personOrCompany).getSalutation();
        verify(personOrCompany).setActionExecutionDatetime((LocalDateTime) any());
        verify(personOrCompany).setActionExecutionStatus((String) any());
        verify(personOrCompany).setActionRemarks((String) any());
        verify(personOrCompany).setAddress((String) any());
        verify(personOrCompany).setDiscountAmount(anyDouble());
        verify(personOrCompany).setDiscountPercentage(anyDouble());
        verify(personOrCompany).setFirstName((String) any());
        verify(personOrCompany).setId(anyInt());
        verify(personOrCompany).setLastNameOrCompanyName((String) any());
        verify(personOrCompany).setMiddleName((String) any());
        verify(personOrCompany).setNextOpportunityAction((String) any());
        verify(personOrCompany).setNextOpportunityActionAssignedTo(anyInt());
        verify(personOrCompany).setNextOpportunityActionDatetime((LocalDateTime) any());
        verify(personOrCompany).setOpportunityAgingDays(anyInt());
        verify(personOrCompany).setOpportunityAmount(anyDouble());
        verify(personOrCompany).setOpportunityAssignedDatetime((LocalDateTime) any());
        verify(personOrCompany).setOpportunityCaptureDatetime((LocalDate) any());
        verify(personOrCompany).setOpportunityClosureProbability(anyDouble());
        verify(personOrCompany, atLeast(1)).setOpportunityDisplayName((String) any());
        verify(personOrCompany).setOpportunityLastContactDays(anyInt());
        verify(personOrCompany).setOpportunityProductList((String) any());
        verify(personOrCompany).setOpportunityStage((String) any());
        verify(personOrCompany).setOpportunityStatus(anyBoolean());
        verify(personOrCompany).setOwnerID(anyInt());
        verify(personOrCompany).setPersonOrCompany((String) any());
        verify(personOrCompany).setProduct((List<Product>) any());
        verify(personOrCompany).setProductDescription((String) any());
        verify(personOrCompany).setQuantity(anyInt());
        verify(personOrCompany).setQuotationAmount(anyDouble());
        verify(personOrCompany).setQuotationDate((LocalDateTime) any());
        verify(personOrCompany).setQuotationGivenBy(anyInt());
        verify(personOrCompany).setQuotationNumber((String) any());
        verify(personOrCompany).setQuoteGenerated(anyBoolean());
        verify(personOrCompany).setSalutation((String) any());
        verify(personOrCompany).setTotalPrice(anyDouble());
        verify(personOrCompany).setUnitPrice(anyInt());
        verify(opportunityRepository).save((PersonOrCompany) any());
    }

    /**
     * Method under test: {@link OpportunityServiceImpl#getOpportunityByID(HttpServletRequest, Integer)}
     */
    @Test
    void testGetOpportunityByID() {
        PersonOrCompany personOrCompany = new PersonOrCompany();
        personOrCompany.setActionExecutionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setActionExecutionStatus("Action Execution Status");
        personOrCompany.setActionRemarks("Action Remarks");
        personOrCompany.setAddress("42 Main St");
        personOrCompany.setDiscountAmount(10.0d);
        personOrCompany.setDiscountPercentage(10.0d);
        personOrCompany.setFirstName("Jane");
        personOrCompany.setId(1);
        personOrCompany.setLastNameOrCompanyName("Doe");
        personOrCompany.setMiddleName("Middle Name");
        personOrCompany.setNextOpportunityAction("Next Opportunity Action");
        personOrCompany.setNextOpportunityActionAssignedTo(1);
        personOrCompany.setNextOpportunityActionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setOpportunityAgingDays(1);
        personOrCompany.setOpportunityAmount(10.0d);
        personOrCompany.setOpportunityAssignedDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setOpportunityCaptureDatetime(LocalDate.ofEpochDay(1L));
        personOrCompany.setOpportunityClosureProbability(0.25d);
        personOrCompany.setOpportunityDisplayName("Opportunity Display Name");
        personOrCompany.setOpportunityLastContactDays(1);
        personOrCompany.setOpportunityProductList("Opportunity Product List");
        personOrCompany.setOpportunityStage("Opportunity Stage");
        personOrCompany.setOpportunityStatus(true);
        personOrCompany.setOwnerID(1);
        personOrCompany.setPersonOrCompany("Person Or Company");
        personOrCompany.setProduct(new ArrayList<>());
        personOrCompany.setProductDescription("Product Description");
        personOrCompany.setQuantity(1);
        personOrCompany.setQuotationAmount(10.0d);
        personOrCompany.setQuotationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setQuotationGivenBy(1);
        personOrCompany.setQuotationNumber("42");
        personOrCompany.setQuoteGenerated(true);
        personOrCompany.setSalutation("Salutation");
        personOrCompany.setTotalPrice(10.0d);
        personOrCompany.setUnitPrice(1);
        when(opportunityRepository.findAllById((Integer) any())).thenReturn(personOrCompany);
        when(opportunityRepository.findAll()).thenReturn(new ArrayList<>());
        ResponseEntity<OpportunityResponse<PersonOrCompany>> actualOpportunityByID = opportunityServiceImpl
                .getOpportunityByID(new MockHttpServletRequest(), 1);
        assertTrue(actualOpportunityByID.hasBody());
        assertTrue(actualOpportunityByID.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualOpportunityByID.getStatusCode());
        OpportunityResponse<PersonOrCompany> body = actualOpportunityByID.getBody();
        assertEquals(" GET_OPPORTUNITY_BY_ID", body.getReasonText());
        assertSame(personOrCompany, body.getResponseObject());
        assertEquals("Success", body.getStatus());
        verify(opportunityRepository).findAllById((Integer) any());
        verify(opportunityRepository).findAll();
    }

    /**
     * Method under test: {@link OpportunityServiceImpl#getOpportunityByID(HttpServletRequest, Integer)}
     */
    @Test
    void testGetOpportunityByID2() {
        PersonOrCompany personOrCompany = mock(PersonOrCompany.class);
        when(personOrCompany.getOpportunityCaptureDatetime()).thenReturn(LocalDate.ofEpochDay(1L));
        doNothing().when(personOrCompany).setActionExecutionDatetime((LocalDateTime) any());
        doNothing().when(personOrCompany).setActionExecutionStatus((String) any());
        doNothing().when(personOrCompany).setActionRemarks((String) any());
        doNothing().when(personOrCompany).setAddress((String) any());
        doNothing().when(personOrCompany).setDiscountAmount(anyDouble());
        doNothing().when(personOrCompany).setDiscountPercentage(anyDouble());
        doNothing().when(personOrCompany).setFirstName((String) any());
        doNothing().when(personOrCompany).setId(anyInt());
        doNothing().when(personOrCompany).setLastNameOrCompanyName((String) any());
        doNothing().when(personOrCompany).setMiddleName((String) any());
        doNothing().when(personOrCompany).setNextOpportunityAction((String) any());
        doNothing().when(personOrCompany).setNextOpportunityActionAssignedTo(anyInt());
        doNothing().when(personOrCompany).setNextOpportunityActionDatetime((LocalDateTime) any());
        doNothing().when(personOrCompany).setOpportunityAgingDays(anyInt());
        doNothing().when(personOrCompany).setOpportunityAmount(anyDouble());
        doNothing().when(personOrCompany).setOpportunityAssignedDatetime((LocalDateTime) any());
        doNothing().when(personOrCompany).setOpportunityCaptureDatetime((LocalDate) any());
        doNothing().when(personOrCompany).setOpportunityClosureProbability(anyDouble());
        doNothing().when(personOrCompany).setOpportunityDisplayName((String) any());
        doNothing().when(personOrCompany).setOpportunityLastContactDays(anyInt());
        doNothing().when(personOrCompany).setOpportunityProductList((String) any());
        doNothing().when(personOrCompany).setOpportunityStage((String) any());
        doNothing().when(personOrCompany).setOpportunityStatus(anyBoolean());
        doNothing().when(personOrCompany).setOwnerID(anyInt());
        doNothing().when(personOrCompany).setPersonOrCompany((String) any());
        doNothing().when(personOrCompany).setProduct((List<Product>) any());
        doNothing().when(personOrCompany).setProductDescription((String) any());
        doNothing().when(personOrCompany).setQuantity(anyInt());
        doNothing().when(personOrCompany).setQuotationAmount(anyDouble());
        doNothing().when(personOrCompany).setQuotationDate((LocalDateTime) any());
        doNothing().when(personOrCompany).setQuotationGivenBy(anyInt());
        doNothing().when(personOrCompany).setQuotationNumber((String) any());
        doNothing().when(personOrCompany).setQuoteGenerated(anyBoolean());
        doNothing().when(personOrCompany).setSalutation((String) any());
        doNothing().when(personOrCompany).setTotalPrice(anyDouble());
        doNothing().when(personOrCompany).setUnitPrice(anyInt());
        personOrCompany.setActionExecutionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setActionExecutionStatus("Action Execution Status");
        personOrCompany.setActionRemarks("Action Remarks");
        personOrCompany.setAddress("42 Main St");
        personOrCompany.setDiscountAmount(10.0d);
        personOrCompany.setDiscountPercentage(10.0d);
        personOrCompany.setFirstName("Jane");
        personOrCompany.setId(1);
        personOrCompany.setLastNameOrCompanyName("Doe");
        personOrCompany.setMiddleName("Middle Name");
        personOrCompany.setNextOpportunityAction("Next Opportunity Action");
        personOrCompany.setNextOpportunityActionAssignedTo(1);
        personOrCompany.setNextOpportunityActionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setOpportunityAgingDays(1);
        personOrCompany.setOpportunityAmount(10.0d);
        personOrCompany.setOpportunityAssignedDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setOpportunityCaptureDatetime(LocalDate.ofEpochDay(1L));
        personOrCompany.setOpportunityClosureProbability(0.25d);
        personOrCompany.setOpportunityDisplayName("Opportunity Display Name");
        personOrCompany.setOpportunityLastContactDays(1);
        personOrCompany.setOpportunityProductList("Opportunity Product List");
        personOrCompany.setOpportunityStage("Opportunity Stage");
        personOrCompany.setOpportunityStatus(true);
        personOrCompany.setOwnerID(1);
        personOrCompany.setPersonOrCompany("Person Or Company");
        personOrCompany.setProduct(new ArrayList<>());
        personOrCompany.setProductDescription("Product Description");
        personOrCompany.setQuantity(1);
        personOrCompany.setQuotationAmount(10.0d);
        personOrCompany.setQuotationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setQuotationGivenBy(1);
        personOrCompany.setQuotationNumber("42");
        personOrCompany.setQuoteGenerated(true);
        personOrCompany.setSalutation("Salutation");
        personOrCompany.setTotalPrice(10.0d);
        personOrCompany.setUnitPrice(1);
        when(opportunityRepository.findAllById((Integer) any())).thenReturn(personOrCompany);
        when(opportunityRepository.findAll()).thenReturn(new ArrayList<>());
        ResponseEntity<OpportunityResponse<PersonOrCompany>> actualOpportunityByID = opportunityServiceImpl
                .getOpportunityByID(new MockHttpServletRequest(), 1);
        assertTrue(actualOpportunityByID.hasBody());
        assertTrue(actualOpportunityByID.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualOpportunityByID.getStatusCode());
        OpportunityResponse<PersonOrCompany> body = actualOpportunityByID.getBody();
        assertEquals(" GET_OPPORTUNITY_BY_ID", body.getReasonText());
        assertEquals("Success", body.getStatus());
        verify(opportunityRepository).findAllById((Integer) any());
        verify(opportunityRepository).findAll();
        verify(personOrCompany).getOpportunityCaptureDatetime();
        verify(personOrCompany).setActionExecutionDatetime((LocalDateTime) any());
        verify(personOrCompany).setActionExecutionStatus((String) any());
        verify(personOrCompany).setActionRemarks((String) any());
        verify(personOrCompany).setAddress((String) any());
        verify(personOrCompany).setDiscountAmount(anyDouble());
        verify(personOrCompany).setDiscountPercentage(anyDouble());
        verify(personOrCompany).setFirstName((String) any());
        verify(personOrCompany).setId(anyInt());
        verify(personOrCompany).setLastNameOrCompanyName((String) any());
        verify(personOrCompany).setMiddleName((String) any());
        verify(personOrCompany).setNextOpportunityAction((String) any());
        verify(personOrCompany).setNextOpportunityActionAssignedTo(anyInt());
        verify(personOrCompany).setNextOpportunityActionDatetime((LocalDateTime) any());
        verify(personOrCompany, atLeast(1)).setOpportunityAgingDays(anyInt());
        verify(personOrCompany).setOpportunityAmount(anyDouble());
        verify(personOrCompany).setOpportunityAssignedDatetime((LocalDateTime) any());
        verify(personOrCompany).setOpportunityCaptureDatetime((LocalDate) any());
        verify(personOrCompany).setOpportunityClosureProbability(anyDouble());
        verify(personOrCompany).setOpportunityDisplayName((String) any());
        verify(personOrCompany).setOpportunityLastContactDays(anyInt());
        verify(personOrCompany).setOpportunityProductList((String) any());
        verify(personOrCompany).setOpportunityStage((String) any());
        verify(personOrCompany).setOpportunityStatus(anyBoolean());
        verify(personOrCompany).setOwnerID(anyInt());
        verify(personOrCompany).setPersonOrCompany((String) any());
        verify(personOrCompany).setProduct((List<Product>) any());
        verify(personOrCompany).setProductDescription((String) any());
        verify(personOrCompany).setQuantity(anyInt());
        verify(personOrCompany).setQuotationAmount(anyDouble());
        verify(personOrCompany).setQuotationDate((LocalDateTime) any());
        verify(personOrCompany).setQuotationGivenBy(anyInt());
        verify(personOrCompany).setQuotationNumber((String) any());
        verify(personOrCompany).setQuoteGenerated(anyBoolean());
        verify(personOrCompany).setSalutation((String) any());
        verify(personOrCompany).setTotalPrice(anyDouble());
        verify(personOrCompany).setUnitPrice(anyInt());
    }

    /**
     * Method under test: {@link OpportunityServiceImpl#getOpportunityByID(HttpServletRequest, Integer)}
     */
    @Test
    void testGetOpportunityByID3() {
        PersonOrCompany personOrCompany = mock(PersonOrCompany.class);
        when(personOrCompany.getOpportunityCaptureDatetime()).thenReturn(null);
        doNothing().when(personOrCompany).setActionExecutionDatetime((LocalDateTime) any());
        doNothing().when(personOrCompany).setActionExecutionStatus((String) any());
        doNothing().when(personOrCompany).setActionRemarks((String) any());
        doNothing().when(personOrCompany).setAddress((String) any());
        doNothing().when(personOrCompany).setDiscountAmount(anyDouble());
        doNothing().when(personOrCompany).setDiscountPercentage(anyDouble());
        doNothing().when(personOrCompany).setFirstName((String) any());
        doNothing().when(personOrCompany).setId(anyInt());
        doNothing().when(personOrCompany).setLastNameOrCompanyName((String) any());
        doNothing().when(personOrCompany).setMiddleName((String) any());
        doNothing().when(personOrCompany).setNextOpportunityAction((String) any());
        doNothing().when(personOrCompany).setNextOpportunityActionAssignedTo(anyInt());
        doNothing().when(personOrCompany).setNextOpportunityActionDatetime((LocalDateTime) any());
        doNothing().when(personOrCompany).setOpportunityAgingDays(anyInt());
        doNothing().when(personOrCompany).setOpportunityAmount(anyDouble());
        doNothing().when(personOrCompany).setOpportunityAssignedDatetime((LocalDateTime) any());
        doNothing().when(personOrCompany).setOpportunityCaptureDatetime((LocalDate) any());
        doNothing().when(personOrCompany).setOpportunityClosureProbability(anyDouble());
        doNothing().when(personOrCompany).setOpportunityDisplayName((String) any());
        doNothing().when(personOrCompany).setOpportunityLastContactDays(anyInt());
        doNothing().when(personOrCompany).setOpportunityProductList((String) any());
        doNothing().when(personOrCompany).setOpportunityStage((String) any());
        doNothing().when(personOrCompany).setOpportunityStatus(anyBoolean());
        doNothing().when(personOrCompany).setOwnerID(anyInt());
        doNothing().when(personOrCompany).setPersonOrCompany((String) any());
        doNothing().when(personOrCompany).setProduct((List<Product>) any());
        doNothing().when(personOrCompany).setProductDescription((String) any());
        doNothing().when(personOrCompany).setQuantity(anyInt());
        doNothing().when(personOrCompany).setQuotationAmount(anyDouble());
        doNothing().when(personOrCompany).setQuotationDate((LocalDateTime) any());
        doNothing().when(personOrCompany).setQuotationGivenBy(anyInt());
        doNothing().when(personOrCompany).setQuotationNumber((String) any());
        doNothing().when(personOrCompany).setQuoteGenerated(anyBoolean());
        doNothing().when(personOrCompany).setSalutation((String) any());
        doNothing().when(personOrCompany).setTotalPrice(anyDouble());
        doNothing().when(personOrCompany).setUnitPrice(anyInt());
        personOrCompany.setActionExecutionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setActionExecutionStatus("Action Execution Status");
        personOrCompany.setActionRemarks("Action Remarks");
        personOrCompany.setAddress("42 Main St");
        personOrCompany.setDiscountAmount(10.0d);
        personOrCompany.setDiscountPercentage(10.0d);
        personOrCompany.setFirstName("Jane");
        personOrCompany.setId(1);
        personOrCompany.setLastNameOrCompanyName("Doe");
        personOrCompany.setMiddleName("Middle Name");
        personOrCompany.setNextOpportunityAction("Next Opportunity Action");
        personOrCompany.setNextOpportunityActionAssignedTo(1);
        personOrCompany.setNextOpportunityActionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setOpportunityAgingDays(1);
        personOrCompany.setOpportunityAmount(10.0d);
        personOrCompany.setOpportunityAssignedDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setOpportunityCaptureDatetime(LocalDate.ofEpochDay(1L));
        personOrCompany.setOpportunityClosureProbability(0.25d);
        personOrCompany.setOpportunityDisplayName("Opportunity Display Name");
        personOrCompany.setOpportunityLastContactDays(1);
        personOrCompany.setOpportunityProductList("Opportunity Product List");
        personOrCompany.setOpportunityStage("Opportunity Stage");
        personOrCompany.setOpportunityStatus(true);
        personOrCompany.setOwnerID(1);
        personOrCompany.setPersonOrCompany("Person Or Company");
        personOrCompany.setProduct(new ArrayList<>());
        personOrCompany.setProductDescription("Product Description");
        personOrCompany.setQuantity(1);
        personOrCompany.setQuotationAmount(10.0d);
        personOrCompany.setQuotationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setQuotationGivenBy(1);
        personOrCompany.setQuotationNumber("42");
        personOrCompany.setQuoteGenerated(true);
        personOrCompany.setSalutation("Salutation");
        personOrCompany.setTotalPrice(10.0d);
        personOrCompany.setUnitPrice(1);
        when(opportunityRepository.findAllById((Integer) any())).thenReturn(personOrCompany);
        when(opportunityRepository.findAll()).thenReturn(new ArrayList<>());
        ResponseEntity<OpportunityResponse<PersonOrCompany>> actualOpportunityByID = opportunityServiceImpl
                .getOpportunityByID(new MockHttpServletRequest(), 1);
        assertTrue(actualOpportunityByID.hasBody());
        assertTrue(actualOpportunityByID.getHeaders().isEmpty());
        assertEquals(HttpStatus.BAD_REQUEST, actualOpportunityByID.getStatusCode());
        OpportunityResponse<PersonOrCompany> body = actualOpportunityByID.getBody();
        assertEquals("Exception In OpportunityServiceImpl : getOpportunityById() :: null", body.getReasonText());
        assertEquals("Fail", body.getStatus());
        verify(opportunityRepository).findAllById((Integer) any());
        verify(opportunityRepository).findAll();
        verify(personOrCompany).getOpportunityCaptureDatetime();
        verify(personOrCompany).setActionExecutionDatetime((LocalDateTime) any());
        verify(personOrCompany).setActionExecutionStatus((String) any());
        verify(personOrCompany).setActionRemarks((String) any());
        verify(personOrCompany).setAddress((String) any());
        verify(personOrCompany).setDiscountAmount(anyDouble());
        verify(personOrCompany).setDiscountPercentage(anyDouble());
        verify(personOrCompany).setFirstName((String) any());
        verify(personOrCompany).setId(anyInt());
        verify(personOrCompany).setLastNameOrCompanyName((String) any());
        verify(personOrCompany).setMiddleName((String) any());
        verify(personOrCompany).setNextOpportunityAction((String) any());
        verify(personOrCompany).setNextOpportunityActionAssignedTo(anyInt());
        verify(personOrCompany).setNextOpportunityActionDatetime((LocalDateTime) any());
        verify(personOrCompany).setOpportunityAgingDays(anyInt());
        verify(personOrCompany).setOpportunityAmount(anyDouble());
        verify(personOrCompany).setOpportunityAssignedDatetime((LocalDateTime) any());
        verify(personOrCompany).setOpportunityCaptureDatetime((LocalDate) any());
        verify(personOrCompany).setOpportunityClosureProbability(anyDouble());
        verify(personOrCompany).setOpportunityDisplayName((String) any());
        verify(personOrCompany).setOpportunityLastContactDays(anyInt());
        verify(personOrCompany).setOpportunityProductList((String) any());
        verify(personOrCompany).setOpportunityStage((String) any());
        verify(personOrCompany).setOpportunityStatus(anyBoolean());
        verify(personOrCompany).setOwnerID(anyInt());
        verify(personOrCompany).setPersonOrCompany((String) any());
        verify(personOrCompany).setProduct((List<Product>) any());
        verify(personOrCompany).setProductDescription((String) any());
        verify(personOrCompany).setQuantity(anyInt());
        verify(personOrCompany).setQuotationAmount(anyDouble());
        verify(personOrCompany).setQuotationDate((LocalDateTime) any());
        verify(personOrCompany).setQuotationGivenBy(anyInt());
        verify(personOrCompany).setQuotationNumber((String) any());
        verify(personOrCompany).setQuoteGenerated(anyBoolean());
        verify(personOrCompany).setSalutation((String) any());
        verify(personOrCompany).setTotalPrice(anyDouble());
        verify(personOrCompany).setUnitPrice(anyInt());
    }

    /**
     * Method under test: {@link OpportunityServiceImpl#getAllOpportunity(HttpServletRequest)}
     */
    @Test
    void testGetAllOpportunity() {
        when(opportunityRepository.findAll()).thenReturn(new ArrayList<>());
        ResponseEntity<OpportunityResponse<PersonOrCompany>> actualAllOpportunity = opportunityServiceImpl
                .getAllOpportunity(new MockHttpServletRequest());
        assertTrue(actualAllOpportunity.hasBody());
        assertTrue(actualAllOpportunity.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualAllOpportunity.getStatusCode());
        OpportunityResponse<PersonOrCompany> body = actualAllOpportunity.getBody();
        assertEquals("NO_OPPORTUNITY", body.getReasonText());
        assertEquals("Success", body.getStatus());
        verify(opportunityRepository).findAll();
    }

    @Test
    void testGetAllOpportunity2() {
        PersonOrCompany personOrCompany = new PersonOrCompany();
        personOrCompany.setActionExecutionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setActionExecutionStatus("Success");
        personOrCompany.setActionRemarks("Success");
        personOrCompany.setAddress("42 Main St");
        personOrCompany.setDiscountAmount(10.0d);
        personOrCompany.setDiscountPercentage(10.0d);
        personOrCompany.setFirstName("Jane");
        personOrCompany.setId(1);
        personOrCompany.setLastNameOrCompanyName("Doe");
        personOrCompany.setMiddleName("Success");
        personOrCompany.setNextOpportunityAction("Success");
        personOrCompany.setNextOpportunityActionAssignedTo(1);
        personOrCompany.setNextOpportunityActionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setOpportunityAgingDays(1);
        personOrCompany.setOpportunityAmount(10.0d);
        personOrCompany.setOpportunityAssignedDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setOpportunityCaptureDatetime(LocalDate.ofEpochDay(1L));
        personOrCompany.setOpportunityClosureProbability(0.25d);
        personOrCompany.setOpportunityDisplayName("Success");
        personOrCompany.setOpportunityLastContactDays(1);
        personOrCompany.setOpportunityProductList("Success");
        personOrCompany.setOpportunityStage("Success");
        personOrCompany.setOpportunityStatus(true);
        personOrCompany.setOwnerID(1);
        personOrCompany.setPersonOrCompany("Success");
        personOrCompany.setProduct(new ArrayList<>());
        personOrCompany.setProductDescription("Success");
        personOrCompany.setQuantity(1);
        personOrCompany.setQuotationAmount(10.0d);
        personOrCompany.setQuotationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setQuotationGivenBy(1);
        personOrCompany.setQuotationNumber("42");
        personOrCompany.setQuoteGenerated(true);
        personOrCompany.setSalutation("Success");
        personOrCompany.setTotalPrice(10.0d);
        personOrCompany.setUnitPrice(1);

        ArrayList<PersonOrCompany> personOrCompanyList = new ArrayList<>();
        personOrCompanyList.add(personOrCompany);
        when(opportunityRepository.findAll()).thenReturn(personOrCompanyList);
        ResponseEntity<OpportunityResponse<PersonOrCompany>> actualAllOpportunity = opportunityServiceImpl
                .getAllOpportunity(new MockHttpServletRequest());
        assertTrue(actualAllOpportunity.hasBody());
        assertTrue(actualAllOpportunity.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualAllOpportunity.getStatusCode());
        OpportunityResponse<PersonOrCompany> body = actualAllOpportunity.getBody();
        assertEquals(1, body.getResponseListObject().size());
        assertEquals("GET_ALL_OPPORTUNITY", body.getReasonText());
        assertEquals(1L, body.getTotalRecords().longValue());
        assertEquals("Success", body.getStatus());
        verify(opportunityRepository).findAll();
    }

    /**
     * Method under test: {@link OpportunityServiceImpl#updateOpportunity(OpportunityRequest, Integer)}
     */
    @Test
    void testUpdateOpportunity() {
        doNothing().when(modelMapper).map((Object) any(), (Object) any());

        PersonOrCompany personOrCompany = new PersonOrCompany();
        personOrCompany.setActionExecutionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setActionExecutionStatus("Action Execution Status");
        personOrCompany.setActionRemarks("Action Remarks");
        personOrCompany.setAddress("42 Main St");
        personOrCompany.setDiscountAmount(10.0d);
        personOrCompany.setDiscountPercentage(10.0d);
        personOrCompany.setFirstName("Jane");
        personOrCompany.setId(1);
        personOrCompany.setLastNameOrCompanyName("Doe");
        personOrCompany.setMiddleName("Middle Name");
        personOrCompany.setNextOpportunityAction("Next Opportunity Action");
        personOrCompany.setNextOpportunityActionAssignedTo(1);
        personOrCompany.setNextOpportunityActionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setOpportunityAgingDays(1);
        personOrCompany.setOpportunityAmount(10.0d);
        personOrCompany.setOpportunityAssignedDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setOpportunityCaptureDatetime(LocalDate.ofEpochDay(1L));
        personOrCompany.setOpportunityClosureProbability(0.25d);
        personOrCompany.setOpportunityDisplayName("Opportunity Display Name");
        personOrCompany.setOpportunityLastContactDays(1);
        personOrCompany.setOpportunityProductList("Opportunity Product List");
        personOrCompany.setOpportunityStage("Opportunity Stage");
        personOrCompany.setOpportunityStatus(true);
        personOrCompany.setOwnerID(1);
        personOrCompany.setPersonOrCompany("Person Or Company");
        personOrCompany.setProduct(new ArrayList<>());
        personOrCompany.setProductDescription("Product Description");
        personOrCompany.setQuantity(1);
        personOrCompany.setQuotationAmount(10.0d);
        personOrCompany.setQuotationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setQuotationGivenBy(1);
        personOrCompany.setQuotationNumber("42");
        personOrCompany.setQuoteGenerated(true);
        personOrCompany.setSalutation("Salutation");
        personOrCompany.setTotalPrice(10.0d);
        personOrCompany.setUnitPrice(1);
        Optional<PersonOrCompany> ofResult = Optional.of(personOrCompany);

        PersonOrCompany personOrCompany1 = new PersonOrCompany();
        personOrCompany1.setActionExecutionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany1.setActionExecutionStatus("Action Execution Status");
        personOrCompany1.setActionRemarks("Action Remarks");
        personOrCompany1.setAddress("42 Main St");
        personOrCompany1.setDiscountAmount(10.0d);
        personOrCompany1.setDiscountPercentage(10.0d);
        personOrCompany1.setFirstName("Jane");
        personOrCompany1.setId(1);
        personOrCompany1.setLastNameOrCompanyName("Doe");
        personOrCompany1.setMiddleName("Middle Name");
        personOrCompany1.setNextOpportunityAction("Next Opportunity Action");
        personOrCompany1.setNextOpportunityActionAssignedTo(1);
        personOrCompany1.setNextOpportunityActionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany1.setOpportunityAgingDays(1);
        personOrCompany1.setOpportunityAmount(10.0d);
        personOrCompany1.setOpportunityAssignedDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany1.setOpportunityCaptureDatetime(LocalDate.ofEpochDay(1L));
        personOrCompany1.setOpportunityClosureProbability(0.25d);
        personOrCompany1.setOpportunityDisplayName("Opportunity Display Name");
        personOrCompany1.setOpportunityLastContactDays(1);
        personOrCompany1.setOpportunityProductList("Opportunity Product List");
        personOrCompany1.setOpportunityStage("Opportunity Stage");
        personOrCompany1.setOpportunityStatus(true);
        personOrCompany1.setOwnerID(1);
        personOrCompany1.setPersonOrCompany("Person Or Company");
        personOrCompany1.setProduct(new ArrayList<>());
        personOrCompany1.setProductDescription("Product Description");
        personOrCompany1.setQuantity(1);
        personOrCompany1.setQuotationAmount(10.0d);
        personOrCompany1.setQuotationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany1.setQuotationGivenBy(1);
        personOrCompany1.setQuotationNumber("42");
        personOrCompany1.setQuoteGenerated(true);
        personOrCompany1.setSalutation("Salutation");
        personOrCompany1.setTotalPrice(10.0d);
        personOrCompany1.setUnitPrice(1);
        when(opportunityRepository.save((PersonOrCompany) any())).thenReturn(personOrCompany1);
        when(opportunityRepository.findById((Integer) any())).thenReturn(ofResult);
        ResponseEntity<OpportunityResponse<PersonOrCompany>> actualUpdateOpportunityResult = opportunityServiceImpl
                .updateOpportunity(new OpportunityRequest(), 1);
        assertTrue(actualUpdateOpportunityResult.hasBody());
        assertTrue(actualUpdateOpportunityResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualUpdateOpportunityResult.getStatusCode());
        OpportunityResponse<PersonOrCompany> body = actualUpdateOpportunityResult.getBody();
        assertEquals("OPPORTUNITY_DATA_UPDATED_SUCCESSFULLY", body.getReasonText());
        assertEquals(personOrCompany, body.getResponseObject());
        assertEquals("Success", body.getStatus());
        verify(modelMapper).map((Object) any(), (Object) any());
        verify(opportunityRepository).save((PersonOrCompany) any());
        verify(opportunityRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link OpportunityServiceImpl#deleteOpportunity(HttpServletRequest, Integer)}
     */
    @Test
    void testDeleteOpportunity() {
        PersonOrCompany personOrCompany = new PersonOrCompany();
        personOrCompany.setActionExecutionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setActionExecutionStatus("Action Execution Status");
        personOrCompany.setActionRemarks("Action Remarks");
        personOrCompany.setAddress("42 Main St");
        personOrCompany.setDiscountAmount(10.0d);
        personOrCompany.setDiscountPercentage(10.0d);
        personOrCompany.setFirstName("Jane");
        personOrCompany.setId(1);
        personOrCompany.setLastNameOrCompanyName("Doe");
        personOrCompany.setMiddleName("Middle Name");
        personOrCompany.setNextOpportunityAction("Next Opportunity Action");
        personOrCompany.setNextOpportunityActionAssignedTo(1);
        personOrCompany.setNextOpportunityActionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setOpportunityAgingDays(1);
        personOrCompany.setOpportunityAmount(10.0d);
        personOrCompany.setOpportunityAssignedDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setOpportunityCaptureDatetime(LocalDate.ofEpochDay(1L));
        personOrCompany.setOpportunityClosureProbability(0.25d);
        personOrCompany.setOpportunityDisplayName("Opportunity Display Name");
        personOrCompany.setOpportunityLastContactDays(1);
        personOrCompany.setOpportunityProductList("Opportunity Product List");
        personOrCompany.setOpportunityStage("Opportunity Stage");
        personOrCompany.setOpportunityStatus(true);
        personOrCompany.setOwnerID(1);
        personOrCompany.setPersonOrCompany("Person Or Company");
        personOrCompany.setProduct(new ArrayList<>());
        personOrCompany.setProductDescription("Product Description");
        personOrCompany.setQuantity(1);
        personOrCompany.setQuotationAmount(10.0d);
        personOrCompany.setQuotationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setQuotationGivenBy(1);
        personOrCompany.setQuotationNumber("42");
        personOrCompany.setQuoteGenerated(true);
        personOrCompany.setSalutation("Salutation");
        personOrCompany.setTotalPrice(10.0d);
        personOrCompany.setUnitPrice(1);
        doNothing().when(opportunityRepository).deleteById((Integer) any());
        when(opportunityRepository.findAllById((Integer) any())).thenReturn(personOrCompany);
        when(opportunityRepository.findAll()).thenReturn(new ArrayList<>());
        ResponseEntity<OpportunityResponse<PersonOrCompany>> actualDeleteOpportunityResult = opportunityServiceImpl
                .deleteOpportunity(new MockHttpServletRequest(), 1);
        assertTrue(actualDeleteOpportunityResult.hasBody());
        assertTrue(actualDeleteOpportunityResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualDeleteOpportunityResult.getStatusCode());
        OpportunityResponse<PersonOrCompany> body = actualDeleteOpportunityResult.getBody();
        assertEquals("DELETE_OPPORTUNITY_BY_ID", body.getReasonText());
        assertEquals("Success", body.getStatus());
        verify(opportunityRepository).findAllById((Integer) any());
        verify(opportunityRepository).findAll();
        verify(opportunityRepository).deleteById((Integer) any());
    }

    /**
     * Method under test: {@link OpportunityServiceImpl#deleteOpportunity(HttpServletRequest, Integer)}
     */
    @Test
    void testDeleteOpportunity2() {
        PersonOrCompany personOrCompany = mock(PersonOrCompany.class);
        doNothing().when(personOrCompany).setActionExecutionDatetime((LocalDateTime) any());
        doNothing().when(personOrCompany).setActionExecutionStatus((String) any());
        doNothing().when(personOrCompany).setActionRemarks((String) any());
        doNothing().when(personOrCompany).setAddress((String) any());
        doNothing().when(personOrCompany).setDiscountAmount(anyDouble());
        doNothing().when(personOrCompany).setDiscountPercentage(anyDouble());
        doNothing().when(personOrCompany).setFirstName((String) any());
        doNothing().when(personOrCompany).setId(anyInt());
        doNothing().when(personOrCompany).setLastNameOrCompanyName((String) any());
        doNothing().when(personOrCompany).setMiddleName((String) any());
        doNothing().when(personOrCompany).setNextOpportunityAction((String) any());
        doNothing().when(personOrCompany).setNextOpportunityActionAssignedTo(anyInt());
        doNothing().when(personOrCompany).setNextOpportunityActionDatetime((LocalDateTime) any());
        doNothing().when(personOrCompany).setOpportunityAgingDays(anyInt());
        doNothing().when(personOrCompany).setOpportunityAmount(anyDouble());
        doNothing().when(personOrCompany).setOpportunityAssignedDatetime((LocalDateTime) any());
        doNothing().when(personOrCompany).setOpportunityCaptureDatetime((LocalDate) any());
        doNothing().when(personOrCompany).setOpportunityClosureProbability(anyDouble());
        doNothing().when(personOrCompany).setOpportunityDisplayName((String) any());
        doNothing().when(personOrCompany).setOpportunityLastContactDays(anyInt());
        doNothing().when(personOrCompany).setOpportunityProductList((String) any());
        doNothing().when(personOrCompany).setOpportunityStage((String) any());
        doNothing().when(personOrCompany).setOpportunityStatus(anyBoolean());
        doNothing().when(personOrCompany).setOwnerID(anyInt());
        doNothing().when(personOrCompany).setPersonOrCompany((String) any());
        doNothing().when(personOrCompany).setProduct((List<Product>) any());
        doNothing().when(personOrCompany).setProductDescription((String) any());
        doNothing().when(personOrCompany).setQuantity(anyInt());
        doNothing().when(personOrCompany).setQuotationAmount(anyDouble());
        doNothing().when(personOrCompany).setQuotationDate((LocalDateTime) any());
        doNothing().when(personOrCompany).setQuotationGivenBy(anyInt());
        doNothing().when(personOrCompany).setQuotationNumber((String) any());
        doNothing().when(personOrCompany).setQuoteGenerated(anyBoolean());
        doNothing().when(personOrCompany).setSalutation((String) any());
        doNothing().when(personOrCompany).setTotalPrice(anyDouble());
        doNothing().when(personOrCompany).setUnitPrice(anyInt());
        personOrCompany.setActionExecutionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setActionExecutionStatus("Action Execution Status");
        personOrCompany.setActionRemarks("Action Remarks");
        personOrCompany.setAddress("42 Main St");
        personOrCompany.setDiscountAmount(10.0d);
        personOrCompany.setDiscountPercentage(10.0d);
        personOrCompany.setFirstName("Jane");
        personOrCompany.setId(1);
        personOrCompany.setLastNameOrCompanyName("Doe");
        personOrCompany.setMiddleName("Middle Name");
        personOrCompany.setNextOpportunityAction("Next Opportunity Action");
        personOrCompany.setNextOpportunityActionAssignedTo(1);
        personOrCompany.setNextOpportunityActionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setOpportunityAgingDays(1);
        personOrCompany.setOpportunityAmount(10.0d);
        personOrCompany.setOpportunityAssignedDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setOpportunityCaptureDatetime(LocalDate.ofEpochDay(1L));
        personOrCompany.setOpportunityClosureProbability(0.25d);
        personOrCompany.setOpportunityDisplayName("Opportunity Display Name");
        personOrCompany.setOpportunityLastContactDays(1);
        personOrCompany.setOpportunityProductList("Opportunity Product List");
        personOrCompany.setOpportunityStage("Opportunity Stage");
        personOrCompany.setOpportunityStatus(true);
        personOrCompany.setOwnerID(1);
        personOrCompany.setPersonOrCompany("Person Or Company");
        personOrCompany.setProduct(new ArrayList<>());
        personOrCompany.setProductDescription("Product Description");
        personOrCompany.setQuantity(1);
        personOrCompany.setQuotationAmount(10.0d);
        personOrCompany.setQuotationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        personOrCompany.setQuotationGivenBy(1);
        personOrCompany.setQuotationNumber("42");
        personOrCompany.setQuoteGenerated(true);
        personOrCompany.setSalutation("Salutation");
        personOrCompany.setTotalPrice(10.0d);
        personOrCompany.setUnitPrice(1);
        doNothing().when(opportunityRepository).deleteById((Integer) any());
        when(opportunityRepository.findAllById((Integer) any())).thenReturn(personOrCompany);
        when(opportunityRepository.findAll()).thenReturn(new ArrayList<>());
        ResponseEntity<OpportunityResponse<PersonOrCompany>> actualDeleteOpportunityResult = opportunityServiceImpl
                .deleteOpportunity(new MockHttpServletRequest(), 1);
        assertTrue(actualDeleteOpportunityResult.hasBody());
        assertTrue(actualDeleteOpportunityResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualDeleteOpportunityResult.getStatusCode());
        OpportunityResponse<PersonOrCompany> body = actualDeleteOpportunityResult.getBody();
        assertEquals("DELETE_OPPORTUNITY_BY_ID", body.getReasonText());
        assertEquals("Success", body.getStatus());
        verify(opportunityRepository).findAllById((Integer) any());
        verify(opportunityRepository).findAll();
        verify(opportunityRepository).deleteById((Integer) any());
        verify(personOrCompany).setActionExecutionDatetime((LocalDateTime) any());
        verify(personOrCompany).setActionExecutionStatus((String) any());
        verify(personOrCompany).setActionRemarks((String) any());
        verify(personOrCompany).setAddress((String) any());
        verify(personOrCompany).setDiscountAmount(anyDouble());
        verify(personOrCompany).setDiscountPercentage(anyDouble());
        verify(personOrCompany).setFirstName((String) any());
        verify(personOrCompany).setId(anyInt());
        verify(personOrCompany).setLastNameOrCompanyName((String) any());
        verify(personOrCompany).setMiddleName((String) any());
        verify(personOrCompany).setNextOpportunityAction((String) any());
        verify(personOrCompany).setNextOpportunityActionAssignedTo(anyInt());
        verify(personOrCompany).setNextOpportunityActionDatetime((LocalDateTime) any());
        verify(personOrCompany).setOpportunityAgingDays(anyInt());
        verify(personOrCompany).setOpportunityAmount(anyDouble());
        verify(personOrCompany).setOpportunityAssignedDatetime((LocalDateTime) any());
        verify(personOrCompany).setOpportunityCaptureDatetime((LocalDate) any());
        verify(personOrCompany).setOpportunityClosureProbability(anyDouble());
        verify(personOrCompany).setOpportunityDisplayName((String) any());
        verify(personOrCompany).setOpportunityLastContactDays(anyInt());
        verify(personOrCompany).setOpportunityProductList((String) any());
        verify(personOrCompany).setOpportunityStage((String) any());
        verify(personOrCompany).setOpportunityStatus(anyBoolean());
        verify(personOrCompany).setOwnerID(anyInt());
        verify(personOrCompany).setPersonOrCompany((String) any());
        verify(personOrCompany).setProduct((List<Product>) any());
        verify(personOrCompany).setProductDescription((String) any());
        verify(personOrCompany).setQuantity(anyInt());
        verify(personOrCompany).setQuotationAmount(anyDouble());
        verify(personOrCompany).setQuotationDate((LocalDateTime) any());
        verify(personOrCompany).setQuotationGivenBy(anyInt());
        verify(personOrCompany).setQuotationNumber((String) any());
        verify(personOrCompany).setQuoteGenerated(anyBoolean());
        verify(personOrCompany).setSalutation((String) any());
        verify(personOrCompany).setTotalPrice(anyDouble());
        verify(personOrCompany).setUnitPrice(anyInt());
    }
}

