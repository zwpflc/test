package com.zwp.common.entity;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.command.BaseModel;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

import java.sql.Date;

@Table(name = "T_USER")
public class User extends BaseModel{
    
	@Column(name = "id",type = MySqlTypeConstant.INT,length = 30,isKey = true,isAutoIncrement = true)
	private Integer	id;

	@Column(name = "password",type = MySqlTypeConstant.VARCHAR,length = 30)
	private String	password;

	@Column(name = "phone",type = MySqlTypeConstant.VARCHAR,length = 30)
	private String	phone;
	
	@Column(name = "name",type = MySqlTypeConstant.VARCHAR,length = 111)
	private String	name;
	
	@Column(name = "description",type = MySqlTypeConstant.TEXT)
	private String	description;

	@Column(name = "create_time",type = MySqlTypeConstant.DATETIME)
	private Date	createTime;

	@Column(name = "update_time",type = MySqlTypeConstant.DATETIME)
	private Date	updateTime;

	@Column(name = "number",type = MySqlTypeConstant.BIGINT,length = 15)
	private Long	number;

	@Column(name = "lifecycle",type = MySqlTypeConstant.CHAR,length = 1)
	private String	lifecycle;

	@Column(name = "dekes",type = MySqlTypeConstant.DOUBLE,length = 255,decimalLength = 2)
	private Double	dekes;


	public Integer getId(){
		return id;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getDescription(){
		return description;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public Long getNumber(){
		return number;
	}

	public void setNumber(Long number){
		this.number = number;
	}

	public String getLifecycle(){
		return lifecycle;
	}

	public void setLifecycle(String lifecycle){
		this.lifecycle = lifecycle;
	}

	public Double getDekes(){
		return dekes;
	}

	public void setDekes(Double dekes){
		this.dekes = dekes;
	}

}
