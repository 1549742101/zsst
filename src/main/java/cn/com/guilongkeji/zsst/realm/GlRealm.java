package cn.com.guilongkeji.zsst.realm;

import cn.com.guilongkeji.zsst.pojo.SysUser;
import cn.com.guilongkeji.zsst.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

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
@Component
@Slf4j
public class GlRealm extends AuthorizingRealm {
    @Resource
    private UserService userService;
    /**
     * 权限信息认证(包括角色以及权限)是用户访问controller的时候才进行验证(redis存储的此处权限信息)
     * 触发检测用户权限时才会调用此方法，例如checkRole,checkPermission
     *
     * @param principalCollection 身份信息
     * @return AuthorizationInfo 权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("===============Shiro权限认证开始============ [ roles、permissions]==========");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        String username = null;
        if (principalCollection!=null){
            SysUser sysUser = (SysUser)principalCollection.getPrimaryPrincipal();
            username = sysUser.getUsername();
        }
        List<String> list = userService.getRolesByUser(username);
        simpleAuthorizationInfo.addRoles(list);
        List<String> list1 = userService.getPermissionsByUser(username);
        simpleAuthorizationInfo.addStringPermissions(list1);
        log.info("===============Shiro权限认证成功==============");
        return simpleAuthorizationInfo;
    }
    /**
     * 功能描述 执行认证
     * @author xgl
     * @date 2020/1/13
      * @param authenticationToken
     * @return org.apache.shiro.authc.AuthenticationInfo
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = authenticationToken.getPrincipal().toString();
        SysUser user = userService.getUserByName(userName);
        if(ObjectUtils.isEmpty(user)){
            throw new UnknownAccountException();
        }
        String passwordInDB = user.getPassword();
        String salt = user.getSalt();
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName, passwordInDB, ByteSource.Util.bytes(salt), getName());
        return authenticationInfo;
    }


}
