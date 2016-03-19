package com.app.shop.shopapp.html;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.Html.ImageGetter;
import android.util.DisplayMetrics;
import android.widget.TextView;

import com.app.shop.shopapp.R;
import com.app.shop.shopapp.utils.Common;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class CImageGetter implements ImageGetter {

	private Context context;

	private TextView tv;
	private int width;
	private int height;

	public CImageGetter(Context context, TextView tv) {
		this.context = context;
		this.tv = tv;
		DisplayMetrics metrics=context.getResources().getDisplayMetrics();
		width=metrics.widthPixels;
		height=metrics.heightPixels;
	}

	@Override
	public Drawable getDrawable(String source) {

		String imageName = Common.md5(source);

		String sdcardPath = Environment.getExternalStorageDirectory()
				.toString();

		String[] ss = source.split("\\.");

		String ext = ss[ss.length - 1];

		String savePath = sdcardPath + "/pinganjun/"
				+ imageName + "." + ext;

		File file = new File(savePath);

		if (file.exists()) {

			Drawable drawable = Drawable.createFromPath(savePath);
			 drawable.setBounds(10, 20, width,drawable.getMinimumHeight());
			return drawable;

		}

		Resources res = context.getResources();

		URLDrawable drawable = new URLDrawable(
				context,res.getDrawable(R.mipmap.ic_launcher));

		new ImageAsync(drawable).execute(savePath, source);

		return drawable;

	}

	private class ImageAsync extends AsyncTask<String, Integer, Drawable> {

		private URLDrawable drawable;

		public ImageAsync(URLDrawable drawable) {

			this.drawable = drawable;

		}

		@Override
		protected Drawable doInBackground(String... params) {

			String savePath = params[0];

			String url = params[1];

			InputStream in = null;

			try {

				HttpGet http = new HttpGet(url);

				HttpClient client = new DefaultHttpClient();

				HttpResponse response = client.execute(http);

				BufferedHttpEntity bufferedHttpEntity = new BufferedHttpEntity(
						response.getEntity());

				in = bufferedHttpEntity.getContent();

			} catch (Exception e) {

				try {

					if (in != null)

						in.close();

				} catch (Exception e2) {

					// TODO: handle exception

				}

			}

			if (in == null)
				return drawable;

			try {

				File file = new File(savePath);

				String basePath = file.getParent();

				File basePathFile = new File(basePath);

				if (!basePathFile.exists()) {

					basePathFile.mkdirs();

				}

				file.createNewFile();

				FileOutputStream fileout = new FileOutputStream(file);
				byte[] buffer = new byte[4 * 1024];
				while (in.read(buffer) != -1) {
					fileout.write(buffer);
				}
				fileout.flush();
				fileout.close(); // �ر���
				Drawable mDrawable = Drawable.createFromPath(savePath);
				return mDrawable;
			} catch (Exception e) {

			}
			return drawable;
		}

		@Override
		protected void onPostExecute(Drawable result) {

			// TODO Auto-generated method stub

			super.onPostExecute(result);

			if (result != null) {

				drawable.setDrawable(result);

				tv.setText(tv.getText()); // ����UI

			}

		}

	}
}