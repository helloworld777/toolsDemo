package com.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.util.Linkify;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

public class ViewHolder {
//	QuickAdapter quickAdapter;
	private final SparseArray<View> mViews;
	private View mConvertView;
	private Context context;
	private ViewHolder(Context context,ViewGroup parent,int layoutId,int postion){
		mViews=new SparseArray<View>();
		this.context=context;
		this.mConvertView=LayoutInflater.from(context).inflate(layoutId, parent,false);
		mConvertView.setTag(this);
	}
	/**
	 * @param context
	 * @param converView
	 * @param parent
	 * @param layoutId
	 * @param postion
	 * @return
	 */
	public static ViewHolder get(Context context,View converView,ViewGroup parent,int layoutId,int postion){
		if(converView==null){
			return new ViewHolder(context, parent, layoutId, postion);
		}
		return (ViewHolder)converView.getTag();
	}
	@SuppressWarnings("unchecked")
	public <T extends View> T retrieveView(int viewId){
		View view=mViews.get(viewId);
		if(view==null){
			view=mConvertView.findViewById(viewId);
			mViews.put(viewId, view);
		}
		return (T) view;
	}

	public View getConverView(){
		return mConvertView;
	}
	public ViewHolder setText(int viewId, String value) {
		TextView view = retrieveView(viewId);
		view.setText(value);
		return this;
	}

	public ViewHolder setImageResource(int viewId, int imageResId) {
		ImageView view = retrieveView(viewId);
		view.setImageResource(imageResId);
		return this;
	}

	public ViewHolder setBackgroundColor(int viewId, int color) {
		View view = retrieveView(viewId);
		view.setBackgroundColor(color);
		return this;
	}

	public ViewHolder setBackgroundRes(int viewId, int backgroundRes) {
		View view = retrieveView(viewId);
		view.setBackgroundResource(backgroundRes);
		return this;
	}

	public ViewHolder setTextColor(int viewId, int textColor) {
		TextView view = retrieveView(viewId);
		view.setTextColor(textColor);
		return this;
	}

	public ViewHolder setTextColorRes(int viewId, int textColorRes) {
		TextView view = retrieveView(viewId);
		view.setTextColor(context.getResources().getColor(textColorRes));
		return this;
	}

	public ViewHolder setImageDrawable(int viewId, Drawable drawable) {
		ImageView view = retrieveView(viewId);
		view.setImageDrawable(drawable);
		return this;
	}

	public ViewHolder setImageUrl(int viewId, String imageUrl) {
		ImageView view = retrieveView(viewId);
//		Picasso.with(context).load(imageUrl).into(view);
		return this;
	}

//	public ViewHolder setImageBuilder(int viewId, RequestCreator requestBuilder) {
//		ImageView view = retrieveView(viewId);
//		requestBuilder.into(view);
//		return this;
//	}

	public ViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
		ImageView view = retrieveView(viewId);
		view.setImageBitmap(bitmap);
		return this;
	}

	@SuppressLint("NewApi")
	public ViewHolder setAlpha(int viewId, float value) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			retrieveView(viewId).setAlpha(value);
		} else {
			// Pre-honeycomb hack to set Alpha value
			AlphaAnimation alpha = new AlphaAnimation(value, value);
			alpha.setDuration(0);
			alpha.setFillAfter(true);
			retrieveView(viewId).startAnimation(alpha);
		}
		return this;
	}

	public ViewHolder setVisible(int viewId, boolean visible) {
		View view = retrieveView(viewId);
		view.setVisibility(visible ? View.VISIBLE : View.GONE);
		return this;
	}

	public ViewHolder linkify(int viewId) {
		TextView view = retrieveView(viewId);
		Linkify.addLinks(view, Linkify.ALL);
		return this;
	}

	public ViewHolder setTypeface(Typeface typeface, int... viewIds) {
		for (int viewId : viewIds) {
			TextView view = retrieveView(viewId);
			view.setTypeface(typeface);
			view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
		}
		return this;
	}

	public ViewHolder setProgress(int viewId, int progress) {
		ProgressBar view = retrieveView(viewId);
		view.setProgress(progress);
		return this;
	}

	public ViewHolder setProgress(int viewId, int progress, int max) {
		ProgressBar view = retrieveView(viewId);
		view.setMax(max);
		view.setProgress(progress);
		return this;
	}

	public ViewHolder setMax(int viewId, int max) {
		ProgressBar view = retrieveView(viewId);
		view.setMax(max);
		return this;
	}

	public ViewHolder setRating(int viewId, float rating) {
		RatingBar view = retrieveView(viewId);
		view.setRating(rating);
		return this;
	}

	public ViewHolder setRating(int viewId, float rating, int max) {
		RatingBar view = retrieveView(viewId);
		view.setMax(max);
		view.setRating(rating);
		return this;
	}

	public ViewHolder setTag(int viewId, Object tag) {
		View view = retrieveView(viewId);
		view.setTag(tag);
		return this;
	}

	public ViewHolder setTag(int viewId, int key, Object tag) {
		View view = retrieveView(viewId);
		view.setTag(key, tag);
		return this;
	}

	public ViewHolder setChecked(int viewId, boolean checked) {
		Checkable view = (Checkable) retrieveView(viewId);
		view.setChecked(checked);
		return this;
	}


//	public ViewHolder setAdapter(int viewId, Adapter adapter) {
//		AdapterView view = retrieveView(viewId);
//		view.setAdapter(adapter);
//		return this;
//	}
	
}
