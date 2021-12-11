package co.edu.unbosque.clientes;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/clientes")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ClienteController {

    private ClienteService clienteService;
    private final JWTChecker jwtchecker;

    @PostMapping
    public void insertCliente(@RequestHeader Map<String, String> headers, @RequestBody Cliente cliente){
        if(jwtchecker.doFilter(headers)){
            clienteService.insertCliente(cliente);
        }
    }

    @GetMapping
    public List<Cliente> getClientes(@RequestHeader Map<String, String> headers){
        if(jwtchecker.doFilter(headers)){
            return clienteService.getClientes();
        }
        return null;
    }

    @GetMapping("/{id}")
    public Optional<Cliente> getCliente(@RequestHeader Map<String, String> headers, @PathVariable int id){
        if(jwtchecker.doFilter(headers)){
            return clienteService.getCliente(id);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteCliente(@RequestHeader Map<String, String> headers, @PathVariable int id){
        if(jwtchecker.doFilter(headers)){
            if(clienteService.deleteCliente(id)){
                return ("{'code':'200','message': 'Registro eliminado'}");
            }
            return ("{'code': '404','message': 'Registro no encontrad'}");
        }
        return null;
    }

    @PutMapping("/{id}")
    public String updateCliente(@RequestHeader Map<String, String> headers, @PathVariable int id, @RequestBody Cliente cliente){
        if(jwtchecker.doFilter(headers)){
            if(clienteService.updateCliente(id, cliente)){
                return ("{'code':'200','message': 'Registro actualiazado'}");
            }
            return ("{'code': '404','message': 'Registro no encontrad'}");
        }
        return null;
    }
}
