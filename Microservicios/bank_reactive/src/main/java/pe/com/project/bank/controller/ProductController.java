package pe.com.project.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.project.bank.model.Product;
import pe.com.project.bank.service.IProductService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/Product")
@Slf4j
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping
    public Flux<Product> findAll(){
        log.info("findAll" + "OK");
        return iProductService.findAll();
    }

    @GetMapping("/{id}")
    public Flux<Product> findProductById(@PathVariable("id") Long id){
        log.info("findProductById" + "OK");
        return  iProductService.findProductById(id);
    }

    @PostMapping
    public Mono<Product> create(@RequestBody Product product){
        log.info("create" + "OK");
        return iProductService.save(product);
    }

    @PutMapping
    public Mono<Product> update(@RequestBody Product product){
        log.info("update" + "OK");
        return iProductService.update(product);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Integer id){
        log.info("delete" + "OK");
        return iProductService.delete(id);
    }

}
