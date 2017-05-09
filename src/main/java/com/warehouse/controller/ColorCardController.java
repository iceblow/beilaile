package com.warehouse.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.warehouse.entity.ColorCard;
import com.warehouse.entity.FabricSupplier;
import com.warehouse.entity.OutsideDaily;
import com.warehouse.service.ColorCardService;
import com.warehouse.service.FabricSupplierService;
import com.warehouse.service.OutsideDailyService;
import com.warehouse.util.DateUtils;
import com.warehouse.util.Page;

@Controller
public class ColorCardController {
	@Resource
	private ColorCardService colorCardService;
	@Resource
	private FabricSupplierService fabricSupplierService;
	@Resource
	private OutsideDailyService outsideDailyService;

	/**
	 * 添加供应商
	 * 
	 * @param colorCard
	 * @return
	 */

	@RequestMapping("addColorCard.do")
	@ResponseBody
	public int addColorCard(ColorCard colorCard) {
		Integer Code = colorCardService.findColorCardByColorCardCode(colorCard);
		if (Code > 0) {
			return 18;
		} else {
			FabricSupplier supplier = fabricSupplierService
					.findFabricSupplierBySupplierCode(colorCard.getSupplierCode());
			colorCard.setAddColorCard(DateUtils.formateYearAndMonthAndSecond(new Date()));
			colorCard.setCreateTime(DateUtils.formateDaTime(new Date()));
			colorCard.setColorCardStatus(1);
			colorCard.setSupplierName(supplier.getSupplierName());
			double parameter = 1000;// 常量
			double conversion = 100;// 单位换算
			double fabricLength = colorCard.getFabricLength();// 门幅
			double gramWeight = colorCard.getGramWeight();// 克重
			// 1厘米(cm)=0.01米(m)
			if ("".equals(fabricLength)) {
				fabricLength = 0;
			}
			if ("".equals(gramWeight)) {
				gramWeight = 0;
			}
			// 计算 如课中220克，门幅185厘米 ， 公司 米 = 1000/（220*1.85）=2.43米
			double kilogramMeter = parameter / (fabricLength * (gramWeight / conversion));
			colorCard.setKilogramMeter(kilogramMeter);
			int reslut = colorCardService.addColorCard(colorCard);
			return reslut;

		}

	}

	@RequestMapping("findColorCardByAll.do")
	@ResponseBody
	public List<ColorCard> findColorCardByAll() {
		List<ColorCard> list = colorCardService.findColorCardByAll();
		return list;
	}

	/**
	 * 修改对象
	 *
	 * @param ColorCard
	 * @return
	 */
	@RequestMapping(value = "modifyColorCard.do", method = RequestMethod.POST)
	@ResponseBody
	public int updateColorCard(ColorCard ColorCard, HttpServletRequest request) {
		int result = colorCardService.modifyColorCard(ColorCard, request);
		return result;
	}

	/**
	 * 根据条件获取增总条数
	 *
	 * @param anyValue
	 * @return
	 */
	@RequestMapping(value = "getColorCardByPageCount.do", method = RequestMethod.POST)
	@ResponseBody
	public Page<ColorCard> getColorCardByPageCount(@RequestParam Map<String, Object> anyValue) {
		int result = colorCardService.getColorCardByPageCount(anyValue);
		Page<ColorCard> page = new Page<ColorCard>(result, 1);
		return page;
	}

	/**
	 * 根据条件获取分页查询
	 *
	 * @param anyValue
	 * @return
	 */
	@RequestMapping(value = "findConditionColorCardByPage.do", method = RequestMethod.POST)
	@ResponseBody
	public List<ColorCard> findConditionColorCardByPage(@RequestParam Map<String, Object> anyValue) {
		int pageNow = Integer.parseInt(anyValue.get("pageNow").toString());
		int pageSize = Integer.parseInt(anyValue.get("pageSize").toString());
		pageNow = (pageNow - 1) * pageSize;
		anyValue.put("pageNow", pageNow);
		anyValue.put("pageSize", pageSize);
		List<ColorCard> list = colorCardService.findConditionColorCardByPage(anyValue);
		return list;
	}

	/**
	 * 根据id获取对象
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "findColorCardById.do", method = RequestMethod.POST)
	@ResponseBody
	public ColorCard findColorCardById(Integer id) {
		ColorCard ColorCard = colorCardService.findColorCardById(id);
		return ColorCard;
	}

	/**
	 * 根据supplierCode获取对象
	 *
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "findColorCardBySupplierCode.do", method = RequestMethod.POST)
	@ResponseBody
	public List<ColorCard> findColorCardBySupplierCode(String supplierCode) {
		List<ColorCard> list = colorCardService.findColorCardBySupplierCode(supplierCode);
		return list;
	}

}
