package com.vodafone.admin.mvc_movie_notify.features.movies

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.vodafone.admin.mvc_movie_notify.R
import com.vodafone.admin.mvc_movie_notify.features.networking.NetworkModel

class MovieActivity : AppCompatActivity() {

    private lateinit var controller: MovieController
    private lateinit var model: NetworkModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        init()

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Refreshing upcomming movies", Snackbar.LENGTH_SHORT).setAction("Action", null).show()
            controller.refreshClick()
        }
    }

    private fun init() {
        model = NetworkModel()
        controller = MovieController(model, this)
    }

    fun updateMovie(){
        //for sample reasons we will get the movies from memory
        val movies = model.movies()
        //todo implement the UI update
    }
}
