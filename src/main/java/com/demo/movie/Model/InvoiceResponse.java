package com.demo.movie.Model;

public class InvoiceResponse {
    private String Message;
    private String invoice_id;

    public InvoiceResponse() {
    }

    public InvoiceResponse(String message, String invoice_id) {
        Message = message;
        this.invoice_id = invoice_id;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public String getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(String invoice_id) {
        this.invoice_id = invoice_id;
    }
}
