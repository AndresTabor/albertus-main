package com.sofka.albertus.domain.usecase;

import co.com.sofka.domain.generic.Command;

public class PayInvoiceUseCase extends Command {

    private String invoiceID;

    public PayInvoiceUseCase(String invoiceID) {
        this.invoiceID = invoiceID;
    }

    public PayInvoiceUseCase() {
    }

    public String getInvoiceID() {
        return invoiceID;
    }
}
