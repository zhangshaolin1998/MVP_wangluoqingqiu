package com.bawei.lianxi;

import android.app.Application;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;

/**
 * Created by 于俊建 on 2017/10/31.
 */

public class MyApp extends Application {


     @Override
         public void onCreate() {
             super.onCreate();
             String clode = Environment.getExternalStorageDirectory()+"/1507B";
             File file=new File(clode);
             ImageLoaderConfiguration colder=new ImageLoaderConfiguration.Builder(this)
                     .threadPoolSize(5)
                     .threadPriority(100)
                     .memoryCacheSize(2*1024*1024)
                     .memoryCacheExtraOptions(200,200)
                     .diskCache(new UnlimitedDiskCache(file))
                     .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                     .diskCacheSize(50*1024)
                     .build();

             ImageLoader.getInstance().init(colder);


         }
         public static DisplayImageOptions getDisp(){

                DisplayImageOptions options=new DisplayImageOptions.Builder()
                        .cacheInMemory(true)
                        .cacheOnDisk(true)
                        .build();



            return options;
         }

}
