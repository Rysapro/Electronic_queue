package com.example.queue2.controller.base;

import com.example.queue2.domain.model.base.BaseEntity;
import com.example.queue2.service.base.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class BaseController<ENTITY extends BaseEntity, SERVICE extends BaseService<ENTITY>> {

    protected final SERVICE baseService;

    public BaseController(SERVICE service) {
        this.baseService = service;
    }

    @GetMapping("/findById/{id}")
    public ENTITY findById(@PathVariable Long id){
        return  baseService.findById(id);
    }

    @GetMapping("/findAll")
    public List<ENTITY> findAll(){
        return baseService.findAll();
    }

    @GetMapping("/findAllWithPagination")
    public Page<ENTITY> findAllWithPagination(@PageableDefault(5) Pageable pageable){
        return baseService.findAllWithPagination(pageable);
    }

    @PostMapping("/save")
    public ENTITY save(@RequestBody ENTITY model){
        return baseService.create(model);
    }

    @PutMapping("/update/{id}")
    public ENTITY update(@RequestBody ENTITY model, @PathVariable Long id){
        model.setId(id);
        return baseService.update(model);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        baseService.deleteById(id);
    }
}
