package co.edu.unbosque.clientes;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/clientes")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ClienteController {

    private ClienteService clienteService;

    @PostMapping
    public void insertCliente(@RequestBody Cliente cliente){
        clienteService.insertCliente(cliente);
    }

    @GetMapping
    public List<Cliente> getClientes(){
        return clienteService.getClientes();
    }

    @GetMapping("/{id}")
    public Optional<Cliente> getCliente(@PathVariable int id){
        return clienteService.getCliente(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCliente(@PathVariable int id){
        if(clienteService.deleteCliente(id)){
            return ("{'code':'200','message': 'Registro eliminado'}");
        }
        return ("{'code': '404','message': 'Registro no encontrad'}");
    }

    @PutMapping("/{id}")
    public String updateCliente(@PathVariable int id, @RequestBody Cliente cliente){
        if(clienteService.updateCliente(id, cliente)){
            return ("{'code':'200','message': 'Registro actualiazado'}");
        }
        return ("{'code': '404','message': 'Registro no encontrad'}");
    }
}
