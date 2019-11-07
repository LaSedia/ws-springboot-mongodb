package com.battesini.wsmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.battesini.wsmongodb.domain.Post;
import com.battesini.wsmongodb.domain.User;
import com.battesini.wsmongodb.dto.AuthorDTO;
import com.battesini.wsmongodb.dto.CommentDTO;
import com.battesini.wsmongodb.repository.PostRepository;
import com.battesini.wsmongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner	{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, sdf.parse("21/03/2019"), "Partiu viagem!", "Hoje vou viajar!!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2019"), "Bom dia facers!", "Beijos luz seguimores!!", new AuthorDTO(maria));

		CommentDTO c1 = new CommentDTO(new AuthorDTO(alex), sdf.parse("21/03/2019"), "Boa viagem!");
		CommentDTO c2 = new CommentDTO(new AuthorDTO(bob), sdf.parse("22/03/2019"), "Aproveite.");
		CommentDTO c3 = new CommentDTO(new AuthorDTO(alex), sdf.parse("23/03/2019"), "xxx");

		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));

		userRepository.save(maria);
		
	}

}
