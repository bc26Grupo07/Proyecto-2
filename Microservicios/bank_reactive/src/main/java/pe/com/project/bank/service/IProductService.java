package pe.com.project.bank.service;

import pe.com.project.bank.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductService {
    Flux<Product> findAll();

    Mono<Product> save(Product product);

    Mono<Product> update(Product product);

    Flux<Product> findProductById(Long id);

    Mono<Void> delete(Integer id);
}
