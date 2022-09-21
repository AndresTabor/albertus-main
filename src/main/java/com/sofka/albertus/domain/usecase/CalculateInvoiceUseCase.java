package com.sofka.albertus.domain.usecase;

import co.com.sofka.domain.generic.Command;

public class CalculateInvoiceUseCase extends Command {

    private String invoiceId;
    private String applicationID;
    private String billingMonth;

    public CalculateInvoiceUseCase(String applicationID, String billingMonth, String invoiceId) {
        this.applicationID = applicationID;
        this.billingMonth = billingMonth;
        this.invoiceId = invoiceId;
    }

    public CalculateInvoiceUseCase() {
    }

    public String getApplicationID() {
        return applicationID;
    }

    public String getBillingMonth() {
        return billingMonth;
    }

    public String getInvoiceId() {
        return invoiceId;
    }
}