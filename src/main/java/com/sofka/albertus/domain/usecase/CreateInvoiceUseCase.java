package com.sofka.albertus.domain.usecase;

import co.com.sofka.domain.generic.Command;

public class CreateInvoiceUseCase extends Command {

    private String applicationID;
    private String billingMonth;

    public CreateInvoiceUseCase(String applicationID, String billingMonth) {
        this.applicationID = applicationID;
        this.billingMonth = billingMonth;
    }

    public CreateInvoiceUseCase() {
    }

    public String getApplicationID() {
        return applicationID;
    }

    public String getBillingMonth() {
        return billingMonth;
    }
}
