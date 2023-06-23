package com.demo.movie.Controller;

import com.demo.movie.Model.Bookings;
import com.demo.movie.Model.Invoice;
import com.demo.movie.Model.InvoiceResponse;
import com.demo.movie.service.InvoiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/invoice")
public class InvoiceController extends InvoiceServiceImpl{

    @Autowired
    InvoiceServiceImpl invoiceServiceImpl;

    @PostMapping(value = "/createInvoice")
    public InvoiceResponse CreateInvoice(Invoice invoice){
       return invoiceServiceImpl.createInvoice(invoice);
    }

    @GetMapping(value = "/getInvoiceByID/{id}")
    public Optional<Invoice> getInvoicesByID(@PathVariable String id) {
        return invoiceServiceImpl.getInvoiceByID(id);
    }
    @GetMapping(value = "/getAllInvoices")
    public List<Invoice> getAllInvoice()
    {
        return invoiceServiceImpl.getAllInvoices();
    }

    @DeleteMapping(value = "/deleteInvoices")
    public String deleteInvoice()
    {
        invoiceServiceImpl.deleteInvoices();
        return "Invoices Deleted";
    }


}
