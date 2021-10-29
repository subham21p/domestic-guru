package com.app.domesticguru.ui.fragment

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.app.domesticguru.R
import com.app.domesticguru.databinding.FragmentHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import org.xmlpull.v1.XmlPullParserFactory.newInstance
import java.lang.reflect.Array.newInstance
import java.net.URLClassLoader.newInstance
import javax.xml.datatype.DatatypeFactory.newInstance


class HomeFragment : Fragment() {
    private lateinit var mLayout : FragmentHomeBinding
    val homeScreenFragment=HomeScreenFragment()
    val myAdsFragment=MyAdsFragment()
    val responsesFragment=ResponsesFragment()
    val bookingsFragment=BookingsFragment()
    var navigationView: BottomNavigationView? = null

    private lateinit var mNavigationView: NavigationView
    private lateinit var mNavController: NavController
    lateinit var menu: Menu
    private lateinit var mBottomNavigationMenu: BottomNavigationView


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_home, container, false)
//        val navHostFragment = activity?.supportFragmentManager
//                ?.findFragmentById(R.id.fragment) as NavHostFragment
//        navController = navHostFragment.findNavController()
        mLayout = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        val callback = requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            // Handle the back button event
            //finish();
            //getActivity()?.onBackPressed();
            System.exit(0);
        }
       /* val navController: NavController =
            Navigation.findNavController(, R.id.fragment)
        mLayout.activityMainBottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home -> setCurrentFragment(firstFragment)
                R.id.person -> setCurrentFragment(secondFragment)
                R.id.settings -> setCurrentFragment(thirdFragment)

            }
            true
        }*/
        // val view = inflater.inflate(R.layout.fragment_log_in, container, false)
       // val appCompat = requireActivity() as AppCompatActivity
        val nestedNavHostFragment =  activity?.supportFragmentManager
                ?.findFragmentById(R.id.fragment) as NavHostFragment

//        val navController = nestedNavHostFragment?.navController
//
//        val bottomNavigationView = view?.findViewById<BottomNavigationView>(R.id.activity_main_bottom_navigation_view)
        val navController = requireActivity().findNavController(R.id.fragment)
        val navView: BottomNavigationView = view?.findViewById(R.id.activity_main_bottom_navigation_view)!!
        navView.setupWithNavController(navController)
        val firstFragment=HomeScreenFragment()
        val secondFragment=MyAdsFragment()
        val thirdFragment=ResponsesFragment()
        val fourthFragment=BookingsFragment()
       //setCurrentFragment(secondFragment)
     //   if (navController != null) {
          //  Toast.makeText(this.context, "Hello!", Toast.LENGTH_SHORT).show()
     //       bottomNavigationView?.setupWithNavController(navController)
//            bottomNavigationView?.setOnNavigationItemSelectedListener {
//                when(it.itemId){
//
//                    R.id.nav_graph_home -> {
//                        Toast.makeText(this.context, "Hello!", Toast.LENGTH_SHORT).show()
//                        setCurrentFragment(firstFragment)
//                    }
//                    R.id.nav_graph_myAds -> setCurrentFragment(secondFragment)
//                    R.id.nav_graph_res -> setCurrentFragment(thirdFragment)
//                    R.id.nav_graph_bookings -> setCurrentFragment(fourthFragment)
//
//                }
//                true
//            }
//            bottomNavigationView?.menu?.getItem(0)?.isCheckable = true
//            setCurrentFragment(HomeScreenFragment())
//            bottomNavigationView?.setOnNavigationItemSelectedListener { menu ->
//                when (menu.itemId) {
//                    R.id.nav_graph_home -> {
//                        //setContent("Home")
//                        setCurrentFragment(HomeScreenFragment())
//                        return@setOnNavigationItemSelectedListener true
//                    }
//                    R.id.nav_graph_myAds -> {
//                        setCurrentFragment(MyAdsFragment())
//                        return@setOnNavigationItemSelectedListener true
//                    }
//                    R.id.nav_graph_res -> {
//                        Toast.makeText(this.context, "Hello!", Toast.LENGTH_SHORT).show()
//                        setCurrentFragment(MyAdsFragment())
//                        return@setOnNavigationItemSelectedListener true
//                    }
//                    R.id.nav_graph_bookings -> {
//                        setCurrentFragment(MyAdsFragment())
//                        return@setOnNavigationItemSelectedListener true
//                    }
//                    else -> return@setOnNavigationItemSelectedListener false
//                }
//            }

//            bottomNavigationView!!.setOnNavigationItemSelectedListener { item ->
//                when (item.itemId) {
//                    R.id.nav_graph_home -> {
//                        //setContent("Home")
//                        setCurrentFragment(firstFragment)
//                        true
//                    }
//                    R.id.nav_graph_myAds -> {
//                        setCurrentFragment(secondFragment)
//                        true
//                    }
//                    R.id.nav_graph_res -> {
//                        Toast.makeText(this.context, "Hello!", Toast.LENGTH_SHORT).show()
//                        setCurrentFragment(thirdFragment)
//                        true
//                    }
//                    R.id.nav_graph_bookings -> {
//                        setCurrentFragment(fourthFragment)
//                        true
//                    }
//                }
//                false
//            }
            //  bottomNavigationView?.findNavController()
            //log ("gdkasgjfkjsgfskfgskfgas 00000000000000000000000001")

//        } else {
//            throw RuntimeException("Controller not found")
//        }

        return mLayout.root
    }
//    private fun setCurrentFragment(fragment: Fragment)=
//            childFragmentManager.beginTransaction().apply {
//                replace(R.id.fragment, fragment)
//                commit()
//            }
    fun setCurrentFragment(fr: Fragment){
        val frag = activity?.supportFragmentManager?.beginTransaction()
        frag?.replace(R.id.fragment, fr)
        frag?.commit()
    }
//    private fun setCurrentFragment(fragment:Fragment)=
//        .beginTransaction().apply {
//            replace(R.id.flFragment,fragment)
//            commit()
//        }

//    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
//        when (item.itemId) {
//            R.id.nav_graph_home -> {
//                currentFragment = HomeScreenFragment()
//                ft = childFragmentManager.beginTransaction()
//                ft.replace(R.id.fragment, currentFragment)
//                ft.commit()
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.frag_b -> {
//                currentFragment = FragmentB()
//                ft = getSupportFragmentManager().beginTransaction()
//                ft.replace(R.id.content, currentFragment)
//                ft.commit()
//                return@OnNavigationItemSelectedListener true
//            }
//            R.id.frag_c -> {
//                currentFragment = FragmentC()
//                ft = getSupportFragmentManager().beginTransaction()
//                ft.replace(R.id.content, currentFragment)
//                ft.commit()
//                return@OnNavigationItemSelectedListener true
//            }
//        }
//        false
//    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        // we can get the innermost NavController using this view,
//        // because we are inside its subtree:
//        nestedNavController = Navigation.findNavController(view)
//
//        // we can find the outer NavController passing the owning Activity
//        // and the id of a view associated to that NavController,
//        // for example the NavHostFragment id:
//        mainNavController = Navigation.findNavController(requireActivity(), R.id.activity_main_bottom_navigation_view)
//    }

//    fun onNavigationItemSelected(item: MenuItem): Boolean {
//        var selectedFragment: Fragment? = null
//        when (item.getItemId()) {
//            R.id.navigation_home -> selectedFragment = HomeFragment.newInstance()
//            R.id.navigation_dashboard -> selectedFragment = DashboardFragment.newInstance()
//            R.id.navigation_notifications -> selectedFragment = NotificationsFragment.newInstance()
//        }
//        getSupportFragmentManager().beginTransaction().replace(R.id.content, selectedFragment).commit()
//        return true
//    }

}