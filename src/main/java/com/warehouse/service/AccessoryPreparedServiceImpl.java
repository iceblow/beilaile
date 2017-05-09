package com.warehouse.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.warehouse.dao.AccessoryPreparedMapper;
import com.warehouse.entity.AccessoryPrepared;
import com.warehouse.util.CharacterUtils;

/**
 * Created by chiayich on 2016/12/30.
 */
@Service
public class AccessoryPreparedServiceImpl implements AccessoryPreparedService {

	@Resource
	public AccessoryPreparedMapper accessoryPreparedMapper;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINESE);// 时间格式化
	SimpleDateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINESE);// 日期格式化


	@Override
	public int addAccessoryPrepared(AccessoryPrepared accessoryPrepared) {
		String addTime = formatter.format(new Date());// 操作时间
		String addDate = formatterDate.format(new Date());// 操作日期
		accessoryPrepared.setDate(addDate);
		accessoryPrepared.setAddTime(addTime);
		accessoryPrepared.setWave(CharacterUtils.getUpperCase(accessoryPrepared.getWave()));// 转换大小写
		accessoryPrepared.setState("1");// 状态
		int reslut = accessoryPreparedMapper.addAccessoryPrepared(accessoryPrepared);
		return reslut;
	}

	@Override
	public int delAccessoryPrepared(Integer id) {
		String delTime = formatter.format(new Date());
		int reslut = accessoryPreparedMapper.delAccessoryPreparedById(id, delTime);
		return reslut;
	}

	@Override
	public int modifyAccessoryPrepared(AccessoryPrepared accessoryPrepared) {
		String updateTime = formatter.format(new Date());
		accessoryPrepared.setUpdateTime(updateTime);
		int reslut = accessoryPreparedMapper.modifyAccessoryPrepared(accessoryPrepared);
		return reslut;
	}

	@Override
	public List<AccessoryPrepared> findConditionAccessoryPreparedByPage(Map<String, Object> anyVal) {
		int pageNow = Integer.parseInt(anyVal.get("pageNow").toString());
		int pageSize = Integer.parseInt(anyVal.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		anyVal.put("pageNow", pageNow);
		anyVal.put("pageSize", pageSize);
		List<AccessoryPrepared> list = accessoryPreparedMapper.findConditionAccessoryPreparedByPage(anyVal);
		return list;
	}

	@Override
	public AccessoryPrepared getAccessoryPreparedById(Integer id) {
		AccessoryPrepared accessoryPrepared = accessoryPreparedMapper.getAccessoryPreparedById(id);
		return accessoryPrepared;
	}

	@Override
	public int getAccessoryPreparedByPageCount(Map<String, Object> anyval) {
		int reslut = accessoryPreparedMapper.getAccessoryPreparedByPageCount(anyval);
		return reslut;
	}

}
