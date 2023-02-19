package com.finance.portfolio.entity;

import javax.persistence.*;

@Entity
@Table(name = "instrument")
public class Instrument {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "instrumentType", nullable = false)
    private IntrumentType intrumentType;

    @Column(name = "instrumentName", nullable = false)
    private String instrumentName;
    @Column(name = "instrumentSymbol", nullable = false)
    private String instrumentSymbol;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "instrument", cascade = CascadeType.ALL, orphanRemoval = true)
    private Portfolio portfolio;

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public IntrumentType getIntrumentType() {
        return intrumentType;
    }

    public void setIntrumentType(IntrumentType intrumentType) {
        this.intrumentType = intrumentType;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public String getInstrumentSymbol() {
        return instrumentSymbol;
    }

    public void setInstrumentSymbol(String instrumentSymbol) {
        this.instrumentSymbol = instrumentSymbol;
    }
}



