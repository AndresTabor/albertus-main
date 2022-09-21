package com.sofka.albertus.domain.commands;

import co.com.sofka.domain.generic.Command;

public class CalculateInvoice extends Command {

    private String applicationID;
    private String billingMonth;

    public CalculateInvoice(String applicationID, String billingMonth) {
        this.applicationID = applicationID;
        this.billingMonth = billingMonth;
    }

    public CalculateInvoice() {
    }

    public String getApplicationID() {
        return applicationID;
    }

    public String getBillingMonth() {
        return billingMonth;
    }


}
