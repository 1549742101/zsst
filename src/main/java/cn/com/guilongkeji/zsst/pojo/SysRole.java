package cn.com.guilongkeji.zsst.pojo;

import javax.persistence.*;
/**
 * 功能描述
 * @author xgl
 * @date 2020/1/5
 */

@Table(name = "sys_role")
public class SysRole {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 角色名称
     */
    private String role;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 	
授权的资源
     */
    @Column(name = "resource_ids")
    private String resourceIds;

    /**
     * 是否可用
     */
    private Byte available;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取角色名称
     *
     * @return role - 角色名称
     */
    public String getRole() {
        return role;
    }

    /**
     * 设置角色名称
     *
     * @param role 角色名称
     */
    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    /**
     * 获取角色描述
     *
     * @return description - 角色描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置角色描述
     *
     * @param description 角色描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取	
授权的资源
     *
     * @return resource_ids - 	
授权的资源
     */
    public String getResourceIds() {
        return resourceIds;
    }

    /**
     * 设置	
授权的资源
     *
     * @param resourceIds 	
授权的资源
     */
    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds == null ? null : resourceIds.trim();
    }

    /**
     * 获取是否可用
     *
     * @return available - 是否可用
     */
    public Byte getAvailable() {
        return available;
    }

    /**
     * 设置是否可用
     *
     * @param available 是否可用
     */
    public void setAvailable(Byte available) {
        this.available = available;
    }
    public void setBAvailable(boolean status){
        Byte zero = 0;
        Byte one = 1;
        this.available=status?one:zero;
    }
    public boolean getBAvailable(){
        return this.available>0?true:false;
    }
}