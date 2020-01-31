package cn.com.guilongkeji.zsst.service.impl;

import cn.com.guilongkeji.zsst.mapper.CodeMapper;
import cn.com.guilongkeji.zsst.mapper.SysUserMapper;
import cn.com.guilongkeji.zsst.mapper.UserDetailMapper;
import cn.com.guilongkeji.zsst.pojo.Code;
import cn.com.guilongkeji.zsst.pojo.SysRole;
import cn.com.guilongkeji.zsst.pojo.SysUser;
import cn.com.guilongkeji.zsst.pojo.UserDetail;
import cn.com.guilongkeji.zsst.service.UserService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
}
