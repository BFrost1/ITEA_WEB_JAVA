package ua.com.ss.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "goods")
public class Item {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "specifications")
	private String specifications;
	
	@Column(name = "guarantee")
	private Integer guarantee;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "distanceLevel")
	private Integer distanceLevel;
	
	@Column(name = "linkImg")
	private String linkImg;
	
	
	public Item() {
		
	}

	
	
	public Item(String name, String specifications, Integer guarantee, Integer price, Integer distanceLevel,
			String linkImg) {
		super();
		this.name = name;
		this.specifications = specifications;
		this.guarantee = guarantee;
		this.price = price;
		this.distanceLevel = distanceLevel;
		this.linkImg = linkImg;
	}



	public Item(Integer id, String name, String specifications, Integer guarantee, Integer price, Integer distanceLevel,
			String linkImg) {
		super();
		this.id = id;
		this.name = name;
		this.specifications = specifications;
		this.guarantee = guarantee;
		this.price = price;
		this.distanceLevel = distanceLevel;
		this.linkImg = linkImg;
	}

	

	@Override
	public String toString() {
		return "Item [name=" + name + ", specifications=" + specifications + ", guarantee=" + guarantee + ", price="
				+ price + ", distanceLevel=" + distanceLevel + ", linkImg=" + linkImg + "]";
	}

	

	



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((distanceLevel == null) ? 0 : distanceLevel.hashCode());
		result = prime * result + ((guarantee == null) ? 0 : guarantee.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((linkImg == null) ? 0 : linkImg.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((specifications == null) ? 0 : specifications.hashCode());
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
		Item other = (Item) obj;
		if (distanceLevel == null) {
			if (other.distanceLevel != null)
				return false;
		} else if (!distanceLevel.equals(other.distanceLevel))
			return false;
		if (guarantee == null) {
			if (other.guarantee != null)
				return false;
		} else if (!guarantee.equals(other.guarantee))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (linkImg == null) {
			if (other.linkImg != null)
				return false;
		} else if (!linkImg.equals(other.linkImg))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (specifications == null) {
			if (other.specifications != null)
				return false;
		} else if (!specifications.equals(other.specifications))
			return false;
		return true;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getSpecifications() {
		return specifications;
	}



	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}



	public Integer getGuarantee() {
		return guarantee;
	}



	public void setGuarantee(Integer guarantee) {
		this.guarantee = guarantee;
	}



	public Integer getPrice() {
		return price;
	}



	public void setPrice(Integer price) {
		this.price = price;
	}



	public Integer getDistanceLevel() {
		return distanceLevel;
	}



	public void setDistanceLevel(Integer distanceLevel) {
		this.distanceLevel = distanceLevel;
	}



	public String getLinkImg() {
		return linkImg;
	}



	public void setLinkImg(String linkImg) {
		this.linkImg = linkImg;
	}

	
	
}
