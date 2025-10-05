package com.example.lab_week_04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {
    private val coffeeTitle: TextView?
        get() = view?.findViewById(R.id.coffee_title)
    private val coffeeDesc: TextView?
        get() = view?.findViewById(R.id.coffee_desc)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Buat pemetaan dari ID resource ke ID data yang bersih
        val coffeeDataMap = mapOf(
            R.id.affogato to 0,   // Affogato akan memiliki ID 0
            R.id.americano to 1, // Americano akan memiliki ID 1
            R.id.latte to 2      // Latte akan memiliki ID 2
        )

        coffeeDataMap.forEach { (viewId, dataId) ->
            val coffeeView = view.findViewById<View>(viewId)
            val bundle = Bundle().apply {
                putInt(COFFEE_ID, dataId) // Kirim ID bersih (0, 1, atau 2)
            }
            coffeeView.setOnClickListener(
                Navigation.createNavigateOnClickListener(
                    R.id.action_listFragment_to_detailFragment,
                    bundle
                )
            )
        }
    }
    fun setCoffeeData(id: Int){
        when(id){
            R.id.affogato -> {
                coffeeTitle?.text = getString(R.string.affogato_title)
                coffeeDesc?.text = getString(R.string.affogato_desc)
            }
            R.id.americano -> {
                coffeeTitle?.text = getString(R.string.americano_title)
                coffeeDesc?.text = getString(R.string.americano_desc)
            }
            R.id.latte -> {
                coffeeTitle?.text = getString(R.string.latte_title)
                coffeeDesc?.text = getString(R.string.latte_desc)
            }
        }
    }
    companion object {
        private const val COFFEE_ID = "COFFEE_ID"
    }
}