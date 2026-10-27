package com.example.kiemtra_laptrinhungdungdidong_2474802017151

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Bắt buộc ánh xạ bằng findViewById theo yêu cầu đề bài
        val tvEmailDisplay = findViewById<TextView>(R.id.tvEmailDisplay)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        // Lấy dữ liệu Email từ màn hình Login truyền sang
        val emailFromLogin = intent.getStringExtra("USER_EMAIL")
        if (emailFromLogin != null) {
            tvEmailDisplay.text = "Email của bạn: $emailFromLogin"
        }

        // Sự kiện Đăng xuất
        btnLogout.setOnClickListener {
            finish() // Tắt màn hình Profile, quay lại màn hình Login
        }
    }
}