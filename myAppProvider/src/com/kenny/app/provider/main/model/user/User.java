package com.kenny.app.provider.main.model.user;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.kenny.app.provider.common.util.Role;


/**
 * 用户实体类
 * @author 宋志浩
 *
 */
public class User implements Serializable{
	
		private static final long serialVersionUID = 7343955164234869249L;
		private BigInteger id; //编号
	    private BigInteger organizationId; //所属公司
	    private String username; //用户名
	    private String password; //密码
	    private String salt; //加密密码的盐
	    private List<Role> roleIds; //拥有的角色列表
	    private Boolean locked = Boolean.FALSE;
	    
	    public User() {
	    }
	    
	    public User(String username, String password) {
	        this.username = username;
	        this.password = password;
	    }
		public BigInteger getId() {
			return id;
		}
		public void setId(BigInteger id) {
			this.id = id;
		}
		public BigInteger getOrganizationId() {
			return organizationId;
		}
		public void setOrganizationId(BigInteger organizationId) {
			this.organizationId = organizationId;
		}
		@NotEmpty(message="用户名不能为空")
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getSalt() {
			return salt;
		}
		public void setSalt(String salt) {
			this.salt = salt;
		}
		//获取权限列表
		public List<Role> getRoleIds() {
			if(roleIds == null) {
	            roleIds = new ArrayList<Role>();
	        }
			return roleIds;
		}
		public void setRoleIds(List<Role> roleIds) {
			this.roleIds = roleIds;
		}
		//新增权限列表字符串
		 public String getRoleIdsStr() {
		        if(CollectionUtils.isEmpty(roleIds)) {
		            return "";
		        }
		        StringBuilder s = new StringBuilder();
		        for(Role roleId : roleIds) {
		            s.append(roleId);
		            s.append(",");
		        }
		        return s.toString();
		    }
		 	//解析权限列表字符串
		    public void setRoleIdsStr(String roleIdsStr) {
		        if(StringUtils.isEmpty(roleIdsStr)) {
		            return;
		        }
		        String[] roleIdStrs = roleIdsStr.split(",");
		        for(String roleIdStr : roleIdStrs) {
		            if(StringUtils.isEmpty(roleIdStr)) {
		                continue;
		            }
//		            getRoleIds().add((Role)roleIdStr);
		        }
		    }
		
		
		public Boolean getLocked() {
			return locked;
		}
		public void setLocked(Boolean locked) {
			this.locked = locked;
		}

		public String getCredentialsSalt() {
	        return username + salt;
	    }
		
		
		  @Override
		    public boolean equals(Object o) {
		        if (this == o) return true;
		        if (o == null || getClass() != o.getClass()) return false;

		        User user = (User) o;

		        if (id != null ? !id.equals(user.id) : user.id != null) return false;

		        return true;
		    }

		    @Override
		    public int hashCode() {
		        return id != null ? id.hashCode() : 0;
		    }

		    @Override
		    public String toString() {
		        return "User{" +
		                "id=" + id +
		                ", organizationId=" + organizationId +
		                ", username='" + username + '\'' +
		                ", password='" + password + '\'' +
		                ", salt='" + salt + '\'' +
		                ", roleIds=" + roleIds +
		                ", locked=" + locked +
		                '}';
		    }
	    
}
