package com.xll.dt.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import org.joda.time.DateTime;


//备份还原工具类
public class DBbackupUtil {
   
	// 数据信息
	private static final String username;// 数据库用户名
	private static final String password;// 数据库用户密码
	private static final String serverUrl;// 数据库ip地址 
	private static final String dbName;// 数据库名
	
	private static final String DB_RESTORE_NAME = "automotive_rescue_restore";//automotiverescue
    private static final String BACKUP_DIR = "d:\\backup";
	
	//初始化成员变量
	static {
		/*加载资源文件的  资源文件不需要写扩展名*/
	    ResourceBundle bundle  = ResourceBundle.getBundle("backup");
		 
		username=bundle.getString("username");
		password=bundle.getString("password");
		serverUrl=bundle.getString("serverUrl");
		dbName=bundle.getString("dbName");
	}   
  
    //备份
    public static void backup() {
       
    	//保存路径
        String savePath = null;
        
        //创建备份文件信息对象
		/*BackupInfo info = new BackupInfo();*/
		//备份记录的编号
		/*info.setNumber(UUID.randomUUID().toString().replaceAll("-", ""));*/
        try { 
            //创建目录
            File filepath = new File(generateSubDirctory("F:\\backUpFiles"));
            if(!filepath.exists()) {  
                //如果目录不存在，则创建 
                filepath.mkdirs();
            }  
            
            // 要用来做导入用的sql目标文件（使用了joda）
            String filename = new DateTime().toString("yyyy-MM-dd-HH-mm-ss");
            //保存路径赋值
            savePath = filepath + "\\" + filename + ".sql";
            
            //创建Runtime对象
            Runtime rt = Runtime.getRuntime();
 
            // 调用 调用mysql的安装目录的命令
            Process child = rt .exec("mysqldump -h" + serverUrl + " -u" + username + " -p" + password + " " + dbName);
           
            // 设置导出编码为utf-8。这里必须是utf-8
            // 把进程执行中的控制台输出信息写入.sql文件，即生成了备份文件。注：如果不对控制台信息进行读出，则会导致进程堵塞无法运行
            InputStream in = child.getInputStream();// 控制台的输出信息作为输入流
 
            InputStreamReader xx = new InputStreamReader(in, "utf-8");
            // 设置输出流编码为utf-8。这里必须是utf-8，否则从流中读入的是乱码
 
            String inStr;
            StringBuffer sb = new StringBuffer("");
            String outStr;
            // 组合控制台输出信息字符串
            BufferedReader br = new BufferedReader(xx);
            while ((inStr = br.readLine()) != null) {
                sb.append(inStr + "\r\n");
            }
            outStr = sb.toString();
            
 
            // 要用来做导入用的sql目标文件：
            FileOutputStream fout = new FileOutputStream(savePath);
            OutputStreamWriter writer = new OutputStreamWriter(fout, "utf-8");
            writer.write(outStr);
            writer.flush();
            in.close();
            xx.close();
            br.close();
            writer.close();
            fout.close();
            
           
    		
    		/* //是否完成
			info.setIsComplete(1);
			long len = new File(savePath).length();
	        //文件大小
			info.setSize(len);
			
	        if (len!=0) {
				//是否出错
				info.setIsError(0);
				//备份错误信息
				info.setErrMsg("无");
			}else {
				//是否出错
				info.setIsError(1);
				//备份错误信息
				info.setErrMsg("备份失败,大小为0");
			}
  
			//备份路径
			info.setPath(savePath);

            System.out.println(len);*/

 
        } catch (Exception e) {
        	/*//是否完成
			info.setIsComplete(0);
			//是否出错
			info.setIsError(1);
			//备份错误信息
			info.setErrMsg("备份失败"+e.getMessage());
			//备份路径
			info.setPath(savePath);*/
        	e.printStackTrace();
        }
 
        /*return info;*/
    }
    
    
    //还原数据
    public static void restore(String filename) {
        try {
        	
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime
                    .exec("mysql.exe -h" + serverUrl + " -u" + username + " -p" + password + " --default-character-set=utf8 "
                            + DB_RESTORE_NAME);
            //创建写入流
            OutputStream outputStream = process.getOutputStream();
            //创建读入流
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "utf-8"));
            
            String str = null;
            StringBuffer sb = new StringBuffer();
            while ((str = br.readLine()) != null) {
                sb.append(str + "\r\n");
            }
            
            str = sb.toString();
            // System.out.println(str);
            OutputStreamWriter writer = new OutputStreamWriter(outputStream,"utf-8");
            writer.write(str);
            writer.flush();
            outputStream.close();
            br.close();
            writer.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
/*    public static void main(String[] args) {
        //备份
         BackupInfo backup = DBbackupUtil.backup();
        
        //还原
        DBbackupUtil.restore(backup.getPath());
        System.out.println(backup);
    }
    */
    
    // 用当天的日期作为子目录
 	private static String generateSubDirctory(String parentDirctory) {
 		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 		String time = sdf.format(new Date());// 得到当天日期的字符串 2017-09-08

 		File childDirctory = new File(parentDirctory, time);
 		if (!childDirctory.exists()) {
 			childDirctory.mkdirs();
 		}

 		return parentDirctory+"\\"+time+"\\";
 	}

}
