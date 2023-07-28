package com.example.prac2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.prac2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val myName2:MyName = MyName("BAIT")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.myName = myName2
        binding.button.setOnClickListener{
            addNickname(it)
        }
        binding.nicknameText.setOnClickListener{
            updateNickname(it)
        }
    }

    private fun addNickname(view:View){
        binding.apply {
            myName?.nickName = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            button.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE)
            as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken,0)
    }
}
    private fun updateNickname(view: View){
        binding.apply {
            nicknameEdit.visibility = View.VISIBLE
            button.visibility = View.VISIBLE
            nicknameText.visibility = View.GONE
        }
    }
}