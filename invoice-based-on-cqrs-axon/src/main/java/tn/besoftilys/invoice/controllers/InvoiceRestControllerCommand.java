package tn.besoftilys.invoice.controllers;

import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.besoftilys.invoice.commands.CreateInvoiceCommand;
import tn.besoftilys.invoice.entities.Invoice;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class InvoiceRestControllerCommand {

    private final CommandGateway commandGateway;
    private final EventStore eventStore;

    @PostMapping
    public CompletableFuture<Long> add(@RequestBody Invoice invoice) {
        return commandGateway.send(new CreateInvoiceCommand(invoice.getInvoiceItems());
    }


}
