package com.warehouse.controller;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.swing.plaf.synth.SynthStyle;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.warehouse.entity.AccessoryInfo;
import com.warehouse.service.AccesInfoService;
import com.warehouse.util.Page;

/**
 * Created by chiayich on 2017/1/20.
 *
 */
@Controller
public class AccesInfoController {

    private Logger logger = LoggerFactory.getLogger(AccesInfoController.class);

    @Resource
    private AccesInfoService accesInfoService;

    /**
     * 带条件查询总条数
     *ByPageCount  Bpcnt  查询辅料信息总数
     */
    @RequestMapping(value = "getAccesInfoBpcnt.do", method = RequestMethod.POST)
    @ResponseBody
    public Page<AccessoryInfo> getAccesInfoBpcnt(@RequestParam Map<String, Object> param) {
        int result = accesInfoService.getAccesInfoBpcnt(param);
        Page<AccessoryInfo> page = new Page<>(result, 1);
        logger.debug("根据分页条件查询  库存辅料总数");
        return page;
        
    }

    /**
     * 带条件分页查询
     *ConditiontByPage Cndbp  查询辅料信息列表
     */
    @RequestMapping(value = "findAccesInfoCndbp.do", method = RequestMethod.POST)
    @ResponseBody
    public List<AccessoryInfo> findAccesInfoCndbp(@RequestParam Map<String, Object> param) {

        List<AccessoryInfo> list = accesInfoService.findAccesInfoCndbp(param);
        logger.debug("根据分页条件查询 辅料理单");
        return list;
    }

    /**
     * 根据 aInfoid  获取 辅料信息
     * @param request 获取Ip
     * @return 辅料信息
     */
    @RequestMapping(value = "getAccesInfoBid.do", method = RequestMethod.POST)
    @ResponseBody
    public AccessoryInfo getAccesInfoBid(Integer id, HttpServletRequest request) {
        AccessoryInfo result = accesInfoService.getAccesInfoBid(id, request);
        return result;
    }


    /**
     * 修改辅料信息
     * @param file  文件名
     * @param accessoryInfo 修改的辅料信息
     * @param request  获取请求信息
     * @return 修改辅料信息结果
     * @throws IOException
     */
    @RequestMapping("modifyAccesInfo")
    @ResponseBody
    public int modifyAccesInfo(@RequestParam MultipartFile file,AccessoryInfo accessoryInfo,
                                HttpServletRequest request) throws IOException {

        String fileName = "";// 声明一个字段来接收新名字
        String rootPath = request.getSession().getServletContext().getRealPath("/");// 图片根路径
        String path = rootPath + "designImg\\";// 图片上传路径
        // 设计图
        if (!file.isEmpty()) {
            fileName = this.fileReName(file.getOriginalFilename()); // 文件重命名
            FileUtils.writeByteArrayToFile(new File(path, fileName), file.getBytes());// 文件流上传
            accessoryInfo.setAccesImgAi("designImg\\" + fileName);// 文件名
        }
        int result = accesInfoService.modifyAccesInfo(accessoryInfo);
        return result;// 返回添加成功页面
    }

    /**
     * 添加辅料
     * @param file 文件名
     * @param accessoryInfo 辅料信息对象
     * @param request 请求信息
     * @return 添加结果
     * @throws IOException
     */
    @RequestMapping("ajaxAddAccesInfo")
    @ResponseBody
    public int ajaxAddAccesInfo(@RequestParam MultipartFile file,AccessoryInfo accessoryInfo,
                                HttpServletRequest request) throws IOException {
        int result = 0;
        String fileName = "";// 声明一个字段来接收新名字
        String rootPath = request.getSession().getServletContext().getRealPath("/");// 图片根路径
        String path = rootPath + "designImg\\";// 图片上传路径
        // 设计图
        if (!file.isEmpty()) {
            fileName = this.fileReName(file.getOriginalFilename()); // 文件重命名
            FileUtils.writeByteArrayToFile(new File(path, fileName), file.getBytes());// 文件流上传
            accessoryInfo.setAccesImgAi("designImg\\" + fileName);// 文件名
        }
        result = accesInfoService.addAccesInfo(accessoryInfo);
        return result;// 返回添加成功页面
    }

    /**
     * 生成新名字
     * @param Filename 文件名
     * @return 新的图片名称
     */
    private String fileReName(String Filename) {
        Random rd = new Random();// 随机数生成
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        String suffix = Filename.substring(Filename.lastIndexOf("."));// 获取后缀名
        return sdf.format(new Date()) + rd.nextInt(10000) + suffix;// 新图片名
    }
}