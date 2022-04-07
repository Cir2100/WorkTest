package com.kurilov.worktest.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kurilov.worktest.data.classes.Answer
import com.kurilov.worktest.data.classes.Article
import com.kurilov.worktest.databinding.ActivityMainBinding
import com.kurilov.worktest.ui.webview.WebViewActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val cellClickListener = CellClickListener()

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NewsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupUI()

        getNews()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private fun setupUI() {
        binding.newsRecyclerView.layoutManager = LinearLayoutManager(this)

        adapter = NewsListAdapter(cellClickListener)
        binding.newsRecyclerView.adapter = adapter
    }

    private fun getNews() {
        viewModel.getNews().enqueue(object : Callback<Answer> {

            override fun onFailure(call: Call<Answer>, t: Throwable) {
                binding.progressBar.visibility = View.GONE
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Answer>, response: Response<Answer>) {
                binding.progressBar.visibility = View.GONE
                if (response.code() == 200)
                    response.body()?.let { adapter.updateItems(it.articles) }
                else
                    Toast.makeText(this@MainActivity, "Что-то пошло не так", Toast.LENGTH_LONG).show()
            }


        })
    }

    inner class CellClickListener {
        fun onClick(url : String) {
            val intent = Intent(this@MainActivity, WebViewActivity::class.java)
            intent.putExtra("url", url)
            startActivity(intent)
        }
    }
}