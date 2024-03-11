package org.educa.examen.controllers.mappers;

import org.educa.examen.dto.RoleDTO;
import org.educa.examen.entity.Role;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoleMapper {
    public Role toEntity(RoleDTO roleDTO) {
        Role rol = new Role();
        rol.setName(roleDTO.getName());
        rol.setRol(roleDTO.getRol());
        rol.setDescription(roleDTO.getDescription());
        return rol;
    }

    public RoleDTO toDTO(Role rol) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setName(rol.getName());
        roleDTO.setRol(rol.getRol());
        roleDTO.setDescription(rol.getDescription());
        return roleDTO;
    }

    public List<Role> toEntities(List<RoleDTO> roleDTOs) {
        List<Role> roles = new ArrayList<>();
        for (RoleDTO roleDTO : roleDTOs) {
            roles.add(toEntity(roleDTO));
        }
        return roles;
    }

    public List<RoleDTO> toDTOs(List<Role> roles) {
        List<RoleDTO> roleDTOs = new ArrayList<>();
        for (Role rol : roles) {
            roleDTOs.add(toDTO(rol));
        }
        return roleDTOs;
    }
}
