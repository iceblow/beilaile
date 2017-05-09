package com.warehouse.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.FabricDemo;
import com.warehouse.service.FabricService;
import com.warehouse.util.PageUtil;
import com.warehouse.util.Pagess;

/**
 * 用料日报表
 * 
 * @author admin
 *
 */
@Controller
@RequestMapping("fabric")
public class FabricController {

	@Autowired
	private FabricService fabricService;
	
	private final Logger logger=LoggerFactory.getLogger(FabricController.class);

	/**
	 * 添加方法
	 * 
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public String add(String b_ids, String fabrics, String consumptions, String companys,String dates) {

		List<FabricDemo> fas = new ArrayList<FabricDemo>();// 创建一个list接受从前台传过来的那些对象

		// 需要添加的对象的属性的集合
		String[] b_id = b_ids.split("/");// b_id的集合
		String[] fabric = fabrics.split("/");// fabric的集合
		String[] consumption = consumptions.split("/");// consumption的集合
		String[] company = companys.split("/");// company的集合
		String[] date=dates.split("!");
		// 将得到的属性组成对象并添加到list中
		for (int i = 0; i < b_id.length; i++) {
			
			FabricDemo fa = new FabricDemo();
			fa.setB_id(b_id[i]);
			fa.setFabric(fabric[i]);
			fa.setConsumption(consumption[i]);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
			fa.setCompany(company[i]);
			fa.setDate(date[i]);
			Date mydate=new Date();
			DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String mytime=format.format(mydate);
			
			fa.setMytime(mytime);
			
			fas.add(fa);
		}
		// 根据得到的对象集合进行循环，将集合中所有的对象添加到数据库中
		for (int i = 0; i < fas.size(); i++) {
			// 添加对象
			this.fabricService.add(fas.get(i));
			
			this.fabricService.updateDateByBid(fas.get(i));//根据波次号修改日期
		}

		logger.info("添加裁床用料信息");
		
		return "添加成功";
	}

	/**
	 * 修改方法
	 * 
	 * @return
	 */
	@RequestMapping("update")
	public void update(FabricDemo fabricz) {
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String mytime=format.format(date);
		
		fabricz.setMytime(mytime);
		
		this.fabricService.update(fabricz);
		
		this.fabricService.updateDateByBid(fabricz);//根据波次号修改日期
		
		logger.info("修改裁床用料信息");

	}

	/**
	 * 查询(拼接出的页面显示结果)
	 * 
	 * @param page
	 * @return
	 */
	@RequestMapping("getByPage")
	@ResponseBody
	public Map<String, Object> getByPage(PageUtil page) {

		Map<String, Object> map = new HashMap<>();

		page.setPageSize(18);// 写入每页显示的数据量
		page.setTotolCount(this.fabricService.getAllCountByBidAndFabric());// 写入不重复的b_id和fabric的数据量，此处需要查询

		// 在后台取得不重复的b_id和fabric
		List<FabricDemo> fabricDemos = this.fabricService
				.getBidAndFabric(new Pagess(page.getReqult()[0], page.getReqult()[1]));

		for (int i = 0; i < fabricDemos.size(); i++) {

			String b_id = fabricDemos.get(i).getB_id();

			String fabric = fabricDemos.get(i).getFabric();
			// 得到波次号和面料名称不同的
			List<FabricDemo> consumptionAndCompany = this.fabricService.getConsumptionByBidAndFabric(b_id, fabric);
			String consumption = "";
			String company = "";
			String id = "";
			String mytime="";
			
			// 将用量和单位拼接成自趺床以后传送至前台
			for (int j = 0; j < consumptionAndCompany.size(); j++) {
				if (j < consumptionAndCompany.size() - 1) {
					consumption = consumption + consumptionAndCompany.get(j).getConsumption() + "/";
					company = company + consumptionAndCompany.get(j).getCompany() + "/";
					id = id + consumptionAndCompany.get(j).getId() + "/";
					mytime=consumptionAndCompany.get(j).getMytime();
				} else {
					consumption = consumption + consumptionAndCompany.get(j).getConsumption();
					company = company + consumptionAndCompany.get(j).getCompany();
					id = id + consumptionAndCompany.get(j).getId();
					mytime=consumptionAndCompany.get(j).getMytime();
				}
			}

			
			
			// 将拼接得到的company和consumption字符串放入到fabricDemos中然后传送至前台进行下一步处理
			fabricDemos.get(i).setConsumption(consumption);
			fabricDemos.get(i).setCompany(company);
			fabricDemos.get(i).setId(id);
			fabricDemos.get(i).setMytime(mytime);
			
			if(fabricDemos.get(i).getDate()==null){
				fabricDemos.get(i).setDate("");
			}
			
		}
		map.put("dataList", fabricDemos);
		map.put("pageUtil", page);
		
		return map;
	}

	/**
	 * 将数据的状态修改为1 并给一个删除时间
	 * 
	 * @param id
	 */
	@RequestMapping("delete")
	public void delete(Integer id) {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String delTime = format.format(date);

		FabricDemo fabric = new FabricDemo();

		fabric.setId(id.toString());
		fabric.setDelTime(delTime);
		
		// (假)删除用料日报表信息
		this.fabricService.delete(fabric);
		
		logger.info("删除裁床用料信息:-"+fabric.toString());
	}
	
	/**
	 * 根据波次号进行查询
	 * @param page
	 * @return
	 */
	@RequestMapping("getAllByBid")
	@ResponseBody
	public Map<String, Object> getAllByBid(PageUtil page,String bid) {

		Map<String, Object> map = new HashMap<String, Object>();

		page.setPageSize(15);// 写入每页显示的数据量
		page.setTotolCount(this.fabricService.getCountByBid(bid));// 写入数据量，此处需要查询
		
		// 在后台取得不重复的b_id和fabric
		List<FabricDemo> fabricDemos = this.fabricService
				.getAllByBid(new Pagess(page.getReqult()[0], page.getReqult()[1],bid));

				for (int i = 0; i < fabricDemos.size(); i++) {

					String b_id = fabricDemos.get(i).getB_id();

					String fabric = fabricDemos.get(i).getFabric();
					// 得到波次号和面料名称不同的
					List<FabricDemo> consumptionAndCompany = this.fabricService.getConsumptionByBidAndFabric(b_id, fabric);
					String consumption = "";
					String company = "";
					String id = "";
					String mytime="";
					// 将用量和单位拼接成自趺床以后传送至前台
					for (int j = 0; j < consumptionAndCompany.size(); j++) {
						if (j < consumptionAndCompany.size() - 1) {
							consumption = consumption + consumptionAndCompany.get(j).getConsumption() + "/";
							company = company + consumptionAndCompany.get(j).getCompany() + "/";
							id = id + consumptionAndCompany.get(j).getId() + "/";
							mytime=consumptionAndCompany.get(j).getMytime();
						} else {
							consumption = consumption + consumptionAndCompany.get(j).getConsumption();
							company = company + consumptionAndCompany.get(j).getCompany();
							id = id + consumptionAndCompany.get(j).getId();
							mytime=consumptionAndCompany.get(j).getMytime();
						}
					}

					// 将拼接得到的company和consumption字符串放入到fabricDemos中然后传送至前台进行下一步处理
					fabricDemos.get(i).setConsumption(consumption);
					fabricDemos.get(i).setCompany(company);
					fabricDemos.get(i).setId(id);
					fabricDemos.get(i).setMytime(mytime);
				}

		map.put("dataList", fabricDemos);
		map.put("pageUtil", page);
		
		return map;
	}
	
	@RequestMapping("getOne")
	@ResponseBody
	public FabricDemo getOne(int id){
		
		FabricDemo fabricDemo=this.fabricService.getOne(id);
		
		return fabricDemo;
	}
}
