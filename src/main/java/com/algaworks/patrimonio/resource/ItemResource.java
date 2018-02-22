package com.algaworks.patrimonio.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.patrimonio.model.Item;
import com.algaworks.patrimonio.repository.ItemRepository;

@CrossOrigin("${origem-permitida}")
@RestController
//@RequestMapping("/")
public class ItemResource {

	@Autowired
	private ItemRepository itemRepository;

	@GetMapping("itens")
	public ResponseEntity<List<Item>> listar(){
		return ResponseEntity.status(HttpStatus.OK).body(itemRepository.findAll());
	}

	@PostMapping("itens")
	public ResponseEntity<Item> adicionar(@RequestBody @Valid Item item){
		return ResponseEntity.status(HttpStatus.CREATED).body(itemRepository.save(item));
	}
}
