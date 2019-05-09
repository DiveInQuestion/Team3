package com.jnu.teamproject.data;

import java.io.File;

import java.io.FileInputStream;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

import org.apache.log4j.Logger;

public class PrintFile {
	
	static Logger logger = Logger.getLogger(PrintFile.class);
	
	public static void main(String args[]) {
		printFileAction();
	}
	
	public static void printFileAction() 
	{ 
		File outFile = new File("./���ϴ�ѧѧ����������.doc");
	     // ������ӡ�������Լ�
	    PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet(); 
	     // ���ô�ӡ��ʽ����Ϊδȷ���ļ����ͣ�����ѡ�� AUTOSENSE 
	    DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE; 
	     // �������еĿ��ô�ӡ����
	    PrintService printService[] = 
	        PrintServiceLookup.lookupPrintServices(flavor, pras);
	     // ��λĬ�ϵĴ�ӡ����
	    PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
	    // ��ʾ��ӡ�Ի���
	    PrintService service = ServiceUI.printDialog(null, 200, 200, printService 
	        , defaultService, flavor, pras); 
	    if (service != null) 
	    { 
	         try 
	        { 
	            DocPrintJob job = service.createPrintJob();// ������ӡ��ҵ
	            FileInputStream fis = new FileInputStream(outFile);// �������ӡ���ļ���
	            DocAttributeSet das = new HashDocAttributeSet(); 
	            Doc doc = new SimpleDoc(fis, flavor, das);// ������ӡ�ļ���ʽ
	            job.print(doc, pras);// �����ļ��Ĵ�ӡ
	        } 
	        catch(Exception e) 
	        { 
	             //e.printStackTrace(); 
	             logger.error(e.getMessage());
	        } 
	    } 
	}
}
