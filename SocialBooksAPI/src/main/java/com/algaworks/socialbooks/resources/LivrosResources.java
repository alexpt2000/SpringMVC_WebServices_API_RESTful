package com.algaworks.socialbooks.resources;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

}
