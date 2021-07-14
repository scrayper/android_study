package com.websarva.wings.android.menusample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView

class MenuSet : AppCompatActivity() {
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
        //戻るメニュー表示のコードを記述 supportActionBarはActionBarを表すプロパティ
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //戻り値用の変数を初期値trueで用意
        var returnVal = true
        //選択されたメニューが戻るの場合アクティビティを終了
        if(item.itemId == android.R.id.home) {
            finish()
        }
        //それ以外
        else {
            //親クラスの同名メソッドを呼び出し、その戻り値をreturnValへ格納
            returnVal = onOptionsItemSelected(item)
        }
        return returnVal
    }
}