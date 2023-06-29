package com.CRM.Opportunity.Service;

import org.springframework.http.ResponseEntity;

import com.CRM.Opportunity.Entity.PersonOrCompany;
import com.CRM.Opportunity.Model.OpportunityRequest;
import com.CRM.Opportunity.Model.OpportunityResponse;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public interface OpportunityService {

    ResponseEntity<OpportunityResponse<PersonOrCompany>> saveOpportunity(OpportunityRequest opportunityRequest);

    ResponseEntity<OpportunityResponse<PersonOrCompany>> getOpportunityByID(HttpServletRequest request, Integer id);


    ResponseEntity<OpportunityResponse<PersonOrCompany>> getAllOpportunity(HttpServletRequest request);

    ResponseEntity<OpportunityResponse<PersonOrCompany>> updateOpportunity(OpportunityRequest opportunityRequest, Integer id);

    ResponseEntity<OpportunityResponse<PersonOrCompany>> deleteOpportunity(HttpServletRequest request, Integer id);

}
