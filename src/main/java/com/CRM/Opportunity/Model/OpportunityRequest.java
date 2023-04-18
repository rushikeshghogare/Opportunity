package com.CRM.Opportunity.Model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.CRM.Opportunity.Entity.Product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OpportunityRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;

    private String personOrCompany;

    private String firstName;

    private String middleName;

    private String lastNameOrCompanyName;

    private String salutation;

    private String opportunityDisplayName;

    private String opportunityStage;

    private String address;

    private int ownerID;

    private boolean opportunityStatus;
    @JsonIgnore
    private LocalDateTime opportunityCaptureDatetime;
    @JsonIgnore
    private LocalDateTime opportunityAssignedDatetime;

    private int opportunityAgingDays;

    private int opportunityLastContactDays;

    private String nextOpportunityAction;

    private int nextOpportunityActionAssignedTo;
    @JsonIgnore
    private LocalDateTime nextOpportunityActionDatetime;

    private String actionExecutionStatus;
    @JsonIgnore
    private LocalDateTime actionExecutionDatetime;

    private String actionRemarks;

    private double opportunityAmount;

    private double opportunityClosureProbability;

    private boolean isQuoteGenerated;

    private String quotationNumber;
    @JsonIgnore
    private LocalDateTime quotationDate;

    private double quotationAmount;

    private int quotationGivenBy;

    private String opportunityProductList;
    @JsonIgnore
    private List<Product> product;

    private String productDescription;

    private int quantity;

    private int unitPrice;

    private double discountAmount;

    private double discountPercentage;

    private double totalPrice;

}
