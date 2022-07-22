package pe.com.project.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.project.bank.model.AffiliateActive;
import pe.com.project.bank.service.IAffiliateActiveService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/AffiliateActive")
@Slf4j
public class AffiliateActiveController {
    @Autowired
    private IAffiliateActiveService iAffiliateActiveService;

    @GetMapping
    public Flux<AffiliateActive> findAll(){
        log.info("findAll" + "OK");
        return iAffiliateActiveService.findAll();
    }

    @GetMapping("/{id}")
    public Flux<AffiliateActive> findActiveById(@PathVariable("id") Long id){
        log.info("findActiveById" + "OK");
        return  iAffiliateActiveService.findActiveById(id);
    }

    @PostMapping
    public Mono<AffiliateActive> create(@RequestBody AffiliateActive active){
        log.info("create" + "OK");
        return iAffiliateActiveService.save(active); }

    @PutMapping
    public Mono<AffiliateActive> update(@RequestBody AffiliateActive active){
        log.info("update" + "OK");
        return iAffiliateActiveService.update(active);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Integer id){
        log.info("delete" + "OK");
        return iAffiliateActiveService.delete(id);
    }

}
