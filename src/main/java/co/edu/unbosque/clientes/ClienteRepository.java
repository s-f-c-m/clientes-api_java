package co.edu.unbosque.clientes;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository< Cliente, Integer> {


}
