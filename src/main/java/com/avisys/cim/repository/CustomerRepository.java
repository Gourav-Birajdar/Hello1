package com.avisys.cim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.avisys.cim.Customer;

//Annotation to tell that this is interface for which repository class should be implemented.
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
	//annotation to indicate that written JPQL should be used for this method.
    @Query("SELECT c FROM Customer c WHERE LOWER(c.firstName) LIKE LOWER(concat('%', :firstName, '%'))")
    List<Customer> findByFirstName(@Param("firstName") String firstName);
    
    //annotation to indicate that written JPQL should be used for this method.
    @Query("SELECT c FROM Customer c WHERE LOWER(c.lastName) LIKE LOWER(concat('%', :lastName, '%'))")
    List<Customer> findByLastName(@Param("lastName") String lastName);
    
    Customer findByMobileNumber(String mobileNumber);

	List<Customer> findByFirstNameAndLastNameAndMobileNumber(String firstName, String lastName, String mobileNumber);

	
}

