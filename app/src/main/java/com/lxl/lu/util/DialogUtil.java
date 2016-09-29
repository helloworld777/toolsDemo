package com.lxl.lu.util;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class DialogUtil {
	private static AlertDialog dialog=null;
	public static void showToast(Context context,String msg){
		TopNoticeDialog.showToast(context,msg);
	}


	private static boolean isActivityNotFinished(Context context){

		if(context==null) return false;

		if(context instanceof Activity){
			Activity activity= (Activity) context;
			return !activity.isFinishing();
		}
		return false;
	}
	public static  void showAlertDialog(Context context,String title,String[] items,OnClickListener dialogInterface){
		AlertDialog.Builder builder=new AlertDialog.Builder(context);
		builder.setTitle(title).setItems(items,dialogInterface);
		dialog=builder.create();
		dialog.show();
	}

	public static  void showAlertDialog(Context context,String title,int items,OnClickListener dialogInterface){
		AlertDialog.Builder builder=new AlertDialog.Builder(context);
		builder.setTitle(title).setItems(items,dialogInterface);
		dialog=builder.create();
		dialog.show();
	}

	public static void closeAlertDialog(){
		if(dialog!=null && dialog.isShowing()){
			dialog.dismiss();
			dialog=null;
		}
	}

	public static void showExitAlertDialog(Context context,OnClickListener dialogInterface){
		AlertDialog.Builder builder=new AlertDialog.Builder(context);
		builder.setTitle("exit").setMessage("Are you sure?")
		.setNegativeButton("cancel", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				closeAlertDialog();
			}
		})
		.setPositiveButton("ok", dialogInterface);
		dialog=builder.create();
		dialog.show();
	}
	public static void showMsgAlertDialog(Context context,String title,String msg,OnClickListener dialogInterface){
		AlertDialog.Builder builder=new AlertDialog.Builder(context);
		builder.setTitle(title).setMessage(msg)
		.setNegativeButton("cancel", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				closeAlertDialog();
			}
		})
		.setPositiveButton("ok", dialogInterface);
		dialog=builder.create();
		dialog.show();
	}

	
	public static void showWaitDialog(Context context){
		dialog=ProgressDialog.show(context, "wait", "please....");
		dialog.show();
	}
	public static void showWaitDialog(Context context,String title,String message){
		dialog=ProgressDialog.show(context, title, message);
		dialog.show();
	}

}
