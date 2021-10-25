package com.softmoon.common

import android.view.View
import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout

@BindingAdapter("app:errorText")
fun errorText(view: View, error: String?) {
    when (view) {
        is TextInputLayout -> {
            view.error = error
        }
    }
}