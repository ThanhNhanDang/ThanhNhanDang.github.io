package com.java10.roleService;

import java.util.LinkedList;
import java.util.List;

import com.java10.DTO.RoleDTO;
import com.java10.module.Role;
import com.java10.respository.RoleRepository;
public class RoleService {
	private RoleRepository roleRepository;
	
	public RoleService() {
		roleRepository = new RoleRepository();
	}
	public List<RoleDTO> getAll(){
		
		List<Role> roles = roleRepository.getAllRole(); 
		List<RoleDTO> roleDTO = new LinkedList<RoleDTO>();
		
		for(Role role:roles) {
			RoleDTO dto = new RoleDTO();
			dto.setId(role.getId());
			dto.setName(role.getName());
			dto.setDescription(role.getDescription());
			roleDTO.add(dto);
		}
		
		return roleDTO;
	}
	
	public int insert(RoleDTO dto) {
		Role role = new Role();
		role.setDescription(dto.getDescription());
		role.setName(dto.getName());
		return roleRepository.insert(role);
				
	}
	
	public int delete(int id) {
		return roleRepository.delete(id);
	}
	
	public int edit(RoleDTO dto) {
		Role role = roleRepository.findRoleByID(dto.getId());
		if (role != null) {
			role.setId(dto.getId());
			role.setDescription(dto.getDescription());
			role.setName(dto.getName());
			return roleRepository.edit(role);
		}
		return -1;
	}
	
	public RoleDTO getRoleDTOByID(int id) {
		Role role = roleRepository.findRoleByID(id);
		RoleDTO dto = new RoleDTO();
		dto.setId(role.getId());
		dto.setDescription(role.getDescription());
		dto.setName(role.getName());
		return dto;
	}
}
