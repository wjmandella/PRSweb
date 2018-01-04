package prs.domain.status;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Status {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	@JsonProperty("Description")
	private String description;
	
	public Status() {
		id = 0;
		description ="";		
	}
	
//	public Status (String desc) {
////		this.id = id;
//		this.description = desc;
//	}

	public Status (int id, String desc) {
		this.id = id;
		this.description = desc;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String toString() {
		String msg =
				"[STATUS:\n"
				+ "id: " + id + ", description: " + description + "]";  
		return msg;
	}
	
}
