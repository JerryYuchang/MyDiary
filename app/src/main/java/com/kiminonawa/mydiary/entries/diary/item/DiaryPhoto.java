package com.kiminonawa.mydiary.entries.diary.item;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;

import com.kiminonawa.mydiary.shared.gui.DiaryPhotoLayout;

import java.io.File;

/**
 * Created by daxia on 2016/11/19.
 */

public class DiaryPhoto implements IDairyRow {

    private DiaryPhotoLayout diaryPhotoLayout;
    private String photoFileName;
    private int position;

    //For Save
    private Bitmap tempBitmap;

    public DiaryPhoto(Context context) {
        diaryPhotoLayout = new DiaryPhotoLayout(context);
        //Default is editable
        setEditMode(true);
    }

    public void setDeleteClickListener(int positionTag, View.OnClickListener clickListener) {
        diaryPhotoLayout.setDeleteOnClick(clickListener);
        diaryPhotoLayout.setPositiontag(positionTag);
    }

    public void setPhoto(Bitmap bitmap, String photoFileName) {
        this.photoFileName = photoFileName;
        diaryPhotoLayout.setPhotoBitmap(bitmap);
    }

    public ImageView getPhoto() {
        return diaryPhotoLayout.getPhoto();
    }


    public Bitmap getTempBitmap() {
        return tempBitmap;
    }

    public void setTempBitmap(Bitmap tempBitmap) {
        this.tempBitmap = tempBitmap;
    }

    @Override
    public void setContent(String content) {
        //This content is path
        File imgFile = new File(content);
        if (imgFile.exists()) {
            Bitmap bitmap = BitmapFactory.decodeFile(content);
            diaryPhotoLayout.getPhoto().setImageBitmap(bitmap);
        }
    }

    @Override
    public void setPosition(int position) {
        this.position = position;
        diaryPhotoLayout.setPositiontag(position);
    }

    @Override
    public int getPosition() {
        return position;
    }

    @Override
    public int getType() {
        return TYPE_PHOTO;
    }

    @Override
    public View getView() {
        return diaryPhotoLayout;
    }

    @Override
    public void setEditMode(boolean isEditMode) {
        diaryPhotoLayout.setVisibleViewByMode(isEditMode);
    }

    @Override
    public String getContent() {
        return photoFileName;
    }

}
