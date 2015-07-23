package com.kenny.app.provider.main.service.user;

import java.util.List;
import java.util.Set;

import com.kenny.app.provider.common.util.Pager;
import com.kenny.app.provider.main.model.user.User;



public interface IUserService{
	
	 /**
     * 创建用户
     * @param user
     */
    public User createUser(User user);
    /**
     * 更新用户
     * @param user
     * @return
     */
    public User updateUser(User user);
    /**
     * 删除用户
     * @param userId
     */
    public void deleteUser(Long userId);

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePassword(Long userId, String newPassword);

    /**
     * 根据用户ID查找用户
     * @param userId
     * @return
     */
    public User findOne(int userId);
    /**
     * 查询所有用户
     * @return
     */
    public List<User> findAll();
    /**
     * 查询所有用户,分页
     * @return
     */
    public Pager<User> findPagerAll();

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User findByUsername(String username);

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
    public Set<String> findRoles(String username);

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username);
}
