package pe.com.project.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.project.bank.model.Product;
import pe.com.project.bank.repository.IProductRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    IProductRepository iProductRepository;

    @Override
    public Flux<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Mono<Product> save(Product product) {
        return iProductRepository.save(product);
    }

    @Override
    public Mono<Product> update(Product product) {
        return iProductRepository.save(product);
    }

    @Override
    public Flux<Product> findProductById(Long id) {
        return iProductRepository.findAll().filter(x-> x.getId().equals(id));
    }

    @Override
    public Mono<Void> delete(Integer id) {
        return iProductRepository.deleteById(id);
    }
}
