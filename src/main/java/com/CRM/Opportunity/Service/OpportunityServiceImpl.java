package com.CRM.Opportunity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.CRM.Opportunity.Entity.PersonOrCompany;
import com.CRM.Opportunity.Model.OpportunityRequest;
import com.CRM.Opportunity.Model.OpportunityResponse;
import com.CRM.Opportunity.Repository.OpportunityRepository;
import com.CRM.Opportunity.Util.CommonConstants;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class OpportunityServiceImpl implements OpportunityService {

    @Autowired
    OpportunityRepository opportunityRepository;

    @Override
    public ResponseEntity<OpportunityResponse<PersonOrCompany>> saveOpportunity(OpportunityRequest opportunityRequest) {
        OpportunityResponse<PersonOrCompany> opportunityResponse = new OpportunityResponse();
        try {
            PersonOrCompany person = new PersonOrCompany();

            person.setPersonOrCompany(opportunityRequest.getPersonOrCompany());
            person.setFirstName(opportunityRequest.getFirstName());
            person.setLastNameOrCompanyName(opportunityRequest.getLastNameOrCompanyName());
            person.setMiddleName(opportunityRequest.getMiddleName());
            person.setSalutation(opportunityRequest.getSalutation());
            person.setOpportunityDisplayName(opportunityRequest.getOpportunityDisplayName());
            person.setOpportunityStage(opportunityRequest.getOpportunityStage());
            person.setAddress(opportunityRequest.getAddress());
            person.setOwnerID(opportunityRequest.getOwnerID());
            person.setOpportunityCaptureDatetime(opportunityRequest.getOpportunityCaptureDatetime());
            person.setOpportunityAssignedDatetime(opportunityRequest.getOpportunityAssignedDatetime());
            person.setOpportunityAgingDays(opportunityRequest.getOpportunityAgingDays());
            person.setOpportunityLastContactDays(opportunityRequest.getOpportunityLastContactDays());
            person.setNextOpportunityAction(opportunityRequest.getNextOpportunityAction());
            person.setNextOpportunityActionAssignedTo(opportunityRequest.getNextOpportunityActionAssignedTo());
            person.setNextOpportunityActionDatetime(opportunityRequest.getNextOpportunityActionDatetime());
            person.setActionExecutionStatus(opportunityRequest.getActionExecutionStatus());
            person.setActionExecutionDatetime(opportunityRequest.getActionExecutionDatetime());
            person.setActionRemarks(opportunityRequest.getActionRemarks());
            person.setOpportunityAmount(opportunityRequest.getOpportunityAmount());
            person.setOpportunityClosureProbability(opportunityRequest.getOpportunityClosureProbability());
            person.isQuoteGenerated();
            person.setOpportunityStatus(opportunityRequest.isOpportunityStatus());
            person.setQuotationNumber(opportunityRequest.getQuotationNumber());
            person.setQuotationDate(opportunityRequest.getQuotationDate());
            person.setQuotationAmount(opportunityRequest.getQuotationAmount());
            person.setQuotationGivenBy(opportunityRequest.getQuotationGivenBy());
            person.setOpportunityProductList(opportunityRequest.getOpportunityProductList());
            person.setProduct(opportunityRequest.getProduct());
            person.setProductDescription(opportunityRequest.getProductDescription());
            person.setQuantity(opportunityRequest.getQuantity());
            person.setUnitPrice(opportunityRequest.getUnitPrice());
            person.setDiscountAmount(opportunityRequest.getDiscountAmount());
            person.setDiscountPercentage(opportunityRequest.getDiscountPercentage());
            person.setTotalPrice(opportunityRequest.getTotalPrice());
            opportunityResponse.setResponseObject(opportunityRepository.save(person));
            opportunityResponse.setStatus(CommonConstants.SUCCESS);
            opportunityResponse.setReasonText(CommonConstants.USER_ADDED_SUCCESSFULLY);
            return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(opportunityResponse, null, HttpStatus.OK);
        } catch (Exception e) {
            opportunityResponse.setStatus(CommonConstants.FAIL);
            opportunityResponse.setReasonText("Exception In UserServiceImpl : saveUser() :: " + e.getMessage());
            return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(opportunityResponse, null, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<OpportunityResponse<PersonOrCompany>> getOpportunityByID(HttpServletRequest request, Integer id) {
        OpportunityResponse<PersonOrCompany> opportunityResponse = new OpportunityResponse<>();
        try {
            List<PersonOrCompany> allOpportunity = opportunityRepository.findAll();
            PersonOrCompany personOrCompany = opportunityRepository.findAllById(id);
            if (!personOrCompany.toString().isEmpty()) {
                opportunityResponse.setResponseObject(personOrCompany);
                opportunityResponse.setStatus(CommonConstants.SUCCESS);
                opportunityResponse.setReasonText(CommonConstants.GET_RECORD_BY_ID);
                return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(opportunityResponse, null, HttpStatus.OK);
            } else {
                opportunityResponse.setStatus(CommonConstants.SUCCESS);
                opportunityResponse.setReasonText(CommonConstants.NO_RECORDS);
                return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(opportunityResponse, null, HttpStatus.OK);
            }
        } catch (Exception e) {

            opportunityResponse.setStatus(CommonConstants.FAIL);
            opportunityResponse.setReasonText("Exception In UserServiceImpl : getUser() :: " + e.getMessage());
            return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(opportunityResponse, null, HttpStatus.BAD_REQUEST);

        }

    }

    @Override
    public ResponseEntity<OpportunityResponse<PersonOrCompany>> getAllOpportunity(HttpServletRequest request) {
        return null;
    }
}

