package pe.com.project.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.com.project.bank.model.AffiliatePassive;
import pe.com.project.bank.model.Client;
import pe.com.project.bank.service.IAffiliatePassiveService;
import pe.com.project.bank.service.IClientService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/AffiliatePassive")
@Slf4j
public class AffiliatePassiveController {
    @Autowired
    private IAffiliatePassiveService iAffiliatePassiveService;

    @Autowired
    private IClientService iClientService;

    @GetMapping
    public Flux<AffiliatePassive> findAll(){
        log.info("findAll" + "OK");
        return iAffiliatePassiveService.findAll();
    }

    @GetMapping("/{id}")
    public Flux<AffiliatePassive> findActiveById(@PathVariable("id") Long id){
        log.info("findActiveById" + "OK");
        return  iAffiliatePassiveService.findPassiveById(id);
    }

    @PostMapping
    public Mono<AffiliatePassive> save(@RequestBody AffiliatePassive passive)
    {

        Flux<AffiliatePassive> affiliatePassiveFlux = iAffiliatePassiveService.findAll();

        if(passive.getClientType().equals("persona")){
            if(!passive.getAccountType().equals("plazoFijo")){
                return affiliatePassiveFlux
                        .filter(x->x.getClientId().equals(passive.getClientId()))
                        .distinct(AffiliatePassive::getAccountType) // ninguna, corriente, ahorro o plazo fijo
                        .filter(x->x.getAccountType().equals(passive.getAccountType()))
                        .count()
                        .flatMap(p -> {
                            if ( p >= 1){
                                System.out.println("No se afilio, porque solo puede tener una sola cuenta " + passive.getAccountType());
                                return Mono.empty();
                            }else {
                                System.out.println("Afilición exitosa de cuenta " + passive.getAccountType());
                                return iAffiliatePassiveService.save(passive);
                            }
                        });


            } else {
                System.out.println("Afilición de cuenta Plazo Fijo exitosa");
                return iAffiliatePassiveService.save(passive);
            }
        } else {
            if (passive.getAccountType().equals("corriente")) {
                System.out.println("Empresa: Afilición exitosa de cuenta " + passive.getAccountType());
                return iAffiliatePassiveService.save(passive);
            } else {
                System.out.println("Empresa: No se afilio, porque no puede tener una cuenta " + passive.getAccountType());
                return  null;
            }



        }

    }

    @PutMapping
    public Mono<AffiliatePassive> update(@RequestBody AffiliatePassive passive){
        log.info("update" + "OK");
        return iAffiliatePassiveService.update(passive);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Integer id){
        log.info("delete" + "OK");
        return iAffiliatePassiveService.delete(id);
    }
}
