package org.mum.scrum.entities;

// Generated Oct 21, 2014 10:30:35 AM by Hibernate Tools 3.6.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.mum.scrum.util.GlobalVar;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "sec_users", catalog = GlobalVar.db_name)
public class User implements java.io.Serializable {
	@Size(min=5, message="Employee name must be at least 5 characters.")	
	private String username;
	
//	@NotNull(message="credential is required")
//			(			        # Start of group
//			  (?=.*\d)		    #   must contains one digit from 0-9
//			  (?=.*[a-z])		#   must contains one lowercase characters
//			  (?=.*[A-Z])		#   must contains one uppercase characters
//			  (?=.*[$&+,:;=?@#|'<>.-^*()%!])		#   must contains one special symbols in the list "@#$%"
//			            .		#     match anything with previous condition checking
//			           {6,20}	#        length at least 6 characters and maximum of 20	
//			)			        # End of group
//	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$&+,:;=?@#|'<>.^*()%!]).{8,60})",message="must contains one digit from 0-9,one lowercase characters,uppercase characters,special characters,length at least 8 characters")
	/*@Size(min=8, message="authentication must be at least 8 characters.")*/
	@Size(min=6,message="password must be at least 6 characters")
	private String password;
	
	@Size(min=1, message="Employee ID field is required!")
	private String userId;
	@Size(min=1, message="Full Name field is required!")
	private String fullName;
	@Size(min=1, message="Full Name KH field is required!")
	private String fullNameKH;
	private String gender;
	
	@Size(min=1,message="Invalid Email")
	@Email
	private String email;
	private Date accountExpiredDate;
	private Date pwdExpiredDate;
	private Date lastLoginDate;
	private Date accountLockDate;
	
	private boolean enabled;
	private boolean firstLogin;
	private boolean locked;
	private Byte attempNo;
	
	@NotNull(message="Max attempt must be bigger than 2")	
	@Min(value=3,message="Max attempt must be bigger than 2")	
	private Byte maxAttempNo;
	private String operator;
	private Date synDate;
	private Set<EmployeeRole> employeeRoles = new HashSet<EmployeeRole>(0);

	public User() {
	}

	public User(String username, String password, boolean enabled,
			boolean firstLogin, boolean locked) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.firstLogin = firstLogin;
		this.locked = locked;
	}

	public User(String username, String password, String userId,
		String fullName, String gender, String email, Date pwdExpiredDate,
		boolean enabled, boolean firstLogin, boolean locked, Byte attempNo,
		String operator, Date synDate, Set<EmployeeRole> employeeRoles) {
		this.username = username;
		this.password = password;
		this.userId = userId;
		this.fullName = fullName;
		this.gender = gender;
		this.email = email;
		this.pwdExpiredDate = pwdExpiredDate;
		this.enabled = enabled;
		this.firstLogin = firstLogin;
		this.locked = locked;
		this.attempNo = attempNo;
		this.operator = operator;
		this.synDate = synDate;
		this.employeeRoles = employeeRoles;
	}

	@Id
	@Column(name = "username", unique = true, nullable = false, length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 60)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "user_id", length = 45)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "full_name", length = 100)
	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "full_name_kh", length = 100)
	public String getFullNameKH() {
		return fullNameKH;
	}

	public void setFullNameKH(String fullNameKH) {
		this.fullNameKH = fullNameKH;
	}

	@Column(name = "gender", length = 15)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "email", length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "account_expired_date", length = 10)
	public Date getAccountExpiredDate() {
		return accountExpiredDate;
	}

	public void setAccountExpiredDate(Date accountExpiredDate) {
		this.accountExpiredDate = accountExpiredDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "pwd_expired_date", length = 10)
	public Date getPwdExpiredDate() {
		return this.pwdExpiredDate;
	}

	public void setPwdExpiredDate(Date pwdExpiredDate) {
		this.pwdExpiredDate = pwdExpiredDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_login_date", length = 10)
	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "account_lock_date", length = 10)
	public Date getAccountLockDate() {
		return accountLockDate;
	}

	public void setAccountLockDate(Date accountLockDate) {
		this.accountLockDate = accountLockDate;
	}

	@Column(name = "enabled", nullable = false)
	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Column(name = "first_login", nullable = false)
	public boolean isFirstLogin() {
		return this.firstLogin;
	}

	public void setFirstLogin(boolean firstLogin) {
		this.firstLogin = firstLogin;
	}

	@Column(name = "locked", nullable = false)
	public boolean isLocked() {
		return this.locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	@Column(name = "attemp_no")
	public Byte getAttempNo() {
		return this.attempNo;
	}

	public void setAttempNo(Byte attempNo) {
		this.attempNo = attempNo;
	}
	
	@Column(name = "max_attemp_no")
	public Byte getMaxAttempNo() {
		return maxAttempNo;
	}

	public void setMaxAttempNo(Byte maxAttempNo) {
		this.maxAttempNo = maxAttempNo;
	}

	@Column(name = "operator", length = 45)
	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "syn_date", length = 19)
	public Date getSynDate() {
		return this.synDate;
	}

	public void setSynDate(Date synDate) {
		this.synDate = synDate;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee",cascade=CascadeType.ALL)
	public Set<EmployeeRole> getEmployeeRoles() {
		return this.employeeRoles;
	}

	public void setEmployeeRoles(Set<EmployeeRole> employeeRoles) {
		this.employeeRoles = employeeRoles;
	}

}
