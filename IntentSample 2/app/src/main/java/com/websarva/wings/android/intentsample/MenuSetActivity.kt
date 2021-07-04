package com.websarva.wings.android.intentsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.TextureView
import android.view.View
import android.widget.TextView

class MenuSetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_set)

        //リスト画面から渡されたデータを取得
        val menuName = intent.getStringExtra("menuName")
        val menuSet = intent.getStringExtra("menuSet")
        //定食名と金額を表示させるText Viewを取得
        val TextMenuName = findViewById<TextView>(R.id.sec_menu_name)
        val TextMenuSet = findViewById<TextView>(R.id.sec_menu_set)
        //TextViewに定食名を金額を表示
        TextMenuName.text = menuName
        TextMenuSet.text = menuSet
    }

    fun onBackButtonClick(view: View) {
        finish()
    }
}