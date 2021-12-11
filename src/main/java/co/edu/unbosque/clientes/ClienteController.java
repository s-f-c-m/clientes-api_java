package co.edu.unbosque.clientes;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.message.AuthException;
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
    public void insertCliente(@RequestHeader Map<String, String> headers, @RequestBody Cliente cliente) throws AuthException {
        if(jwtchecker.doFilter(headers)){
            clienteService.insertCliente(cliente);
    }else{
        throw new AuthException("No authorizado");
    }
    }

    @GetMapping
    public List<Cliente> getClientes(@RequestHeader Map<String, String> headers) throws AuthException {
        if(jwtchecker.doFilter(headers)){
            return clienteService.getClientes();
    }else{
        throw new AuthException("No authorizado");
        }
    }

    @GetMapping("/{id}")
    public Optional<Cliente> getCliente(@RequestHeader Map<String, String> headers, @PathVariable int id) throws AuthException {
        if(jwtchecker.doFilter(headers)){
            return clienteService.getCliente(id);
        }else{
        throw new AuthException("No authorizado");
        }
    }

    @DeleteMapping("/{id}")
    public String deleteCliente(@RequestHeader Map<String, String> headers, @PathVariable int id) throws AuthException {
        if(jwtchecker.doFilter(headers)){
            if(clienteService.deleteCliente(id)){
                return ("{'code':'200','message': 'Registro eliminado'}");
            }
            return ("{'code': '404','message': 'Registro no encontrad'}");
        }else{
        throw new AuthException("No authorizado");
        }
    }

    @PutMapping("/{id}")
    public String updateCliente(@RequestHeader Map<String, String> headers, @PathVariable int id, @RequestBody Cliente cliente) throws AuthException {
        if(jwtchecker.doFilter(headers)){
            if(clienteService.updateCliente(id, cliente)){
                return ("{'code':'200','message': 'Registro actualiazado'}");
            }
            return ("{'code': '404','message': 'Registro no encontrad'}");
        }else{
        throw new AuthException("No authorizado");
        }
    }
}
