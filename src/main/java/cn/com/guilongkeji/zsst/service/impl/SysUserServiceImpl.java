package cn.com.guilongkeji.zsst.service.impl;

import cn.com.guilongkeji.zsst.dto.UserDto;
import cn.com.guilongkeji.zsst.mapper.SysResourceMapper;
import cn.com.guilongkeji.zsst.mapper.SysRoleMapper;
import cn.com.guilongkeji.zsst.mapper.SysUserMapper;
import cn.com.guilongkeji.zsst.mapper.UserDetailMapper;
import cn.com.guilongkeji.zsst.pojo.SysResource;
import cn.com.guilongkeji.zsst.pojo.SysRole;
import cn.com.guilongkeji.zsst.pojo.SysUser;
import cn.com.guilongkeji.zsst.pojo.UserDetail;
import cn.com.guilongkeji.zsst.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/4
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;
    @Resource
    private UserDetailMapper userDetailMapper;
    @Resource
    private SysResourceMapper sysResourceMapper;
    @Resource
    private SysRoleMapper sysRoleMapper;
    @Override
    public SysUser isLogin(String username, String password) {
        return null;
    }

    @Override
    public boolean updateSysUser(SysUser sysUser) {
        return false;
    }

    @Override
    public List<UserDetail> getAllUserDetail() {
        return userDetailMapper.getAllUserDetail();
    }

    @Override
    public List<SysUser> getAllSysUser() {
        return sysUserMapper.getAllUser();
    }

    @Override
    public List<SysUser> getAllSysUserByIds(List<Integer> ids) {
        return sysUserMapper.getAllUserByIds(ids);
    }

    @Override
    public List<SysUser> getAllSysUserByExcludeIds(List<Integer> ids) {
        return sysUserMapper.getAllUserExcludeIds(ids);
    }

    @Override
    public List<Integer> getUserByDetail() {
        return userDetailMapper.getUserId();
    }

    @Override
    public List<SysUser> getUserByRolesOne() {
        return sysUserMapper.getUserByRolesOne();
    }

    @Override
    public List<SysRole> getAllRole() {
        return sysRoleMapper.getAllRole();
    }

    @Override
    public List<SysResource> getResourceOne() {
        return null;
    }

    @Override
    public List<SysResource> getResourceTwo() {
        return null;
    }

    @Override
    public List<UserDto> getAllUser() {
        List<UserDetail> userDetailList = userDetailMapper.getAllUserDetail();
        List<SysUser> sysUserList = sysUserMapper.getAllUserByIds(userDetailMapper.getUserId());
        List<UserDto> userDtoList = new ArrayList<>();
        for (int i = 0; i <userDetailList.size() ; i++) {
            UserDto userDto = new UserDto();
            userDto.setSysUser(sysUserList.get(i));
            userDto.setUserDetail(userDetailList.get(i));
            userDtoList.add(userDto);
        }
        return userDtoList;
    }
}
