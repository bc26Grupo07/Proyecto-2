package pe.com.project.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pe.com.project.bank.model.Affiliate;
import pe.com.project.bank.service.IAffiliateService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/Affiliate")
@Slf4j
public class AffiliateController {
    @Autowired
    private IAffiliateService iAffiliateService;

    @GetMapping
    public Flux<Affiliate> findAll(){ log.info("findAll" + "OK"); return iAffiliateService.findAll(); }

    @GetMapping("/{id}")
    public Flux<Affiliate> findActiveById(@PathVariable("id") Long id){ log.info("findActiveById" + "OK"); return  iAffiliateService.findAffiliateById(id);}

    @PostMapping
    public Mono<Affiliate> create(@RequestBody Affiliate affiliate){ log.info("create" + "OK"); return iAffiliateService.save(affiliate); }

    @PutMapping
    public Mono<Affiliate> update(@RequestBody Affiliate affiliate){
        log.info("update" + "OK");
        return iAffiliateService.update(affiliate);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Integer id){
        log.info("delete" + "OK");
        return iAffiliateService.delete(id);
    }
}
