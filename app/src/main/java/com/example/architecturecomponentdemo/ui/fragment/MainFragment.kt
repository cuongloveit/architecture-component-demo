package com.example.architecturecomponentdemo.ui.fragment

import android.arch.lifecycle.*
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.architecturecomponentdemo.R
import com.example.architecturecomponentdemo.api.entity.Repository
import com.example.architecturecomponentdemo.base.BaseFragment
import com.example.architecturecomponentdemo.di.Injectable
import com.example.architecturecomponentdemo.ui.adapter.RepositoryAdapter
import com.example.architecturecomponentdemo.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject


/**
 * Created by cuong on 7/14/17.
 */
class MainFragment : BaseFragment(), LifecycleRegistryOwner, Injectable {
    private val lifecycleRegistry by lazy { LifecycleRegistry(this) }
    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by lazy { ViewModelProviders.of(activity, viewModelFactory).get(MainViewModel::class.java) }
    private val listRepository = ArrayList<Repository>()
    private val adapter by lazy { RepositoryAdapter(listRepository) }

    override fun getLifecycle() = lifecycleRegistry

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_main, container, false)

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        updateListRepository()
        showProgressbar()
        listenSearch()


    }

    private fun listenSearch() {
        btnSearch.setOnClickListener({
            viewModel.keyword.value = edtSearch.text.toString()
        })

        viewModel.keyword.observe(this, Observer {
            it?.let {
                viewModel.searchRespository(it)
            }
        })


    }

    private fun showProgressbar() {

        viewModel.isLoading.observe(this, Observer {
            it?.let {
                progressbar.visibility = if (it) View.VISIBLE else View.GONE
            }
        })
    }

    private fun updateListRepository() {
        viewModel.repositories.observe(this, Observer {
            it?.let {
                adapter.run {
                    listRepository.clear()
                    listRepository.addAll(it)
                    notifyDataSetChanged()
                }
            }
        })
    }

    private fun setupRecyclerView() {
        rcvRepository.layoutManager = LinearLayoutManager(context)
        rcvRepository.adapter = adapter
    }


    companion object {
        fun newInstance() = MainFragment()
    }
}
