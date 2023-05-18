package br.com.shopbra.entity.products;

import java.util.List;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
	
	private String id;
	private String name;
	private List<ProductChannel> channels;
	

}
