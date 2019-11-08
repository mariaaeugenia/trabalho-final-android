package com.dflm.mudeja.presenter.user.view

import android.os.Bundle
import androidx.lifecycle.Observer
import com.dflm.mudeja.R
import com.dflm.mudeja.presenter.base.BaseActivity
import com.dflm.mudeja.presenter.user.state.UserState
import com.dflm.mudeja.presenter.user.viewmodel.UserViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class SignInActivity : BaseActivity() {

    private val userViewModel: UserViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        setupViewModel()
    }

    private fun setupViewModel() {
        userViewModel.userState.observe(this, Observer { state ->
            when (state) {
                is UserState.ShowLoading -> showLoading()
                is UserState.HideLoading -> hideLogind()
                is UserState.ShowErro -> showError()
            }
        })
    }

    private fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
