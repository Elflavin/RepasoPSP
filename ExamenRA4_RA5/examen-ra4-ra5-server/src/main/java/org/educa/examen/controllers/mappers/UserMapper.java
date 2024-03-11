package org.educa.examen.controllers.mappers;

import org.educa.examen.dto.UserDTO;
import org.educa.examen.entity.User;
import org.educa.examen.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    private final RoleMapper roleMapper;
    private final SecurityUtil securityUtil;

    @Autowired
    public UserMapper(RoleMapper roleMapper, SecurityUtil securityUtil) {
        this.roleMapper = roleMapper;
        this.securityUtil = securityUtil;
    }

    public User toEntity(UserDTO userDTO) throws Exception {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(securityUtil.createHash(userDTO.getPassword()));
        user.setEmail(securityUtil.crypt(userDTO.getEmail()));
        user.setNif(securityUtil.crypt(userDTO.getNif()));
        user.setSurname(userDTO.getSurname());
        user.setName(userDTO.getName());
        user.setRoles(roleMapper.toEntities(userDTO.getRoles()));
        return user;
    }

    public UserDTO toDTO(User user) throws IllegalBlockSizeException, NoSuchPaddingException,
            BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(securityUtil.decrypt(user.getEmail()));
        userDTO.setNif(securityUtil.decrypt(user.getNif()));
        userDTO.setSurname(user.getSurname());
        userDTO.setName(user.getName());
        userDTO.setRoles(roleMapper.toDTOs(user.getRoles()));
        return userDTO;
    }

    public List<User> toEntities(List<UserDTO> userDTOs) throws Exception {
        List<User> users = new ArrayList<>();
        for (UserDTO userDTO : userDTOs) {
            users.add(toEntity(userDTO));
        }
        return users;
    }

    public List<UserDTO> toDTOs(List<User> users) throws IllegalBlockSizeException, NoSuchPaddingException,
            BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        List<UserDTO> userDTOs = new ArrayList<>();
        for (User user : users) {
            userDTOs.add(toDTO(user));
        }
        return userDTOs;
    }
}
