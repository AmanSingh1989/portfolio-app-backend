package com.finance.portfolio.controller;

import com.finance.portfolio.entity.Portfolio;
import com.finance.portfolio.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/portfolio")
public class PortfolioController {
    @Autowired
    PortfolioService portfolioService;

    @GetMapping
    public List<Portfolio> get() {
        return portfolioService.getAll();
    }

    @PostMapping
    public Portfolio add(@RequestBody Portfolio p) {
        System.out.println(p);
        return portfolioService.add(p);
    }
}
