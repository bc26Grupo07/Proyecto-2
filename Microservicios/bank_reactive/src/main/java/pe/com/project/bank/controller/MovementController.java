package pe.com.project.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.project.bank.model.Movement;
import pe.com.project.bank.service.IMovementService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/Movement")
@Slf4j
public class MovementController {
    @Autowired
    private IMovementService iMovementService;

    @GetMapping
    public Flux<Movement> findAll(){
        log.info("findAll" + "OK");
        return iMovementService.findAll();
    }

    @GetMapping("/{id}")
    public Flux<Movement> findProductById(@PathVariable("id") Long id){
        log.info("findProductById" + "OK");
        return  iMovementService.findMovementById(id);
    }

    @PostMapping
    public Mono<Movement> create(@RequestBody Movement movement){
        log.info("create" + "OK");
        return iMovementService.save(movement);
    }

    @PutMapping
    public Mono<Movement> update(@RequestBody Movement movement){
        log.info("update" + "OK");
        return iMovementService.update(movement);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Integer id){
        log.info("delete" + "OK");
        return iMovementService.delete(id);
    }

    @GetMapping("/{clientId}/{productId}")
    //@RequestMapping(value = "/{clientId}/{productId}", method = GET)
    //@ResponseBody
    public Flux<Movement> findByClientIdAndProductId(@PathVariable Long clientId,@PathVariable Long productId){
        log.info("findByClientIdAndProductId" + "OK");
        return  iMovementService.findByClientIdAndProductId(clientId,productId);
    }

    @GetMapping("movement/id")
    public Flux<Movement> movementBank(@PathVariable("id") Long id)
    {
        log.info("movementBank" + "OK");
        return iMovementService.findAll().filter(x -> x.getClientId().equals(id));
    }
}
