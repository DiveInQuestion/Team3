package com.jnu.teamproject.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

public class Save {

	static Logger logger = Logger.getLogger(Save.class);
	
	public static void saveWord(String str[]){
        Map<String,Object> dataMap = new HashMap<String, Object>();
        try {
        	dataMap.put("reason", str[0]);

            dataMap.put("Fyear", str[1]);

            dataMap.put("Fmonth",str[2]);

            dataMap.put("Fday", str[3]);

            dataMap.put("Tyear", str[4]);

            dataMap.put("Tmonth", str[5]);

            dataMap.put("Tday", str[6]);
            
            int day=Integer.valueOf(str[6])-Integer.valueOf(str[3]);
            dataMap.put("day", String.valueOf(day));
            //Configuration ���ڶ�ȡftl�ļ�
            Configuration configuration = new Configuration(new Version("2.3.0"));
            configuration.setDefaultEncoding("utf-8");
 
            //ָ��·���ĵ�һ�ַ�ʽ������ĳ��������·��ָ����
            //configuration.setClassForTemplateLoading(Save.class, "");
 
            //ָ��·���ĵڶ��ַ�ʽ���ҵ�·����C��/a.ftl
            String path = System.getProperty("user.dir")+"./documents";
            configuration.setDirectoryForTemplateLoading(new File(path));
            
            //���̵����·�����
            File outFile = new File("./���ϴ�ѧѧ����������.doc");
            //��utf-8�ı����ȡftl�ļ�
            Template template = configuration.getTemplate("���ϴ�ѧѧ����������.ftl", "utf-8");
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"), 10240);
            template.process(dataMap, out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
	}
	
	public static void savePDF(String str[]){
        Map<String,Object> dataMap = new HashMap<String, Object>();
        try {

            dataMap.put("reason", str[0]);

            dataMap.put("Fyear", str[1]);

            dataMap.put("Fmonth",str[2]);

            dataMap.put("Fday", str[3]);

            dataMap.put("Tyear", str[4]);

            dataMap.put("Tmonth", str[5]);

            dataMap.put("Tday", str[6]);
            
            int day=Integer.valueOf(str[6])-Integer.valueOf(str[3]);
            dataMap.put("day", String.valueOf(day));
            
            Configuration configuration = new Configuration(new Version("2.3.0"));
            configuration.setDefaultEncoding("utf-8");
 
            String path = System.getProperty("user.dir")+"./documents";
            configuration.setDirectoryForTemplateLoading(new File(path));
            
            File outFile = new File("./���ϴ�ѧѧ����������.doc");
            Template template = configuration.getTemplate("���ϴ�ѧѧ����������.ftl", "utf-8");
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"), 10240);
            template.process(dataMap, out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        Word2Pdf.doc2pdf("./���ϴ�ѧѧ����������.doc", "./���ϴ�ѧѧ����������.pdf");
	}
}
