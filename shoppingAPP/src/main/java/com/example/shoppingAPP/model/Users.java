package com.example.shoppingAPP.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users  {

	
	private int id;
	private boolean active;
	private String address;
	private String name;
    private String password;
    private String phone;
    private String role;
    
    
	public Users(int id, boolean active, String address, String name, String password, String phone, String role) {
		
		this.id = id;
		this.active = active;
		this.address = address;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.role = role;
		
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
   public void setId(int id) {
		this.id = id;
	}

    @Column(name = "active" , nullable = false)
	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}

	@Column(name = "address" , nullable = false)
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "name" , nullable = false)
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password" , nullable = false)
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "phone" , nullable = false)
	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "role" , nullable = false)
	public String getRole() {
		return role;
	}


	public Users() {
		super();
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "Users [id=" + id + ", active=" + active + ", address=" + address + ", name=" + name + ", password="
				+ password + ", phone=" + phone + ", role=" + role + "]";
	}
	
	

}