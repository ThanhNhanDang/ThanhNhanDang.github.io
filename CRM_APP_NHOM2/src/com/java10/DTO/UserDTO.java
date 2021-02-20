package com.java10.DTO;

public class UserDTO {
	private int id;
	private String email;
	private String password;
	private String fullname;
	private String avatar;
	private int role_id;
	private String desRole;
	private String roleName;
	

	public UserDTO(String email, String password, String fullname, String avatar) {
		this.email = email;
		this.password = password;
		this.fullname = fullname;
		this.avatar = avatar;
	}
	public UserDTO() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAvatar() {
		return avatar;
	}
	
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	public String getDesRole() {
		return this.desRole;
	}
	public void setDesRole(String desRole) {
		this.desRole = desRole;
	}
	public String getRoleName() {
		return this.roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
