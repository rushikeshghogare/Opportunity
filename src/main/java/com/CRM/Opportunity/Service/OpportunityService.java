package com.CRM.Opportunity.Service;

import org.springframework.http.ResponseEntity;

import com.CRM.Opportunity.Entity.PersonOrCompany;
import com.CRM.Opportunity.Model.OpportunityRequest;
import com.CRM.Opportunity.Model.OpportunityResponse;

import javax.servlet.http.HttpServletRequest;

public interface OpportunityService {

    ResponseEntity<OpportunityResponse<PersonOrCompany>> saveOpportunity(OpportunityRequest opportunityRequest);
    ResponseEntity<OpportunityResponse<PersonOrCompany>> getOpportunityByID(HttpServletRequest request, Integer id);


    ResponseEntity<OpportunityResponse<PersonOrCompany>> getAllOpportunity(HttpServletRequest request);
//    ResponseEntity<OpportunityResponse<PersonOrCompany>> updateOpportunity();
//    ResponseEntity<OpportunityResponse<PersonOrCompany>> deleteOpportunity();

}
