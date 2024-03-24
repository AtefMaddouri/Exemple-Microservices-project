package tn.besoftilys.invoice.commands;

import tn.besoftilys.invoice.entities.InvoiceItem;

import java.util.List;

public record CreateInvoiceCommand(List<InvoiceItem> invoiceItems) {
}
