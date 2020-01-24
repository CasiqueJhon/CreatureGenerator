package com.raywenderlich.android.creaturemon.presenter

import java.lang.ref.WeakReference

abstract class BasePresenter<T> {

    private var view: WeakReference<T>? = null

    fun setView(view: T){
        this.view = WeakReference(view)
    }
    fun getView(): T? = view?.get()
}
