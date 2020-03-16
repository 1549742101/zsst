package cn.com.guilongkeji.zsst.pojo;

import javax.persistence.*;

@Table(name = "sys_resource")
public class Resource {
    /**
     * 编号 主键
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     *
     资源名称
     */
    private String name;

    /**
     * 资源类型
     */
    private String type;

    /**
     * 显示顺序
     */
    private Integer priority;

    /**
     * 父编号
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     *
     父编号列表
     */
    @Column(name = "icon")
    private String icon;

    /**
     *
     权限字符串
     */
    private String permission;

    /**
     * 是否可用
     */
    @Column(name = "available")
    private Byte available;

    @Column(name = "url")
    private String url;
    /**
     * 获取编号 主键
     *
     * @return id - 编号 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置编号 主键
     *
     * @param id 编号 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取	
     资源名称
     *
     * @return
    name -
    资源名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置	
     资源名称
     *
     * @param
    name
    资源名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取资源类型
     *
     * @return type - 资源类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置资源类型
     *
     * @param type 资源类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取显示顺序
     *
     * @return priority - 显示顺序
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * 设置显示顺序
     *
     * @param priority 显示顺序
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     * 获取父编号
     *
     * @return parent_id - 父编号
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父编号
     *
     * @param parentId 父编号
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取	
     父编号列表
     *
     * @return parent_ids - 	
    父编号列表
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置	
     父编号列表
     *
     * @param icon
    父编号列表
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取	
     权限字符串
     *
     * @return permission - 	
    权限字符串
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 设置	
     权限字符串
     *
     * @param permission
    权限字符串
     */
    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    /**
     * 获取是否可用
     *
     * @return  available - 是否可用
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}