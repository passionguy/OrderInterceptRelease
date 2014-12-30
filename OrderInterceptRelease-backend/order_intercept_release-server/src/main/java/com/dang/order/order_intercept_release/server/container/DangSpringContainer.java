package com.dang.order.order_intercept_release.server.container;

/**   
* @author zhangjing@dangdang.com
* @date 2014-3-28 下午1:55:02 
*/
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.util.Log4jConfigurer;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.container.Container;
import com.alibaba.dubbo.container.spring.SpringContainer;

/** 
 * @date 2014-3-28 下午1:55:02 
 *  
 */
public class DangSpringContainer implements Container {

	private static final Logger logger = LoggerFactory.getLogger(SpringContainer.class);

    public static final String SPRING_CONFIG = "dubbo.spring.config";
    
    public static final String DEFAULT_SPRING_CONFIG = "classpath*:META-INF/spring/*.xml";

    static FileSystemXmlApplicationContext context;
    
    public static FileSystemXmlApplicationContext getContext() {
		return context;
	}
	/* (non-Javadoc)
	 * @see com.alibaba.dubbo.container.Container#start()
	 */
	@Override
	public void start() {
//		String configPath = ConfigUtils.getProperty(SPRING_CONFIG);
//        if (configPath == null || configPath.length() == 0) {
//            configPath = DEFAULT_SPRING_CONFIG;
//        }
//        context = new ClassPathXmlApplicationContext(configPath.split("[,\\s]+"));
//        context.start();
		context = getSpringContext();
		
	}

	/* (non-Javadoc)
	 * @see com.alibaba.dubbo.container.Container#stop()
	 */
	@Override
	public void stop() {
		try {
            if (context != null) {
                context.stop();
                context.close();
                context = null;
            }
        } catch (Throwable e) {
            logger.error(e.getMessage(), e);
        }
	}
	/**
	 * 获取spring会话
	 * 
	 * @return
	 */
	public static synchronized FileSystemXmlApplicationContext getSpringContext() {
			Log4jConfigurer.setWorkingDirSystemProperty("log4j.WebApp.root");
			String path = PathUtil.getAppConfPath()
					.concat(PathUtil.getSeparator()).concat("spring.xml");
			path = PathUtil.getPath(path);
			return new FileSystemXmlApplicationContext(path);
	}

}
