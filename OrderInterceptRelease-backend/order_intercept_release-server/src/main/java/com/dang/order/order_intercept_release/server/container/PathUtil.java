package com.dang.order.order_intercept_release.server.container;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 路径工具，提供App项目、Web项目获取一些路径方法。
 * @author jiangshujian
 * @version 1.0,2013.06.01
 */
public class PathUtil {

	private static final String FOLDER_CONF = "conf";
	private static final String FOLDER_LIB = "lib";
	private static final String FOLDER_BIN = "bin";
	private static final Log log = LogFactory.getLog(PathUtil.class);

	/**
	 * 获取App运行所在路径<br>
	 * 注意：如果上级目录为bin或者lib，获取的是上级目录
	 * @return
	 */
	public static String getAppPath() {
		String path = getPropAppPath();
		if (path.endsWith("\\" + FOLDER_LIB)) {
			path = path.substring(0, path.length() - 4);
		}
		if (path.endsWith("/" + FOLDER_LIB)) {
			path = path.substring(0, path.length() - 4);
		}
		if (path.endsWith(":" + FOLDER_LIB)) {
			path = path.substring(0, path.length() - 4);
		}
		if (path.endsWith("\\" + FOLDER_BIN)) {
			path = path.substring(0, path.length() - 4);
		}
		if (path.endsWith("/" + FOLDER_BIN)) {
			path = path.substring(0, path.length() - 4);
		}
		if (path.endsWith(":" + FOLDER_BIN)) {
			path = path.substring(0, path.length() - 4);
		}
		return path;
	}

	/**
	 * 获取App运行所在路径。<br>
	 * 相对于getAppPath()，该方法获得是原生的路径，没有任何后期处理。
	 * @return
	 */
	public static String getPropAppPath() {
		String path = "";
		try {
			File directory = new File("");// 参数为空
			path = directory.getCanonicalPath();
		} catch (IOException e) {
			log.error(e);
		}
		return path;
	}

	/**
	 * 获取应用conf路径。
	 * @return
	 */
	public static String getAppConfPath() {
		return getAppPath().concat(getSeparator()).concat(FOLDER_CONF);
	}

	/**
	 * 获取路径分隔符（兼容windows和linux）。
	 * @return
	 */
	public static String getSeparator() {
		String se = System.getProperty("file.separator");
		return StringUtils.isEmpty(se) ? "\\" : se;
	}

	/**
	 * 获取web项目class物理路径<br>
	 * Thread.currentThread() .getContextClassLoader().getResource("").getPath()
	 */
	public static String getWebClassPath() {
		return Thread.currentThread().getContextClassLoader().getResource("")
				.getPath();
	}

	/**
	 * linux path 处理。<br>
	 * 将路径中的"\"统一换成"/"。
	 * 
	 * @param path
	 * @return
	 */
	public static String getPath(String path) {
		String pathTemp = path;
		String osName = System.getProperty("os.name");
		if (!osName.toUpperCase().startsWith("WIN")) {
			pathTemp = pathTemp.replaceAll("\\\\", "/");
			pathTemp = pathTemp.replaceAll("\\/", "//");
		}
		return pathTemp;
	}

	public static void main(String[] args) {
		System.out.println(System.getProperty("os.name"));
		System.out.println(getPath("D:/a/b"));
	}
}
