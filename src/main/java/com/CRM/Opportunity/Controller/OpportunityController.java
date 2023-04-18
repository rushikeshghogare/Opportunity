package com.CRM.Opportunity.Controller;

import com.CRM.Opportunity.Entity.PersonOrCompany;
import com.CRM.Opportunity.Model.OpportunityRequest;
import com.CRM.Opportunity.Model.OpportunityResponse;
import com.CRM.Opportunity.Service.OpportunityService;
import com.CRM.Opportunity.Util.CommonConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

@RequestMapping("/api/v1/Opportunity")
@RestController
public class OpportunityController {

    @Autowired
    OpportunityService opportunityService;

    @PostMapping(value = "/_add")
    public ResponseEntity<OpportunityResponse<PersonOrCompany>> saveOpportunity(
            @RequestBody OpportunityRequest opportunityRequest) throws CloneNotSupportedException {
        OpportunityResponse<PersonOrCompany> res = new OpportunityResponse<>();

        try {
            String validate = validateRequest(opportunityRequest); 
            if (validate.trim().isEmpty()) {
                return opportunityService.saveOpportunity(opportunityRequest);
            } else {
                res.setStatus(CommonConstants.FAIL);
                res.setReasonText(validate);
                return new ResponseEntity<>(res, null, HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            res.setStatus(CommonConstants.FAIL);
            res.setReasonText("Exception In UserController : saveUser() :: " + e.getMessage());
            return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(res, null, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "_get/{id}")
    public ResponseEntity<OpportunityResponse<PersonOrCompany>> getUser(HttpServletRequest request,
                                                                        @PathVariable("id") Integer id) {
        OpportunityResponse<PersonOrCompany> res = new OpportunityResponse();

        try {
            if(id == null || id.toString().isEmpty()) {
                res.setStatus(CommonConstants.FAIL);
                res.setReasonCode(CommonConstants.PPUID);
            }else if(id==0){
                return opportunityService.getAllOpportunity(request);

            }else if(!id.toString().isBlank()){
                return opportunityService.getOpportunityByID(request,id);
            }else {
                return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(res,null,HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            res.setStatus(CommonConstants.FAIL);
            res.setReasonText("Exception In UserController : saveUser() :: "+e.getMessage());
            return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(res,null,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(res,null,HttpStatus.OK);


    }
    private String validateRequest(OpportunityRequest opportunityRequest) {
        StringBuilder validate = new StringBuilder();

        if (opportunityRequest.getFirstName() == null || opportunityRequest.getFirstName().trim().isEmpty()) {
            validate.append(CommonConstants.PPUFN);
        }
        if (opportunityRequest.getLastNameOrCompanyName() == null || opportunityRequest.getLastNameOrCompanyName().trim().isEmpty()) {
            validate.append(CommonConstants.PPULN);
        }
        if (opportunityRequest.getActionRemarks() == null || opportunityRequest.getActionRemarks().trim().isEmpty()) {
            validate.append(CommonConstants.PPUAR);
        }

        return validate.toString();
    }

}