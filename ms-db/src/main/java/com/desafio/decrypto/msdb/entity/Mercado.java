package com.desafio.decrypto.msdb.entity;

import com.desafio.decrypto.msdb.enums.AdmitedCountries;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.EnumType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.FetchType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "marketList", cascade = CascadeType.ALL)
    private List<Comitente> comitenteList;

    /**
     * @return id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * @return code
     */
    public String getCode() {
        return this.code;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * @return country
     */
    public AdmitedCountries getCountry() {
        return this.country;
    }

    /**
     * @return createDate
     */
    public Date getCreateDate() {
        return this.createDate;
    }

    /**
     * @return modifyDate
     */
    public Date getModifyDate() {
        return this.modifyDate;
    }

    /**
     * @return comitenteList
     */
    @JsonManagedReference
    public List<Comitente> getComitenteList() {
        return this.comitenteList;
    }
}
