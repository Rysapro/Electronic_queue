package com.example.queue2.service.base;

import com.example.queue2.domain.model.base.BaseEntity;
import com.example.queue2.repository.base.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public abstract class BaseServiceImpl<E extends BaseEntity, Repo extends BaseRepository<E>> implements BaseService<E> {
    protected final Repo repo;
    public BaseServiceImpl(Repo repo) {
        this.repo = repo;
    }

    @Override
    public E create(E dto) {
        return repo.save(dto);
    }

    @Override
    public E findById(Long id) {
        return repo.findById(id).orElseThrow(()-> new RuntimeException("Not found!"));
    }

    @Override
    public E update(E dto) {
        return repo.save(dto);
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<E> findAll() {
        return repo.findAll();
    }

    @Override
    public Page<E> findAllWithPagination(Pageable pageable) {
        return repo.findAll(pageable);
    }
}
