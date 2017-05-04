package com.algaworks.socialbooks.resources;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.socialbooks.domain.Livro;
import com.algaworks.socialbooks.repository.LivrosRepository;

@RestController // RestController e a notacao para Rest enquanto Controller e
				// apenas para MVC
@RequestMapping("/livros")
public class LivrosResources {

	@Autowired
	LivrosRepository livrosRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Livro> listar() {

		return livrosRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void Salvar(@RequestBody Livro livro) {

		livrosRepository.save(livro);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Livro Buscar(@PathVariable("id") Long id) {

		return livrosRepository.findOne(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void Deletar(@PathVariable("id") Long id) {

		livrosRepository.delete(id);
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void Atualizar(@RequestBody Livro livro, @PathVariable("id") Long id) {
		livro.setId(id);
		livrosRepository.save(livro);
	}
}
