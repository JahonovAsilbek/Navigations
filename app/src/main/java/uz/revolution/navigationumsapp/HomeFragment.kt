package uz.revolution.navigationumsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()


    }

    lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_home, container, false)

        root.tarif.setOnClickListener {

            val bundle = Bundle()
            bundle.putString("hechchi","hechchi")

            val navOptions = NavOptions.Builder()
//            navOptions.setEnterAnim(R.anim.enter_anim)
//            navOptions.setExitAnim(R.anim.exit_anim)
//            navOptions.setPopEnterAnim(R.anim.pop_enter_anim)
//            navOptions.setPopExitAnim(R.anim.pop_exit_anim)

            findNavController().navigate(R.id.tarifFragment, bundle, navOptions.build())
        }

        root.daqiqa.setOnClickListener {

            val bundle = Bundle()
            bundle.putString("hechchi","hechchi")

            val navOptions = NavOptions.Builder()
//            navOptions.setEnterAnim(R.anim.enter_anim)
//            navOptions.setExitAnim(R.anim.exit_anim)
//            navOptions.setPopEnterAnim(R.anim.pop_enter_anim)
//            navOptions.setPopExitAnim(R.anim.pop_exit_anim)

            root.findNavController().navigate(R.id.daqiqaFragment,bundle,navOptions.build())
        }

        root.internet.setOnClickListener {

            val bundle = Bundle()
            bundle.putString("hechchi","hechchi")

            val navOptions = NavOptions.Builder()
//            navOptions.setEnterAnim(R.anim.enter_anim)
//            navOptions.setExitAnim(R.anim.exit_anim)
//            navOptions.setPopEnterAnim(R.anim.pop_enter_anim)
//            navOptions.setPopExitAnim(R.anim.pop_exit_anim)

            root.findNavController().navigate(R.id.internetFragment,bundle,navOptions.build())
        }

        root.sms.setOnClickListener {

            val bundle = Bundle()
            bundle.putString("hechchi","hechchi")

            val navOptions = NavOptions.Builder()
//            navOptions.setEnterAnim(R.anim.enter_anim)
//            navOptions.setExitAnim(R.anim.exit_anim)
//            navOptions.setPopEnterAnim(R.anim.pop_enter_anim)
//            navOptions.setPopExitAnim(R.anim.pop_exit_anim)

            root.findNavController().navigate(R.id.smsFragment,bundle,navOptions.build())
        }

        root.sozlamalar.setOnClickListener {

            val bundle = Bundle()
            bundle.putString("hechchi","hechchi")

            val navOptions = NavOptions.Builder()
//            navOptions.setEnterAnim(R.anim.enter_anim)
//            navOptions.setExitAnim(R.anim.exit_anim)
//            navOptions.setPopEnterAnim(R.anim.pop_enter_anim)
//            navOptions.setPopExitAnim(R.anim.pop_exit_anim)

            root.findNavController().navigate(R.id.sozlamalarFragment,bundle,navOptions.build())
        }

        root.yangiliklar.setOnClickListener {

            val bundle = Bundle()
            bundle.putString("hechchi","hechchi")

            val navOptions = NavOptions.Builder()
//            navOptions.setEnterAnim(R.anim.enter_anim)
//            navOptions.setExitAnim(R.anim.exit_anim)
//            navOptions.setPopEnterAnim(R.anim.pop_enter_anim)
//            navOptions.setPopExitAnim(R.anim.pop_exit_anim)

            root.findNavController().navigate(R.id.yangiliklarFragment, bundle, navOptions.build())
        }



        return root
    }



    override fun onStart() {
        super.onStart()
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}