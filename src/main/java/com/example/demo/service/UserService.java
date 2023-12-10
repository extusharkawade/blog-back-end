package com.example.demo.service;

import com.example.demo.Entity.User;
import com.example.demo.dto.user.OccupationDto;
import com.example.demo.dto.user.UserDto;
import com.example.demo.repository.OccupationsRepo;
import com.example.demo.repository.UserRepo;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    OccupationsRepo occupationsRepo;
    public ResponseEntity<UserDto> saveUser(UserDto user){
        User userEntity = new User(user.getUsername(),user.getEmail(),user.getOccupation());
        try
        {
           User savedUser = userRepo.save(userEntity);
           UserDto userDto = new UserDto(savedUser.getUsername(),savedUser.getEmail(),savedUser.getOccupation());
            return ResponseEntity.status(200).body(userDto) ;
        }
        catch (ConstraintViolationException e)
        {
           return  ResponseEntity.status(400).body(null);
        }catch (OptimisticLockingFailureException e)
        {
            return ResponseEntity.status(409).body(null);
        }
        catch (InvalidDataAccessApiUsageException e){
            return ResponseEntity.status(400).body(null);
        }
        catch (Exception e){
            return ResponseEntity.status(500).body(null);
        }
    }

    public List<OccupationDto> getOccupations(){
        List<OccupationDto> occupations=  occupationsRepo.findAll().stream()
                .map(obj -> {
                        OccupationDto dto =new OccupationDto();
                        dto.setId(obj.getId());
                        dto.setOccupation(obj.getOccupation());
                        return dto;
                }).collect(Collectors.toList());

        return  occupations;
    }
}
