package com.websarva.wings.android.menusample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity

class MainActivity : AppCompatActivity() {
    //リストビューに表示するリストデータ
    private lateinit var _training_menu: MutableList<MutableMap<String, String>>
    //SimpleAdapterの第4引数fromに使用するプロパティ
    val _from = arrayOf("name", "set")
    //SimpleAdapterの第5引数toに使用するプロパティ
    val _to = intArrayOf(R.id.MenuNameRow, R.id.set_amount_row)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_set)

        //定食メニューListオブジェクトをprivateメソッドを利用して用意し、プロパティへ格納
        _training_menu = createKintoreList()
        //画面部品ListViewを取得
        val lvTraining = findViewById<ListView>(R.id.training_menu)

        //SimpleAdapterを生成
        val adapter = SimpleAdapter(this@MainActivity, _training_menu,R.layout.row,_from,_to)

        //アダプタの登録
        lvTraining.adapter = adapter

        //リストタップのリスナクラス登録
        lvTraining.onItemClickListener = ListItemClickListener()

        //コンテキストメニューの登録
        registerForContextMenu(lvTraining)
    }

    //筋トレメニューリストをprivateメソッド化
    private fun createKintoreList(): MutableList<MutableMap<String, String>> {

        //筋トレメニューリスト用のリストオブジェクトを用意
        val training_menu: MutableList<MutableMap<String, String>> = mutableListOf()
        //「ベンチプレス」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        var menu = mutableMapOf("name" to "ベンチプレス", "set" to "3", "desc" to "Big3の1つ。大胸筋をはじめとした上半身の全面を鍛えます。")
        training_menu.add(menu)
        //「ベンチプレス」のデータを格納するMapオブジェクトの用意とmenuListへのデータ登録
        menu = mutableMapOf("name" to "加重ディップス", "set" to "3","desc" to "隠れた最高の胸トレ")
        training_menu.add(menu)
        //以下、データ登録
        menu = mutableMapOf("name" to "ダンベルフライ", "set" to "2","desc" to "Big3の1つ。大胸筋をはじめとした上半身の全面を鍛えます。")
        training_menu.add(menu)
        menu = mutableMapOf("name" to "インクラインダンベルフライ", "set" to "2" ,"desc" to "Big3の1つ。大胸筋をはじめとした上半身の全面を鍛えます。")
        training_menu.add(menu)
        menu = mutableMapOf("name" to "バーベルスクワット", "set" to "2","desc" to "Big3の1つ。大胸筋をはじめとした上半身の全面を鍛えます。" )
        training_menu.add(menu)
        menu = mutableMapOf("name" to "ハックスクワット", "set" to "2","desc" to "Big3の1つ。大胸筋をはじめとした上半身の全面を鍛えます。" )
        training_menu.add(menu)
        menu = mutableMapOf("name" to "ブルガリアンスクワット", "set" to "2","desc" to "Big3の1つ。大胸筋をはじめとした上半身の全面を鍛えます。" )
        training_menu.add(menu)
        menu = mutableMapOf("name" to "レッグカール", "set" to "3","desc" to "Big3の1つ。大胸筋をはじめとした上半身の全面を鍛えます。" )
        training_menu.add(menu)
        menu = mutableMapOf("name" to "レッグエクステンション", "set" to "3","desc" to "Big3の1つ。大胸筋をはじめとした上半身の全面を鍛えます。" )
        training_menu.add(menu)
        menu = mutableMapOf("name" to "加重チンニング", "set" to "3","desc" to "Big3の1つ。大胸筋をはじめとした上半身の全面を鍛えます。" )
        training_menu.add(menu)
        menu = mutableMapOf("name" to "加重チンニング(パラレルグリップ)", "set" to "3","desc" to "Big3の1つ。大胸筋をはじめとした上半身の全面を鍛えます。" )
        training_menu.add(menu)
        menu = mutableMapOf("name" to "プルオーバー", "set" to "3","desc" to "Big3の1つ。大胸筋をはじめとした上半身の全面を鍛えます。" )
        training_menu.add(menu)
        menu = mutableMapOf("name" to "アーノルドプレス", "set" to "3","desc" to "Big3の1つ。大胸筋をはじめとした上半身の全面を鍛えます。" )
        training_menu.add(menu)
        menu = mutableMapOf("name" to "インクラインサイドレイズ", "set" to "2","desc" to "Big3の1つ。大胸筋をはじめとした上半身の全面を鍛えます。" )
        training_menu.add(menu)
        menu = mutableMapOf("name" to "ライングリア", "set" to "3","desc" to "Big3の1つ。大胸筋をはじめとした上半身の全面を鍛えます。" )
        training_menu.add(menu)

        return training_menu
    }
    //フリーウェイトメニューリストを生成するメソッドを追加する
    private fun createFreeWeightList() :MutableList<MutableMap<String, String>> {
        //フリーウェイト用のリストオブジェクトを用意
        var free_weight_menu :MutableList<MutableMap<String,String>> = mutableListOf()

        //ベンチプレスを格納
        var barbell_menu = mutableMapOf("name" to "ベンチプレス", "set" to "3", "desc" to "Big3の1つ。大胸筋をはじめとした上半身の全面を鍛えます。")
        free_weight_menu.add(barbell_menu)
        //デッドリフトを格納
        barbell_menu = mutableMapOf("name" to "デッドリフト", "set" to "3", "desc" to "Big3の1つ。背面全体を鍛えます。")
        free_weight_menu.add(barbell_menu)
        barbell_menu = mutableMapOf("name" to "スクワット", "set" to "3", "desc" to "Big3の1つ。下半身全体を鍛えます。")
        free_weight_menu.add(barbell_menu)
        barbell_menu = mutableMapOf("name" to "バーベルショルダープレス", "set" to "3", "desc" to "Big3の1つ。大胸筋をはじめとした上半身の全面を鍛えます。")
        free_weight_menu.add(barbell_menu)
        barbell_menu = mutableMapOf("name" to "バーベルローイング", "set" to "3", "desc" to "Big3の1つ。大胸筋をはじめとした上半身の全面を鍛えます。")
        free_weight_menu.add(barbell_menu)
        barbell_menu = mutableMapOf("name" to "バーベルブルガリアんスクワット", "set" to "3", "desc" to "Big3の1つ。大胸筋をはじめとした上半身の全面を鍛えます。")
        free_weight_menu.add(barbell_menu)
        barbell_menu = mutableMapOf("name" to "ダンベルフライ", "set" to "3", "desc" to "Big3の1つ。大胸筋をはじめとした上半身の全面を鍛えます。")
        free_weight_menu.add(barbell_menu)
        barbell_menu = mutableMapOf("name" to "インクラインダンベルフライ", "set" to "3", "desc" to "Big3の1つ。大胸筋をはじめとした上半身の全面を鍛えます。")
        free_weight_menu.add(barbell_menu)

        //リストオブジェクトをreturnする
        return free_weight_menu
    }


    //リスナクラスの作成
    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            //イベントハンドラの記述
            //タップされた行のデータを取得する。SimpleAdapterではMutableMap型
            val line_data = parent?.getItemAtPosition(position) as MutableMap<String, String>
           //設定処理
            order(line_data)
        }
    }

    //オプションメニューの実装
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //オプションメニュー用xmlファイルをインフレイト(.xmlに記述されたメニュー部品がJAVAオブジェクトになる)
        menuInflater.inflate(R.menu.menu_options_menu_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //戻り値用の変数を初期値trueで用意
        var returnVal = true
        //選択されたメニューのIDのR値による処理の分岐
        when(item.itemId) {
            //筋トレメニューが選択された場合の処理
            R.id.menu_list_options_all ->
                //筋トレメニューリストデータの生成
                _training_menu = createKintoreList()
            //フリーウェイトメニューが選択された場合の処理
            R.id.menu_list_option_free_weight ->
                //フリーウェイトメニューリストデータの生成
                _training_menu = createFreeWeightList()
            //それ意外
            else ->
                //親クラスの同名メソッドを呼び出し、その戻り値をreturnValとする
                returnVal = super.onOptionsItemSelected(item)
        }
        //画面部品ListViewを取得
        val lvTraining = findViewById<ListView>(R.id.training_menu)

        //SimpleAdapterを選択されたメニューデータで生成
        val adapter = SimpleAdapter(this@MainActivity, _training_menu,R.layout.row,_from,_to)

        //アダプタの登録
        lvTraining.adapter = adapter
        return returnVal

    }

    //コンテキストメニューの実装
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        //親クラスの同名メソッドの呼び出し
        super.onCreateContextMenu(menu, v, menuInfo)
        //コンテキストメニュー用xmlファイルをインフレート
        menuInflater.inflate(R.menu.menu_context_menu_list, menu)
        //コンテキストメニューのヘッダタイトルを設定
        menu?.setHeaderTitle(R.string.list_context_header)
    }

    //再利用できるように、画面を遷移するという処理を一つのprivateメソッドとして切り出す
    private fun order(menu: MutableMap<String, String>) {
            //メニュー名/セット数を変数として取得する
            val menuName = menu["name"] as String
            val menuSet = menu["set"] as Int
            //第二画面へ遷移
            //インテントオブジェクトを生成
            val intent2MenuSet = Intent(this@MainActivity, MenuSet::class.java)
            //第二画面へ送るデータを格納
            intent2MenuSet.putExtra("menuName", menuName)
            intent2MenuSet.putExtra("menuSet", menuSet)
            //第二画面を起動
            startActivity(intent2MenuSet)

    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        //戻り値用の変数を初期値trueで用意
        var returnVal = true
        //長押しされたビューに関する情報が格納されたオブジェクトを取得
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        //長押しされたリストのポジションを取得
        val listPosition = info.position
        //ポジションから長押しされたメニュー情報Mapオブジェクトを取得
        val menu = _training_menu[listPosition]
        //選択されたメニューIDのR値による処理の分岐
        when(item.itemId) {
            //「説明を表示」メニューが選択されたとき
            R.id.menuListConstextDesc -> {
                //メニューの説明文字列を取得
                val menu_desc = menu["desc"] as String
                //トーストの表示
                Toast.makeText(this@MainActivity, menu_desc, Toast.LENGTH_LONG).show()
            }
            //[メニューに追加]メニューが選択された時
            R.id.menuListContextOrder -> {
                //設定処理　画面遷移functionのorderを呼び出す
                order(menu)
            }
            //それ以外
            else ->
                //親クラスの同名メソッドを呼び出して、その戻り値をreturnValとする
                returnVal = super.onContextItemSelected(item)
        }
    return returnVal
    }

}

