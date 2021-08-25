package com.madhis.optimed.repository;

import com.madhis.optimed.entity.Patient;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    
    public List<Patient> findByPatientName(String name);
    
    public Patient findByPatientId(Long patientId);
    
    //jpl query
    @Query("select p from Patient p where p.patientNumber=?1")
    Patient  getPatientByPatientNumber(String patientNumber);
  
    //Native Query
    @Query(
            value = "select * from patient p where p.patient_number=?1",
            nativeQuery = true
    )
    Patient  getPatientByPatientNumberNative(String patientNumber);
  

}
