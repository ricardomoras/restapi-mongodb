package org.ricardo.restapi.service;

import java.util.List;

import org.ricardo.restapi.domain.dto.ProducDTO;
import org.ricardo.restapi.domain.model.Product;
import org.ricardo.restapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class ProductService {
	
	@Autowired
	ProductRepository repository;

	public List<Product> getAllProducts(){
		return repository.findAll();
	}

	public void createProduct(ProducDTO productDTO) {
		Product product = new Product(
				productDTO.getId(),
				productDTO.getImagenPath(),
				productDTO.getTitle(),
				productDTO.getDescription()
				);
		repository.save(product);
		
	}

	public void updateProduct(int productId, ProducDTO productDTO) {
		Product product = repository.findById(productId).orElse(null);
		
		if (product != null) {
			product.setTitle(productDTO.getTitle());
			product.setDescription(productDTO.getDescription());
			repository.save(product);
		}
		
	}

	public void deleteProduct(int productId) {
		Product product = repository.findById(productId).orElse(null);
		if (product != null) {
			repository.delete(product);
		}
		
	};

}
