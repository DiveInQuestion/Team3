package com.jnu.teamproject.junit;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

public class WordTest {
	@Test
	public void test(){
        Map<String,Object> dataMap = new HashMap<String, Object>();
        try {
            //���
            dataMap.put("reason", "�����ˣ���ҽ��");
            //����
            dataMap.put("Fyear", "2019");
            //��������
            dataMap.put("Fmonth", "5");
            //�ܿ���
            dataMap.put("Fday", "3");
            //������;
            dataMap.put("Tyear", "2019");
            //��д���
            dataMap.put("Tmonth", "5");
            //Сд���
            dataMap.put("Tday", "4");
            dataMap.put("day", "1");
            //Configuration ���ڶ�ȡftl�ļ�
            Configuration configuration = new Configuration(new Version("2.3.0"));
            configuration.setDefaultEncoding("utf-8");
 
            /**
             * ����������ָ��ftl�ļ�����Ŀ¼·���ķ�ʽ��ע�������ַ�ʽ����
             * ָ��ftl�ļ�����Ŀ¼��·����������ftl�ļ���·��
             */
            //ָ��·���ĵ�һ�ַ�ʽ������ĳ��������·��ָ����
            configuration.setClassForTemplateLoading(this.getClass(), "doc");
 
            //ָ��·���ĵڶ��ַ�ʽ���ҵ�·����C��/a.ftl
            //configuration.setDirectoryForTemplateLoading(new File("c:/"));
 
            //����ĵ��ľ���·��������
            //File outFile = new File("E:/���ϴ�ѧѧ����������.doc");
            
            //���̵����·�����
            File outFile = new File("./���ϴ�ѧѧ����������.doc");
            //��utf-8�ı����ȡftl�ļ�
            Template template = configuration.getTemplate("���ϴ�ѧѧ����������.ftl", "utf-8");
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"), 10240);
            template.process(dataMap, out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
