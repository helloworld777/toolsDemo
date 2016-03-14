package com.lu.util;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import android.net.Uri;
import android.os.Environment;

/**
 *
 */
public class FileUtils {
	private static String SDCardRoot=Environment.getExternalStorageDirectory()
	.getAbsolutePath() + File.separator;
	/**
	 * Ӧ�ó���·��
	 */
	
	private static String dataPath=SDCardRoot+"lu";
	/**
	 * ����·��
	 */
	private static String downPath=dataPath+File.separator+"download";
	/**
	 * ͼƬ·��
	 */
	private static String imgPath=dataPath+File.separator+"img";
	
	/**
	 * ͼƬ·��
	 */
	private static String lrcPath=dataPath+File.separator+"lrc";
	
	
	/**
	 * ���ص�ַ
	 * @return
	 */
	public static String downPath(){
		createDirFile(dataPath);
		createDirFile(downPath);
		return downPath;
	}
	/**
	 * ���ص�ַ
	 * @return
	 */
	public static String lrcPath(){
		createDirFile(dataPath);
		createDirFile(lrcPath);
		return downPath;
	}
	/**
	 *  ͼƬ��ַ
	 * @return
	 */
	public static String imgPathPath(){
		createDirFile(dataPath);
		createDirFile(imgPath);
		return imgPath;
	}
	
	/**
	 * �ж�SD�Ƿ����
	 * 
	 * @return
	 */
	public static boolean isSdcardExist() {
		if (Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) {
			return true;
		}
		return false;
	}

	/**
	 * ����Ŀ¼
	 * 
	 * @param path
	 *            Ŀ¼·��
	 */
	public static void createDirFile(String path) {
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}
	}

	/**
	 * �����ļ�
	 * 
	 * @param path
	 *            �ļ�·��
	 * @return �������ļ�
	 */
	public static File createNewFile(String path) {
		File file = new File(path);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				return null;
			}
		}
		return file;
	}

	/**
	 * ɾ���ļ���
	 * 
	 * @param folderPath
	 *            �ļ��е�·��
	 */
	public static void delFolder(String folderPath) {
		delAllFile(folderPath);
		String filePath = folderPath;
		filePath = filePath.toString();
		File myFilePath = new File(filePath);
		myFilePath.delete();
	}

	/**
	 * ɾ���ļ�
	 * 
	 * @param path
	 *            �ļ���·��
	 */
	public static void delAllFile(String path) {
		File file = new File(path);
		if (!file.exists()) {
			return;
		}
		if (!file.isDirectory()) {
			return;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				delAllFile(path + "/" + tempList[i]);
				delFolder(path + "/" + tempList[i]);
			}
		}
	}

	/**
	 * ��ȡ�ļ���Uri
	 * 
	 * @param path
	 *            �ļ���·��
	 * @return
	 */
	public static Uri getUriFromFile(String path) {
		File file = new File(path);
		return Uri.fromFile(file);
	}

	/**
	 * �����ļ���С
	 * 
	 * @param size
	 * @return
	 */
	public static String formatFileSize(long size) {
		DecimalFormat df = new DecimalFormat("#.00");
		String fileSizeString = "δ֪��С";
		if (size < 1024) {
			fileSizeString = df.format((double) size) + "B";
		} else if (size < 1048576) {
			fileSizeString = df.format((double) size / 1024) + "K";
		} else if (size < 1073741824) {
			fileSizeString = df.format((double) size / 1048576) + "M";
		} else {
			fileSizeString = df.format((double) size / 1073741824) + "G";
		}
		return fileSizeString;
	}
	
}
