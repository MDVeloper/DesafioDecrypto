package com.desafio.decrypto.msdb.entity;

import com.desafio.decrypto.msdb.enums.AdmitedCountries;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

/**
 * Represents the table MERCADO
 */
@Entity
@Table(name = "MERCADO")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mercado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "CODE", nullable = false, unique = true)
    private String code;

    @Column (name = "DESCRIPTION")
    private String description;

    @Column (name = "COUNTRY", nullable = false)
    @Enumerated(EnumType.STRING)
    private AdmitedCountries country;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFY_DATE")
    private Date modifyDate;

    @ManyToMany(mappedBy = "marketList")
    private List<Comitente> comitenteList;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return country
     */
    public AdmitedCountries getCountry() {
        return country;
    }

    /**
     * @return createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @return modifyDate
     */
    public Date getModifyDate() {
        return modifyDate;
    }

    /**
     * @return comitenteList
     */
    @JsonManagedReference
    public List<Comitente> getComitenteList() {
        return comitenteList;
    }
}
