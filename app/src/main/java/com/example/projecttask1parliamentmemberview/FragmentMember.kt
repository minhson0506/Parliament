package com.example.projecttask1parliamentmemberview

import MemberOfParliament
import ParliamentMembersData
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.projecttask1parliamentmemberview.databinding.FragmentMemberBinding
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentParliament.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentParliament : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentMemberBinding
    private val parliamentData = ParliamentMembersData
    private val members: List<MemberOfParliament> = parliamentData.members


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_member,
            container,
            false)
        binding.btRandom.setOnClickListener { displayMember(getRandomIndex(members))}
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    private fun displayMember(index: Int) {
        //set image for the party
        val drawableResource = when(members[index].party) {
            "sd" -> R.drawable.sd
            "ps" -> R.drawable.ps
            "kd" -> R.drawable.kd
            "kesk" -> R.drawable.kesk
            "kok" -> R.drawable.kok
            "vihr" -> R.drawable.vihr
            "liik" -> R.drawable.liik
            "vas" -> R.drawable.vas
            "r" -> R.drawable.r
            else -> R.drawable.ic_launcher_foreground
        }
        binding.imageParty.setImageResource(drawableResource)
        //check if member is minister
        binding.status.text = if(members[index].minister) "Minister" else "Member of Parliament"

        binding.name.text = members[index].first + " " + members[index].last
        binding.age.text = ((Calendar.getInstance().get(Calendar.YEAR)) -
                members[index].bornYear).toString() + " " + "years-old"
        binding.constituency.text = members[index].constituency
    }

    private fun getRandomIndex(members:List<MemberOfParliament>): Int{
        val listOfIndex = members.withIndex().map { it.index }
        return listOfIndex.random()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentParliament.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentParliament().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}