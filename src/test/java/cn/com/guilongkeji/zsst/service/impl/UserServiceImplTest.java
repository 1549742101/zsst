package cn.com.guilongkeji.zsst.service.impl;

import cn.com.guilongkeji.zsst.PocketCafeteriaApplication;
import cn.com.guilongkeji.zsst.pojo.Code;
import cn.com.guilongkeji.zsst.pojo.SysUser;
import cn.com.guilongkeji.zsst.service.UserService;
import cn.com.guilongkeji.zsst.utils.TencentSms;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PocketCafeteriaApplication.class)
public class UserServiceImplTest {
    @Resource
    private UserService userService;
    @Test
    public void isExist() {
    }

    @Test
    public void getByUsernameAndPassword() {
    }

    @Test
    public void registerSysUser() {
        SysUser sysUser = new SysUser();
        sysUser.setUsername("username");
        sysUser.setPassword("password");
        sysUser.setBLocked(true);
        sysUser.setPhone("12345678910");
        sysUser.setRoleIds("1,2,3");
        sysUser.setSalt("55555");
        userService.registerSysUser(sysUser);
    }

    @Test
    public void updateSysUser() {
    }

    @Test
    public void getAllSysUser() {
    }

    @Test
    public void registerAllSysUser() {
    }

    @Test
    public void getSysOrganization() {
    }

    @Test
    public void insertCode() {
        Code code = new Code();
        code.setPhone("13272950110");
        code.setCode(TencentSms.random());
        userService.insertCode(code);
    }

    @Test
    public void getCodeByPhone() {
    }
}