package com.lxl.lu.util;

import android.content.Context;
import android.os.Environment;
import android.os.Looper;
import android.util.Log;

import com.lxl.lu.toolsample.R;
import com.lxl.lu.util.file.FileUtils;
import com.lxl.lu.util.file.IOUtil;
import com.lxl.lu.util.file.SDCardUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CrashUtils implements UncaughtExceptionHandler{

	public static final String TAG = "CrashUtils";
	
	private UncaughtExceptionHandler mDefaultHandler;
	private static CrashUtils INSTANCE = new CrashUtils();
	private Context mContext;
	private Map<String, String> infos = new HashMap<String, String>();

	private DateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	
	private  static String crashDri = "/sdcard/s%/crash/";
	private CrashUtils() {
	}

	public static CrashUtils getInstance() {
		return INSTANCE;
	}

	public void init(Context context) {
		mContext = context.getApplicationContext();
		mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
		Thread.setDefaultUncaughtExceptionHandler(this);
		crashDri="/sdcard/"+(context.getText(R.string.app_name)+"/crash/");
	}

	/**
	 */
	@Override
	public void uncaughtException(Thread thread, Throwable ex) {
		if (!handleException(ex) && mDefaultHandler != null) {
			mDefaultHandler.uncaughtException(thread, ex);
		} else {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				Log.e(TAG, "error : ", e);
			}
			android.os.Process.killProcess(android.os.Process.myPid());
			System.exit(1);
		}
	}

	/**
	 *
	 * @param ex
	 */
	private boolean handleException(Throwable ex) {
		if (ex == null) {
			return false;
		}
		new Thread() {
			@Override
			public void run() {
				Looper.prepare();
//				Toast.makeText(mContext, "sorry ,there is  err happend.", Toast.LENGTH_LONG).show();
				Looper.loop();
			}
		}.start();
		saveCrashInfo2File(ex);
		return true;
	}

	/**
	 * 获取APP崩溃异常报告
	 *
	 * @param ex
	 * @return
	 */
	private String getCrashReport(Throwable ex) {
//        PackageInfo pinfo = AppUtils.getPackageInfo(context);
		StringBuffer exceptionStr = new StringBuffer();
//        exceptionStr.append("Version: " + pinfo.versionName + "(" + pinfo.versionCode + ")\n");
		exceptionStr.append("Android: " + android.os.Build.VERSION.RELEASE + "(" + android.os.Build.MODEL + ")\n");
		exceptionStr.append("Exception: " + ex.getMessage() + "\n");
		StackTraceElement[] elements = ex.getStackTrace();
		for (int i = 0; i < elements.length; i++) {
			exceptionStr.append(elements[i].toString() + "\n");
		}
		return exceptionStr.toString();
	}
	/**
	 *
	 * @param ex
	 */
	private String saveCrashInfo2File(Throwable ex) {
		
		StringBuffer sb = new StringBuffer();
		for (Map.Entry<String, String> entry : infos.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			sb.append(key + "=" + value + "\n");
		}
		
		Writer writer = new StringWriter();
		PrintWriter printWriter = new PrintWriter(writer);
		ex.printStackTrace(printWriter);
		Throwable cause = ex.getCause();
		while (cause != null) {
			cause.printStackTrace(printWriter);
			cause = cause.getCause();
		}
		printWriter.close();
		String result = writer.toString();
		sb.append(result);
		LogUtil.d("aaaa",sb.toString());
		try {
//			long timestamp = System.currentTimeMillis();
			String time = formatter.format(new Date());
			String fileName = time+".log";
			if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
				File dir = new File(crashDri);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				String crashFile=new File(dir,fileName).getAbsolutePath();
				IOUtil.writerString(crashFile,sb.toString());
				LogUtil.d("aaaa","bbbbbbbbbbbbbbbbbbbbbb");
			}
			return fileName;
		} catch (Exception e) {
			Log.e(TAG, "an error occured while writing file...", e);
		}
		return null;
	}

}
