package com.warehouse.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 2016年12月13日14:38:42
 * 
 * @author Beilaile
 *
 */
public class PropertiesUtil {
	private Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);
	private ConcurrentHashMap<String, Properties> proMap;

	private PropertiesUtil() {
		proMap = new ConcurrentHashMap<String, Properties>();
	}

	private static PropertiesUtil instance = new PropertiesUtil();

	/**
	 * 获取单例对象
	 * 
	 * @return
	 */
	public static PropertiesUtil getInstance() {
		return instance;
	}

	/**
	 * 根据key从gzt.properties配置文件获取配置信息
	 * 
	 * @param key
	 *            键值
	 * @return
	 */
	public String getSysPro(String key) {
		return getSysPro(key, null);
	}

	/**
	 * 根据key从gzt.properties配置文件获取配置信息
	 * 
	 * @param key
	 *            键值
	 * @param defaultValue
	 *            默认值
	 * @return
	 */
	public String getSysPro(String key, String defaultValue) {
		return getValue("spring/imageserver-" + System.getProperty("spring.profiles.active") + ".properties", key,
				defaultValue);
	}

	/**
	 * 从配置文件中获取对应key值
	 * 
	 * @param fileName
	 *            配置文件名
	 * @param key
	 *            key值
	 * @param defaultValue
	 *            默认值
	 * @return
	 */
	public String getValue(String fileName, String key, String defaultValue) {
		String val = null;
		Properties properties = proMap.get(fileName);
		if (properties == null) {
			InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName);
			try {
				properties = new Properties();
				properties.load(new InputStreamReader(inputStream, "UTF-8"));
				proMap.put(fileName, properties);
				val = properties.getProperty(key, defaultValue);
			} catch (IOException e) {
				logger.error("getValue", e);
			} finally {
				try {
					if (inputStream != null) {
						inputStream.close();
					}
				} catch (IOException e1) {
					logger.error(e1.toString());
				}
			}
		} else {
			val = properties.getProperty(key, defaultValue);
		}
		return val;
	}
}
