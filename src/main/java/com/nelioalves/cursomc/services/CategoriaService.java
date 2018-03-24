package com.nelioalves.cursomc.services;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.domain.Categoria;
import com.nelioalves.cursomc.repositories.CategoriaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoriaService
{
	@Autowired // Instancia automaticamente pelo Spring boot
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) throws ObjectNotFoundException
	{
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException(
				"Object not found. Id used: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
//	public Categoria buscar(Integer id)
//	{
//		Optional <Categoria> obj = repo.findById(id);
//		
//		if ( obj == null )
//		{
//			throw new com.nelioalves.cursomc.services.exceptions.ObjectNotFoundException("Object not found. Id used: " + id 
//			+ ", Tipo: " + Categoria.class.getName());
//		}
//		
//		return obj;
//	}
}
