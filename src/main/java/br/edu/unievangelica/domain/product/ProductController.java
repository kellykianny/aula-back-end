package br.edu.unievangelica.domain.product;

import br.edu.unievangelica.core.controller.ResponseAbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController extends ResponseAbstractController{

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return jsonResponse(productService.listarPorOrdemAlfabetica());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        return jsonResponse(productService.findOne(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@Validated @RequestBody Product product){
        return jsonResponse(productService.save(product));
    }

    @PutMapping
    public ResponseEntity<?> update(@Validated @RequestBody Product product){
        return jsonResponse(productService.save(product));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        return jsonResponse(productService.delete(id));
    }
}