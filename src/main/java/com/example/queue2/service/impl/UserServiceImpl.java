package com.example.queue2.service.impl;

import com.example.queue2.domain.dto.UserRequestDto;
import com.example.queue2.domain.dto.UserResponseDto;
import com.example.queue2.domain.model.Place;
import com.example.queue2.domain.model.Role;
import com.example.queue2.domain.model.User;
import com.example.queue2.repository.UserRepository;
import com.example.queue2.service.UserService;
import com.example.queue2.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, UserRequestDto, UserResponseDto, UserRepository>implements UserService {

    public UserServiceImpl(UserRepository repo) {
        super(repo);
    }

    @Override
    public User toEntity(UserRequestDto dto) {
        User user = new User();
        user.setName(dto.name());
        user.setSurname(dto.surname());
        user.setPatronymic(dto.patronymic());
        user.setBlocked(dto.blocked());
        user.setPlace(createEntityIfNotNull(
                dto.placeId(), id -> {
                    Place place = new Place();
                    place.setId(id);
                    return place;
                }
        ));
        user.setRole(createEntityIfNotNull(
                dto.roleId(), id -> {
                    Role role = new Role();
                    role.setId(id);
                    return role;
                }
        ));


        return user;
    }
    private <T> T createEntityIfNotNull(Long id, java.util.function.Function<Long, T> constructor) {
        return id != null ? constructor.apply(id) : null;}

    @Override
    public UserResponseDto toDTO(User entity) {
        return new UserResponseDto(
                entity.getId(),
                entity.getName(),
                entity.getSurname(),
                entity.getBlocked(),
                entity.getPlace() != null ? new UserResponseDto.PlaceDto(
                        entity.getPlace().getId(),
                        entity.getPlace().getName()) : null
                );
    }
}
