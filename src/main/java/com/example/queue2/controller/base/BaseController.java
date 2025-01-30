package com.example.queue2.controller.base;

import com.example.queue2.service.base.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<
        ENTITY,
        REQUEST_DTO,
        RESPONSE_DTO,
        SERVICE extends BaseService<ENTITY, REQUEST_DTO, RESPONSE_DTO>> {

    protected final SERVICE baseService;

    public BaseController(SERVICE service) {
        this.baseService = service;
    }

    @GetMapping("/findById/{id}")
    public RESPONSE_DTO findById(@PathVariable Long id){
        return baseService.findById(id);
    }

    @GetMapping("/findAll")
    public List<RESPONSE_DTO> findAll(){
        return baseService.findAll();
    }

    @GetMapping("/findAllWithPagination")
    public Page<RESPONSE_DTO> findAllWithPagination(@PageableDefault(5) Pageable pageable){
        return baseService.findAllWithPagination(pageable);
    }

    @PostMapping("/save")
    public RESPONSE_DTO save(@RequestBody REQUEST_DTO model){
        return baseService.create(model);
    }

    @PutMapping("/update/{id}")
    public RESPONSE_DTO update(@RequestBody REQUEST_DTO model, @PathVariable Long id){
        return baseService.update(id, model);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        baseService.deleteById(id);
    }
}
