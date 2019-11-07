package com.battesini.wsmongodb.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.battesini.wsmongodb.domain.Post;
import com.battesini.wsmongodb.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@PostMapping(value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id)	{
		Post post = service.findById(id);
		return ResponseEntity.ok().body(post);
	}
	
}
