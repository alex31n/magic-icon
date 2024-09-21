package com.github.alex31n.magicicon;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;

import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageView;

public class IconButton extends AppCompatImageView {

	public static final int SHAPE_RECTANGLE = 101;
	public static final int SHAPE_OVAL = 102;

	private static final String TAG = IconButton.class.getSimpleName();

	private Typeface iconTypeface = null;

	private Context context;
	private int src = 0;

	private int typefaceCode = 0;
	private int iconColor = 0xFF000000;
	//private String fontAwesome = "\uf03e", fontDefault = "\uf03e";
	private String fontText = "", fontDefault = "";
	private final int defaultFontSize = 100;
	private int fontSize = defaultFontSize;

	private int fpadding = 30, padding = 30, paddingLeft = 30, paddingTop = 30, paddingRight = 30, paddingBottom = 30;

	private int backgroundColor = 0;
	private int focusColor = 0xFFCCCCCC;
	private int disabledColor = Color.GRAY;
	private int shape = SHAPE_RECTANGLE;
	private int borderWidth = 0;
	private int borderColor = Color.TRANSPARENT;
	private float radius = 0;
	private boolean isEnabled = true;

	public IconButton(Context context) {
		super(context);
		this.context = context;
		initializeView();
		//Log.e("TAG", "IconView(Context context)");
	}

	public IconButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;

		processAttributes(context, attrs);

		initializeView();
		//Log.e("TAG", "IconView(Context context, @Nullable AttributeSet attrs)");
	}

	public IconButton(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		this.context = context;

		processAttributes(context, attrs);

		initializeView();
		//Log.e("TAG", "IconView(Context context, @Nullable AttributeSet attrs, int defStyleAttr)");
	}

	/*@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
	public IconView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
	}*/

	private void processAttributes(final Context context, final AttributeSet attrs) {
		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1)
			initDefaultAttributes(attrs);
		else
			initDefaultAttributes17(attrs);

		TypedArray attrsArray = context.obtainStyledAttributes(attrs, R.styleable.IconButton, 0, 0);
		initAttributes(attrsArray);
		attrsArray.recycle();
	}


	private void initDefaultAttributes(AttributeSet attrs) {
		int[] defAttr = new int[]{
			  android.R.attr.padding,
			  android.R.attr.paddingLeft,
			  android.R.attr.paddingTop,
			  android.R.attr.paddingRight,
			  android.R.attr.paddingBottom,
			  /*android.R.attr.paddingStart,
			  android.R.attr.paddingEnd,*/
			  android.R.attr.src
		};

		TypedArray defAttrsArray = context.obtainStyledAttributes(attrs, defAttr);

		if (defAttrsArray.hasValue(0)) {
			padding = defAttrsArray.getDimensionPixelSize(0, padding);
			//Log.e(TAG, "Padding " + padding + "");
			paddingLeft = paddingTop = paddingRight = paddingBottom = padding;
		}


		paddingLeft = defAttrsArray.getDimensionPixelSize(1, paddingLeft);
		paddingTop = defAttrsArray.getDimensionPixelSize(2, paddingTop);
		paddingRight = defAttrsArray.getDimensionPixelSize(3, paddingRight);
		paddingBottom = defAttrsArray.getDimensionPixelSize(4, paddingBottom);
		/*paddingLeft = defAttrsArray.getDimensionPixelSize(5, paddingLeft);
		paddingRight = defAttrsArray.getDimensionPixelSize(6, paddingRight);*/

		src = defAttrsArray.getResourceId(5, src);
		//Log.e(TAG, "src "+src+"");

		defAttrsArray.recycle();

	}

	@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
	private void initDefaultAttributes17(AttributeSet attrs) {
		int[] defAttr = new int[]{
			  android.R.attr.padding,
			  android.R.attr.paddingLeft,
			  android.R.attr.paddingTop,
			  android.R.attr.paddingRight,
			  android.R.attr.paddingBottom,
			  android.R.attr.paddingStart,
			  android.R.attr.paddingEnd,
			  android.R.attr.src
		};

		TypedArray defAttrsArray = context.obtainStyledAttributes(attrs, defAttr);


		padding = defAttrsArray.getDimensionPixelSize(0, padding);
		//Log.e(TAG, "Padding " + padding + "");
		paddingLeft = paddingTop = paddingRight = paddingBottom = padding;


		paddingLeft = defAttrsArray.getDimensionPixelSize(1, paddingLeft);
		paddingTop = defAttrsArray.getDimensionPixelSize(2, paddingTop);

		paddingRight = defAttrsArray.getDimensionPixelSize(3, paddingRight);
		paddingBottom = defAttrsArray.getDimensionPixelSize(4, paddingBottom);
		paddingLeft = defAttrsArray.getDimensionPixelSize(5, paddingLeft);
		paddingRight = defAttrsArray.getDimensionPixelSize(6, paddingRight);

		src = defAttrsArray.getResourceId(7, src);
		//Log.e(TAG, "src "+src+"");

		defAttrsArray.recycle();

	}


	private void initAttributes(TypedArray attrs) {

		iconColor = attrs.getColor(R.styleable.IconButton_mi_iconColor, iconColor);
		fontText = attrs.getString(R.styleable.IconButton_mi_fontText);
		typefaceCode = attrs.getInt(R.styleable.IconButton_mi_typeface, FontHelper.getDefaultFontCode());

		backgroundColor = attrs.getColor(R.styleable.IconButton_mi_backgroundColor, backgroundColor);
		disabledColor = attrs.getColor(R.styleable.IconButton_mi_disabledColor, disabledColor);
		focusColor = attrs.getColor(R.styleable.IconButton_mi_focusColor, focusColor);
		shape = attrs.getInt(R.styleable.IconButton_mi_shape, shape);

		borderWidth = attrs.getDimensionPixelSize(R.styleable.IconButton_mi_borderWidth, borderWidth);
		borderColor = attrs.getInt(R.styleable.IconButton_mi_borderColor, borderColor);

		radius = attrs.getDimension(R.styleable.IconButton_mi_radius, radius);
		isEnabled = attrs.getBoolean(R.styleable.IconButton_mi_enabled, isEnabled);
	}


	private void initializeView() {
		setClickable(true);
		super.setEnabled(isEnabled);

		if (!isInEditMode()) {
			iconTypeface = FontHelper.getTypeface(context, typefaceCode);
		}
		//Log.e("TAG","typefaceCode: "+ typefaceCode);

		super.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);

		if (getDrawable() != null) {

			changeBitmapColor();

		} else if (!TextUtils.isEmpty(fontText)) {

			setImageBitmap(textToBitmap(fontText, fontSize, iconColor));
		}


		// setup background
		updateDrawable();

	}


	private void updateDrawable() {
		DrawableHelper helper = new DrawableHelper.Builder()
			  .setBackgroundColor(backgroundColor)
			  .setFocusColor(focusColor)
			  .setShape(shape)
			  .setDisabledColor(disabledColor)
			  .setBorderWidth(borderWidth)
			  .setBorderColor(borderColor)
			  .setRadius((int) radius)
			  .setEnabled(isEnabled)
			  .build();
		//Drawable drawable = helper.setupBackground();
		helper.setBackground(this);
	}


	private Bitmap textToBitmap(String text, int textSize, int textColor) {

		/*if (awesomeIconTypeFace == null) {
			return null;
		}*/
		if (text == null || text.isEmpty()) {
			text = fontDefault;
		}

		float tSize = textSize != 0 ? textSize : this.defaultFontSize;
		//Log.e("TAG", "tSize " + tSize);
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setColor(textColor);
		paint.setTextSize(tSize);
		if (iconTypeface != null) {
			paint.setTypeface(iconTypeface);
		} else {
			text = "o";
		}


		paint.setTextAlign(Paint.Align.LEFT);
		float baseline = -paint.ascent(); // ascent() is negative

		/*int width = (int) (paint.measureText(text) + 0.5f); // round
		int height = (int) (baseline + paint.descent() + 0.5f);*/
		int width = (int) (paint.measureText(text) < 1 ? 100 : paint.measureText(text) + 0.5f); // round
		int height = (int) ((baseline + paint.descent()) < 1 ? 100 : baseline + paint.descent() + 0.5f);
		//Log.e("TAG", "TextToBitmap " + width + "  " + height);
		Bitmap image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(image);
		canvas.drawText(text, 0, baseline, paint);
		//Log.e(TAG, image.getWidth()+"  "+ image.getHeight());
		return image;
	}


	private void changeBitmapColor() {

		if (iconColor == 0) {
			return;
		}

		/*Bitmap sourceBitmap = ((BitmapDrawable) getDrawable()).getBitmap();

		Bitmap resultBitmap = Bitmap.createBitmap(sourceBitmap, 0, 0,
			  sourceBitmap.getWidth() - 1, sourceBitmap.getHeight() - 1);

		// resultBitmap = resultBitmap.copy(Bitmap.Config.ARGB_8888, true);

		Paint p = new Paint();
		//ColorFilter filter = new LightingColorFilter(color, 1);
		ColorFilter filter = new LightingColorFilter(iconColor, iconColor);
		p.setColorFilter(filter);
		p.setAntiAlias(true);
		//setImageBitmap(resultBitmap);

		Canvas canvas = new Canvas(resultBitmap);
		canvas.drawBitmap(resultBitmap, 0, 0, p);

		setImageBitmap(resultBitmap);*/
		setColorFilter(iconColor);
	}


	public void setFontText(String icon) {
		this.fontText = icon;
		setImageBitmap(textToBitmap(fontText, fontSize, iconColor));
	}

	public void setTypeface(int typeface) {
		this.typefaceCode = typeface;
		this.iconTypeface = FontHelper.getTypeface(context, this.typefaceCode);
		setImageBitmap(textToBitmap(fontText, fontSize, iconColor));
	}

	public void setFontSize(int size) {
		this.fontSize = size;
		setImageBitmap(textToBitmap(fontText, fontSize, iconColor));
	}

	public int getFontSize() {
		return this.fontSize;
	}

	public void setIconColor(@ColorInt int color) {
		this.iconColor = color;
		setImageBitmap(textToBitmap(fontText, fontSize, iconColor));
	}

	public int getIconColor() {
		return this.iconColor;
	}

	public void setBackgroundColor(@ColorInt int backgroundColor) {
		this.backgroundColor = backgroundColor;
		updateDrawable();
	}

	public int getBackgroundColor() {
		return this.backgroundColor;
	}

	public void setDisabledColor(@ColorInt int color) {
		this.disabledColor = color;
		updateDrawable();
	}

	public int getDisabledColor() {
		return disabledColor;
	}

	public void setFocusColor(int focusColor) {
		this.focusColor = focusColor;
		updateDrawable();
	}

	public int getFocusColor() {
		return focusColor;
	}

	public void setShape(int shape) {
		this.shape = shape;
		updateDrawable();
	}

	public int getShape() {
		return this.shape;
	}

	/*public void setDisabledColor(@ColorInt int color){
		this.disabledColor  = color;
		updateDrawable();
	}*/

	public void setBorderWidth(int width) {
		this.borderWidth = width;
		updateDrawable();
	}

	public int getBorderWidth() {
		return this.borderWidth;
	}

	public void setBorderColor(@ColorInt int color) {
		this.borderColor = color;
		updateDrawable();
	}

	public int getBorderColor() {
		return borderColor;
	}

	public void setRadius(int radius) {
		this.radius = radius;
		updateDrawable();
	}

	public float getRadius() {
		return radius;
	}


	/*public void setOnClickListener(@Nullable OnClickListener listener){
		this.setOnClickListener(listener);
	}*/
}
