package pareon.canto.framework.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Base class of Entity
 * @author tzhrora2
 *
 */
public abstract class DomainEntity implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4345550512664041766L;
	
	private Long id;
	private Date createTime;
	private Date modifiedTime;
	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	
	

}
