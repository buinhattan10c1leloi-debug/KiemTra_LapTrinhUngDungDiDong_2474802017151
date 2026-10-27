package com.example.kiemtra_laptrinhungdungdidong_2474802017151

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtPassword = findViewById<EditText>(R.id.edtPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val password = edtPassword.text.toString().trim()

            tvStatus.setTextColor(Color.parseColor("#F44336"))

            if (email.isEmpty() || password.isEmpty()) {
                tvStatus.text = "Lỗi: Email hoặc Mật khẩu không được để trống!"
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                tvStatus.text = "Lỗi: Email không đúng định dạng!"
                return@setOnClickListener
            }

            if (password.length < 6) {
                tvStatus.text = "Lỗi: Mật khẩu phải từ 6 ký tự trở lên!"
                return@setOnClickListener
            }

            // Dữ liệu hợp lệ -> Đổi màu, báo thành công
            tvStatus.setTextColor(Color.parseColor("#4CAF50"))
            tvStatus.text = "Xác thực thành công!"

            // CHUYỂN MÀN HÌNH BẰNG INTENT
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("USER_EMAIL", email) // Gói cái email mang theo
            startActivity(intent)
        }
    }
}