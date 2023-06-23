package com.demo.movie.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Invoice
{
    @Id
    private String invoice_id;
    @DBRef
    private Bookings bookings;

    private float total;

    public Invoice() {
    }



    @Autowired
    public Invoice(String invoice_id, Bookings bookings, float total) {
        this.invoice_id=invoice_id;
        this.bookings = bookings;
        this.total = total;
    }

    @Autowired
    public Invoice(Bookings bookings) {
        this.bookings = bookings;
    }



    public String getInvoice_id()
    {
        return invoice_id;
    }

    public void setInvoice_id(String invoice_id) {
        this.invoice_id = invoice_id;
    }

  public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }

    public Bookings getBookings() {
        return bookings;
    }

    public void setBookings(Bookings bookings) {
        this.bookings = bookings;
    }

}
