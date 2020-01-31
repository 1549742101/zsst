package cn.com.guilongkeji.zsst.service.impl;

import cn.com.guilongkeji.zsst.mapper.ActiveMapper;
import cn.com.guilongkeji.zsst.mapper.AssessMapper;
import cn.com.guilongkeji.zsst.mapper.ImgMapper;
import cn.com.guilongkeji.zsst.mapper.RecordMapper;
import cn.com.guilongkeji.zsst.pojo.*;
import cn.com.guilongkeji.zsst.service.MainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description
 * @Author xgl
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/1/31
 */
@Service
public class MainServiceImpl implements MainService {
    @Resource
    private ImgMapper imgMapper;
    @Resource
    private RecordMapper recordMapper;
    @Resource
    private AssessMapper assessMapper;
    @Resource
    private ActiveMapper activeMapper;

    @Override
    public void addImg(Img img) {

    }

    @Override
    public void updateImg(Img img) {

    }

    @Override
    public void removeImg(Integer id) {

    }

    @Override
    public Img getImgById(Integer id) {
        return null;
    }

    @Override
    public List<Img> getImgByAllId(List<Integer> ids) {
        return null;
    }

    @Override
    public void addRecord(Record record) {

    }

    @Override
    public void addAllRecord(List<Record> records) {

    }

    @Override
    public void updateRecord(Record record) {

    }

    @Override
    public void updateRecords(List<Record> records) {

    }

    @Override
    public void deleteRecords(List<Integer> ids) {

    }

    @Override
    public void deleteRecord(Integer id) {

    }

    @Override
    public List<Record> getRecordByUserId(Integer uid) {
        return null;
    }

    @Override
    public List<Record> getAllRecord() {
        return null;
    }

    @Override
    public void addAssess(Assess assess) {

    }

    @Override
    public void removeAssess(Integer id) {

    }

    @Override
    public void updateAssess(Assess assess) {

    }

    @Override
    public List<Assess> getAllAssess() {
        return null;
    }

    @Override
    public Assess getAssessById(Integer id) {
        return null;
    }

    @Override
    public List<Assess> getAssessByUserId(Integer uid) {
        return null;
    }

    @Override
    public List<Assess> getAssessByOrderId(Integer oid) {
        return null;
    }

    @Override
    public List<Assess> getAssessByStatus() {
        return null;
    }

    @Override
    public void addActive(Active active) {

    }

    @Override
    public void addAllActive(List<Active> actives) {

    }

    @Override
    public void removeActive(Integer id) {

    }

    @Override
    public void removeAllActive(List<Integer> ids) {

    }

    @Override
    public List<Active> getAllActive() {
        return null;
    }

    @Override
    public List<Active> getActiveByShop(Integer shopId) {
        return null;
    }

    @Override
    public List<Active> getActiveByStatus() {
        return null;
    }

    @Override
    public Active getActiveById(Integer id) {
        return null;
    }

    @Override
    public List<Dish> getDishByActive() {
        return null;
    }

    @Override
    public void updateActive(Active active) {

    }

    @Override
    public void updateAllActive(List<Active> active) {

    }
}
