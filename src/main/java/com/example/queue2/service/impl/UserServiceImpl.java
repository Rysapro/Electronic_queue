package com.example.queue2.service.impl;
//
//import com.example.queue2.domain.model.User;
//import com.example.queue2.repository.UserRepository;
//import com.example.queue2.service.UserService;
//import com.example.queue2.service.base.BaseServiceImpl;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserServiceImpl extends BaseServiceImpl<User, UserRepository>implements UserService {
//
//    public UserServiceImpl(UserRepository repo) {
//        super(repo);
//    }

//    @Override
//    public User toEntity(UserRequestDto dto) {
//        return new User(dto.name(), dto.surname(), dto.patronymic(), dto.blocked() , dto.place(), dto.role());
//    }
//
//    @Override
//    public UserResponseDto toDTO(User entity) {
//        return new UserResponseDto(entity.getId(), entity.getCreateDate(), entity.getUpdateDate(),
//                entity.getName(), entity.getSurname(), entity.getPatronymic(), entity.getBlocked(),
//                entity.getPlaceOfCustomsClearance(), entity.getRole());
//    }
//}
