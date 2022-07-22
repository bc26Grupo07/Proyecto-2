package pe.com.project.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.project.bank.model.Consumption;
import pe.com.project.bank.service.IConsumptionService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/Consumption")
@Slf4j
public class ConsumptionController {
    @Autowired
    private IConsumptionService iConsumptionService;

    @GetMapping
    public Flux<Consumption> findAll(){
        log.info("findAll" + "OK");
        return iConsumptionService.findAll();
    }

    @GetMapping("/{id}")
    public Flux<Consumption> findProductById(@PathVariable("id") Long id){
        log.info("findProductById" + "OK");
        return  iConsumptionService.findConsumptionById(id);
    }

    @PostMapping
    public Mono<Consumption> create(@RequestBody Consumption consumption){
        log.info("create" + "OK");
        return iConsumptionService.save(consumption);
    }

    @PutMapping
    public Mono<Consumption> update(@RequestBody Consumption consumption){
        log.info("update" + "OK");
        return iConsumptionService.update(consumption);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Integer id){
        log.info("delete" + "OK");
        return iConsumptionService.delete(id);
    }
}
