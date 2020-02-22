package cn.com.guilongkeji.zsst.service.impl;

import cn.com.guilongkeji.zsst.mapper.*;
import cn.com.guilongkeji.zsst.pojo.*;
import cn.com.guilongkeji.zsst.service.UserService;
import cn.com.guilongkeji.zsst.utils.StringUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/5
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private SysUserMapper userMapper;
    @Resource
    private UserDetailMapper userDetailMapper;
    @Resource
    private CodeMapper codeMapper;
    @Resource
    private SysRoleMapper sysRoleMapper;
    @Resource
    private SysResourceMapper sysResourceMapper;

    @Override
    public boolean isExist(String username) {
        return userMapper.findByUsername(username)!=null;
    }

    @Override
    public SysUser getUserByName(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public SysUser getByUsernameAndPassword(String username, String password) {
        return userMapper.getByUsernameAndPassword(username,password);
    }

    @Override
    public void registerSysUser(SysUser sysUser) {
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        String encodedPassword = new SimpleHash("md5",sysUser.getPassword(),salt,2).toString();
        sysUser.setPassword(encodedPassword);
        sysUser.setRoleIds("1");
        sysUser.setBLocked(true);
        sysUser.setSalt(salt);
        userMapper.addSysUser(sysUser);
    }

    @Override
    public void updateSysUser(SysUser sysUser) {
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        String encodedPassword = new SimpleHash("md5",sysUser.getPassword(),salt,2).toString();
        sysUser.setPassword(encodedPassword);
        sysUser.setRoleIds("1");
        sysUser.setBLocked(true);
        sysUser.setSalt(salt);
        userMapper.updateSysUser(sysUser);
    }

    @Override
    public List<SysUser> getAllSysUser() {
        return userMapper.getAllUser();
    }

    @Override
    public void registerAllSysUser(List<SysUser> sysUserList) {
        userMapper.addAllSysUser(sysUserList);
    }


    @Override
    public void insertCode(Code code) {
        codeMapper.insertCode(code);
    }

    @Override
    public Code getCodeByPhone(String phone) {
        return codeMapper.getCodeByPhone(phone);
    }

    @Override
    public UserDetail getUserDetailByUserId(Integer uid) {
        return userDetailMapper.getUserDetailByUser(uid);
    }

    @Override
    public void addUserDetail(UserDetail userDetail) {
        userDetailMapper.addUserDetail(userDetail);
    }

    @Override
    public void updateUserDetail(UserDetail userDetail) {
        userDetailMapper.updateUserDetail(userDetail);
    }

    @Override
    public void removeUserDetail(Integer id) {
        userDetailMapper.removeUserDetail(id);
    }

    @Override
    public void deleteUserDetail(UserDetail userDetail) {
        userDetail.setCode("400");
        userDetailMapper.updateUserDetail(userDetail);
    }

    @Override
    public List<String> getRolesByUser(String username) {
        SysUser sysUser = this.getUserByName(username);
        List<Integer> list = StringUtils.StringToList(sysUser.getRoleIds());
        List<SysRole> sysRoles = sysRoleMapper.getRoleByAll(list);
        List<String> stringList = new ArrayList<>();
        for (SysRole i:sysRoles){
            stringList.add(i.getRole());
        }
        return stringList;
    }

    @Override
    public List<String> getPermissionsByUser(String username) {
        SysUser sysUser = this.getUserByName(username);
        List<Integer> list = StringUtils.StringToList(sysUser.getRoleIds());
        List<SysRole> sysRoles = sysRoleMapper.getRoleByAll(list);
        list.clear();
        for (SysRole sysRole : sysRoles){
            list.addAll(StringUtils.StringToList(sysRole.getResourceIds()));
        }
        List<SysResource> list1 = sysResourceMapper.getSysResourceByAll(list);
        List<String> stringList = new ArrayList<>();
        for (SysResource sysResource:list1){
            stringList.add(sysResource.getPermission());
        }
        return stringList;
    }
}
