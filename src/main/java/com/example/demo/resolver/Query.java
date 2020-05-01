package com.example.demo.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.model.Author;
import com.example.demo.model.Tutorial;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.TutorialRepository;

@Component
public class Query implements GraphQLQueryResolver {

	private AuthorRepository authorRepository;
	private TutorialRepository tutorialRepository;

	@Autowired
	public Query(AuthorRepository authorRepository, TutorialRepository tutorialRepository) {
		this.authorRepository = authorRepository;
		this.tutorialRepository = tutorialRepository;
	}

	public Iterable<Author> findAllAuthors() {
		return authorRepository.findAll();
	}

	public Author findAuthorById(Long id) {
		return authorRepository.findById(id).orElse(null);
	}

	public Iterable<Tutorial> findAllTutorials() {
		return tutorialRepository.findAll();
	}

	public Tutorial findTutorialById(Long id) {
		return tutorialRepository.findById(id).orElse(null);
	}

	public long countAuthors() {
		return authorRepository.count();
	}

	public long countTutorials() {
		return tutorialRepository.count();
	}

}