package com.finance.portfolio.service;

import com.finance.portfolio.entity.Instrument;
import com.finance.portfolio.entity.Portfolio;
import com.finance.portfolio.repository.InstrumentRepository;
import com.finance.portfolio.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PortfolioService {

    @Autowired
    PortfolioRepository portfolioRepository;

    @Autowired
    InstrumentRepository instrumentRepository;

    public List<Portfolio> getAll() {
        return portfolioRepository.findAll();
    }

    public Portfolio add(Portfolio p) {
        if (!Objects.nonNull(p.getInstrument().getId())) {
            System.out.print("Instrument" + p.getInstrument().toString());
            Instrument instrument = instrumentRepository.save(p.getInstrument());
            p.setInstrument(instrument);
        }
        return portfolioRepository.save(p);
    }

}
