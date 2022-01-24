package com.relation.entities.jpahibernate.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.relation.entities.jpahibernate.model.Cliente;
import com.relation.entities.jpahibernate.repository.ClienteRepository;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping(value = "buscarTodos") 
	@ResponseBody
	public List<Cliente> listarTodosClientes(){
		return clienteRepository.findAll();
	}
	
	@GetMapping(value = "buscarPorId") 
	@ResponseBody
	public Optional<Cliente> listarPorId(@RequestParam Integer id){
		return clienteRepository.findById(id);
	}
	
	@PostMapping(value = "salvar") 
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity <Cliente> salvarCliente(@RequestBody Cliente cliente) {
		
		Cliente clien = clienteRepository.save(cliente);
		return new ResponseEntity<Cliente>(clien, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "deletar") 
	@ResponseBody
	public ResponseEntity<String>deletarCliente(@RequestParam Integer id) {
		clienteRepository.deleteById(id);
		 
		return new ResponseEntity<String>("Cliente deletado com sucesso", HttpStatus.OK);
	}
	
	

	
	
	
	
	

}
