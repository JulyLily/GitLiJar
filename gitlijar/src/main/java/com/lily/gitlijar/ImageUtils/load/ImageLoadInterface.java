package com.lily.gitlijar.ImageUtils.load;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.lily.gitlijar.ImageUtils.ImgUtilsType;

public interface ImageLoadInterface {

    void ImageLoad(Context mContext, ImageView mImageView, String url);

    void ImageLoad(Context mContext, ImageView mImageView, String url, int mErrorOrPlacePath,ImgUtilsType loadType);

    void ImageLoad(Context mContext, ImageView mImageView, String url, int mErrorPath, int placeHolderPath);

    Bitmap ImageDownLoad(String loadUrl);
}