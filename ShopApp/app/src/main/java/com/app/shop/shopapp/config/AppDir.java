package com.app.shop.shopapp.config;

import java.io.File;

/**
 * <请描述这个类是干什么的>
 *
 * @author lwli
 * @data: 2016/2/17 10:25
 * @version: V1.0
 */
public class AppDir {
    public enum AppDirEnum {

        ROOT_DIR("ShopApp"), IMAGE("ImgCache"), CACHE("cache"), VOLLEY("volley"),
        UPLOAD_IMAGE_TEMP("ImgUploadTemp"), DOWNLOAD("download"), CRASH_LOGS("Log")
        ,HTML_FILE("m"),OFFLINE_CACEH("tmp");

        private String value;
        AppDirEnum(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public static File getRootDir() {
        File file = new File(
                android.os.Environment.getExternalStorageDirectory(),
                AppDirEnum.ROOT_DIR.getValue());

        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }

        return file;
    }

    public static File getDir(AppDirEnum dirEnum) {
        File file = new File(getRootDir(), dirEnum.getValue());
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        return file;
    }
}
