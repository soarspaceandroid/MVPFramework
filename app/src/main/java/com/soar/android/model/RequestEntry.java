package com.soar.android.model;

import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by gaofei on 2016/4/26.
 */
public interface RequestEntry {

    /**
     * 获取picinfo
     * @return
     */
    @POST("/tnfs/api/list")
    public Observable<PicInfoOutput> getPicInfo(@Query("id") int id);
}
