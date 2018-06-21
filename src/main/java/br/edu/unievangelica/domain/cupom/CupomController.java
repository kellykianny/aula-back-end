package br.edu.unievangelica.domain.cupom;

import br.edu.unievangelica.core.controller.ResponseAbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cupom")
public class CupomController extends ResponseAbstractController{
    @Autowired
    CupomService cupomService;

    @GetMapping(value = "/{cupom}")
    public ResponseEntity<?> findCupomByName(@PathVariable String cupom){
        return jsonResponse(cupomService.findCupomByName(cupom));
    }

    @PostMapping
    public ResponseEntity<?> save(@Validated @RequestBody Cupom cupom){
        return jsonResponse(cupomService.save(cupom));
    }
}
