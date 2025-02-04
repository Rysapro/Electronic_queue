package com.example.queue2.service.impl;
//
//import com.example.queue2.domain.dto.WindowRequestDto;
//import com.example.queue2.domain.dto.WindowResponseDto;
//import com.example.queue2.domain.model.Window;
//import com.example.queue2.repository.WindowRepository;
//import com.example.queue2.service.WindowService;
//import com.example.queue2.service.base.BaseServiceImpl;
//import org.springframework.stereotype.Service;
//
//@Service
//public class WindowServiceImpl extends BaseServiceImpl<Window,  WindowRepository> implements WindowService {
//
//    public WindowServiceImpl(WindowRepository repo) {
//        super(repo);
//    }

//    @Override
//    public Window toEntity(WindowRequestDto dto) {
//        return new Window(dto.number());
//    }
//
//    @Override
//    public WindowResponseDto toDTO(Window entity) {
//        return new WindowResponseDto(entity.getId(), entity.getNumber(), entity.getProcessedTicket(),
//                entity.getProvision(), entity.getOperatorId(), entity.getPlace(), entity.getNumber());
//    }
//}
