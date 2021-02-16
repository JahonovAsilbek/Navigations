package uz.revolution.navigationumsapp

import android.annotation.SuppressLint
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_tarif.view.*
import uz.revolution.navigationumsapp.R
import uz.revolution.navigationumsapp.adapters.TarifAdapter
import uz.revolution.navigationumsapp.models.Tarif

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class TarifFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        (activity as AppCompatActivity?)!!.supportActionBar!!.show()
    }

    lateinit var root: View
    lateinit var adapter: TarifAdapter
    lateinit var data: ArrayList<Tarif>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_tarif, container, false)

        loadData()
        adapter = TarifAdapter(data)
        root.rv.adapter = adapter

        adapter.setOnClickListener(object : TarifAdapter.OnItemClickListener {
            override fun onClick(tarif: Tarif) {
                val bundle = Bundle()
                bundle.putSerializable("tarif", tarif)
                root.findNavController().navigate(R.id.rateFragment,bundle)
            }

        })


        return root
    }

    private fun loadData() {
        var i: Int = 0
        data = ArrayList()

        data.add(Tarif(i++, "Mobi 20", "*111*120#", resources.getString(R.string.mobi20)))
        data.add(Tarif(i++, "Mobi 30", "*111*128#", resources.getString(R.string.mobi30)))
        data.add(Tarif(i++, "Mobi 40", "*111*122#", resources.getString(R.string.mobi40)))
        data.add(Tarif(i++, "Mobi 50", "*111*129#", resources.getString(R.string.mobi50)))
        data.add(Tarif(i++, "Mobi 70", "111*131#", resources.getString(R.string.mobi70)))
        data.add(Tarif(i++, "Mobi 90", "*111*132#", resources.getString(R.string.mobi90)))
        data.add(Tarif(i++, "Mobi 110", "*111*133#", resources.getString(R.string.mobi110)))
        data.add(Tarif(i++, "Mobi 150", "*111*134#", resources.getString(R.string.mobi150)))
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TarifFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}