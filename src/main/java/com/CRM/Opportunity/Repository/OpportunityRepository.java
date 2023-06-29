package com.CRM.Opportunity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.CRM.Opportunity.Entity.PersonOrCompany;

@Repository
public interface OpportunityRepository extends JpaRepository<PersonOrCompany, Integer> {

    PersonOrCompany findAllById(Integer id);

//    @Query()
//   PersonOrCompany findId(Integer id);



}
