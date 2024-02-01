package com.desafio.decrypto.msdb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.UniqueConstraint;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

/**
 * Represent the table COMITENTE
 */
@Entity
@Table(name = "COMITENTE")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comitente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_DATE")
    private Date createDate;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFY_DATE")
    private Date modifyDate;

    @ManyToMany
    @JoinTable(
            name = "RELACION",
            joinColumns = @JoinColumn(name = "COMITENTE_ID"),
            inverseJoinColumns = @JoinColumn(name = "MERCADO_ID"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"COMITENTE_ID", "MERCADO_ID"}))
    private List<Mercado> marketList;

    /**
     * @return id
     */
    public long getId() {
        return this.id;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return this.description;
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
     * @return marketList
     */
    @JsonBackReference
    public List<Mercado> getMarketList() {
        return this.marketList;
    }
}
