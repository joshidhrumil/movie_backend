package com.demo.movie.service;

import com.demo.movie.Model.Bookings;
import com.demo.movie.Model.Invoice;
import com.demo.movie.Model.InvoiceResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public abstract interface InvoiceService {
    public InvoiceResponse createInvoice(@RequestBody Invoice invoice);
    public Optional<Invoice> getInvoiceByID(String id);
    public List<Invoice> getAllInvoices();
    public String deleteInvoices();
}
