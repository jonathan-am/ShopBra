package br.com.shopbra.entity.user;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import br.com.shopbra.constants.UserTypes;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{
	
	private static final long serialVersionUID = -1805386692964812143L;

	@Id
	private String id;
	private String name;
	private String login;
	private String password;
	private UserTypes type;
	private Date created;
	private List<CustomProperty> customProperties;

}
