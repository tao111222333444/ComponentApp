package com.hugo.base.net

import com.hugo.base.net.exception.OtherException
import com.hugo.base.net.exception.ServerException
import com.hugo.base.utils.Utils

import org.reactivestreams.Publisher

import io.reactivex.Flowable
import io.reactivex.FlowableTransformer
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers

/**
 * @author 作者：hugo
 * @date 时间：2018/7/19.
 * 版本：v1.0
 * 描述：RxJava 工具类
 */
object RxUtils {


    /**
     * 统一线程处理
     * @param <T> 指定的泛型类型
     * @return  FlowableTransformer
    </T> */
    fun <T> rxFlSchedulerHelper(): FlowableTransformer<T, T> {
        return FlowableTransformer { upstream ->
            upstream.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }

    /**
     * 统一线程处理
     * @param <T> 指定的泛型类型
     * @return ObservableTransformer
    </T> */
    fun <T> rxSchedulerHelper(): ObservableTransformer<T, T> {
        return ObservableTransformer { observable ->
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }


    /**
     * 统一返回结果处理
     * @param <T>  指定的泛型类型
     * @return ObservableTransformer
    </T> */
    fun <T> handleResult(): ObservableTransformer<BaseResponse<T>, T> {
        return ObservableTransformer { responseObservable ->
            return@ObservableTransformer responseObservable.flatMap(Function<BaseResponse<T>,Observable<T>> {baseResponse ->
                return@Function if (baseResponse.errorCode >= BaseResponse.SUCCESS
                    && baseResponse.data != null
                    && NetworkUtils.isNetworkConnected()) {
                createData(baseResponse.data)
            } else {
                Observable.error(ServerException(
                        baseResponse.errorMsg, baseResponse.errorCode))
            }
            })
        }
    }

    /**
     * 没有数据的接口   返回结果处理
     * @param <T> 指定的泛型类型
     * @return ObservableTransformer
    </T> */
    fun <T> handleNotDataResult(): ObservableTransformer<BaseResponse<T>, T> {
        return ObservableTransformer{ responseObservable ->
            return@ObservableTransformer responseObservable.flatMap(Function<BaseResponse<T>,Observable<T>>{ baseResponse ->
                return@Function if (baseResponse.errorCode >= BaseResponse.SUCCESS
                        && NetworkUtils.isNetworkConnected()) {
                    //TODO  这是是未完成的
                    createData (Utils.cast(Any()))
                } else {
                   Observable . error( OtherException())
                }
            } )
        }
    }

    /**
     * 得到Observable
     * @param <T> 指定的泛型类型
     * @return Observable
    </T> */
    private fun <T> createData(t: T): Observable<T> {
        return Observable.create { emitter ->
            try {
                emitter.onNext(t)
                emitter.onComplete()
            } catch (e: Exception) {
                emitter.onError(e)
            }
        }
    }
}
