package com.ornach.magicicon;


import android.content.Context;
import android.graphics.Typeface;

public class FontHelper {

	private static final String TYPEFACE_MATERIAL_ICON = "fonts/material-icons-regular.ttf";
	private static final String TYPEFACE_AWESOME = "fonts/fontawesome-webfont.ttf";
	private static final String TYPEFACE_IONICONS = "fonts/ionicons.ttf";

	public static final int MATERIAL_ICON = 1001;
	public static final int FONT_AWESOME = 1002;
	public static final int IONICONS = 1003;


	protected static Typeface getMaterialIconTypeface(Context context) {
		// https://github.com/google/material-design-icons
		// https://material.io/icons/
		return Typeface.createFromAsset(context.getAssets(), TYPEFACE_MATERIAL_ICON);
	}

	protected static Typeface getAwesomeTypeface(Context context) {
		return Typeface.createFromAsset(context.getAssets(), TYPEFACE_AWESOME);
	}

	protected static Typeface getIoniconsTypeface(Context context) {
		return Typeface.createFromAsset(context.getAssets(), TYPEFACE_IONICONS);
	}

	protected static Typeface getTypeface(Context context, int typefaceCode) {
		Typeface iconTypeface = null;

		switch (typefaceCode) {
			case IONICONS:
				iconTypeface = FontHelper.getIoniconsTypeface(context);
				break;

			case FONT_AWESOME:
				iconTypeface = FontHelper.getAwesomeTypeface(context);
				break;

			case MATERIAL_ICON:
			default:
				iconTypeface = FontHelper.getMaterialIconTypeface(context);
				//Log.e("TAG","FONT_AWESOME");
				break;
		}

		return iconTypeface;
	}

	protected static int getDefaultFontCode() {
		return MATERIAL_ICON;
	}
}
