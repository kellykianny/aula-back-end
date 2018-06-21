package br.edu.unievangelica.domain.cupom;

import br.edu.unievangelica.core.exception.CustomInternalException;
import br.edu.unievangelica.core.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CupomService extends AbstractService<Cupom>{
    @Autowired
    CupomRepository cupomRepository;

    public Cupom findCupomByName(String cupomName){
        Cupom cupom = cupomRepository.findCupomByNameIgnoreCase(cupomName);
        if(cupom.getIsUsed() == false){
            cupom.setIsUsed(true);
            return cupomRepository.save(cupom);
        }
        throw  new CustomInternalException("");
    }
}
