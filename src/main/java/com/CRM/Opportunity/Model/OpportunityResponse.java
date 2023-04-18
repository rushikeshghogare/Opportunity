package com.CRM.Opportunity.Model;

import java.io.Serializable;
import java.util.List;

import com.CRM.Opportunity.Entity.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OpportunityResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    @Setter
    @Getter
    private String status;
    @Setter
    @Getter
    private String reasonCode;
    @Setter
    @Getter
    private String reasonText;
    @Setter
    @Getter
    private T responseObject;

    @Setter
    @Getter
    private Integer totalRecords;
    @Setter
    @Getter
    private List<T> responseListObject;

    @Override
    public String toString() {
        return "OpportunityResponse [status=" + status + ", reasonCode=" + reasonCode + ", reasonText=" + reasonText
                + ", responseObject=" + responseObject + ", totalRecords=" + totalRecords + ", responseListObject="
                + responseListObject + "]";
    }


}
