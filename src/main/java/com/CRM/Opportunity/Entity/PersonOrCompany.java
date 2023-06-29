package com.CRM.Opportunity.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "User_Opportunity")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@DynamicUpdate
public class PersonOrCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "sequence")
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

    @Column(name = "OpportunityCaptureDatetime")
    private LocalDate opportunityCaptureDatetime;

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

    @Column(name = "NextOpportunityActionDatetime")
    private LocalDateTime nextOpportunityActionDatetime;

    @NotEmpty
    @Column(name = "ActionExecutionStatus")
    private String actionExecutionStatus;

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

    @OneToMany(targetEntity = Product.class)
    @JoinColumn(name = "ProductId_FK", referencedColumnName = "id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
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
