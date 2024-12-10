package com.app_proxy.budgetplanner.Controller;

import com.app_proxy.budgetplanner.Dto.CategorieDto;
import com.app_proxy.budgetplanner.Service.CategorieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user/categorie")
@RequiredArgsConstructor
public class CategorieController {
    @Autowired
    private CategorieService categorieService;
    @GetMapping("/public")
    public ResponseEntity<String> publicEndpoint() {
        String responseContent = "Public content";
        return ResponseEntity.ok(responseContent);
    }

    @GetMapping("")
    public ResponseEntity<List<CategorieDto>> getAllCategories() {
    List<CategorieDto> categories= categorieService.getAllCategories();
    return ResponseEntity.ok(categories);
    }
    @GetMapping("{id}")
    public ResponseEntity<CategorieDto> getCategorieById(@PathVariable Long id) {
        return ResponseEntity.ok(categorieService.getCategorieById(id));
    }
    @PostMapping("")
    public ResponseEntity<Object> addCategorie(@RequestBody @Valid CategorieDto categorieDto) {
        categorieService.createCategorie(categorieDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("message","save success !")
        );
    }
    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateCategorie(
            @PathVariable(name="id") Long id,
            @RequestBody @Valid CategorieDto categorieDto) {
        categorieService.updateCategorie(categorieDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                Collections.singletonMap("message","update success !!!"));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCategorie(@PathVariable(name="id") Long id) {
        boolean deleted = categorieService.deleteCategorie(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    /*

     */
}
