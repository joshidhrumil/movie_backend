package com.demo.movie.service;

import com.demo.movie.Model.Bookings;
import com.demo.movie.Model.Invoice;
import com.demo.movie.Model.InvoiceResponse;
import com.demo.movie.Repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    @Override
    public InvoiceResponse createInvoice(Invoice invoice) {
        Invoice createdInvoice= new Invoice();
        System.out.println("Quau:" +invoice.getBookings().getQuantity());
        createdInvoice.setBookings(invoice.getBookings());

        createdInvoice.setTotal((invoice.getBookings().getQuantity()*invoice.getBookings().getMovie().getPrice()));
        Invoice finalInvoice= invoiceRepository.save(createdInvoice);
        return new InvoiceResponse("Invoice Succesfully Generated",""+invoice.getInvoice_id());
    }

    @Override
    public Optional<Invoice> getInvoiceByID(String id) {

        Optional<Invoice> bb= invoiceRepository.findById(id);
        return bb;
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    @Override
    public String deleteInvoices() {
        invoiceRepository.deleteAll();
        return "Invoices Deleted";
    }
}
