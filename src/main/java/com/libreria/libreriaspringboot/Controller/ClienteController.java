package com.libreria.libreriaspringboot.Controller;

import com.libreria.libreriaspringboot.Model.Cliente;
import com.libreria.libreriaspringboot.Model.Copia;
import com.libreria.libreriaspringboot.Service.ClienteService;
import com.libreria.libreriaspringboot.Service.CopiaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService service;

    @Autowired
    private CopiaService copiaService;

    @GetMapping("/listar")
    public String listarClientes(Model model){
        model.addAttribute("clientes", service.listarClientes());
        return "cliente/clientes";
    }

    @GetMapping("/nuevo")
    public String nuevoCliente(Model model){
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        return "cliente/nuevo_cliente";
    }

    @PostMapping("/guardar")
    public String guardarCliente(@ModelAttribute("cliente") Cliente cliente){
        service.guardarCliente(cliente);
        return "redirect:listar";
    }

    @GetMapping("/editar/{id}")
    public String editarCliente(@PathVariable Integer id, Model model){
        model.addAttribute("cliente", service.obtenerClientePorId(id));
        return "cliente/editar_cliente";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarCliente(@PathVariable Integer id, @ModelAttribute("cliente") Cliente cliente){
        Cliente clienteExistente = service.obtenerClientePorId(id);
        clienteExistente.setIdCliente(id);
        clienteExistente.setNombre(cliente.getNombre());
        clienteExistente.setTelefono(cliente.getTelefono());
        clienteExistente.setDireccion(cliente.getDireccion());
        service.actualizarCliente(clienteExistente);
        return "redirect:../listar";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Integer id){
        service.eliminarCliente(id);
        return "redirect:../listar";
    }
    
    @GetMapping("/prestar/{id}")
    public String prestarLibroCliente(@PathVariable Integer id, Model model){
        model.addAttribute("cliente", service.obtenerClientePorId(id));

        List<Copia> copias = copiaService.listarCopias();
        model.addAttribute("copias", copias);
        return "cliente/prestar";
    }

    @PostMapping("/prestamo/{id}")
    public String guardarPrestamo(@PathVariable Integer id, @ModelAttribute("cliente") Cliente cliente){
        Cliente clienteExistente = service.obtenerClientePorId(id);
        Copia copiaExistente = copiaService.obtenerCopiaPorId(cliente.getIdCopia());
        clienteExistente.agregarCopia(copiaExistente);
        service.guardarCliente(clienteExistente);
        return "redirect:../listar";
    }
    
    
}
