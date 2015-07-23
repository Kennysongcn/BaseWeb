package com.kenny.app.web.main.controller.base;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;


public class BaseController {

	@Autowired
	protected HttpServletRequest request;
	@Autowired
	protected HttpSession sesson;
	@Autowired
	protected ServletContext servletContext;
    /**
     * 返回页面参数容器
     */
    @SuppressWarnings("rawtypes")
	public Map paramMap=new HashMap();
    protected ModelAndView mav;
	
	

	public static final String CONTENTTYPE_HTML = "text/html";
	
    public static final String CHARTSET_UTF8 = "utf-8";
	
    /**
     * 从Request获取参数
     * @param name
     * @return
     */
    final protected String getParam(String name){
    	return request.getParameter(name);
    }
    
    /**
     * 从Request获取参数
     * @param name
     * @return
     */
    final protected String[] getParams(String name){
    	return request.getParameterValues(name);
    }
    
    /**
     * 获取参数为Map
     * @return
     */
	final protected Map<String,String> getParamMap(){
    	Map<String, String> m = new HashMap<String, String>();
        Iterator<String> keys = request.getParameterMap().keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            m.put(key, getParam(key));
        }
        return m;
    }
	
	
	/**
     * 向HttpServletResponse输出文本
     * @param response
     * @param text 输出的字符串
     * @param contentType 类型
     * @param charset 编码
     */
    final public void outputText(HttpServletResponse response,String text, String contentType, String charset) {
    	response.setCharacterEncoding(charset);
        //指定内容类型
    	response.setContentType(contentType + ";charset=" + charset);
        //禁止缓存
    	response.setHeader("Pragma", "no-cache");
    	response.setHeader("Cache-Control", "no-cache");
    	response.setDateHeader("Expires", 0);
    	OutputStream o = null;
        try {
        	byte[] content = text.getBytes(charset);
        	o = response.getOutputStream();
        	o.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
        	try {
        		if(o!=null){
        			o.close();
        		}
        		o = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }
    
    /**
     * 向客户端输出字符串，编码为UTF-8
     * @param response
     * @param text
     */
    final protected void outputString(HttpServletResponse response,String text){
    	this.outputText(response,text, CONTENTTYPE_HTML, CHARTSET_UTF8);
    }
    
    public ModelAndView getMav() {
		return mav;
	}

	public void setMav(ModelAndView mav) {
		this.mav = mav;
	}

	@SuppressWarnings("rawtypes")
	public void setParamMap(Map paramMap) {
		this.paramMap = paramMap;
	}
	
	
}
