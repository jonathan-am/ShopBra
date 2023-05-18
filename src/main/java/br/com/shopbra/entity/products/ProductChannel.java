package br.com.shopbra.entity.products;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ProductChannel {
	
	@Id
	private String id;
	
	private String name;
	private Double price;
	private String description;
	private String imageUrl;
	private Integer embedColor;
	
	
}
