package pe.com.project.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.project.bank.model.Affiliate;
import pe.com.project.bank.repository.IAffiliateRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AffiliateServiceImpl implements IAffiliateService{

    @Autowired
    IAffiliateRepository iAffiliateRepository;

    @Override
    public Flux<Affiliate> findAll() {
        return iAffiliateRepository.findAll();
    }

    @Override
    public Mono<Affiliate> save(Affiliate affiliate) {
        return iAffiliateRepository.save(affiliate);
    }

    @Override
    public Mono<Affiliate> update(Affiliate affiliate) {
        return iAffiliateRepository.save(affiliate);
    }

    @Override
    public Flux<Affiliate> findAffiliateById(Long id) {
        return iAffiliateRepository.findAll().filter(x-> x.getId().equals(id));
    }

    @Override
    public Mono<Void> delete(Integer id) {
        return iAffiliateRepository.deleteById(id);
    }
}
