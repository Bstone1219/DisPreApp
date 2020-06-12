package com.example.dispreapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.Button
import android.widget.ScrollView
import android.widget.TextView
import com.example.dispreapp.consts.CorrespondenceActivityTextConst
import kotlinx.android.synthetic.main.activity_correct_action.*
import android.view.View.INVISIBLE as ViewINVISIBLE

/***************************
 画面名：適切な行動
****************************/

class CorrectActionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_correct_action)

        // レイアウトのID取得
        val toTop = findViewById<TextView>(R.id.toTop)
        val placeAndCorresScroll = findViewById<ScrollView>(R.id.placeAndCorresScroll)
        val otherCorrectActionScroll = findViewById<ScrollView>(R.id.otherCorrectActionScroll)
        val insideBtn = findViewById<Button>(R.id.inside)
        val outsideBtn = findViewById<Button>(R.id.outside)
        val dummy1 = findViewById<Button>(R.id.dummy1)
        val dummy2 = findViewById<Button>(R.id.dummy2)
        val dummy3 = findViewById<Button>(R.id.dummy3)
        val dummy4 = findViewById<Button>(R.id.dummy4)
        val dummy5 = findViewById<Button>(R.id.dummy5)
        val dummy6 = findViewById<Button>(R.id.dummy6)

        // ボタンのレイアウト
        val noPush = R.drawable.shape_rounded_corners_5dp_correct_action_before
        val pushed = R.drawable.shape_rounded_corners_5dp_correct_action_after

        //　ボタンフラグ
        var placeAndCorresFlg = 0
        var otherCorrectActionFlg = 0
        var inSideFlg = 0
        var outSideFlg = 0
        var dummySwitchFlg = 0
        var dummyBtnNum = 0

        // backボタン押下処理
        backButton.setOnClickListener {
            finish()
        }

        // 「TOPへ」押下処理
        toTop.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        toTop.movementMethod = LinkMovementMethod.getInstance()
        toTop.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        // 「発生場所と対応」押下処理
        placeAndCorres.setOnClickListener {

            if (placeAndCorresFlg == 1) {
                placeAndCorresScroll.visibility = View.GONE
                placeAndCorresFlg = 0
            }
            if (otherCorrectActionFlg == 1) {
                otherCorrectActionScroll.visibility = View.GONE
                otherCorrectActionFlg = 0
            }
            if (insideBtn.visibility == View.VISIBLE && outsideBtn.visibility == View.VISIBLE) {
                placeAndCorres.setBackgroundResource(noPush)
                inside.setBackgroundResource(noPush)
                outside.setBackgroundResource(noPush)
                dummy1.setBackgroundResource(noPush)
                dummy2.setBackgroundResource(noPush)
                dummy3.setBackgroundResource(noPush)
                dummy4.setBackgroundResource(noPush)
                dummy5.setBackgroundResource(noPush)
                dummy6.setBackgroundResource(noPush)
                insideBtn.visibility = View.GONE
                outsideBtn.visibility = View.GONE
                if (dummySwitchFlg == 1) {
                    dummy1.visibility = View.GONE
                    dummy2.visibility = View.GONE
                    dummy3.visibility = View.GONE
                    dummy4.visibility = View.GONE
                    dummy5.visibility = View.GONE
                    dummy6.visibility = View.GONE
                }
                inSideFlg = 0
                outSideFlg = 0
                dummySwitchFlg = 0
                dummyBtnNum = 0
            } else {
                placeAndCorres.setBackgroundResource(pushed)
                otherCorrectAction.setBackgroundResource(noPush)
                insideBtn.visibility = View.VISIBLE
                outsideBtn.visibility = View.VISIBLE
            }
        }

        // 「その他正しい行動」押下処理
        otherCorrectAction.setOnClickListener {

            if (insideBtn.visibility == View.VISIBLE && outsideBtn.visibility == View.VISIBLE) {
                inside.setBackgroundResource(noPush)
                outside.setBackgroundResource(noPush)
                dummy1.setBackgroundResource(noPush)
                dummy2.setBackgroundResource(noPush)
                dummy3.setBackgroundResource(noPush)
                dummy4.setBackgroundResource(noPush)
                dummy5.setBackgroundResource(noPush)
                dummy6.setBackgroundResource(noPush)
                insideBtn.visibility = View.GONE
                outsideBtn.visibility = View.GONE
                if (dummySwitchFlg == 1) {
                    dummy1.visibility = View.GONE
                    dummy2.visibility = View.GONE
                    dummy3.visibility = View.GONE
                    dummy4.visibility = View.GONE
                    dummy5.visibility = View.GONE
                    dummy6.visibility = View.GONE
                }
                if (placeAndCorresFlg == 1) {
                    placeAndCorresScroll.visibility = View.GONE
                    placeAndCorresFlg = 0
                }
                dummySwitchFlg = 0
                inSideFlg = 0
                outSideFlg = 0
            }
            if (otherCorrectActionFlg == 0) {
                otherCorrectAction.setBackgroundResource(pushed)
                placeAndCorres.setBackgroundResource(noPush)
                otherCorrectActionScroll.visibility = View.VISIBLE
                otherCorrectActionFlg = 1
            } else {
                otherCorrectAction.setBackgroundResource(noPush)
                otherCorrectActionScroll.visibility = View.GONE
                otherCorrectActionFlg = 0
            }
        }

        // 「室内」押下処理
        inside.setOnClickListener {

            if (placeAndCorresFlg == 1) {
                placeAndCorresScroll.visibility = View.GONE
                placeAndCorresFlg = 0
                dummyBtnNum = 0
            }
            if ((inSideFlg == 0 && outSideFlg == 0) || outSideFlg == 1) {
                dummy1.text = "自宅"
                dummy2.text = "睡眠時"
                dummy3.text = "入浴中"
                dummy4.text = "台所"
                dummy5.text = "職場"
                dummy6.text = "エレベーター"
                if (dummySwitchFlg == 0) {
                    dummy1.visibility = View.VISIBLE
                    dummy2.visibility = View.VISIBLE
                    dummy3.visibility = View.VISIBLE
                    dummy4.visibility = View.VISIBLE
                    dummy5.visibility = View.VISIBLE
                    dummy6.visibility = View.VISIBLE
                    dummySwitchFlg = 1
                }
                inside.setBackgroundResource(pushed)
                outside.setBackgroundResource(noPush)
                dummy1.setBackgroundResource(noPush)
                dummy2.setBackgroundResource(noPush)
                dummy3.setBackgroundResource(noPush)
                dummy4.setBackgroundResource(noPush)
                dummy5.setBackgroundResource(noPush)
                dummy6.setBackgroundResource(noPush)
                inSideFlg = 1
                outSideFlg = 0
            } else if (dummySwitchFlg == 1) {
                dummy1.visibility = View.GONE
                dummy2.visibility = View.GONE
                dummy3.visibility = View.GONE
                dummy4.visibility = View.GONE
                dummy5.visibility = View.GONE
                dummy6.visibility = View.GONE
                inside.setBackgroundResource(noPush)
                dummy1.setBackgroundResource(noPush)
                dummy2.setBackgroundResource(noPush)
                dummy3.setBackgroundResource(noPush)
                dummy4.setBackgroundResource(noPush)
                dummy5.setBackgroundResource(noPush)
                dummy6.setBackgroundResource(noPush)
                dummySwitchFlg = 0
                inSideFlg = 0
                outSideFlg = 0
            }
        }

        // 「屋外」押下処理
        outside.setOnClickListener {

            if (placeAndCorresFlg == 1) {
                placeAndCorresScroll.visibility = View.GONE
                placeAndCorresFlg = 0
                dummyBtnNum = 0
            }
            if ((inSideFlg == 0 && outSideFlg == 0) || inSideFlg == 1) {
                dummy1.text = "住宅街"
                dummy2.text = "オフィス街・\n繁華街"
                dummy3.text = "海岸"
                dummy4.text = "川べり"
                dummy5.text = "山・丘陵地"
                dummy6.text = "運転中"
                if (dummySwitchFlg == 0) {
                    dummy1.visibility = View.VISIBLE
                    dummy2.visibility = View.VISIBLE
                    dummy3.visibility = View.VISIBLE
                    dummy4.visibility = View.VISIBLE
                    dummy5.visibility = View.VISIBLE
                    dummy6.visibility = View.VISIBLE
                    dummySwitchFlg = 1
                }
                inside.setBackgroundResource(noPush)
                outside.setBackgroundResource(pushed)
                dummy1.setBackgroundResource(noPush)
                dummy2.setBackgroundResource(noPush)
                dummy3.setBackgroundResource(noPush)
                dummy4.setBackgroundResource(noPush)
                dummy5.setBackgroundResource(noPush)
                dummy6.setBackgroundResource(noPush)
                inSideFlg = 0
                outSideFlg = 1
            } else if (dummySwitchFlg == 1) {
                dummy1.visibility = View.GONE
                dummy2.visibility = View.GONE
                dummy3.visibility = View.GONE
                dummy4.visibility = View.GONE
                dummy5.visibility = View.GONE
                dummy6.visibility = View.GONE
                outside.setBackgroundResource(noPush)
                dummy1.setBackgroundResource(noPush)
                dummy2.setBackgroundResource(noPush)
                dummy3.setBackgroundResource(noPush)
                dummy4.setBackgroundResource(noPush)
                dummy5.setBackgroundResource(noPush)
                dummy6.setBackgroundResource(noPush)
                dummySwitchFlg = 0
                inSideFlg = 0
                outSideFlg = 0
            }
        }

        // 「ダミー1」押下処理
        dummy1.setOnClickListener {

            if (dummyBtnNum == 0 || dummyBtnNum != 1) {
                dummy1.setBackgroundResource(pushed)
                when(dummyBtnNum) {
                    2 -> dummy2.setBackgroundResource(noPush)
                    3 -> dummy3.setBackgroundResource(noPush)
                    4 -> dummy4.setBackgroundResource(noPush)
                    5 -> dummy5.setBackgroundResource(noPush)
                    6 -> dummy6.setBackgroundResource(noPush)
                }
                dummyBtnNum = 1
                if (inSideFlg == 1 && outSideFlg == 0) {
                    placeAndCorresText.text = CorrespondenceActivityTextConst.HOME
                } else if (inSideFlg == 0 && outSideFlg == 1) {
                    placeAndCorresText.text = CorrespondenceActivityTextConst.RESIDENTIAL
                }
                if (placeAndCorresFlg == 0) {
                    placeAndCorresScroll.visibility = View.VISIBLE
                    placeAndCorresFlg = 1
                }
            } else {
                dummy1.setBackgroundResource(noPush)
                placeAndCorresScroll.visibility = View.GONE
                placeAndCorresFlg = 0
                dummyBtnNum = 0
            }
        }

        // 「ダミー2」押下処理
        dummy2.setOnClickListener {

            if (dummyBtnNum == 0 || dummyBtnNum != 2) {
                dummy2.setBackgroundResource(pushed)
                when(dummyBtnNum) {
                    1 -> dummy1.setBackgroundResource(noPush)
                    3 -> dummy3.setBackgroundResource(noPush)
                    4 -> dummy4.setBackgroundResource(noPush)
                    5 -> dummy5.setBackgroundResource(noPush)
                    6 -> dummy6.setBackgroundResource(noPush)
                }
                dummyBtnNum = 2
                if (inSideFlg == 1 && outSideFlg == 0) {
                    placeAndCorresText.text = CorrespondenceActivityTextConst.SLEEPING
                } else if (inSideFlg == 0 && outSideFlg == 1) {
                    placeAndCorresText.text = CorrespondenceActivityTextConst.DOWNTOWN
                }
                if (placeAndCorresFlg == 0) {
                    placeAndCorresScroll.visibility = View.VISIBLE
                    placeAndCorresFlg = 1
                }
            } else {
                dummy2.setBackgroundResource(noPush)
                placeAndCorresScroll.visibility = View.GONE
                placeAndCorresFlg = 0
                dummyBtnNum = 0
            }
        }

        // 「ダミー3」押下処理
        dummy3.setOnClickListener {

            if (dummyBtnNum == 0 || dummyBtnNum != 3) {
                dummy3.setBackgroundResource(pushed)
                when(dummyBtnNum) {
                    1 -> dummy1.setBackgroundResource(noPush)
                    2 -> dummy2.setBackgroundResource(noPush)
                    4 -> dummy4.setBackgroundResource(noPush)
                    5 -> dummy5.setBackgroundResource(noPush)
                    6 -> dummy6.setBackgroundResource(noPush)
                }
                dummyBtnNum = 3
                if (inSideFlg == 1 && outSideFlg == 0) {
                    placeAndCorresText.text = CorrespondenceActivityTextConst.BATHING
                } else if (inSideFlg == 0 && outSideFlg == 1) {
                    placeAndCorresText.text = CorrespondenceActivityTextConst.COAST
                }
                if (placeAndCorresFlg == 0) {
                    placeAndCorresScroll.visibility = View.VISIBLE
                    placeAndCorresFlg = 1
                }
            } else {
                dummy3.setBackgroundResource(noPush)
                placeAndCorresScroll.visibility = View.GONE
                placeAndCorresFlg = 0
                dummyBtnNum = 0
            }
        }

        // 「ダミー4」押下処理
        dummy4.setOnClickListener {

            if (dummyBtnNum == 0 || dummyBtnNum != 4) {
                dummy4.setBackgroundResource(pushed)
                when(dummyBtnNum) {
                    1 -> dummy1.setBackgroundResource(noPush)
                    2 -> dummy2.setBackgroundResource(noPush)
                    3 -> dummy3.setBackgroundResource(noPush)
                    5 -> dummy5.setBackgroundResource(noPush)
                    6 -> dummy6.setBackgroundResource(noPush)
                }
                dummyBtnNum = 4
                if (inSideFlg == 1 && outSideFlg == 0) {
                    placeAndCorresText.text = CorrespondenceActivityTextConst.KITCHEN
                } else if (inSideFlg == 0 && outSideFlg == 1) {
                    placeAndCorresText.text = CorrespondenceActivityTextConst.ROVERSIDE
                }
                if (placeAndCorresFlg == 0) {
                    placeAndCorresScroll.visibility = View.VISIBLE
                    placeAndCorresFlg = 1
                }
            } else {
                dummy4.setBackgroundResource(noPush)
                placeAndCorresScroll.visibility = View.GONE
                placeAndCorresFlg = 0
                dummyBtnNum = 0
            }
        }

        // 「ダミー5」押下処理
        dummy5.setOnClickListener {

            if (dummyBtnNum == 0 || dummyBtnNum != 5) {
                dummy5.setBackgroundResource(pushed)
                when(dummyBtnNum) {
                    1 -> dummy1.setBackgroundResource(noPush)
                    2 -> dummy2.setBackgroundResource(noPush)
                    3 -> dummy3.setBackgroundResource(noPush)
                    4 -> dummy4.setBackgroundResource(noPush)
                    6 -> dummy6.setBackgroundResource(noPush)
                }
                dummyBtnNum = 5
                if (inSideFlg == 1 && outSideFlg == 0) {
                    placeAndCorresText.text = CorrespondenceActivityTextConst.WORKPLACE
                } else if (inSideFlg == 0 && outSideFlg == 1) {
                    placeAndCorresText.text = CorrespondenceActivityTextConst.HILLS
                }
                if (placeAndCorresFlg == 0) {
                    placeAndCorresScroll.visibility = View.VISIBLE
                    placeAndCorresFlg = 1
                }
            } else {
                dummy5.setBackgroundResource(noPush)
                placeAndCorresScroll.visibility = View.GONE
                placeAndCorresFlg = 0
                dummyBtnNum = 0
            }
        }

        // 「ダミー6」押下処理
        dummy6.setOnClickListener {

            if (dummyBtnNum == 0 || dummyBtnNum != 6) {
                dummy6.setBackgroundResource(pushed)
                when(dummyBtnNum) {
                    1 -> dummy1.setBackgroundResource(noPush)
                    2 -> dummy2.setBackgroundResource(noPush)
                    3 -> dummy3.setBackgroundResource(noPush)
                    4 -> dummy4.setBackgroundResource(noPush)
                    5 -> dummy5.setBackgroundResource(noPush)
                }
                dummyBtnNum = 6
                if (inSideFlg == 1 && outSideFlg == 0) {
                    placeAndCorresText.text = CorrespondenceActivityTextConst.ELEVATOR
                } else if (inSideFlg == 0 && outSideFlg == 1) {
                    placeAndCorresText.text = CorrespondenceActivityTextConst.DRIVING
                }
                if (placeAndCorresFlg == 0) {
                    placeAndCorresScroll.visibility = View.VISIBLE
                    placeAndCorresFlg = 1
                }
            } else {
                dummy6.setBackgroundResource(noPush)
                placeAndCorresScroll.visibility = View.GONE
                placeAndCorresFlg = 0
                dummyBtnNum = 0
            }
        }
    }

}
