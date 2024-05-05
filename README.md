package com.example.musiee

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class MainActivity : AppCompatActivity() {
    lateinit var myReclerView: RecyclerView
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        myReclerView=findViewById(R.id.recyclerView)
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData("eminem")

        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {

                val dataList = response.body()?.data!!

                //val textView = findViewById<TextView>(R.id.helloText)
                //textView.text = dataList.toString()

                myAdapter= MyAdapter(this@MainActivity, dataList)
                myReclerView.adapter=myAdapter
                myReclerView.layoutManager=LinearLayoutManager(this@MainActivity)

                Log.d("TAG : onResponse", "onResponse: " + response.body())
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                Log.d("TAG : onFailure", "onFailure:" + t.message)
            }
        })
    }
}











package com.example.musiee

import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



class MainActivity : AppCompatActivity() {
    lateinit var myReclerView: RecyclerView
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        myReclerView=findViewById(R.id.recyclerView)
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://deezerdevs-deezer.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData("eminem")

        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {

                val dataList = response.body()?.data!!

                //val textView = findViewById<TextView>(R.id.helloText)
                //textView.text = dataList.toString()

                myAdapter= MyAdapter(this@MainActivity, dataList)
                myReclerView.adapter=myAdapter
                myReclerView.layoutManager=LinearLayoutManager(this@MainActivity)

                Log.d("TAG : onResponse", "onResponse: " + response.body())
            }<?xml version="1.0" encoding="utf-8"?>




            
<LinearLayout  xmlns:android="http://schemas.android.com/apk/res/android"


    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal">

    <androidx.cardview.widget.CardView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/translucent_white"
        app:cardCornerRadius="4dp">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_margin="1dp"
            android:orientation="horizontal">

            <ImageView
                android:id="@+id/musicimage"
                android:layout_width="100dp"
                android:layout_height="100dp"
                tools:srcCompat="@tools:sample/avatars" />


            <TextView
                android:id="@+id/musictitle"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                android:layout_marginLeft="4dp"
                android:text="TextView" />


            <ImageButton
                android:id="@+id/btnplay"
                android:layout_width="50dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                app:srcCompat="@android:drawable/ic_media_play" />

            <ImageButton
                android:id="@+id/btnpause"
                android:layout_width="50dp"
                android:layout_height="wrap_content"
                android:layout_weight="1"
                app:srcCompat="@android:drawable/ic_media_pause" />


        </LinearLayout>

    </androidx.cardview.widget.CardView>
</LinearLayout>

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                Log.d("TAG : onFailure", "onFailure:" + t.message)
            }
        })
    }
}
