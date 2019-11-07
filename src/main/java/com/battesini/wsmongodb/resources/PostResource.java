package com.battesini.wsmongodb.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.battesini.wsmongodb.domain.Post;
import com.battesini.wsmongodb.resources.util.URL;
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
	
	@GetMapping(value="/titlesearch")
	public ResponseEntity<List <Post>> fullSearch(@RequestParam(value = "text", defaultValue = "") String text)	{
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/fullsearch")
	public ResponseEntity<List <Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate,
			@RequestParam(value = "minDate", defaultValue = "") String minDate)	{
		text = URL.decodeParam(text);
		Date max = URL.convertDate(maxDate, new Date()); //Default HOJE
		Date min = URL.convertDate(minDate, new Date(0L)); //Default 1970
		List<Post> list = service.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);
	}
	
}
