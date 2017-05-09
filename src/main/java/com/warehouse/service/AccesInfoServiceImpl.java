package com.warehouse.service;

import com.warehouse.dao.AccessoryInfoMapper;
import com.warehouse.entity.AccessoryInfo;
import com.warehouse.util.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by chiayich on 2017/1/20.
 *
 */
@Service
public class AccesInfoServiceImpl implements AccesInfoService {

    @Resource
    private AccessoryInfoMapper accessoryInfoMapper;


    /**
     * 获取辅料信息总数
     * @param param 页面显示数量  筛查条件
     * @return 查询到符合筛查条件的总数
     */
    @Override
    public int getAccesInfoBpcnt(Map<String, Object> param) {
        return accessoryInfoMapper.getAccesInfoBpcnt(param);
    }

    /**
     *  查询辅料信息一览
     * @param param 页面显示数 当前页 查询条件
     * @return  返回信息一览
     */
    @Override
    public List<AccessoryInfo> findAccesInfoCndbp(Map<String, Object> param) {
        int pageNow = Integer.parseInt(param.get("pageNow").toString());
        int pageSize = Integer.parseInt(param.get("pageSize").toString());
        pageNow = (pageNow - 1) * pageSize;
        param.put("pageNow", pageNow);
        param.put("pageSize", pageSize);
        return accessoryInfoMapper.findAccesInfoCndbp(param);
    }

    /**
     * 跟据ID 获取指定辅料信息
     * @param id 辅料id
     * @param request 查询者ip
     * @return 辅料信息
     */
    @Override
    public AccessoryInfo getAccesInfoBid(Integer id, HttpServletRequest request) {
        return accessoryInfoMapper.selectByPrimaryKey(id);
    }

    /**
     * 添加辅料信息
     * @param accessoryInfo 要添加的辅料对象
     * @return 影响行数
     */
    @Override
    public int addAccesInfo(AccessoryInfo accessoryInfo) {
        accessoryInfo.setMarkStatus("1");//默认有效
        return accessoryInfoMapper.insert(accessoryInfo);
    }

    /**
     * 修改辅料信息
     * @param accessoryInfo 要修改的辅料对象
     * @return 修改后影响行数
     */
    @Override
    public int modifyAccesInfo(AccessoryInfo accessoryInfo) {
        accessoryInfo.setModifyTime(DateUtils.formateDaTime(new Date()).toString());
        return accessoryInfoMapper.updateByPrimaryKeySelective(accessoryInfo);
    }
}
