package com.CRM.Opportunity.Controller;

import com.CRM.Opportunity.Entity.PersonOrCompany;
import com.CRM.Opportunity.Model.OpportunityRequest;
import com.CRM.Opportunity.Model.OpportunityResponse;
import com.CRM.Opportunity.Service.OpportunityService;
import com.CRM.Opportunity.Util.CommonConstants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.NoSuchElementException;


@RequestMapping("/api/v1/Opportunity")
@RestController
@Api("OpportunityController")
public class OpportunityController {

    @Autowired
    OpportunityService opportunityService;

    @PostMapping(value = "/_add")
    @ApiOperation("saveOpportunity")
    public ResponseEntity<OpportunityResponse<PersonOrCompany>> saveOpportunity(
            @RequestBody OpportunityRequest opportunityRequest)  {
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
            res.setReasonText("Exception In UserController : saveOpportunity() :: " + e.getMessage());
            return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(res, null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "_get/{id}")
    @ApiOperation("getByIdOpportunity")
    public ResponseEntity<OpportunityResponse<PersonOrCompany>> getOpportunityById(HttpServletRequest request,
                                                                                   @PathVariable("id") Integer id) {
        OpportunityResponse<PersonOrCompany> res = new OpportunityResponse();

        try {
            if (id == null || id.toString().isEmpty()) {
                res.setStatus(CommonConstants.FAIL);
                res.setReasonCode(CommonConstants.PPUID);
            } else if (id == 0) {
                return opportunityService.getAllOpportunity(request);

            } else if (!id.toString().isBlank()) {
                return opportunityService.getOpportunityByID(request, id);
            } else {
                return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(res, null, HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            res.setStatus(CommonConstants.FAIL);
            res.setReasonText("Exception In UserController : saveOpportunity() :: " + e.getMessage());
            return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(res, null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(res, null, HttpStatus.OK);
    }

    @GetMapping(value = "_getAll")
    @ApiOperation("allOpportunity")
    public ResponseEntity<OpportunityResponse<PersonOrCompany>> getAllOpportunity(HttpServletRequest request) {

        OpportunityResponse<PersonOrCompany> res = new OpportunityResponse();


        try {

            return opportunityService.getAllOpportunity(request);
        } catch (Exception e) {
            res.setStatus(CommonConstants.FAIL);
            res.setReasonText("Exception In UserController : getAllOpportunity() :: " + e.getMessage());
            return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(res, null, HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping(value = "_update/{id}")
    @ApiOperation("updateOpportunity")
    public ResponseEntity<OpportunityResponse<PersonOrCompany>> updateOpportunity(@RequestBody OpportunityRequest opportunityRequest,
                                                                                  @PathVariable("id") Integer id)  {
        OpportunityResponse<PersonOrCompany> res = new OpportunityResponse<>();

        try {
            String validate = validateRequest(opportunityRequest);
            if (!opportunityRequest.toString().isEmpty()) {
                return opportunityService.updateOpportunity(opportunityRequest, id);
            } else {
                res.setStatus(CommonConstants.FAIL);
                res.setReasonText(CommonConstants.PPUID);
                return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(res, null, HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            res.setStatus(CommonConstants.FAIL);
            res.setReasonText("Exception In OpportunityController : updateOpportunity() :: " + e.getMessage());
            return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(res, null, HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping(value = "_delete/{id}")
    @ApiOperation("deleteOpportunity")
    public ResponseEntity<OpportunityResponse<PersonOrCompany>> deleteOpportunity(HttpServletRequest request,
                                                                                  @PathVariable("id") Integer id) {
        OpportunityResponse<PersonOrCompany> res = new OpportunityResponse<>();

        try {

            if (id == null || id.toString().isEmpty()) {
                res.setStatus(CommonConstants.FAIL);
                res.setReasonCode(CommonConstants.PPUID);
            } else if (!id.toString().isBlank()) {
                return opportunityService.deleteOpportunity(request, id);
            } else {
                return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(res, null, HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            res.setStatus(CommonConstants.FAIL);
            res.setReasonText("Exception In OpportunityController : deleteOpportunity() :: " + e.getMessage());
            return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(res, null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<OpportunityResponse<PersonOrCompany>>(res, null, HttpStatus.OK);


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