package com.fastaccess.ui.adapter.viewholder

import android.annotation.SuppressLint
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import com.fastaccess.R
import com.fastaccess.data.dao.model.Login
import com.fastaccess.ui.widgets.AvatarLayout
import com.fastaccess.ui.widgets.FontTextView
import com.fastaccess.ui.widgets.bindOptionalView
import com.fastaccess.ui.widgets.bindView
import com.fastaccess.ui.widgets.recyclerview.BaseRecyclerAdapter
import com.fastaccess.ui.widgets.recyclerview.BaseViewHolder

/**
 * Created by Kosh on 09 Jul 2017, 4:54 PM
 */

class LoginViewHolder private constructor(itemView: View, adapter: BaseRecyclerAdapter<*, *, *>?) :
        BaseViewHolder<Login>(itemView, adapter) {
    val avatarLayout: AvatarLayout? by bindOptionalView(R.id.avatarLayout)
    val title: FontTextView by bindView(R.id.title)

    @SuppressLint("SetTextI18n")
    override fun bind(login: Login) {
        avatarLayout?.setUrl(login.avatarUrl, null, false, false)
        title.text = if (login.isIsEnterprise) {
            "${login.login} ${Uri.parse(login.enterpriseUrl).authority}"
        } else {
            login.login
        }
    }

    companion object {
        fun newInstance(parent: ViewGroup, adapter: BaseRecyclerAdapter<*, *, *>, small: Boolean): LoginViewHolder {
            return LoginViewHolder(BaseViewHolder.getView(parent, if (small) R.layout.login_row_item_menu else R.layout.login_row_item), adapter)
        }
    }
}
