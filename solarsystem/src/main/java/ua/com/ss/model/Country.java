package ua.com.ss.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name = "countries")
public class Country {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "alpha2")
	private String alpha2;
	
	@Column(name = "alpha3")
	private String alpha3;
	
	
	public Country() {
		
	}

	
	public Country(String name, String alpha2, String alpha3) {
		super();
		this.name = name;
		this.alpha2 = alpha2;
		this.alpha3 = alpha3;
	}


	public Country(int id, String name, String alpha2, String alpha3) {
		this.id = id;
		this.name = name;
		this.alpha2 = alpha2;
		this.alpha3 = alpha3;
	}


	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", alpha2=" + alpha2 + ", alpha3=" + alpha3 + "]";
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alpha2 == null) ? 0 : alpha2.hashCode());
		result = prime * result + ((alpha3 == null) ? 0 : alpha3.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (alpha2 == null) {
			if (other.alpha2 != null)
				return false;
		} else if (!alpha2.equals(other.alpha2))
			return false;
		if (alpha3 == null) {
			if (other.alpha3 != null)
				return false;
		} else if (!alpha3.equals(other.alpha3))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	public int getId() {
		return id;
	}



	public String getName() {
		return name;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAlpha2() {
		return alpha2;
	}


	public void setAlpha2(String alpha2) {
		this.alpha2 = alpha2;
	}


	public String getAlpha3() {
		return alpha3;
	}


	public void setAlpha3(String alpha3) {
		this.alpha3 = alpha3;
	}
		
}
