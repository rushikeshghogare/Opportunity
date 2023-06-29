package com.CRM.Opportunity.Controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.CRM.Opportunity.Model.OpportunityRequest;
import com.CRM.Opportunity.Service.OpportunityService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {OpportunityController.class})
@ExtendWith(SpringExtension.class)
class OpportunityControllerTest {
    @Autowired
    private OpportunityController opportunityController;

    @MockBean
    private OpportunityService opportunityService;

    @Test
    void testSaveOpportunity2() throws Exception {
        when(opportunityService.saveOpportunity((OpportunityRequest) any()))
                .thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));

        OpportunityRequest opportunityRequest = new OpportunityRequest();
        opportunityRequest.setActionExecutionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setActionExecutionStatus("Action Execution Status");
        opportunityRequest.setActionRemarks("Action Remarks");
        opportunityRequest.setAddress("42 Main St");
        opportunityRequest.setDiscountAmount(10.0d);
        opportunityRequest.setDiscountPercentage(10.0d);
        opportunityRequest.setFirstName("Jane");
        opportunityRequest.setId(1);
        opportunityRequest.setLastNameOrCompanyName("Doe");
        opportunityRequest.setMiddleName("Middle Name");
        opportunityRequest.setNextOpportunityAction("Next Opportunity Action");
        opportunityRequest.setNextOpportunityActionAssignedTo(1);
        opportunityRequest.setNextOpportunityActionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setOpportunityAgingDays(1);
        opportunityRequest.setOpportunityAmount(10.0d);
        opportunityRequest.setOpportunityAssignedDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setOpportunityCaptureDatetime(null);
        opportunityRequest.setOpportunityClosureProbability(0.25d);
        opportunityRequest.setOpportunityDisplayName("Opportunity Display Name");
        opportunityRequest.setOpportunityLastContactDays(1);
        opportunityRequest.setOpportunityProductList("Opportunity Product List");
        opportunityRequest.setOpportunityStage("Opportunity Stage");
        opportunityRequest.setOpportunityStatus(true);
        opportunityRequest.setOwnerID(1);
        opportunityRequest.setPersonOrCompany("Person Or Company");
        opportunityRequest.setProduct(new ArrayList<>());
        opportunityRequest.setProductDescription("Product Description");
        opportunityRequest.setQuantity(1);
        opportunityRequest.setQuotationAmount(10.0d);
        opportunityRequest.setQuotationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setQuotationGivenBy(1);
        opportunityRequest.setQuotationNumber("42");
        opportunityRequest.setQuoteGenerated(true);
        opportunityRequest.setSalutation("Salutation");
        opportunityRequest.setTotalPrice(10.0d);
        opportunityRequest.setUnitPrice(1);
        String content = (new ObjectMapper()).writeValueAsString(opportunityRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/Opportunity/_add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(opportunityController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }

    /**
     * Method under test: {@link OpportunityController#saveOpportunity(OpportunityRequest)}
     */
    @Test
    void testSaveOpportunity3() throws Exception {
        when(opportunityService.saveOpportunity((OpportunityRequest) any()))
                .thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));

        OpportunityRequest opportunityRequest = new OpportunityRequest();
        opportunityRequest.setActionExecutionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setActionExecutionStatus("Action Execution Status");
        opportunityRequest.setActionRemarks(null);
        opportunityRequest.setAddress("42 Main St");
        opportunityRequest.setDiscountAmount(10.0d);
        opportunityRequest.setDiscountPercentage(10.0d);
        opportunityRequest.setFirstName("Jane");
        opportunityRequest.setId(1);
        opportunityRequest.setLastNameOrCompanyName("Doe");
        opportunityRequest.setMiddleName("Middle Name");
        opportunityRequest.setNextOpportunityAction("Next Opportunity Action");
        opportunityRequest.setNextOpportunityActionAssignedTo(1);
        opportunityRequest.setNextOpportunityActionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setOpportunityAgingDays(1);
        opportunityRequest.setOpportunityAmount(10.0d);
        opportunityRequest.setOpportunityAssignedDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setOpportunityCaptureDatetime(null);
        opportunityRequest.setOpportunityClosureProbability(0.25d);
        opportunityRequest.setOpportunityDisplayName("Opportunity Display Name");
        opportunityRequest.setOpportunityLastContactDays(1);
        opportunityRequest.setOpportunityProductList("Opportunity Product List");
        opportunityRequest.setOpportunityStage("Opportunity Stage");
        opportunityRequest.setOpportunityStatus(true);
        opportunityRequest.setOwnerID(1);
        opportunityRequest.setPersonOrCompany("Person Or Company");
        opportunityRequest.setProduct(new ArrayList<>());
        opportunityRequest.setProductDescription("Product Description");
        opportunityRequest.setQuantity(1);
        opportunityRequest.setQuotationAmount(10.0d);
        opportunityRequest.setQuotationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setQuotationGivenBy(1);
        opportunityRequest.setQuotationNumber("42");
        opportunityRequest.setQuoteGenerated(true);
        opportunityRequest.setSalutation("Salutation");
        opportunityRequest.setTotalPrice(10.0d);
        opportunityRequest.setUnitPrice(1);
        String content = (new ObjectMapper()).writeValueAsString(opportunityRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/Opportunity/_add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(opportunityController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":\"Fail\",\"reasonCode\":null,\"reasonText\":\"Please Provide User Action Remark\",\"responseObject\""
                                        + ":null,\"totalRecords\":null,\"responseListObject\":null}"));
    }


    @Test
    void testSaveOpportunity4() throws Exception {
        when(opportunityService.saveOpportunity((OpportunityRequest) any()))
                .thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));

        OpportunityRequest opportunityRequest = new OpportunityRequest();
        opportunityRequest.setActionExecutionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setActionExecutionStatus("Action Execution Status");
        opportunityRequest.setActionRemarks("");
        opportunityRequest.setAddress("42 Main St");
        opportunityRequest.setDiscountAmount(10.0d);
        opportunityRequest.setDiscountPercentage(10.0d);
        opportunityRequest.setFirstName("Jane");
        opportunityRequest.setId(1);
        opportunityRequest.setLastNameOrCompanyName("Doe");
        opportunityRequest.setMiddleName("Middle Name");
        opportunityRequest.setNextOpportunityAction("Next Opportunity Action");
        opportunityRequest.setNextOpportunityActionAssignedTo(1);
        opportunityRequest.setNextOpportunityActionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setOpportunityAgingDays(1);
        opportunityRequest.setOpportunityAmount(10.0d);
        opportunityRequest.setOpportunityAssignedDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setOpportunityCaptureDatetime(null);
        opportunityRequest.setOpportunityClosureProbability(0.25d);
        opportunityRequest.setOpportunityDisplayName("Opportunity Display Name");
        opportunityRequest.setOpportunityLastContactDays(1);
        opportunityRequest.setOpportunityProductList("Opportunity Product List");
        opportunityRequest.setOpportunityStage("Opportunity Stage");
        opportunityRequest.setOpportunityStatus(true);
        opportunityRequest.setOwnerID(1);
        opportunityRequest.setPersonOrCompany("Person Or Company");
        opportunityRequest.setProduct(new ArrayList<>());
        opportunityRequest.setProductDescription("Product Description");
        opportunityRequest.setQuantity(1);
        opportunityRequest.setQuotationAmount(10.0d);
        opportunityRequest.setQuotationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setQuotationGivenBy(1);
        opportunityRequest.setQuotationNumber("42");
        opportunityRequest.setQuoteGenerated(true);
        opportunityRequest.setSalutation("Salutation");
        opportunityRequest.setTotalPrice(10.0d);
        opportunityRequest.setUnitPrice(1);
        String content = (new ObjectMapper()).writeValueAsString(opportunityRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/Opportunity/_add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(opportunityController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":\"Fail\",\"reasonCode\":null,\"reasonText\":\"Please Provide User Action Remark\",\"responseObject\""
                                        + ":null,\"totalRecords\":null,\"responseListObject\":null}"));
    }


    @Test
    void testSaveOpportunity5() throws Exception {
        when(opportunityService.saveOpportunity((OpportunityRequest) any()))
                .thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));

        OpportunityRequest opportunityRequest = new OpportunityRequest();
        opportunityRequest.setActionExecutionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setActionExecutionStatus("Action Execution Status");
        opportunityRequest.setActionRemarks("Action Remarks");
        opportunityRequest.setAddress("42 Main St");
        opportunityRequest.setDiscountAmount(10.0d);
        opportunityRequest.setDiscountPercentage(10.0d);
        opportunityRequest.setFirstName(null);
        opportunityRequest.setId(1);
        opportunityRequest.setLastNameOrCompanyName("Doe");
        opportunityRequest.setMiddleName("Middle Name");
        opportunityRequest.setNextOpportunityAction("Next Opportunity Action");
        opportunityRequest.setNextOpportunityActionAssignedTo(1);
        opportunityRequest.setNextOpportunityActionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setOpportunityAgingDays(1);
        opportunityRequest.setOpportunityAmount(10.0d);
        opportunityRequest.setOpportunityAssignedDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setOpportunityCaptureDatetime(null);
        opportunityRequest.setOpportunityClosureProbability(0.25d);
        opportunityRequest.setOpportunityDisplayName("Opportunity Display Name");
        opportunityRequest.setOpportunityLastContactDays(1);
        opportunityRequest.setOpportunityProductList("Opportunity Product List");
        opportunityRequest.setOpportunityStage("Opportunity Stage");
        opportunityRequest.setOpportunityStatus(true);
        opportunityRequest.setOwnerID(1);
        opportunityRequest.setPersonOrCompany("Person Or Company");
        opportunityRequest.setProduct(new ArrayList<>());
        opportunityRequest.setProductDescription("Product Description");
        opportunityRequest.setQuantity(1);
        opportunityRequest.setQuotationAmount(10.0d);
        opportunityRequest.setQuotationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setQuotationGivenBy(1);
        opportunityRequest.setQuotationNumber("42");
        opportunityRequest.setQuoteGenerated(true);
        opportunityRequest.setSalutation("Salutation");
        opportunityRequest.setTotalPrice(10.0d);
        opportunityRequest.setUnitPrice(1);
        String content = (new ObjectMapper()).writeValueAsString(opportunityRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/Opportunity/_add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(opportunityController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":\"Fail\",\"reasonCode\":null,\"reasonText\":\"Please Provide User First Name \",\"responseObject\""
                                        + ":null,\"totalRecords\":null,\"responseListObject\":null}"));
    }


    @Test
    void testSaveOpportunity6() throws Exception {
        when(opportunityService.saveOpportunity((OpportunityRequest) any()))
                .thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));

        OpportunityRequest opportunityRequest = new OpportunityRequest();
        opportunityRequest.setActionExecutionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setActionExecutionStatus("Action Execution Status");
        opportunityRequest.setActionRemarks("Action Remarks");
        opportunityRequest.setAddress("42 Main St");
        opportunityRequest.setDiscountAmount(10.0d);
        opportunityRequest.setDiscountPercentage(10.0d);
        opportunityRequest.setFirstName("");
        opportunityRequest.setId(1);
        opportunityRequest.setLastNameOrCompanyName("Doe");
        opportunityRequest.setMiddleName("Middle Name");
        opportunityRequest.setNextOpportunityAction("Next Opportunity Action");
        opportunityRequest.setNextOpportunityActionAssignedTo(1);
        opportunityRequest.setNextOpportunityActionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setOpportunityAgingDays(1);
        opportunityRequest.setOpportunityAmount(10.0d);
        opportunityRequest.setOpportunityAssignedDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setOpportunityCaptureDatetime(null);
        opportunityRequest.setOpportunityClosureProbability(0.25d);
        opportunityRequest.setOpportunityDisplayName("Opportunity Display Name");
        opportunityRequest.setOpportunityLastContactDays(1);
        opportunityRequest.setOpportunityProductList("Opportunity Product List");
        opportunityRequest.setOpportunityStage("Opportunity Stage");
        opportunityRequest.setOpportunityStatus(true);
        opportunityRequest.setOwnerID(1);
        opportunityRequest.setPersonOrCompany("Person Or Company");
        opportunityRequest.setProduct(new ArrayList<>());
        opportunityRequest.setProductDescription("Product Description");
        opportunityRequest.setQuantity(1);
        opportunityRequest.setQuotationAmount(10.0d);
        opportunityRequest.setQuotationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setQuotationGivenBy(1);
        opportunityRequest.setQuotationNumber("42");
        opportunityRequest.setQuoteGenerated(true);
        opportunityRequest.setSalutation("Salutation");
        opportunityRequest.setTotalPrice(10.0d);
        opportunityRequest.setUnitPrice(1);
        String content = (new ObjectMapper()).writeValueAsString(opportunityRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/Opportunity/_add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(opportunityController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400))
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"status\":\"Fail\",\"reasonCode\":null,\"reasonText\":\"Please Provide User First Name \",\"responseObject\""
                                        + ":null,\"totalRecords\":null,\"responseListObject\":null}"));
    }

    @Test
    void testGetAllOpportunity() throws Exception {
        when(opportunityService.getAllOpportunity((HttpServletRequest) any()))
                .thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/Opportunity/_getAll");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(opportunityController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }

    @Test
    void testUpdateOpportunity2() throws Exception {
        when(opportunityService.updateOpportunity((OpportunityRequest) any(), (Integer) any()))
                .thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));

        OpportunityRequest opportunityRequest = new OpportunityRequest();
        opportunityRequest.setActionExecutionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setActionExecutionStatus("Action Execution Status");
        opportunityRequest.setActionRemarks("Action Remarks");
        opportunityRequest.setAddress("42 Main St");
        opportunityRequest.setDiscountAmount(10.0d);
        opportunityRequest.setDiscountPercentage(10.0d);
        opportunityRequest.setFirstName("Jane");
        opportunityRequest.setId(1);
        opportunityRequest.setLastNameOrCompanyName("Doe");
        opportunityRequest.setMiddleName("Middle Name");
        opportunityRequest.setNextOpportunityAction("Next Opportunity Action");
        opportunityRequest.setNextOpportunityActionAssignedTo(1);
        opportunityRequest.setNextOpportunityActionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setOpportunityAgingDays(1);
        opportunityRequest.setOpportunityAmount(10.0d);
        opportunityRequest.setOpportunityAssignedDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setOpportunityCaptureDatetime(null);
        opportunityRequest.setOpportunityClosureProbability(0.25d);
        opportunityRequest.setOpportunityDisplayName("Opportunity Display Name");
        opportunityRequest.setOpportunityLastContactDays(1);
        opportunityRequest.setOpportunityProductList("Opportunity Product List");
        opportunityRequest.setOpportunityStage("Opportunity Stage");
        opportunityRequest.setOpportunityStatus(true);
        opportunityRequest.setOwnerID(1);
        opportunityRequest.setPersonOrCompany("Person Or Company");
        opportunityRequest.setProduct(new ArrayList<>());
        opportunityRequest.setProductDescription("Product Description");
        opportunityRequest.setQuantity(1);
        opportunityRequest.setQuotationAmount(10.0d);
        opportunityRequest.setQuotationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setQuotationGivenBy(1);
        opportunityRequest.setQuotationNumber("42");
        opportunityRequest.setQuoteGenerated(true);
        opportunityRequest.setSalutation("Salutation");
        opportunityRequest.setTotalPrice(10.0d);
        opportunityRequest.setUnitPrice(1);
        String content = (new ObjectMapper()).writeValueAsString(opportunityRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v1/Opportunity/_update/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(opportunityController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }

    @Test
    void testUpdateOpportunity3() throws Exception {
        when(opportunityService.updateOpportunity((OpportunityRequest) any(), (Integer) any()))
                .thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));

        OpportunityRequest opportunityRequest = new OpportunityRequest();
        opportunityRequest.setActionExecutionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setActionExecutionStatus("Action Execution Status");
        opportunityRequest.setActionRemarks(null);
        opportunityRequest.setAddress("42 Main St");
        opportunityRequest.setDiscountAmount(10.0d);
        opportunityRequest.setDiscountPercentage(10.0d);
        opportunityRequest.setFirstName("Jane");
        opportunityRequest.setId(1);
        opportunityRequest.setLastNameOrCompanyName("Doe");
        opportunityRequest.setMiddleName("Middle Name");
        opportunityRequest.setNextOpportunityAction("Next Opportunity Action");
        opportunityRequest.setNextOpportunityActionAssignedTo(1);
        opportunityRequest.setNextOpportunityActionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setOpportunityAgingDays(1);
        opportunityRequest.setOpportunityAmount(10.0d);
        opportunityRequest.setOpportunityAssignedDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setOpportunityCaptureDatetime(null);
        opportunityRequest.setOpportunityClosureProbability(0.25d);
        opportunityRequest.setOpportunityDisplayName("Opportunity Display Name");
        opportunityRequest.setOpportunityLastContactDays(1);
        opportunityRequest.setOpportunityProductList("Opportunity Product List");
        opportunityRequest.setOpportunityStage("Opportunity Stage");
        opportunityRequest.setOpportunityStatus(true);
        opportunityRequest.setOwnerID(1);
        opportunityRequest.setPersonOrCompany("Person Or Company");
        opportunityRequest.setProduct(new ArrayList<>());
        opportunityRequest.setProductDescription("Product Description");
        opportunityRequest.setQuantity(1);
        opportunityRequest.setQuotationAmount(10.0d);
        opportunityRequest.setQuotationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setQuotationGivenBy(1);
        opportunityRequest.setQuotationNumber("42");
        opportunityRequest.setQuoteGenerated(true);
        opportunityRequest.setSalutation("Salutation");
        opportunityRequest.setTotalPrice(10.0d);
        opportunityRequest.setUnitPrice(1);
        String content = (new ObjectMapper()).writeValueAsString(opportunityRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v1/Opportunity/_update/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(opportunityController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }

    @Test
    void testUpdateOpportunity4() throws Exception {
        when(opportunityService.updateOpportunity((OpportunityRequest) any(), (Integer) any()))
                .thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));

        OpportunityRequest opportunityRequest = new OpportunityRequest();
        opportunityRequest.setActionExecutionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setActionExecutionStatus("Action Execution Status");
        opportunityRequest.setActionRemarks("");
        opportunityRequest.setAddress("42 Main St");
        opportunityRequest.setDiscountAmount(10.0d);
        opportunityRequest.setDiscountPercentage(10.0d);
        opportunityRequest.setFirstName("Jane");
        opportunityRequest.setId(1);
        opportunityRequest.setLastNameOrCompanyName("Doe");
        opportunityRequest.setMiddleName("Middle Name");
        opportunityRequest.setNextOpportunityAction("Next Opportunity Action");
        opportunityRequest.setNextOpportunityActionAssignedTo(1);
        opportunityRequest.setNextOpportunityActionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setOpportunityAgingDays(1);
        opportunityRequest.setOpportunityAmount(10.0d);
        opportunityRequest.setOpportunityAssignedDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setOpportunityCaptureDatetime(null);
        opportunityRequest.setOpportunityClosureProbability(0.25d);
        opportunityRequest.setOpportunityDisplayName("Opportunity Display Name");
        opportunityRequest.setOpportunityLastContactDays(1);
        opportunityRequest.setOpportunityProductList("Opportunity Product List");
        opportunityRequest.setOpportunityStage("Opportunity Stage");
        opportunityRequest.setOpportunityStatus(true);
        opportunityRequest.setOwnerID(1);
        opportunityRequest.setPersonOrCompany("Person Or Company");
        opportunityRequest.setProduct(new ArrayList<>());
        opportunityRequest.setProductDescription("Product Description");
        opportunityRequest.setQuantity(1);
        opportunityRequest.setQuotationAmount(10.0d);
        opportunityRequest.setQuotationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setQuotationGivenBy(1);
        opportunityRequest.setQuotationNumber("42");
        opportunityRequest.setQuoteGenerated(true);
        opportunityRequest.setSalutation("Salutation");
        opportunityRequest.setTotalPrice(10.0d);
        opportunityRequest.setUnitPrice(1);
        String content = (new ObjectMapper()).writeValueAsString(opportunityRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v1/Opportunity/_update/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(opportunityController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }

    @Test
    void testUpdateOpportunity5() throws Exception {
        when(opportunityService.updateOpportunity((OpportunityRequest) any(), (Integer) any()))
                .thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));

        OpportunityRequest opportunityRequest = new OpportunityRequest();
        opportunityRequest.setActionExecutionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setActionExecutionStatus("Action Execution Status");
        opportunityRequest.setActionRemarks("Action Remarks");
        opportunityRequest.setAddress("42 Main St");
        opportunityRequest.setDiscountAmount(10.0d);
        opportunityRequest.setDiscountPercentage(10.0d);
        opportunityRequest.setFirstName(null);
        opportunityRequest.setId(1);
        opportunityRequest.setLastNameOrCompanyName("Doe");
        opportunityRequest.setMiddleName("Middle Name");
        opportunityRequest.setNextOpportunityAction("Next Opportunity Action");
        opportunityRequest.setNextOpportunityActionAssignedTo(1);
        opportunityRequest.setNextOpportunityActionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setOpportunityAgingDays(1);
        opportunityRequest.setOpportunityAmount(10.0d);
        opportunityRequest.setOpportunityAssignedDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setOpportunityCaptureDatetime(null);
        opportunityRequest.setOpportunityClosureProbability(0.25d);
        opportunityRequest.setOpportunityDisplayName("Opportunity Display Name");
        opportunityRequest.setOpportunityLastContactDays(1);
        opportunityRequest.setOpportunityProductList("Opportunity Product List");
        opportunityRequest.setOpportunityStage("Opportunity Stage");
        opportunityRequest.setOpportunityStatus(true);
        opportunityRequest.setOwnerID(1);
        opportunityRequest.setPersonOrCompany("Person Or Company");
        opportunityRequest.setProduct(new ArrayList<>());
        opportunityRequest.setProductDescription("Product Description");
        opportunityRequest.setQuantity(1);
        opportunityRequest.setQuotationAmount(10.0d);
        opportunityRequest.setQuotationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setQuotationGivenBy(1);
        opportunityRequest.setQuotationNumber("42");
        opportunityRequest.setQuoteGenerated(true);
        opportunityRequest.setSalutation("Salutation");
        opportunityRequest.setTotalPrice(10.0d);
        opportunityRequest.setUnitPrice(1);
        String content = (new ObjectMapper()).writeValueAsString(opportunityRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v1/Opportunity/_update/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(opportunityController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }

    @Test
    void testDeleteOpportunity() throws Exception {
        when(opportunityService.deleteOpportunity((HttpServletRequest) any(), (Integer) any()))
                .thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/v1/Opportunity/_delete/{id}", 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(opportunityController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }

    @Test
    void testGetOpportunityById() throws Exception {
        when(opportunityService.getOpportunityByID((HttpServletRequest) any(), (Integer) any()))
                .thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/Opportunity/_get/{id}", 1);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(opportunityController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }

    @Test
    void testGetOpportunityById2() throws Exception {
        when(opportunityService.getAllOpportunity((HttpServletRequest) any()))
                .thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
        when(opportunityService.getOpportunityByID((HttpServletRequest) any(), (Integer) any()))
                .thenReturn(new ResponseEntity<>(HttpStatus.CONTINUE));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v1/Opportunity/_get/{id}", 0,
                "Uri Vars");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(opportunityController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }

    @Test
    void testSaveOpportunity() throws Exception {
        OpportunityRequest opportunityRequest = new OpportunityRequest();
        opportunityRequest.setActionExecutionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setActionExecutionStatus("Action Execution Status");
        opportunityRequest.setActionRemarks("Action Remarks");
        opportunityRequest.setAddress("42 Main St");
        opportunityRequest.setDiscountAmount(10.0d);
        opportunityRequest.setDiscountPercentage(10.0d);
        opportunityRequest.setFirstName("Jane");
        opportunityRequest.setId(1);
        opportunityRequest.setLastNameOrCompanyName("Doe");
        opportunityRequest.setMiddleName("Middle Name");
        opportunityRequest.setNextOpportunityAction("Next Opportunity Action");
        opportunityRequest.setNextOpportunityActionAssignedTo(1);
        opportunityRequest.setNextOpportunityActionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setOpportunityAgingDays(1);
        opportunityRequest.setOpportunityAmount(10.0d);
        opportunityRequest.setOpportunityAssignedDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setOpportunityCaptureDatetime(LocalDate.ofEpochDay(1L));
        opportunityRequest.setOpportunityClosureProbability(0.25d);
        opportunityRequest.setOpportunityDisplayName("Opportunity Display Name");
        opportunityRequest.setOpportunityLastContactDays(1);
        opportunityRequest.setOpportunityProductList("Opportunity Product List");
        opportunityRequest.setOpportunityStage("Opportunity Stage");
        opportunityRequest.setOpportunityStatus(true);
        opportunityRequest.setOwnerID(1);
        opportunityRequest.setPersonOrCompany("Person Or Company");
        opportunityRequest.setProduct(new ArrayList<>());
        opportunityRequest.setProductDescription("Product Description");
        opportunityRequest.setQuantity(1);
        opportunityRequest.setQuotationAmount(10.0d);
        opportunityRequest.setQuotationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setQuotationGivenBy(1);
        opportunityRequest.setQuotationNumber("42");
        opportunityRequest.setQuoteGenerated(true);
        opportunityRequest.setSalutation("Salutation");
        opportunityRequest.setTotalPrice(10.0d);
        opportunityRequest.setUnitPrice(1);
        String content = (new ObjectMapper()).writeValueAsString(opportunityRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/v1/Opportunity/_add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(opportunityController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }

    @Test
    void testUpdateOpportunity() throws Exception {
        OpportunityRequest opportunityRequest = new OpportunityRequest();
        opportunityRequest.setActionExecutionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setActionExecutionStatus("Action Execution Status");
        opportunityRequest.setActionRemarks("Action Remarks");
        opportunityRequest.setAddress("42 Main St");
        opportunityRequest.setDiscountAmount(10.0d);
        opportunityRequest.setDiscountPercentage(10.0d);
        opportunityRequest.setFirstName("Jane");
        opportunityRequest.setId(1);
        opportunityRequest.setLastNameOrCompanyName("Doe");
        opportunityRequest.setMiddleName("Middle Name");
        opportunityRequest.setNextOpportunityAction("Next Opportunity Action");
        opportunityRequest.setNextOpportunityActionAssignedTo(1);
        opportunityRequest.setNextOpportunityActionDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setOpportunityAgingDays(1);
        opportunityRequest.setOpportunityAmount(10.0d);
        opportunityRequest.setOpportunityAssignedDatetime(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setOpportunityCaptureDatetime(LocalDate.ofEpochDay(1L));
        opportunityRequest.setOpportunityClosureProbability(0.25d);
        opportunityRequest.setOpportunityDisplayName("Opportunity Display Name");
        opportunityRequest.setOpportunityLastContactDays(1);
        opportunityRequest.setOpportunityProductList("Opportunity Product List");
        opportunityRequest.setOpportunityStage("Opportunity Stage");
        opportunityRequest.setOpportunityStatus(true);
        opportunityRequest.setOwnerID(1);
        opportunityRequest.setPersonOrCompany("Person Or Company");
        opportunityRequest.setProduct(new ArrayList<>());
        opportunityRequest.setProductDescription("Product Description");
        opportunityRequest.setQuantity(1);
        opportunityRequest.setQuotationAmount(10.0d);
        opportunityRequest.setQuotationDate(LocalDateTime.of(1, 1, 1, 1, 1));
        opportunityRequest.setQuotationGivenBy(1);
        opportunityRequest.setQuotationNumber("42");
        opportunityRequest.setQuoteGenerated(true);
        opportunityRequest.setSalutation("Salutation");
        opportunityRequest.setTotalPrice(10.0d);
        opportunityRequest.setUnitPrice(1);
        String content = (new ObjectMapper()).writeValueAsString(opportunityRequest);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/v1/Opportunity/_update/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(opportunityController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(400));
    }
}

