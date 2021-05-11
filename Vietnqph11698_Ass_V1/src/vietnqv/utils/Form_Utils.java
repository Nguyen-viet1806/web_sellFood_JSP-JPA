package vietnqv.utils;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.Part;
import org.apache.commons.beanutils.BeanUtils;

public class Form_Utils {
	public static boolean exist(String name) {
		return RRShare_Utils.request().getParameter(name)!=null;
	}
	
	public static String getString(String name, String defval) {
		String value = RRShare_Utils.request().getParameter(name);
		return value == null ? defval:value;
	}
	
	public static int getInt(String name,int defval) {
		String value = getString(name, String.valueOf(defval));
		return Integer.parseInt(value);
	}
	
	public static double getDouble(String name,double defval) {
		String value = getString(name, String.valueOf(defval));
		return Double.parseDouble(value);
	}
	
	public static boolean getBoolean(String name,boolean defval) {
		String value = getString(name, String.valueOf(defval));
		return Boolean.parseBoolean(value);
	}
	
	public static Date getDate(String name,Date defval) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String date = getString(name, sdf.format(defval));
		try {
			return sdf.parse(date);
		} catch (Exception e) {
			return defval;
		}
	}
	
	public static File getFile(String name) {
		File dir = new File(RRShare_Utils.request().getServletContext().getRealPath("D:\\Tu_Hoc_Java\\Anh_ASS"));
		if(!dir.exists()) {
			dir.mkdirs();
		}
		try {
			Part partFile = RRShare_Utils.request().getPart(name);
			File newFile = new File(dir,partFile.getSubmittedFileName());
			partFile.write(newFile.getAbsolutePath());
			return newFile;
		} catch (IOException e) {
			return null;
		} catch (ServletException e) {
			return null;
		}
	}
	
	public static <T> T getBean(Class<T> clazz) {
		try {
			T bean = clazz.newInstance();
			BeanUtils.populate(bean, RRShare_Utils.request().getParameterMap());
			return bean;
		} catch (Exception e) {
			return null;
		}
	}
}
