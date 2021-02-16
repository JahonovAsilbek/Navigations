package uz.revolution.navigationumsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_tarif.view.*
import uz.revolution.navigationumsapp.adapters.DaqiqaAdapter
import uz.revolution.navigationumsapp.models.Daqiqa


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DaqiqaFragment : Fragment() {

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
    lateinit var adapter: DaqiqaAdapter
    lateinit var data: ArrayList<Daqiqa>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        root = inflater.inflate(R.layout.fragment_daqiqa, container, false)



        loadData()
        adapter = DaqiqaAdapter(data)
        root.rv.adapter = adapter

        adapter.setOnClickListener(object : DaqiqaAdapter.OnItemClickListener {
            override fun onClick(daqiqa: Daqiqa) {
                val bundle = Bundle()
                bundle.putSerializable("daqiqa", daqiqa)
                root.findNavController().navigate(R.id.minuteFragment, bundle)
            }

        })

//        root.back_to_home.setOnClickListener {
//            findNavController().popBackStack()
//        }


        return root
    }

    private fun loadData() {
        var i: Int = 0
        data = ArrayList()

        data.add(
            Daqiqa(
                i++,
                "60 daqiqalik to‘plam",
                "*103*60#",
                resources.getString(R.string.daqiqa60)
            )
        )
        data.add(
            Daqiqa(
                i++,
                "120 daqiqalik to‘plam",
                "*103*120#",
                resources.getString(R.string.daqiqa120)
            )
        )
        data.add(
            Daqiqa(
                i++,
                "180 daqiqalik to‘plam",
                "*103*180#",
                resources.getString(R.string.daqiqa180)
            )
        )
        data.add(
            Daqiqa(
                i++,
                "300 daqiqalik to‘plam",
                "*103*300#",
                resources.getString(R.string.daqiqa300)
            )
        )
        data.add(
            Daqiqa(
                i++,
                "900 daqiqalik to‘plam",
                "103*900#",
                resources.getString(R.string.daqiqa900)
            )
        )
        data.add(
            Daqiqa(
                i++,
                "1200 daqiqalik to‘plam",
                "*103*1200#",
                resources.getString(R.string.daqiqa1200)
            )
        )
        data.add(
            Daqiqa(
                i++,
                "1800 daqiqalik to‘plam",
                "*103*1800#",
                resources.getString(R.string.daqiqa1800)
            )
        )
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DaqiqaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}