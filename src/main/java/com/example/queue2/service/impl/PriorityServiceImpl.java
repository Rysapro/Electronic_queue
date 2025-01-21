//package com.example.queue2.service.impl;
//
//import com.example.queue2.domain.dto.PriorityDto;
//import com.example.queue2.repository.PriorityRepository;
//import com.example.queue2.service.PriorityService;
//
//import java.util.List;
//import java.util.Optional;
//
//public class PriorityServiceImpl implements PriorityService {
//
//    private final PriorityRepository priorityRepository;
//
//    public PriorityServiceImpl(PriorityRepository priorityRepository) {
//        this.priorityRepository = priorityRepository;
//    }
//
//    @Override
//    public PriorityDto save(PriorityDto priorityDto) {
//        return priorityRepository.save(priorityDto);
//    }
//
//    @Override
//    public Optional<PriorityDto> getById(Long id) {
//        return priorityRepository.findById(id);
//    }
//
//    @Override
//    public List<PriorityDto> getAll() {
//        return priorityRepository.findAll();
//    }
//}
