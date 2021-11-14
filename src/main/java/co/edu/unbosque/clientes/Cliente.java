package co.edu.unbosque.clientes;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data  //getter, setter, toString, ...
@AllArgsConstructor
@Document
public class Cliente {
    @Id
    private int cedulaCliente;
    private String direccionCliente;
    @Indexed(unique = true)
    private String emailCliente;
    private String nombreCliente;
    private String telefonoCliente;

}
