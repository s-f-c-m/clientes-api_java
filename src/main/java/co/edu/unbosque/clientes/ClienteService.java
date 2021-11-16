package co.edu.unbosque.clientes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteService {
    private ClienteRepository clienteRepository;

    public void insertCliente(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public List<Cliente> getClientes(){
       return clienteRepository.findAll();
    }

    public Optional<Cliente> getCliente(int id){
        return clienteRepository.findById(id);
    }

    public boolean deleteCliente(int id){
        if (clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean updateCliente(int id, Cliente cliente){
        if (clienteRepository.existsById(id)){
            System.out.println("first");
            clienteRepository.save(cliente);
            return true;
        }
        System.out.println("second");
        return false;
    }
}
