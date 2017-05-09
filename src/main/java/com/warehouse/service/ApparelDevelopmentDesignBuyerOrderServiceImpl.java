package com.warehouse.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.warehouse.dao.ApparelDevelopmentDesignBuyerOrderMapper;
import com.warehouse.entity.ApparelDevelopmentDesignBuyerOrder;
import com.warehouse.util.CharacterUtils;
import com.warehouse.util.Page;
@Service
public class ApparelDevelopmentDesignBuyerOrderServiceImpl implements ApparelDevelopmentDesignBuyerOrderService{

	@Autowired
	private ApparelDevelopmentDesignBuyerOrderMapper apparelDevelopmentDesignBuyerOrderMapper;
	

	
	/**
	 * 查询总条数
	 */
    @Override
    public Page<ApparelDevelopmentDesignBuyerOrder> getPageCount(ApparelDevelopmentDesignBuyerOrder order,String pageNow,String pageSize) {
    	int pageNowInt = Integer.parseInt(pageNow.toString());
       //int pageSizeInt = Integer.parseInt(pageSize.toString());
        //总条数
        int pageCount = apparelDevelopmentDesignBuyerOrderMapper.getPageCount(order);
        //page(总条数,当前页),通过这里传过去的总条数，在page类里计算出总页数传到前台
        Page<ApparelDevelopmentDesignBuyerOrder> page2 = new Page<>(pageCount,pageNowInt);
        return page2;
    }
	
	/**
	 * 删除
	 */
	public int deleteById(Integer id) {
		return apparelDevelopmentDesignBuyerOrderMapper.deleteById(id);
	}

	/**
	 * 添加
	 */
	public int addApparelDevelopmentDesignBuyerOrder(MultipartFile file1,ApparelDevelopmentDesignBuyerOrder record,HttpServletRequest request) {
		//文件部位空才添加
		if (!file1.isEmpty()) {
			//得到图片路径,并保存图片
			String imgPath = saveImg(file1,this.getStringImgName(),"buyerOrder",request);
			// 设置图片路径
			record.setDesignImg(imgPath);
		}
		//设置总件数
		record.setTotalPiece(this.totalPiece(record));
		//设置添加时间
		record.setAddTime(this.getStringTime());
		//把波次号的字母全变成大写
		record.setWave(CharacterUtils.getUpperCase(record.getWave()));
		return apparelDevelopmentDesignBuyerOrderMapper.addApparelDevelopmentDesignBuyerOrder(record);
	}

	/**
	 * 查询
	 */
	public List<ApparelDevelopmentDesignBuyerOrder> select(Map<String, Object> map) {
		//转换分页数据格式
		int pageNow = Integer.parseInt(map.get("pageNow").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        pageNow = (pageNow - 1) * pageSize;
        map.put("pageNow", pageNow);
        map.put("pageSize", pageSize);
		return apparelDevelopmentDesignBuyerOrderMapper.select(map);
	}

	/**
	 * 修改
	 */
	public int updateApparelDevelopmentDesignBuyerOrder(MultipartFile file1,ApparelDevelopmentDesignBuyerOrder record, HttpServletRequest request) {
		//生成个随机数
		
		// 文件不为空才可以修改，不然修改别的字段时，没有修改图片，图片修改时没有加载进页面，那么点提交就会把图片设为空
		if (!file1.isEmpty()) {
			//得到图片路径,并保存图片
			String imgPath = saveImg(file1,this.getStringImgName(),"buyerOrder",request);
			// 设置图片路径
			record.setDesignImg(imgPath);
		}
		//设置总件数
		record.setTotalPiece(this.totalPiece(record));
		return apparelDevelopmentDesignBuyerOrderMapper.updateApparelDevelopmentDesignBuyerOrder(record);
	}

	/**
	 * 修改（前段不是提交表单的那种修改，之所以分开写两个修改，是因为有的修改不是提交表单那种，
	 * 如果不分开就报 org.springframework.web.multipart.MultipartException: The current request is not a multipart request] with root cause这个错误）
	 */
	public int updateOrderOntForm(ApparelDevelopmentDesignBuyerOrder record){
		//如果点击的是 确定采购,在这里生成采购时间
		if("y".equals(record.getBuyStatus())){
	    	record.setBuyTime(this.getStringTime());
		}
		//如果订单取消，生成订单取消时间
		else if("c".equals(record.getBuyStatus())){
			record.setCancelTime(this.getStringTime());
		}
		return apparelDevelopmentDesignBuyerOrderMapper.updateApparelDevelopmentDesignBuyerOrder(record);
	}
	
	/**
	 *根据id查询
	 */
	public ApparelDevelopmentDesignBuyerOrder selectById(Integer id){
		return apparelDevelopmentDesignBuyerOrderMapper.selectById(id);
	}
	
	//====================================下面是工具类=================================================
	
	/**
	 * 放回一个String类型的时间格式(当前时间)
	 * @return
	 */
	public String getStringTime(){
		//生成当前时间
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    	Date date = new Date(System.currentTimeMillis());
    	return sdf.format(date);
	}
	/**
	 * 放回一个String类型的时间格式(当前时间)
	 * @return
	 */
	public String getStringImgName(){
		//生成当前时间
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
    	Date date = new Date(System.currentTimeMillis());
    	return sdf.format(date);
	}
	
	/**
	 * 保存图片到指定路径 并返回存到数据库的路径
	 * params(图片文件,文件夹名称,图片名称,HttpServletRequest获取根目录用的)
	 * return 图片路径(存到数据库里的)
	 */
	public String saveImg(MultipartFile file,String imgName,String folderName, HttpServletRequest request){
			// 图片名字(存到文件下的图片的名称)
			String fileName = "";
			try {
				// 获取根路径
				String contextRoot = request.getSession().getServletContext().getRealPath("/");
				String path = contextRoot +folderName+ "\\";
				//如果这个文件夹不存在，创建一个
				isHaveFolder(path);
				// 取新的名字，并保留原来的后缀
				fileName = this.getNewName(imgName,file.getOriginalFilename());
				// 转存文件
				FileUtils.writeByteArrayToFile(new File(path, fileName),
						file.getBytes());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			// 设置图片路径
			imgName ="/"+folderName+"/" + fileName;
		return imgName;
	}
	/**
	 * 
	 * 修改图片名字
	 * 
	 * @param name
	 * @return
	 */
	public String getNewName(String goodsId, String name) {
		String str = goodsId + name.substring(name.lastIndexOf("."));
		return str;
	}
	/**
	 * 判断是否存在该文件
	 *
	 * @param fileName
	 */
	public static void isHaveFolder(String fileName) {
		File file = new File(fileName);
		// 如果文件夹不存在则创建
		if (!file.exists() && !file.isDirectory()) {// 不存在
			file.mkdir(); // 创建
		}
	}
	/**
	 * 计算总件数
	 */
	public int totalPiece(ApparelDevelopmentDesignBuyerOrder record){
		int total = (record.getCode52() == null ? 0 : record.getCode52())
				+ (record.getCode59() == null ? 0 : record.getCode59()) + (record.getCode66() == null ? 0 : record.getCode66())
				+ (record.getCode73() == null ? 0 : record.getCode73()) + (record.getCode80() == null ? 0 : record.getCode80())
				+ (record.getCode90() == null ? 0 : record.getCode90())
				+ (record.getCode100() == null ? 0 : record.getCode100())
				+ (record.getCode110() == null ? 0 : record.getCode110())
				+ (record.getCode120() == null ? 0 : record.getCode120())
				+ (record.getCode130() == null ? 0 : record.getCode130())
				+ (record.getCode160() == null ? 0 : record.getCode160())
				+ (record.getCode170() == null ? 0 : record.getCode170());
		return total;
	}


}
