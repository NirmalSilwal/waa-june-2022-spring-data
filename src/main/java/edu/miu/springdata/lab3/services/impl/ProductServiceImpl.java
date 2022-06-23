package edu.miu.springdata.lab3.services.impl;

import com.pprajapati.springdata1.domain.*;
import edu.miu.springdata.lab3.domain.Product;
import edu.miu.springdata.lab3.domain.Review;
import edu.miu.springdata.lab3.repositories.ProductRepo;
import edu.miu.springdata.lab3.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    @Override
    public void save(Product p) {
        productRepo.save(p);
    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product getById(int id) {
        return (Product) productRepo.findById(id).get();
    }

    @Override
    public List<Product> getAll() {
        return StreamSupport.stream(productRepo.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getWithMinPrice() {
        return null;
    }

    @Override
    public List<Review> getReviewsFromProductId(int productId){
        Product product = (Product) productRepo.findById(productId).get();
        return product.getReviews();
    }

    @Override
    public List<Product> getByName(String name) {
        return productRepo.findByNameContaining(name);
//        return StreamSupport.stream(productRepo.findByNameContaining(name).spliterator(), false)
//                .collect(Collectors.toList());
    }
}

