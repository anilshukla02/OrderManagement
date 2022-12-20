package com.nirmalyalabs.voicerecognition.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "all_roles")

public class Role {

    /*
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     */
	@Id
    @Column(nullable = false, unique = true, length = 45)
    private String rolename;
	private String description;
	
 
    public Role() { }

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    
    
    
}
