package cn.com.guilongkeji.zsst.mapper;


import cn.com.guilongkeji.zsst.pojo.SysUser;
import cn.com.guilongkeji.zsst.pojo.UserDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 功能描述 用户唯一认证方式，激活方式
 * @author xgl
 * @date 2020/1/5
 */
@Mapper
public interface UserDetailMapper {
    /**
     * 功能描述 增加用户详情
     * @author xgl
     * @date 2020/1/13
      * @param userDetail
     * @return void
     */
    public void addUserDetail(UserDetail userDetail);
    /**
     * 功能描述 修改用户详情
     * @author xgl
     * @date 2020/1/13
      * @param userDetail
     * @return void
     */
    public void updateUserDetail(UserDetail userDetail);
    /**
     * 功能描述 根据用户获取用户详细信息
     * @author xgl
     * @date 2020/1/13
      * @param uid
     * @return cn.com.guilongkeji.zsst.pojo.UserDetail
     */
    public UserDetail getUserDetailByUser(Integer uid);
    /**
     * 功能描述 获取所有用户认证信息
     * @author xgl
     * @date 2020/1/13
      * @param
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.UserDetail>
     */
    public List<UserDetail> getAllUserDetail();
    /**
     * 功能描述 删除用户认证信息
     * @author xgl
     * @date 2020/1/13
      * @param id
     * @return void
     */
    public void removeUserDetail(Integer id);
    /**
     * 功能描述 批量删除用户认证信息
     * @author xgl
     * @date 2020/1/13
      * @param ids
     * @return void
     */
    public void removeUserDetails(List<Integer> ids);
}