package com.example.dispreapp

import android.content.Intent
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
        val toTop = findViewById<TextView>(R.id.toTop)

        var placeAndCorresFlg = 0
        var otherCorrectActionFlg = 0
        var inSideFlg = 0
        var outSideFlg = 0
        var dummySwitchFlg = 0
        var dummyBtnNum = 0

        toTop.paintFlags = Paint.UNDERLINE_TEXT_FLAG
        toTop.movementMethod = LinkMovementMethod.getInstance()
        toTop.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

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
                insideBtn.visibility = View.VISIBLE
                outsideBtn.visibility = View.VISIBLE
            }
        }

        otherCorrectAction.setOnClickListener {
            if (insideBtn.visibility == View.VISIBLE && outsideBtn.visibility == View.VISIBLE) {
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
                otherCorrectActionScroll.visibility = View.VISIBLE
                otherCorrectActionFlg = 1
            } else {
                otherCorrectActionScroll.visibility = View.GONE
                otherCorrectActionFlg = 0
            }
        }

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
                inSideFlg = 1
                outSideFlg = 0
            } else if (dummySwitchFlg == 1) {
                dummy1.visibility = View.GONE
                dummy2.visibility = View.GONE
                dummy3.visibility = View.GONE
                dummy4.visibility = View.GONE
                dummy5.visibility = View.GONE
                dummy6.visibility = View.GONE
                dummySwitchFlg = 0
                inSideFlg = 0
                outSideFlg = 0
            }
        }

        outside.setOnClickListener {
            if (placeAndCorresFlg == 1) {
                placeAndCorresScroll.visibility = View.GONE
                placeAndCorresFlg = 0
                dummyBtnNum = 0
            }
            if ((inSideFlg == 0 && outSideFlg == 0) || inSideFlg == 1) {
                dummy1.text = "住宅街"
                dummy2.text = "オフィス街・繁華街"
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
                inSideFlg = 0
                outSideFlg = 1
            } else if (dummySwitchFlg == 1) {
                dummy1.visibility = View.GONE
                dummy2.visibility = View.GONE
                dummy3.visibility = View.GONE
                dummy4.visibility = View.GONE
                dummy5.visibility = View.GONE
                dummy6.visibility = View.GONE
                dummySwitchFlg = 0
                inSideFlg = 0
                outSideFlg = 0
            }
        }

        dummy1.setOnClickListener {
            if (dummyBtnNum == 0 || dummyBtnNum != 1) {
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
                placeAndCorresScroll.visibility = View.GONE
                placeAndCorresFlg = 0
                dummyBtnNum = 0
            }
        }

        dummy2.setOnClickListener {
            if (dummyBtnNum == 0 || dummyBtnNum != 2) {
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
                placeAndCorresScroll.visibility = View.GONE
                placeAndCorresFlg = 0
                dummyBtnNum = 0
            }
        }

        dummy3.setOnClickListener {
            if (dummyBtnNum == 0 || dummyBtnNum != 3) {
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
                placeAndCorresScroll.visibility = View.GONE
                placeAndCorresFlg = 0
                dummyBtnNum = 0
            }
        }

        dummy4.setOnClickListener {
            if (dummyBtnNum == 0 || dummyBtnNum != 4) {
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
                placeAndCorresScroll.visibility = View.GONE
                placeAndCorresFlg = 0
                dummyBtnNum = 0
            }
        }

        dummy5.setOnClickListener {
            if (dummyBtnNum == 0 || dummyBtnNum != 5) {
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
                placeAndCorresScroll.visibility = View.GONE
                placeAndCorresFlg = 0
                dummyBtnNum = 0
            }
        }

        dummy6.setOnClickListener {
            if (dummyBtnNum == 0 || dummyBtnNum != 6) {
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
                placeAndCorresScroll.visibility = View.GONE
                placeAndCorresFlg = 0
                dummyBtnNum = 0
            }
        }
    }

}
