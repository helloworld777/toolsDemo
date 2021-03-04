package com.lyw.buildSrc

object Dependencies {

    object Versions {
        const val kotlin = "1.3.61"
        const val greendao = "3.2.0"
        const val aspectjx = "2.0.4"
        const val symtabfileuploader = "2.2.1"
        const val andResGuard = "1.2.17"
        const val bbasePlugin = "0.3.10"
    }

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    const val junit = "junit:junit:4.12"
    const val stetho = "com.facebook.stetho:stetho:1.5.0"
    const val androidcompat = "com.cootek.bbase:androidcompat:1.0.3"
    const val mpandroidchart = "com.github.PhilJay:MPAndroidChart:v2.2.4"
    const val xtablayout = "com.androidkun:XTabLayout:1.1.4"

    const val timber = "com.jakewharton.timber:timber:4.7.1"

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.0.2"
        const val coreKtx = "androidx.core:core-ktx:1.0.2"
        const val annotation = "androidx.annotation:annotation:1.1.0"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:1.1.3"
        const val recyclerview = "androidx.recyclerview:recyclerview:1.0.0"
        const val activityKtx = "androidx.activity:activity-ktx:1.0.0"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:1.1.0"
        const val paging = "androidx.paging:paging-runtime-ktx:2.1.0"
        const val viewpager2 = "androidx.viewpager2:viewpager2:1.0.0"

        object Lifecycle {
            private const val version = "2.2.0"
            const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
            const val viewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val livedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
            const val process = "androidx.lifecycle:lifecycle-process:$version"
            const val compiler = "androidx.lifecycle:lifecycle-compiler:$version"
        }

        object Room {
            private const val version = "2.1.0"
            const val common = "androidx.room:room-common:$version"
            const val runtime = "androidx.room:room-runtime:$version"
            const val rxjava2 = "androidx.room:room-rxjava2:$version"
            const val compiler = "androidx.room:room-compiler:$version"
            const val ktx = "androidx.room:room-ktx:$version"
            const val testing = "androidx.room:room-testing:$version"
        }

        const val testExt = "androidx.test.ext:junit:1.1.1"
        const val testEspresso = "androidx.test.espresso:espresso-core:3.2.0"
    }

    object Google {
        const val material = "com.google.android.material:material:1.0.0"
    }

    object RxJava {
        const val rxjava = "io.reactivex.rxjava2:rxjava:2.2.10"
        const val rxandroid = "io.reactivex.rxjava2:rxandroid:2.1.1"
        const val rxkotlin = "io.reactivex.rxjava2:rxkotlin:2.3.0"
    }

    object Retrofit {
        private const val version = "2.5.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val rxjavaAdapter = "com.squareup.retrofit2:adapter-rxjava2:$version"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"
    }

    object OkHttp {
        private const val version = "3.12.3"
        const val okhttp = "com.squareup.okhttp3:okhttp:$version"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object Glide {
        private const val version = "4.9.0"
        const val glide = "com.github.bumptech.glide:glide:$version"
        const val compiler = "com.github.bumptech.glide:compiler:$version"
    }

    object LeakCanary {
        private const val version = "1.6.3"
        const val leakcanary = "com.squareup.leakcanary:leakcanary-android:$version"
        const val noop = "com.squareup.leakcanary:leakcanary-android-no-op:$version"
        const val fragment = "com.squareup.leakcanary:leakcanary-support-fragment:$version"
    }

    object DataBase {
        const val greenDao = "org.greenrobot:greendao:3.2.0"
    }

    object immersionBar {
        private const val version = "3.0.0-beta05"
        const val core = "com.gyf.immersionbar:immersionbar:$version"
        const val components = "com.gyf.immersionbar:immersionbar-components:$version"
        const val ktx = "com.gyf.immersionbar:immersionbar-ktx:$version"
    }

    //bbase 相关
    object bbase {
        const val bbase =
            "com.cootek:bbase:6.3.1.0-mainland.202102181811-jpush_vip-glide_v3-kuaishou_3361-naga_header_bidding-risk_whitelist-toutiao_3303-delay_bugly-zhuiguang-new_domain_path-naga_174-bugly_150"
    }

    //smart refresh 相关
    object smartRefresh {
        const val smartrefresh = "com.scwang.smartrefresh:SmartRefreshLayout:1.1.0"
        const val smartheader = "com.scwang.smartrefresh:SmartRefreshHeader:1.1.0"
    }

    const val cpermission = "com.gz.gb:cpermission:1.0.4-mainland"

    const val lottie = "com.github.easytome:lottie-android:3.4.0-fix-hardware-202004171211"

    const val wechat = "com.tencent.mm.opensdk:wechat-sdk-android-without-mta:5.5.8"


    const val toastcompat = "me.drakeet.support:toastcompat:1.1.0"

    const val calendarview = "com.haibin:calendarview:3.6.7"

    const val circleImageView = "de.hdodenhof:circleimageview:3.0.1"

    const val shimmer = "com.facebook.shimmer:shimmer:0.5.0"

    const val threetenabp = "com.jakewharton.threetenabp:threetenabp:1.2.1"

    const val flexbox = "com.google.android:flexbox:1.1.1"
    
    //第三方推送
    const val mipushw = "com.cootek.lamech:mipushw:1.2.0"

    const val hmswrap = "com.cootek.lamech:hmswrap:2.0.0"

    const val vpushwr = "com.cootek.lamech:vpushwr:0.3.0"

    const val opushwr = "com.cootek.lamech:opushwr:1.0.1"

    const val chatkit = "com.github.stfalcon:chatkit:0.3.3"

    const val indicatorseekbar = "com.github.warkiz.widget:indicatorseekbar:2.1.2"

    const val rxpermission = "com.github.tbruyelle:rxpermissions:0.10.2"

    const val plot = "com.androidplot:androidplot-core:1.5.7"

    const val roundedimageview = "com.makeramen:roundedimageview:2.3.0"

    const val xBanner = "com.github.xiaohaibin:XBanner:androidx_v1.1.2"

    const val cn_permission ="com.cootek.permission.mig:permission:real_money_1.0.3"

    const val tplog= "com.cootek.dialer.base:tplog:0.2.3"

    const val barcodescanner = "me.dm7.barcodescanner:zxing:1.9.13"

    const val multitype = "me.drakeet.multitype:multitype:3.4.2"

    const val mmkv = "com.tencent:mmkv:1.0.22"

    const val marquee = "com.gongwen:marqueelibrary:1.1.3"

}
