package com.jnu.teamproject.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetPythonData {
	public static String[] getElecCost(String room) throws IOException{
		String[] elecCost=new String[6];
		File directory = new File(".");
		String exeFileName=directory.getCanonicalPath()+"\\libs\\getele.exe";
		String[] cmd = {exeFileName,room};
		//ִ��exe�ļ�
		final Process proc = Runtime.getRuntime().exec(cmd);

		//��ȡexe�ļ���exe����̨��������
		BufferedReader stdout = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		stdout.readLine();//��ȡһ��
		elecCost[0] = stdout.readLine();//��ȡһ��
		System.out.println(elecCost[0]);
		
		stdout.readLine();
		stdout.readLine();
		stdout.readLine();
		stdout.readLine();
		
		
		elecCost[1] = stdout.readLine();//��ȡһ��
		elecCost[2] = stdout.readLine();//��ȡһ��
		elecCost[3] = stdout.readLine();//��ȡһ��
		elecCost[4] = stdout.readLine();//��ȡһ��
		elecCost[5] = stdout.readLine();//��ȡһ��
		
		System.out.println(elecCost[0].substring(8, 13));
		return elecCost;
	}
	
	public static String[] getSchoolCardInfo(String number,String password) throws IOException{
		String[] InfoString=new String[2];
		File directory = new File(".");
		String exeFileName=directory.getCanonicalPath()+"\\libs\\getcardinf\\getcardinf";

		//ִ��exe�ļ�
		final Process proc = Runtime.getRuntime().exec("cmd /c cd "+exeFileName+"&getcardinf.exe "+number+" "+password);
		//��ȡexe�ļ���exe����̨��������
		BufferedReader stdout = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		
		InfoString[0] = stdout.readLine();//��ȡһ��
		InfoString[1]=stdout.readLine();
		return InfoString;
	}
}
