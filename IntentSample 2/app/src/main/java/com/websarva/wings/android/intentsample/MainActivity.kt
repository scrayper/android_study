package com.websarva.wings.android.intentsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //画面部品List Viewを取得
        val lvTraining = findViewById<ListView>(R.id.training_menu)
        //Simple Adapterで使用するMutable Listオブジェクトを用意
        //Stringを二つもったmutableMapのcollectionであるMutableListとして変数を宣言する
        val training_menu: MutableList<MutableMap<String, String>> = mutableListOf()
        //「ベンチプレス」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        var menu = mutableMapOf("name" to "ベンチプレス", "set" to "3セット" )
        training_menu.add(menu)
        //「ベンチプレス」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menu = mutableMapOf("name" to "加重ディップス", "set" to "3セット" )
        training_menu.add(menu)
        //以下、データ登録
        menu = mutableMapOf("name" to "ダンベルフライ", "set" to "2セット" )
        training_menu.add(menu)
        menu = mutableMapOf("name" to "インクラインダンベルフライ", "set" to "2セット" )
        training_menu.add(menu)
        menu = mutableMapOf("name" to "バーベルスクワット", "set" to "2セット" )
        training_menu.add(menu)
        menu = mutableMapOf("name" to "ハックスクワット", "set" to "2セット" )
        training_menu.add(menu)
        menu = mutableMapOf("name" to "ブルガリアンスクワット", "set" to "2セット" )
        training_menu.add(menu)
        menu = mutableMapOf("name" to "レッグカール", "set" to "3セット" )
        training_menu.add(menu)
        menu = mutableMapOf("name" to "レッグエクステンション", "set" to "3セット" )
        training_menu.add(menu)
        menu = mutableMapOf("name" to "加重チンニング", "set" to "3セット" )
        training_menu.add(menu)
        menu = mutableMapOf("name" to "加重チンニング(パラレルグリップ)", "set" to "3セット" )
        training_menu.add(menu)
        menu = mutableMapOf("name" to "プルオーバー", "set" to "3セット" )
        training_menu.add(menu)
        menu = mutableMapOf("name" to "アーノルドプレス", "set" to "3セット" )
        training_menu.add(menu)
        menu = mutableMapOf("name" to "インクラインサイドレイズ", "set" to "2セット" )
        training_menu.add(menu)
        menu = mutableMapOf("name" to "ライングリア", "set" to "3セット" )
        training_menu.add(menu)

        //Simple Adapter第4引数from用データの用意
        val from = arrayOf("name", "set")
        //SimpleAdapter第5引数to用データの用意
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)
        //SimpleAdapterオブジェクトを生成
        val adapter = SimpleAdapter(this@MainActivity,training_menu,android.R.layout.simple_list_item_2,from,to)
        //リストビューにアダプタを設定
        lvTraining.adapter = adapter

        //リスナクラスのインスタンスを作成して、リスナ設定メソッドの引数として渡す(この場合はプロパティでsetterを呼び出す)
        lvTraining.onItemClickListener = ListItemClickListener()

    }


    //リスナクラスの作成
    private inner class ListItemClickListener :AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            //イベントハンドラの記述
            //タップされた行のデータを取得する。SimpleAdapterではMutableMap型
            val line_data = parent?.getItemAtPosition(position) as MutableMap<String, String>
            //定食名/金額を変数として取得する
            val menuName = line_data["name"]
            val menuSet = line_data["set"]
            //第二画面へ遷移
            //インテントオブジェクトを生成
            val intent2MenuSet = Intent(this@MainActivity,MenuSetActivity::class.java)
            //第二画面へ送るデータを格納
            intent2MenuSet.putExtra("menuName", menuName)
            intent2MenuSet.putExtra("menuSet", menuSet)
            //第二画面を起動
            startActivity(intent2MenuSet)
        }
    }

}