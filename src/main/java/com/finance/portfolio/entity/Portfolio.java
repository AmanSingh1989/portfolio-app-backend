package com.finance.portfolio.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Portfolio")
public class Portfolio {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instrument_id")
    private Instrument instrument;
    private long units;
    private long investedAmt;
    private long currentAmt;
    private long pricePerUnit;
    private String links;

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public long getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(long pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public long getInvestedAmt() {
        return investedAmt;
    }

    public void setInvestedAmt(long investedAmt) {
        this.investedAmt = investedAmt;
    }

    public long getCurrentAmt() {
        return currentAmt;
    }

    public void setCurrentAmt(long currentAmt) {
        this.currentAmt = currentAmt;
    }

    public long getUnits() {
        return units;
    }

    public void setUnits(long units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "id=" + id +
                ", instrument=" + instrument +
                ", units=" + units +
                ", investedAmt=" + investedAmt +
                ", currentAmt=" + currentAmt +
                ", pricePerUnit=" + pricePerUnit +
                ", links='" + links + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Portfolio portfolio = (Portfolio) o;
        return units == portfolio.units && investedAmt == portfolio.investedAmt && currentAmt == portfolio.currentAmt && pricePerUnit == portfolio.pricePerUnit && Objects.equals(id, portfolio.id) && Objects.equals(instrument, portfolio.instrument) && Objects.equals(links, portfolio.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, instrument, units, investedAmt, currentAmt, pricePerUnit, links);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
