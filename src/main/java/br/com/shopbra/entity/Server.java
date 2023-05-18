package br.com.shopbra.entity;

import java.util.List;

import org.springframework.data.annotation.Id;

import br.com.shopbra.entity.products.Category;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Server {
	
	@Id
	private String id;
	private String name;
	private String customerId;
	private String thumbnail;
	private List<Category> categorys;//Only purchases
	
	
}
