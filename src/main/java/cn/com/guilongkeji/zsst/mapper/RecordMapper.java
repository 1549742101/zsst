package cn.com.guilongkeji.zsst.mapper;


import cn.com.guilongkeji.zsst.pojo.Record;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 功能描述 浏览记录
 * @author xgl
 * @date 2020/1/5
 */
@Mapper
public interface RecordMapper{
    /**
     * 功能描述 增加浏览记录
     * @author xgl
     * @date 2020/1/30
      * @param record
     * @return void
     */
    public void addRecord(Record record);
    /**
     * 功能描述 增加浏览记录
     * @author xgl
     * @date 2020/1/30
      * @param records
     * @return void
     */
    public void addAllRecord(List<Record> records);
    /**
     * 功能描述 更新浏览记录
     * @author xgl
     * @date 2020/1/30
      * @param record
     * @return void
     */
    public void updateRecord(Record record);
    /**
     * 功能描述 更新浏览记录
     * @author xgl
     * @date 2020/1/30
      * @param records
     * @return void
     */
    public void updateRecords(List<Record> records);
    /**
     * 功能描述 删除浏览记录
     * @author xgl
     * @date 2020/1/30
      * @param ids
     * @return void
     */
    @Deprecated
    public void deleteRecords(List<Integer> ids);
    /**
     * 功能描述 删除浏览记录
     * @author xgl
     * @date 2020/1/30
      * @param id
     * @return void
     */
    @Deprecated
    public void deleteRecord(Integer id);
    /**
     * 功能描述 根据用户编号获取浏览记录
     * @author xgl
     * @date 2020/1/30
      * @param uid
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.Record>
     */
    public List<Record> getRecordByUserId(Integer uid);
    /**
     * 功能描述 获取所有浏览记录
     * @author xgl
     * @date 2020/1/30
      * @param
     * @return java.util.List<cn.com.guilongkeji.zsst.pojo.Record>
     */
    public List<Record> getAllRecord();
}