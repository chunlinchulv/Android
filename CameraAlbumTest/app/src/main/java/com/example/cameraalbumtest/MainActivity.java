package com.example.cameraalbumtest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button takePhote;
    private Button chooseFromAlbum;
    public static final int TAKE_PHOTO = 1;
    public static final int CHOOSE_PHOTO = 2;
    private ImageView picture;
    private Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        takePhote = (Button)findViewById(R.id.take_photo);
        picture = (ImageView)findViewById(R.id.picture);
        chooseFromAlbum = (Button)findViewById(R.id.choose_from_album);
        chooseFromAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this,new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                }else {
                    openAlbum();
                }
            }
        });

        takePhote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //创建File对象，用于存储拍照后的图片
                File outputImage = new File(getExternalCacheDir(),"output_image.jpg");
                try {
                    if(outputImage.exists()) {
                    outputImage.delete();
                }
                    outputImage.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(Build.VERSION.SDK_INT>=24) {
                    imageUri = FileProvider.getUriForFile(MainActivity.this,"com.example.cameraalbumtest.fileprovider",outputImage);
                }else {
                    imageUri = Uri.fromFile(outputImage);
                }

                //启动相机程序
                Intent intent =new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                startActivityForResult(intent,TAKE_PHOTO);
            }
        });
    }
    private void openAlbum() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");            //允许用户选择特殊种类的数据，并返回（特殊种类的数据：照一张相片或录一段音
        intent.setType("image/*");     //选择图片
        startActivityForResult(intent,CHOOSE_PHOTO);            //第二个参数用于辨别由哪一个活动返回
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode) {
            case 1:
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openAlbum();
                }else {
                    Toast.makeText(this, "You denied the permission", Toast.LENGTH_SHORT).show();
                }
                break;
                default:
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case TAKE_PHOTO:
                if(resultCode == RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        picture.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            case CHOOSE_PHOTO:
                if(resultCode ==RESULT_OK) {
                    //判断手机系统的版本号
                    if(Build.VERSION.SDK_INT >= 19) {
                        handleImageOnKitKat(data);
                    }else {
                        handleImageBeforeKitKat(data);
                    }
                }
        }
    }

    private void handleImageBeforeKitKat(Intent data) {

    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void handleImageOnKitKat(Intent data) {
        String imagePath = null;
        Uri uri = data.getData();
        if(DocumentsContract.isDocumentUri(this,uri)) {
        }
    }
}
