package com.CRM.Opportunity.Entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "User_Opportunity")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PersonOrCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "PersonOrCompany")
    @NotEmpty
    private String personOrCompany;

    @Column(name = "FirstName")
    @NotEmpty
    private String firstName;

    @NotEmpty
    @Column(name = "MiddleName")
    private String middleName;

    @NotEmpty
    @Column(name = "LastNameOrCompanyName")
    private String lastNameOrCompanyName;

    @NotEmpty
    @Column(name = "Salutation")
    private String salutation;

    @NotEmpty
    @Column(name = "OpportunityDisplayName")
    private String opportunityDisplayName;

    @NotEmpty
    @Column(name = "OpportunityStage")
    private String opportunityStage;

    @Column(name = "Address")
    private String address;

    @Column(name = "OwnerID")
    private int ownerID;


    @Column(name = "OpportunityStatus")
    private boolean opportunityStatus;
    @JsonIgnore
    @Column(name = "OpportunityCaptureDatetime")
    private LocalDateTime opportunityCaptureDatetime;
    @JsonIgnore
    @Column(name = "OpportunityAssignedDatetime")
    private LocalDateTime opportunityAssignedDatetime;

    @Column(name = "OpportunityAgingDays")
    private int opportunityAgingDays;

    @Column(name = "OpportunityLastContactDays")
    private int opportunityLastContactDays;

    @NotEmpty
    @Column(name = "NextOpportunityAction")
    private String nextOpportunityAction;

    @NotNull
    @Column(name = "NextOpportunityActionAssignedTo")
    private int nextOpportunityActionAssignedTo;
    @JsonIgnore
    @Column(name = "NextOpportunityActionDatetime")
    private LocalDateTime nextOpportunityActionDatetime;

    @NotEmpty
    @Column(name = "ActionExecutionStatus")
    private String actionExecutionStatus;
    @JsonIgnore
    @Column(name = "ActionExecutionDatetime")
    private LocalDateTime actionExecutionDatetime;

    @NotEmpty
    @Column(name = "ActionRemarks")
    private String actionRemarks;

    @NotNull
    @Column(name = "OpportunityAmount")
    private double opportunityAmount;

    @NotNull
    @Column(name = "OpportunityClosureProbability")
    private double opportunityClosureProbability;


    @Column(name = "IsQuoteGenerated")
    private boolean isQuoteGenerated;

    @NotEmpty
    @Column(name = "QuotationNumber")
    private String quotationNumber;

    @Column(name = "QuotationDate")
    private LocalDateTime quotationDate;

    @NotNull
    @Column(name = "QuotationAmount")
    private double quotationAmount;

    @NotNull
    @Column(name = "QuotationGivenBy")
    private int quotationGivenBy;

    @Column(name = "OpportunityProductList")
    private String opportunityProductList;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Product.class)
    @JoinColumn(name = "ProductId_FK", referencedColumnName = "id")

    private List<Product> product;

    @NotEmpty
    @Column(name = "ProductDescription")
    private String productDescription;

    @NotNull
    @Column(name = "Quantity")
    private int quantity;

    @NotNull
    @Column(name = "UnitPrice")
    private int unitPrice;

    @NotNull
    @Column(name = "DiscountAmount")
    private double discountAmount;

    @NotNull
    @Column(name = "DiscountPercentage")
    private double discountPercentage;

    @NotNull
    @Column(name = "TotalPrice")
    private double totalPrice;


}
