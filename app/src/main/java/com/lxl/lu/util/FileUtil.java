package com.lxl.lu.util;

import android.net.Uri;
import android.os.Environment;
import android.os.StatFs;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 *
 */
public class FileUtil {
	private static String SDCardRoot=Environment.getExternalStorageDirectory()
	.getAbsolutePath() + File.separator;
	/**
	 */
	
	private static String dataPath=SDCardRoot+"lu";
	/**
	 */
	private static String downPath=dataPath+File.separator+"download";
	/**
	 */
	private static String imgPath=dataPath+File.separator+"img";
	
	/**
	 */
	private static String lrcPath=dataPath+File.separator+"lrc";
	
	
	/**
	 * @return
	 */
	public static String downPath(){
		createDirFile(dataPath);
		createDirFile(downPath);
		return downPath;
	}
	/**
	 * @return
	 */
	public static String lrcPath(){
		createDirFile(dataPath);
		createDirFile(lrcPath);
		return downPath;
	}
	/**
	 * @return
	 */
	public static String imgPathPath(){
		createDirFile(dataPath);
		createDirFile(imgPath);
		return imgPath;
	}
	
	/**
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
	 *
	 * @param path
	 */
	public static void createDirFile(String path) {
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}
	}

	/**
	 *
	 * @param path
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

	public static void delFolder(String folderPath) {
		delAllFile(folderPath);
		String filePath = folderPath;
		filePath = filePath.toString();
		File myFilePath = new File(filePath);
		myFilePath.delete();
	}
	public static boolean isSDCardEnable() {
		return Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED);

	}


	public static String getSDCardPath() {
		return Environment.getExternalStorageDirectory().getAbsolutePath()
				+ File.separator;
	}


	public static long getSDCardAllSize() {
		if (isSDCardEnable()) {
			StatFs stat = new StatFs(getSDCardPath());
			long availableBlocks = (long) stat.getAvailableBlocks() - 4;
			long freeBlocks = stat.getAvailableBlocks();
			return freeBlocks * availableBlocks;
		}
		return 0;
	}

	public static long getFreeBytes(String filePath) {
		if (filePath.startsWith(getSDCardPath())) {
			filePath = getSDCardPath();
		} else {
			filePath = Environment.getDataDirectory().getAbsolutePath();
		}
		StatFs stat = new StatFs(filePath);
		long availableBlocks = (long) stat.getAvailableBlocks() - 4;
		return stat.getBlockSize() * availableBlocks;
	}

	/**
	 * @return
	 */
	public static String getRootDirectoryPath() {
		return Environment.getRootDirectory().getAbsolutePath();
	}
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

	public static Uri getUriFromFile(String path) {
		File file = new File(path);
		return Uri.fromFile(file);
	}

	public static String formatFileSize(long size) {
		DecimalFormat df = new DecimalFormat("#.00");
		String fileSizeString = "aa";
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
