package org.ricardo.restapi.domain.model;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import jakarta.persistence.Id;
import lombok.Data;

@SuppressWarnings("serial")
@Data
@Document(collection = "Product")
public class Product implements Serializable {

	@Id
	@NonNull
	private int id;
	private String imagenPath;
	private String title;
	private String description;
	
	public Product(int id, String imagenPath, String title, String description) {
		this.id = id;
		this.imagenPath = imagenPath;
		this.title = title;
		this.description = description;
	}

}
