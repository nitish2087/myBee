package com.internshala.echo.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.internshala.echo.R
import com.internshala.echo.activities.MainActivity
import com.internshala.echo.fragments.AboutUsFragment
import com.internshala.echo.fragments.FavoriteFragment
import com.internshala.echo.fragments.MainScreenFragment
import com.internshala.echo.fragments.Settingsfragment
import org.w3c.dom.Text
import java.text.FieldPosition
import java.util.ArrayList

class NavigationDrawerAdapter(_contentlist: ArrayList<String>, _getImages: IntArray, _context: Context) :
    RecyclerView.Adapter<NavigationDrawerAdapter.NavViewHolder>() {

    var contentList: ArrayList<String>? = null
    var getImages: IntArray? = null
    var mContext: Context? = null

    init {
        this.contentList = _contentlist
        this.getImages = _getImages
        this.mContext = _context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavViewHolder {
        var itemView = LayoutInflater.from(parent?.context)
            .inflate(R.layout.row_custom_navigationdrawer, parent, false)
        var returnThis = NavViewHolder(itemView)
        return returnThis
    }

    override fun getItemCount(): Int {
        return 4
        //return (contentList as ArrayList).size
    }

    override fun onBindViewHolder(holder: NavViewHolder, position: Int) {
        holder?.icon_Get?.setBackgroundResource(getImages?.get(position) as Int)
        holder?.text_Get?.setText(contentList?.get(position))
        holder?.contentHolder?.setOnClickListener {
            if (position == 0) {
                val mainScreenFragment = MainScreenFragment()
                (mContext as MainActivity).supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.details_fragment, mainScreenFragment)
                    .commit()
            } else if (position == 1) {
                val favoriteFragment = FavoriteFragment()
                (mContext as MainActivity).supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.details_fragment, favoriteFragment)
                    .commit()
            } else if (position == 2) {
                val settingsFragment = Settingsfragment()
                (mContext as MainActivity).supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.details_fragment, settingsFragment)
                    .commit()
            } else {
                val aboutUsFragment = AboutUsFragment()
                (mContext as MainActivity).supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.details_fragment, aboutUsFragment)
                    .commit()
            }
            MainActivity.Statified.drawerLayout?.closeDrawers()
        }
    }


    class NavViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var icon_Get: ImageView? = null
        var text_Get: TextView? = null
        var contentHolder: RelativeLayout? = null

        init {
            icon_Get = itemView?.findViewById(R.id.icon_navdrawer)
            text_Get = itemView?.findViewById(R.id.text_navdrawer)
            contentHolder = itemView?.findViewById(R.id.navdrawer_item_content_holder)
        }

    }
}