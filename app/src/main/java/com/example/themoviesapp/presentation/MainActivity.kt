package com.example.themoviesapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themoviesapp.R
import com.example.themoviesapp.data.di.Injector
import com.example.themoviesapp.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var movieViewModel: MyViewModel

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MovieAdapter
    private lateinit var tvAdapter:TvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        (application as Injector).createMovieSubComp().inject(this)

        movieViewModel=ViewModelProvider(this,factory)
            .get(MyViewModel::class.java)
        setUpRecyclerView()
        setUpRecyclerView2()
    }

    private fun setUpRecyclerView2() {
         binding.TvShowsRecyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        tvAdapter=TvAdapter()
        binding.TvShowsRecyclerView.adapter=tvAdapter
        displayPopularShow()
    }

    private fun displayPopularShow() {
        binding.progressbar.visibility=View.VISIBLE
        val responseLiveData=movieViewModel.getTvShows()
        responseLiveData.observe(this, Observer {
            if(it!=null)
            {
                tvAdapter.differ.submitList(it)
                binding.progressbar.visibility=View.GONE
            }
            else{
                binding.progressbar.visibility=View.GONE
                Toast.makeText(applicationContext,"No Data Available",Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun setUpRecyclerView() {
        binding.recyclerivew.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        adapter= MovieAdapter()
        binding.recyclerivew.adapter=adapter
        displayPopularMovie()
    }

    private fun displayPopularMovie() {
        binding.progressbar.visibility=View.VISIBLE
        val responseLiveData=movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {
            if(it!=null)
            {
                adapter.differ.submitList(it)
//                adapter.notifyDataSetChanged()
                binding.progressbar.visibility=View.GONE

            }
            else{
                binding.progressbar.visibility=View.GONE
                Toast.makeText(applicationContext,"No Data Available",Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater:MenuInflater=menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_update->{
                updateMovies()
                true
            }
            else->super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovies() {
        binding.progressbar.visibility=View.VISIBLE
        val response=movieViewModel.updateMovies()
        response.observe(this, Observer {
            if(it!=null)
            {
                adapter.differ.submitList(it)

                binding.progressbar.visibility=View.GONE

            }
            else {
                binding.progressbar.visibility = View.GONE
            }
        })
    }
}