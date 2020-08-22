package com.binar.ccgameandprofile.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.binar.ccgameandprofile.R
import com.binar.ccgameandprofile.databinding.ActivityVsSahabatBinding
import com.binar.ccgameandprofile.sharedpreference.SharedPreferences
import kotlinx.android.synthetic.main.activity_vs_sahabat.*

class VsSahabat : AppCompatActivity() {
    private var you: String = ""
    private var com: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityVsSahabatBinding = ActivityVsSahabatBinding.inflate(layoutInflater)
        val view = binding.root
        this.supportActionBar?.hide()
        setContentView(view)
        hideP2()
        tv_alert.visibility = View.VISIBLE
        tv_alert.setText(R.string.alert_p1)

        // REMOVE ACTION BAR
        this.supportActionBar?.hide()

        // CLICKABLE EVENT LISTENERS
        binding.ivYouRock.setOnClickListener {
            you = "rock"
            tv_reset.visibility = View.VISIBLE
            tv_alert.visibility = View.VISIBLE
            tv_alert.setText(R.string.alert_p2)
            changeYouIcons(you)
        }
        binding.ivYouPaper.setOnClickListener {
            you = "paper"
            tv_reset.visibility = View.VISIBLE
            tv_alert.visibility = View.VISIBLE
            tv_alert.setText(R.string.alert_p2)
            changeYouIcons(you)
        }
        binding.ivYouScissors.setOnClickListener {
            you = "scissors"
            tv_reset.visibility = View.VISIBLE
            tv_alert.visibility = View.VISIBLE
            tv_alert.setText(R.string.alert_p2)
            changeYouIcons(you)
        }
        binding.tvReset.setOnClickListener {
            resetYouIcons()
            resetComIcons()
            tv_status.setText(R.string.vs)
            tv_status.setTextColor(Color.parseColor("#83A8C2"))
            tv_alert.visibility = View.VISIBLE
            tv_alert.setText(R.string.alert_p1)
            enableAllButtons()
            unhideP1()
            hideP2()
            Log.d("RESET", "Status Reset")
        }
        binding.ivComRock.setOnClickListener {
            com = "rock"
            tv_reset.visibility = View.VISIBLE
            changeComIcons(com)
        }
        binding.ivComPaper.setOnClickListener {
            com = "paper"
            tv_reset.visibility = View.VISIBLE
            changeComIcons(com)
        }
        binding.ivComScissors.setOnClickListener {
            com = "scissors"
            tv_reset.visibility = View.VISIBLE
            changeComIcons(com)
        }
        binding.tvCredit.setOnClickListener {
            finish()
        }
    }

    private fun hideP1() {
        iv_you_rock.visibility = View.GONE
        iv_you_paper.visibility = View.GONE
        iv_you_scissors.visibility = View.GONE
    }
    private fun unhideP1() {
        iv_you_rock.visibility = View.VISIBLE
        iv_you_paper.visibility = View.VISIBLE
        iv_you_scissors.visibility = View.VISIBLE
    }

    private fun hideP2() {
        iv_com_rock.visibility = View.GONE
        iv_com_paper.visibility = View.GONE
        iv_com_scissors.visibility = View.GONE
    }
    private fun unhideP2() {
        iv_com_rock.visibility = View.VISIBLE
        iv_com_paper.visibility = View.VISIBLE
        iv_com_scissors.visibility = View.VISIBLE
    }

    private fun disableAllButtons() {
        iv_you_rock.isClickable = false
        iv_you_paper.isClickable = false
        iv_you_scissors.isClickable = false
        iv_com_rock.isClickable = false
        iv_com_paper.isClickable = false
        iv_com_scissors.isClickable = false
        tv_reset.visibility = View.VISIBLE
        tv_alert.visibility = View.VISIBLE
    }

    private fun enableAllButtons() {
        iv_you_rock.isClickable = true
        iv_you_paper.isClickable = true
        iv_you_scissors.isClickable = true
        iv_com_rock.isClickable = true
        iv_com_paper.isClickable = true
        iv_com_scissors.isClickable = true
        tv_reset.visibility = View.GONE
    }

    private fun resetYouIcons() {
        iv_you_rock.setImageResource(R.drawable.ic_rock)
        iv_you_rock.setBackgroundResource(R.drawable.ic_stroke)
        iv_you_paper.setImageResource(R.drawable.ic_paper)
        iv_you_paper.setBackgroundResource(R.drawable.ic_stroke)
        iv_you_scissors.setImageResource(R.drawable.ic_scissors)
        iv_you_scissors.setBackgroundResource(R.drawable.ic_stroke)
    }

    private fun resetComIcons() {
        val preferences = SharedPreferences(this)
        iv_com_rock.setImageResource(R.drawable.ic_rock)
        iv_com_rock.setBackgroundResource(R.drawable.ic_stroke)
        iv_com_paper.setImageResource(R.drawable.ic_paper)
        iv_com_paper.setBackgroundResource(R.drawable.ic_stroke)
        iv_com_scissors.setImageResource(R.drawable.ic_scissors)
        iv_com_scissors.setBackgroundResource(R.drawable.ic_stroke)
        preferences.setP1("")
        preferences.setP2("")
    }

    private fun changeYouIcons(you: String) {
        val preferences = SharedPreferences(this)
        preferences.setP1(you)
        hideP1()
        unhideP2()

        when (you) {
            "rock" -> {
                resetYouIcons()
                iv_you_rock.setBackgroundResource(R.drawable.ic_fill)
            }
            "paper" -> {
                resetYouIcons()
                iv_you_paper.setBackgroundResource(R.drawable.ic_fill)
            }
            "scissors" -> {
                resetYouIcons()
                iv_you_scissors.setBackgroundResource(R.drawable.ic_fill)
            }
            else -> Log.d("ERROR", "You Neither Rock Paper or Scissors")
        }
    }

    private fun changeComIcons(com: String) {
        val preferences = SharedPreferences(this)
        preferences.setP2(com)
        checkAnswers(preferences.getP1(), com)

        when (com) {
            "rock" -> {
                resetComIcons()
                iv_com_rock.setBackgroundResource(R.drawable.ic_fill)
            }
            "paper" -> {
                resetComIcons()
                iv_com_paper.setBackgroundResource(R.drawable.ic_fill)
            }
            "scissors" -> {
                resetComIcons()
                iv_com_scissors.setBackgroundResource(R.drawable.ic_fill)
            }
            else -> Log.d("ERROR", "Com Neither Rock Paper or Scissors")
        }
    }

    private fun checkAnswers(you: String, com: String) {
        if (you == "" || com == "") {
            Log.d("CHECK ANSWER", "SOMETHING STILL NULL")
        } else {
            unhideP1()
            unhideP2()

            showResult(matchingCondition(you, com))
            Log.d("CHECK ANSWER", "ANSWERS ARE $you & $com")
        }
    }

    private fun matchingCondition(you: String, com: String): String {
        if (you == com) {
            return "draw"
        } else if ((you == "rock" && com == "paper") || (com == "rock" && you == "paper")) {
            return if (you == "paper") {
                "win"
            } else {
                "lose"
            }
        } else if ((you == "rock" && com == "scissors") || (com == "rock" && you == "scissors")) {
            return if (you == "rock") {
                "win"
            } else {
                "lose"
            }
        } else if ((you == "paper" && com == "scissors") || com == "paper" && you == "scissors") {
            return if (you == "scissors") {
                "win"
            } else {
                "lose"
            }
        } else {
            return "error"
        }
    }

    private fun showResult(result: String) {
        val preferences = SharedPreferences(this)
        disableAllButtons()
        tv_alert.setText(R.string.alert_disable)
        when (result) {
            "draw" -> {
                tv_status.setText(R.string.draw)
                tv_status.setTextColor(Color.parseColor("#83A8C2"))
                Log.d("RESULT", "P1 chose ${preferences.getP1()}, P2 chose ${preferences.getP2()}. DRAW !!")
            }
            "win" -> {
                tv_status.setText(R.string.p1_win)
                Log.d("RESULT", "P1 chose ${preferences.getP1()}, P2 chose ${preferences.getP2()}. P1 WIN !!")
            }
            "lose" -> {
                tv_status.setText(R.string.p2_win)
                Log.d("RESULT", "P1 chose ${preferences.getP1()}, P2 chose ${preferences.getP2()}. P2 WIN !!")
            }
            else -> Log.d("ERROR", "Neither Win Lose or Draw")
        }
    }
}