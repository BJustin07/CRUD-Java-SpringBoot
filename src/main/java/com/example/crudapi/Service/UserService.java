package com.example.crudapi.Service;

import com.example.crudapi.Model.UserEntity;
import com.example.crudapi.Model.UserModel;
import com.example.crudapi.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserModel getUserById(Long id) throws Exception {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (!userEntity.isPresent()) {
            throw new Exception("error 404");
        }
        UserModel userModel = new UserModel();
        userModel.setAge(userEntity.get().getAge());
        userModel.setCute(userEntity.get().getCute());
        userModel.setId(userEntity.get().getId());
        userModel.setName(userEntity.get().getName());
        return userModel;
    }
    public List<UserModel> getAllUsers() throws Exception {
        List<UserEntity> userEntity = userRepository.findAll();
        if (userEntity.isEmpty()) {
            throw new Exception("error 404");
        }
        List<UserModel> userModels = new ArrayList<>();
        userEntity.forEach(userEntity1 -> {
            UserModel userModel = new UserModel();
            userModel.setId(userEntity1.getId());
            userModel.setName(userEntity1.getName());
            userModel.setAge(userEntity1.getAge());
            userModel.setCute(userEntity1.getCute());
            userModels.add(userModel);
        });
        return userModels;
    }

    public void createUser(UserModel userModel) {
        UserEntity userEntity = new UserEntity();
        userEntity.setAge(userModel.getAge());
        userEntity.setCute(userModel.getCute());
        userEntity.setId(userModel.getId());
        userEntity.setName(userModel.getName());
        userRepository.save(userEntity);
    }
    public UserModel updateUserById(Long id, UserModel userModel) throws Exception {
       UserModel userModel1 = getUserById(id);
       if (userModel1 == null) {
           throw new Exception("error 404");
       }
       UserEntity userEntity = new UserEntity();
       userEntity.setAge(userModel.getAge());
       userEntity.setCute(userModel.getCute());
       userEntity.setId(userModel.getId());
       userEntity.setName(userModel.getName());
       userRepository.save(userEntity);
       return userModel;
    }
    public void deleteUserById(Long id) throws Exception {
        UserModel userModel1 = getUserById(id);
        if (userModel1 == null) {
            throw new Exception("error 404");
        }
        userRepository.deleteById(id);
    }
}
