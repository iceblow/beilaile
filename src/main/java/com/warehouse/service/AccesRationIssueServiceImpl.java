package com.warehouse.service;

import com.warehouse.constant.StateConstant;
import com.warehouse.dao.AccesRationIssueMapper;
import com.warehouse.entity.AccesOrderRation;
import com.warehouse.entity.AccesRationIssue;
import com.warehouse.util.ClientIpUtil;
import com.warehouse.util.DateUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by chiayich on 2017/1/20.
 */
@Service
public class AccesRationIssueServiceImpl implements AccesRationIssueService {


    @Resource
    private AccesRationIssueMapper accesRationIssueMapper;


    /**
     * 根据条件查询配发辅料的总数
     * @param param  筛查条件
     * @return 总数
     */
    @Override
    public int getAccesOrderIssueBpcnt(Map<String, Object> param) {
        int countNum = accesRationIssueMapper.getAccesOrderIssueBpcnt(param);
        return countNum;
    }

    /**
     * 根据条件查询配发辅料的信息列表
     * @param param 筛查条件 当前页  页面显示数量
     * @return  符合条件的辅料配发信息列表
     */
    @Override
    public List<AccesRationIssue> findAccesOrderIssueCndbp(Map<String, Object> param) {
        int pageNow = Integer.parseInt(param.get("pageNow").toString());
        int pageSize = Integer.parseInt(param.get("pageSize").toString());
        pageNow = (pageNow - 1) * pageSize;
        param.put("pageNow", pageNow);
        param.put("pageSize", pageSize);
        List<AccesRationIssue> list = accesRationIssueMapper.findAccesOrderIssueCndbp(param);
        return list;
    }

    /**
     * 保持辅料配发备注
     * @param ari 要修改的对象
     * @param request  ip
     * @return
     */
    @Override
    public AccesRationIssue savaRemarkIssue(AccesRationIssue ari, HttpServletRequest request) {
        ari.setOperatorIp(ClientIpUtil.getIpAddress(request));
        ari.setModifyTime(DateUtils.formateDaTime(new Date()));
        accesRationIssueMapper.updateByPrimaryKeySelective(ari);
        return ari;
    }

    /**
     * 辅料配发完成 状态修改
     * @param amId 配发完成的辅料id
     * @param request ip
     * @return
     */
    @Override
    public AccesRationIssue issueDone(Integer amId, HttpServletRequest request) {

        String operatorIp = ClientIpUtil.getIpAddress(request);
        AccesRationIssue accesRationIssue = accesRationIssueMapper.selectByPrimaryKey(amId);
        accesRationIssue.setOperatorIp(operatorIp);
        accesRationIssue.setModifyTime(new Date().toString());
        accesRationIssue.setIssueStatus("完成配发");
        accesRationIssueMapper.updateByPrimaryKeySelective(accesRationIssue);

        return accesRationIssue;
    }


    /**
     * 打印配发信息单
     * @param param 要打印的id 数组字符串
     * @param request  获取ip
     * @return  打印的信息对象
     */
    @Override
    public List<AccesRationIssue> printIssueSheet(String param, HttpServletRequest request) {
        List<AccesRationIssue> issueList = new ArrayList<>();
        String[] idList = param.split(",");
        for (String idStr : idList) {
            Integer idParam = Integer.valueOf(idStr);
            issueList.add(accesRationIssueMapper.selectByPrimaryKey(idParam));
        }
//
//        SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");// 设置时间格式
//        File file = new File("C:/accessory");// 文件夹存放路径
//        // 如果文件夹不存在则创建
//        if (!file.exists() && !file.isDirectory()) {
//            file.mkdir();
//        }
//        File files = new File(file + "/accessory");// 文件存放路径
//
//        if (!files.exists() && !files.isDirectory()) {
//            files.mkdir();
//        }
//
//        HSSFWorkbook wb = new HSSFWorkbook();//建立新HSSFWorkbook对象
//        HSSFSheet sheet = wb.createSheet("new sheet");//建立新的sheet对象
//        sheet.setColumnWidth(0,5<<8);
//        sheet.setColumnWidth(1,7<<8);
//        sheet.setColumnWidth(2,13<<8);
//        sheet.setColumnWidth(3,8<<8);
//        sheet.setColumnWidth(4,8<<8);
//        sheet.setColumnWidth(5,20<<8);
//        sheet.setColumnWidth(6,8<<8);
////        sheet.setColumnWidth(7,20<<8);
//        // Create a row and put some cells in it. Rows are 0 based.
//        HSSFRow row = sheet.createRow(0);//建立新行
//        // Create a cell and put a value in it.
//        row.createCell(0).setCellValue(StateConstant._XLS_ID_);//编号
//        row.createCell(1).setCellValue(StateConstant._XLS_WAVE);//波段
//        row.createCell(2).setCellValue(StateConstant._XLS_ISSUE_NAME);//辅料名称
//        row.createCell(3).setCellValue(StateConstant._XLS_ISSUE_SERINUM);//辅料序列号
//        row.createCell(4).setCellValue(StateConstant._XLS_ISSUE_QUALITY);//数量
//        row.createCell(5).setCellValue(StateConstant._XLS_ISSUE_ETALON);//规格
//        row.createCell(6).setCellValue(StateConstant._XLS_ISSUE_QUALITY);//配料数量
////        row.createCell(7).setCellValue(StateConstant._XLS_SYNCH_TIME);//要求配发时间
//
//        for (int i = 1; i < issueList.size(); i++) {
//            HSSFRow rowOfi = sheet.createRow(i);//建立新行
//            rowOfi.setHeightInPoints(25);
//            rowOfi.createCell(0).setCellValue(issueList.get(i-1).getId().toString());//编号
//            rowOfi.createCell(1).setCellValue(issueList.get(i-1).getWave());//波段
//            rowOfi.createCell(2).setCellValue(issueList.get(i-1).getAccesName());//辅料名称
//            rowOfi.createCell(3).setCellValue(issueList.get(i-1).getAccesSerialNum().toString());//辅料序列号
//            Integer Num =  issueList.get(i-1).getAccesQuantity().intValue();
//            rowOfi.createCell(4).setCellValue(Num.toString());//实发数量
//            rowOfi.createCell(5).setCellValue(issueList.get(i-1).getAccesEtalonDescription());//规格
//            rowOfi.createCell(6).setCellValue(issueList.get(i-1).getIssueNum().toString());//配料数量
////            rowOfi.createCell(7).setCellValue(issueList.get(i-1).getOrderDetails());//配料详情
////            rowOfi.createCell(8).setCellValue(issueList.get(i-1).getIssueMethod());//配发方式
////            rowOfi.createCell(7).setCellValue(issueList.get(i-1).getScheTime());//要求配发时间
//        }
//
//        try {
//            FileOutputStream fileOut;
//            fileOut = new FileOutputStream(new File(files + "/" + "issueSheet"+ System.currentTimeMillis()+ ".xls"));
//            wb.write(fileOut);
//            fileOut.close();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        return issueList;
    }


    /**
     * 热敏纸打印 配发辅料信息条码
     * @param param 要打印的 辅料信息id数组字符串
     * @param request 获取ip
     * @return
     */
    @Override
    public List<AccesRationIssue> printHTPaper(String param, HttpServletRequest request) {

        List<AccesRationIssue> issueList = new ArrayList<>();
        String[] idList = param.split(",");
        for (String idStr : idList) {
            Integer idParam = Integer.valueOf(idStr);
            issueList.add(accesRationIssueMapper.selectByPrimaryKey(idParam));
        }
        return issueList;
    }
}
