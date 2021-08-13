package com.madhis.optimed.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Table(
        name = "Consult"
      )




public class Consult {
    @Id
    @SequenceGenerator(
            name = "consult_sequence",
            sequenceName = "consult_sequence",
            allocationSize = 1
            
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "consult_sequence"
    )
    private Long consultId;
       
    private Date consultDate;
    private String reservationNumber;
    
    
  // Define 1-Many Relation Patient can come for many consults.
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "consult_id",
            referencedColumnName = "ConsultId"
    )
    private List<Dispense> dispenses;// 1 consult has List of dispensed Items
      
    
    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "consult_id",
            referencedColumnName = "ConsultId"
    )
    private Script script;// 1 consult has 1 script      

}
