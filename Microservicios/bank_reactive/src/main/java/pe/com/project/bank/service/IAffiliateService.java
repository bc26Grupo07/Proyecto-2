package pe.com.project.bank.service;

import pe.com.project.bank.model.Affiliate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAffiliateService {
    Flux<Affiliate> findAll();

    Mono<Affiliate> save(Affiliate affiliate);

    Mono<Affiliate> update(Affiliate affiliate);

    Flux<Affiliate> findAffiliateById(Long id);

    Mono<Void> delete(Integer id);
}
