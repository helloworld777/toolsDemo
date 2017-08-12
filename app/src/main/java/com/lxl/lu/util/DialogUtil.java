package com.lxl.lu.util;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class DialogUtil {
//	private static AlertDialog dialog=null;
	public static void showToast(Context context,String msg){
		TopNoticeDialog.showToast(context.getApplicationContext(),msg);
	}


	private static boolean isActivityNotFinished(Context context){

		if(context==null) return false;

		if(context instanceof Activity){
			Activity activity= (Activity) context;
			return !activity.isFinishing();
		}
		return false;
	}
	public static Dialog showAlertDialog(Context context, String title, String[] items, OnClickListener dialogInterface){
		AlertDialog.Builder builder=new AlertDialog.Builder(context);
		builder.setTitle(title).setItems(items,dialogInterface);
		AlertDialog dialog=builder.create();
		dialog.show();
		return dialog;
	}

	public static  Dialog showAlertDialog(Context context,String title,int items,OnClickListener dialogInterface){
		AlertDialog.Builder builder=new AlertDialog.Builder(context);
		builder.setTitle(title).setItems(items,dialogInterface);
		AlertDialog dialog=builder.create();
		dialog.show();
		return dialog;
	}

	public static void closeAlertDialog(Dialog dialog){
		if(dialog!=null && dialog.isShowing()){
			dialog.dismiss();
			dialog=null;
		}
	}

	public static Dialog showWaitDialog(Context context){
		AlertDialog dialog=ProgressDialog.show(context, "wait", "please....");
		dialog.show();
		return dialog;
	}
	public static Dialog showWaitDialog(Context context,String title,String message){
		AlertDialog  dialog=ProgressDialog.show(context, title, message);
		dialog.show();
		return dialog;
	}

}
