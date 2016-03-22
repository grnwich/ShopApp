package com.app.shop.shopapp.html;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.text.Editable;
import android.text.Html.TagHandler;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.View;

import com.app.shop.shopapp.utils.Common;

import org.xml.sax.XMLReader;

import java.io.File;

public class CTagHandler implements TagHandler {

	private Context context;

	public CTagHandler(Context context) {

		this.context = context;

	}

	@Override
	public void handleTag(boolean opening, String tag, Editable output,

	XMLReader xmlReader) {

		if (tag.toLowerCase().equals("IMG")) {

			int len = output.length();

			ImageSpan[] images = output.getSpans(len - 1, len, ImageSpan.class);

			String imgURL = images[0].getSource();

			output.setSpan(new ImageClick(context, imgURL), len - 1, len,
					Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

		}

	}

	private class ImageClick extends ClickableSpan {

		private String url;

		private Context context;

		public ImageClick(Context context, String url) {

			this.context = context;

			this.url = url;

		}

		@Override
		public void onClick(View widget) {

			String imageName = Common.md5(url);

			String sdcardPath = Environment.getExternalStorageDirectory()
					.toString(); //

			String[] ss = url.split("\\.");

			String ext = ss[ss.length - 1];

			String savePath = sdcardPath + "/pinganjun/"
					+ imageName + "." + ext;

			File file = new File(savePath);

			if (file.exists()) {

				Intent intent = new Intent();

				intent.setAction(Intent.ACTION_VIEW);

				intent.setDataAndType(Uri.fromFile(file), "image/*");

				context.startActivity(intent);

				Log.i("Load", "data");

			}

		}

	}

}
