package com.example.queue2.service.base;

import com.example.queue2.domain.model.base.BaseEntity;
import com.example.queue2.repository.base.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseServiceImpl<
        ENTITY extends BaseEntity, // 👈 добавляем ограничение
        REQUEST_DTO,
        RESPONSE_DTO,
        REPO extends BaseRepository<ENTITY>
        > implements BaseService<ENTITY, REQUEST_DTO, RESPONSE_DTO> {

    protected final REPO repo;

    public BaseServiceImpl(REPO repo) {
        this.repo = repo;
    }

    @Override
    public RESPONSE_DTO create(REQUEST_DTO dto) {
        ENTITY entity = toEntity(dto);
        return toDTO(repo.save(entity));
    }

    @Override
    public RESPONSE_DTO findById(Long id) {
        return repo.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new RuntimeException("Not found!"));
    }

    @Override
    public RESPONSE_DTO update(Long id, REQUEST_DTO dto) {
        ENTITY entity = toEntity(dto);
        try {
            var idField = entity.getClass().getSuperclass().getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(entity, id);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка установки ID", e);
        }
        return toDTO(repo.save(entity));
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<RESPONSE_DTO> findAll() {
        return repo.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public Page<RESPONSE_DTO> findAllWithPagination(Pageable pageable) {
        return repo.findAll(pageable).map(this::toDTO);
    }
}
