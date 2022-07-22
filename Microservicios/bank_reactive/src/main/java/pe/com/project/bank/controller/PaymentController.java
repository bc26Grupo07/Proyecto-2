package pe.com.project.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.project.bank.model.Payment;
import pe.com.project.bank.service.IPaymentService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/Payment")
@Slf4j
public class PaymentController {
    @Autowired
    private IPaymentService iPaymentService;

    @GetMapping
    public Flux<Payment> findAll(){
        log.info("findAll" + "OK");
        return iPaymentService.findAll();
    }

    @GetMapping("/{id}")
    public Flux<Payment> findActiveById(@PathVariable("id") Long id){
        log.info("findActiveById" + "OK");
        return  iPaymentService.findPaymentById(id);
    }

    @PostMapping
    public Mono<Payment> create(@RequestBody Payment payment){
        log.info("create" + "OK");
        return iPaymentService.save(payment);
    }

    @PutMapping
    public Mono<Payment> update(@RequestBody Payment payment){
        log.info("update" + "OK");
        return iPaymentService.update(payment);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Integer id){
        log.info("delete" + "OK");
        return iPaymentService.delete(id);
    }
}
