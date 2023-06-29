package com.CRM.Opportunity.Service;

import com.CRM.Opportunity.Entity.PersonOrCompany;
import com.CRM.Opportunity.Entity.Product;
import com.CRM.Opportunity.Model.OpportunityRequest;
import com.CRM.Opportunity.Model.OpportunityResponse;
import com.CRM.Opportunity.Repository.OpportunityRepository;
import com.CRM.Opportunity.Repository.ProductRepository;
import com.CRM.Opportunity.Util.CommonConstants;
import org.apache.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class OpportunityServiceImpl implements OpportunityService {
    static Logger log = Logger.getLogger(OpportunityServiceImpl.class.getName());
    private static final Logger LOGGER = Logger.getLogger(OpportunityServiceImpl.class);
    @Autowired
    OpportunityRepository opportunityRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<OpportunityResponse<PersonOrCompany>> saveOpportunity(OpportunityRequest opportunityRequest) {
        OpportunityResponse<PersonOrCompany> opportunityResponse = new OpportunityResponse();
        try {
            PersonOrCompany person = modelMapper.map(opportunityRequest, PersonOrCompany.class);
            person.setOpportunityDisplayName(person.getSalutation() + " " + person.getFirstName() + " " + person.getMiddleName() + " " + person.getLastNameOrCompanyName());
            PersonOrCompany savedUser = opportunityRepository.save(person);
            OpportunityRequest savedUserDto = modelMapper.map(savedUser, OpportunityRequest.class);
            opportunityResponse.setResponseObject(opportunityRepository.save(person));
            opportunityResponse.setStatus(CommonConstants.SUCCESS);
            opportunityResponse.setReasonCode("This opportunity saved");
            opportunityResponse.setReasonText(CommonConstants.OPPORTUNITY_ADDED_SUCCESSFULLY);
            opportunityResponse.setTotalRecords(opportunityRepository.count());
            return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(opportunityResponse, null, HttpStatus.OK);
        } catch (Exception e) {
            opportunityResponse.setStatus(CommonConstants.FAIL);
            opportunityResponse.setReasonText("Exception In OpportunityServiceImpl : saveOpportunity() :: " + e.getMessage());
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
                personOrCompany.setOpportunityAgingDays(LocalDate.now().getDayOfYear() - personOrCompany.getOpportunityCaptureDatetime().getDayOfYear());

                opportunityResponse.setResponseObject(personOrCompany);
                opportunityResponse.setStatus(CommonConstants.SUCCESS);
                opportunityResponse.setReasonText(CommonConstants.GET_OPPORTUNITY_BY_ID);
                return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(opportunityResponse, null, HttpStatus.OK);
            } else {
                opportunityResponse.setStatus(CommonConstants.FAIL);
                opportunityResponse.setReasonText(CommonConstants.NO_OPPORTUNITY);
                return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(opportunityResponse, null, HttpStatus.OK);
            }
        } catch (Exception e) {

            opportunityResponse.setStatus(CommonConstants.FAIL);
            opportunityResponse.setReasonText("Exception In OpportunityServiceImpl : getOpportunityById() :: " + e.getMessage());
            return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(opportunityResponse, null, HttpStatus.BAD_REQUEST);

        }

    }

    @Override
    public ResponseEntity<OpportunityResponse<PersonOrCompany>> getAllOpportunity(HttpServletRequest request) {

        OpportunityResponse<PersonOrCompany> opportunityResponse = new OpportunityResponse<>();
        try {
            List<PersonOrCompany> allUser = opportunityRepository.findAll();
            if (allUser.size() > 0) {
                opportunityResponse.setResponseListObject(allUser);
                opportunityResponse.setStatus(CommonConstants.SUCCESS);
                opportunityResponse.setReasonText(CommonConstants.GET_ALL_OPPORTUNITY);
                opportunityResponse.setTotalRecords((long) allUser.size());
                return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(opportunityResponse, null, HttpStatus.OK);
            } else {
                opportunityResponse.setStatus(CommonConstants.SUCCESS);
                opportunityResponse.setReasonText(CommonConstants.NO_OPPORTUNITY);
                return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(opportunityResponse, null, HttpStatus.OK);
            }
        } catch (Exception e) {

            opportunityResponse.setStatus(CommonConstants.FAIL);
            opportunityResponse.setReasonText("Exception In OpportunityServiceImpl : getAllOpportunity() :: " + e.getMessage());
            return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(opportunityResponse, null, HttpStatus.BAD_REQUEST);

        }

    }

    @Override
    public ResponseEntity<OpportunityResponse<PersonOrCompany>> updateOpportunity(OpportunityRequest opportunityRequest, Integer id) {
        OpportunityResponse<PersonOrCompany> opportunityResponse = new OpportunityResponse<>();
        try {
            PersonOrCompany existedRecord = opportunityRepository.findById(id).get();
           // opportunityRequest.setProduct(productRepository.findAllById(Collections.singleton(id)));
            opportunityRequest.setId(id);
            modelMapper.map(opportunityRequest, existedRecord);
            opportunityResponse.setResponseObject(opportunityRepository.save(existedRecord));
            opportunityResponse.setStatus(CommonConstants.SUCCESS);
            opportunityResponse.setReasonText(CommonConstants.OPPORTUNITY_DATA_UPDATED_SUCCESSFULLY);
            return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(opportunityResponse, HttpStatus.OK);
        } catch (Exception e) {
            opportunityResponse.setStatus(CommonConstants.FAIL);
            opportunityResponse.setReasonText("Exception In OpportunityServiceImpl : updateOpportunity :: " + e.getMessage());
            return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(opportunityResponse, null, HttpStatus.BAD_REQUEST);

        }

    }

    @Override
    public ResponseEntity<OpportunityResponse<PersonOrCompany>> deleteOpportunity(HttpServletRequest request, Integer id) {

        OpportunityResponse<PersonOrCompany> opportunityResponse = new OpportunityResponse<>();
        try {
            List<PersonOrCompany> allUser = opportunityRepository.findAll();
            PersonOrCompany personOrCompany = opportunityRepository.findAllById(id);
            if (!personOrCompany.toString().isEmpty()) {
                opportunityRepository.deleteById(id);
                opportunityResponse.setStatus(CommonConstants.SUCCESS);
                opportunityResponse.setReasonText(CommonConstants.DELETE_OPPORTUNITY_BY_ID);
                return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(opportunityResponse, null, HttpStatus.OK);
            } else {
                opportunityResponse.setStatus(CommonConstants.SUCCESS);
                opportunityResponse.setReasonText(CommonConstants.NO_OPPORTUNITY);
                return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(opportunityResponse, null, HttpStatus.OK);
            }
        } catch (Exception e) {

            opportunityResponse.setStatus(CommonConstants.FAIL);
            opportunityResponse.setReasonText("Exception In OpportunityDeleteImpl : getOpportunity() :: " + e.getMessage());
            return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(opportunityResponse, null, HttpStatus.BAD_REQUEST);

        }
    }
}


