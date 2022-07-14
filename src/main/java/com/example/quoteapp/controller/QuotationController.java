package com.example.quoteapp.controller;


import com.example.quoteapp.domain.Quotation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuotationController {

    private List<Quotation> quotations;

    public QuotationController() {
        this.quotations = new ArrayList<>();
        quotations.add(new Quotation("author1", "quotation1"));
        quotations.add(new Quotation("author2", "quotation2"));
    }

    @GetMapping("/api")
    public List<Quotation> getQuotations() {
        return quotations;
    }

    @PostMapping("/api")
    public boolean addQuotation(@RequestBody Quotation quotation) {
        return quotations.add(quotation);
    }

    @DeleteMapping("/api")
    public void deleteQuotation(@RequestParam int index) {
        quotations.remove(index);
    }
}





















