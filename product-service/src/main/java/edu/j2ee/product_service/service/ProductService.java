package edu.j2ee.product_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.j2ee.product_service.dto.ProductDto;
import edu.j2ee.product_service.entity.Product;
import edu.j2ee.product_service.mapper.ProductMapper;
import edu.j2ee.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	private final ProductRepository repository;
	private final ProductMapper mapper;

	public Product getProductById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
	}
	
	public List<Product> getAllProducts() {
		return repository.findAll();
	}

	public Product saveProduct(ProductDto product) {
		return repository.save(mapper.toEntity(product));
	}
}
