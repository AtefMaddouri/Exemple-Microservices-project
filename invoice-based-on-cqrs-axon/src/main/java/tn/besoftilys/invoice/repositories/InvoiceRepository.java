package tn.besoftilys.invoice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.besoftilys.invoice.entities.Invoice;

public interface InvoiceRepository extends MongoRepository<Invoice,Long> {
}
